package de.rac.openscenario.v1_0.loader;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import de.rac.openscenario.v1_0.api.ICatalogElement;
import de.rac.openscenario.v1_0.api.ICatalogLocations;
import de.rac.openscenario.v1_0.api.ICatalogReference;
import de.rac.openscenario.v1_0.api.IControllerCatalogLocation;
import de.rac.openscenario.v1_0.api.IDirectory;
import de.rac.openscenario.v1_0.api.IEnvironmentCatalogLocation;
import de.rac.openscenario.v1_0.api.IManeuverCatalogLocation;
import de.rac.openscenario.v1_0.api.IMiscObjectCatalogLocation;
import de.rac.openscenario.v1_0.api.IOpenScenario;
import de.rac.openscenario.v1_0.api.IParameterAssignment;
import de.rac.openscenario.v1_0.api.IPedestrianCatalogLocation;
import de.rac.openscenario.v1_0.api.IRouteCatalogLocation;
import de.rac.openscenario.v1_0.api.IScenarioDefinition;
import de.rac.openscenario.v1_0.api.ITrajectoryCatalogLocation;
import de.rac.openscenario.v1_0.api.IVehicleCatalogLocation;
import de.rac.openscenario.v1_0.catalog.CatalogCache;
import de.rac.openscenario.v1_0.catalog.ICatalogReferenceProvider;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.common.ILocator;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.impl.CatalogReferenceImpl;
import de.rac.openscenario.v1_0.impl.ParameterAssignmentImpl;

/**
 * Implemens a loader for catalogs 
 * 
 * @author Andreas Hege - RA Consulting
 *
 */
public class XmlScenarioImportLoader implements IScenarioLoader {

	private XmlScenarioLoader innerScenarioLoader;
	private IParserMessageLogger catalogMessageLogger;

	/**
	 * Constructor
	 * @param innerScenarioLoader scenario loader that is used to get properties from (Resource locators, filename)
	 * @param catalogMessageLogger message logger for catalogs.
	 */
	public XmlScenarioImportLoader(XmlScenarioLoader innerScenarioLoader,
			IParserMessageLogger catalogMessageLogger) {
		super();
		this.innerScenarioLoader = innerScenarioLoader;
		this.catalogMessageLogger = catalogMessageLogger;
	}

	@Override
	public IOpenScenario load(IParserMessageLogger messageLogger)
			throws ScenarioLoaderException {
		MessageLoggerDecorator messageLoggerEnvelope = new MessageLoggerDecorator(
				messageLogger);
		IOpenScenario openScenario = innerScenarioLoader
				.load(messageLoggerEnvelope);

		if (!messageLoggerEnvelope.hasErrors()) {
			IResourceLocator resourceLocator = innerScenarioLoader
					.getResourceLocator();

			// do imports here
			String filename = innerScenarioLoader.getFilename();
			Set<String> catalogLocations = getCatalogLocations(openScenario,
					resourceLocator, filename, messageLoggerEnvelope);
			CatalogCache catalogCache = new CatalogCache(resourceLocator,
					catalogMessageLogger);
			for (String catalogLocationPath : catalogLocations) {
				List<String> filenames = resourceLocator
						.getSymbolicFilenamesInSymbolicDir(catalogLocationPath);
				for (String symbolicFilename : filenames) {
					XmlScenarioLoaderFactory xmlScenarioLoaderFactory = new XmlScenarioLoaderFactory(
							symbolicFilename);
					catalogCache.addCatalogFile(xmlScenarioLoaderFactory);
				}
			}
			// Get the CatalogLocations
			List<ICatalogReference> catalogReferences = ((ICatalogReferenceProvider) openScenario
					.getAdapter(ICatalogReferenceProvider.class))
					.getCatalogReferences();
			// get the catalogRefences
			for (ICatalogReference catalogReference : catalogReferences) {
				ICatalogElement catalogElement = catalogCache
						.importCatalogElement(catalogReference);
				if (catalogElement != null) {
					((CatalogReferenceImpl) catalogReference)
							.setRef(catalogElement);
					OpenScenarioProcessingHelper
							.resolveWithParameterAssignements(
									messageLoggerEnvelope,
									catalogElement,
									getMapFromParameterAssignements(
											catalogReference
													.getParameterAssignments(),
											messageLoggerEnvelope));
					// resolve CatalogReference Parameters.
				} else {
					messageLoggerEnvelope.logMessage(new FileContentMessage(
							"Cannot resolve entry '"
									+ catalogReference.getEntryName()
									+ "' in catalog '"
									+ catalogReference.getCatalogName() + "'",
							ErrorLevel.ERROR,
							((CatalogReferenceImpl) catalogReference)
									.getStartMarker()));
				}
			}

		}

		return openScenario;
	}

	/**
	 * The map for the list of parameter assignment that maps parameter names 
	 * to assigned parameter values.
	 * @param parameterAssignments list of parameter assignments from a catalog referernce
	 * @param parserMessageLogger to log errors and warnings
	 * @return the table that maps parameter names to parameter values
	 */
	private Hashtable<String, String> getMapFromParameterAssignements(
			List<IParameterAssignment> parameterAssignments,
			IParserMessageLogger parserMessageLogger) {
		Hashtable<String, String> result = new Hashtable<String, String>();
		if (parameterAssignments != null)
		{
			for (IParameterAssignment parameterAssignment : parameterAssignments) {
				String parameterName = parameterAssignment.getParameterRef()
						.getNameRef();
				String parameterValue = parameterAssignment.getValue();
				if (result.get(parameterName) != null) {
					parserMessageLogger.logMessage(new FileContentMessage(
							"Parameter '" + parameterName
									+ "assigned multiple times (last wins)",
							ErrorLevel.WARNING,
							((ParameterAssignmentImpl) parameterAssignment)
									.getStartMarker()));
				}
				result.put(parameterName, parameterValue);
			}
		}
		return result;
	}

	/**
	 * Extract the catalog locations from a IOpenScenario instance
	 * @param openScenario the IOpenScenario instance
	 * @param resourceLocator locator for the symbolic filenames
	 * @param filename a base directory
	 * @param messageLogger to log errors and warnings
	 * @return a set of symbolic directory names
	 */
	private Set<String> getCatalogLocations(IOpenScenario openScenario,
			IResourceLocator resourceLocator, String filename,
			IParserMessageLogger messageLogger) {
		Set<String> result = new HashSet<String>();

		IScenarioDefinition scenarioDefinition = openScenario
				.getOpenScenarioCategory().getScenarioDefinition();
		if (scenarioDefinition != null) {
			ICatalogLocations catalogLocations = scenarioDefinition
					.getCatalogLocations();
			if (catalogLocations != null) {
				IControllerCatalogLocation controllerCatalogLocation = catalogLocations
						.getControllerCatalog();
				IDirectory directory = controllerCatalogLocation.getDirectory();
				addPath(resourceLocator, filename, messageLogger, result,
						directory);

				IManeuverCatalogLocation maneuverCatalogLocation = catalogLocations
						.getManeuverCatalog();
				if (maneuverCatalogLocation != null) {
					directory = maneuverCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);
				}

				IVehicleCatalogLocation vehicleCatalogLocation = catalogLocations
						.getVehicleCatalog();
				if (vehicleCatalogLocation != null) {
					directory = vehicleCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);

				}

				IMiscObjectCatalogLocation miscObjectCatalogLocation = catalogLocations
						.getMiscObjectCatalog();
				if (miscObjectCatalogLocation != null) {
					directory = miscObjectCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);
				}

				ITrajectoryCatalogLocation trajectoryCatalogLocation = catalogLocations
						.getTrajectoryCatalog();
				if (trajectoryCatalogLocation != null) {
					directory = trajectoryCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);
				}

				IEnvironmentCatalogLocation environmentCatalogLocation = catalogLocations
						.getEnvironmentCatalog();
				if (environmentCatalogLocation != null) {
					directory = environmentCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);
				}

				IRouteCatalogLocation routeCatalogLocation = catalogLocations
						.getRouteCatalog();
				if (routeCatalogLocation != null) {
					directory = routeCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);
				}

				IPedestrianCatalogLocation pedestrianCatalogLocation = catalogLocations
						.getPedestrianCatalog();
				if (pedestrianCatalogLocation != null) {
					directory = pedestrianCatalogLocation.getDirectory();
					addPath(resourceLocator, filename, messageLogger, result,
							directory);
				}
			}
		}
		return result;
	}

	/**
	 * Adding symbolic directory names from an IDirectory model element 
	 * @param resourceLocator resource locator for abstracting from file system
	 * @param filename base file name
	 * @param messageLogger to log messages
	 * @param result in/out parameter
	 * @param directory the IDirectorx model element
	 */
	private void addPath(IResourceLocator resourceLocator, String filename,
			IParserMessageLogger messageLogger, Set<String> result,
			IDirectory directory) {

		String path = null;
		if (directory != null) {
			path = directory.getPath();
			if (path != null && !path.isEmpty()) {
				String symbolicDirname = resourceLocator.getSymbolicDirname(
						filename, path);
				if (symbolicDirname != null) {
					result.add(symbolicDirname);
				} else {
					ILocator locator = (ILocator) directory
							.getAdapter(ILocator.class);
					Textmarker textmarker = locator
							.getStartMarkerOfProperty(OscConstants.ATTRIBUTE__PATH);
					messageLogger.logMessage(new FileContentMessage(
							"Cannot resolve catalog directory '" + path + "' (" + symbolicDirname+ ")",
							ErrorLevel.ERROR, textmarker));
				}
			}
		}
	}

}