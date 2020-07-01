package de.rac.openscenario.v1_0.main;

import de.rac.openscenario.v1_0.api.IOpenScenario;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.impl.OpenScenarioImpl;
import de.rac.openscenario.v1_0.loader.FileResourceLocator;
import de.rac.openscenario.v1_0.loader.IScenarioLoader;
import de.rac.openscenario.v1_0.loader.IScenarioLoaderFactory;
import de.rac.openscenario.v1_0.loader.ScenarioLoaderException;
import de.rac.openscenario.v1_0.loader.XmlScenarioImportLoaderFactory;


/**
 * Executable class for checking a OpenScenario file.
 * 
 * @author Andreas Hege - RA Consulting *
 * 
 * <ul>
 * <li> Reading the file
 * <li> Resolving the parameters
 * <li> Resolving the catalog references
 * <li> Checking all type ranges that differ from the ones of the default type (e.g. positiv doubles)
 * </ul>
 *
 */
public class OpenScenarioChecker {
	public static String version = "1.0";
	public static boolean isDebug = false;

	public static void main(String[] args) {
		// 1. input file
		// 2. option skip parameter checking -P
		// 3. option skip import -Y
		// 4. option skip range checker rules -R
		// 5. Version -v
		// 8. print import errors
		System.out.println("**************************************");
		System.out.println("* ASAM OpenSCENARIO 1.0 Checker (2020)");
		System.out.println("**************************************");
		if (args == null || args.length == 0) {
			System.out.println("OpenScenarioChecker [option]");
			System.out.println("Options:");
			System.out.println("[input]\tinput file name");
			System.out.println("-v\tprogram version");
		}
		if (args[0].equals("-v")) {
			System.out.println("Program version " + version);
		}
		
		System.out.println("Checking '"+args[0]+"'");
		MessageLogger catalogMessageLogger = new MessageLogger();
		MessageLogger messageLogger = new MessageLogger();

		try {
			executeImportParsing(args[0], messageLogger, catalogMessageLogger);

			System.out.println("Errors and Warnings");
			System.out.println("===================");
			for (FileContentMessage message : messageLogger.getMessages()) {
				Textmarker textmarker = message.getTextmarker();
				if (message.getErrorLevel() != ErrorLevel.DEBUG || isDebug)
				{
					System.out.println(message.getErrorLevel().toString() + ": "
						+ message.getMessage() + " (" + textmarker.getLine()
						+ "," + textmarker.getColumn() + ")");
				}
			}

			if (!catalogMessageLogger.getMessages().isEmpty() && isDebug) {
				System.out.println("Info from catalog referencing");
				System.out.println("=============================");
				for (FileContentMessage message : catalogMessageLogger
						.getMessages()) {
					Textmarker textmarker = message.getTextmarker();
					if (message.getErrorLevel() != ErrorLevel.DEBUG || isDebug)
					{
						System.out.println(ErrorLevel.INFO.toString()
					
							+ ": (File:" + textmarker.getFilename()+") "
							+ message.getMessage() + " (" + textmarker.getLine()
							+ "," + textmarker.getColumn() + ")");
					}
				}
			}
			

		} catch (ScenarioLoaderException e) {
			System.err.println("Internal error Ocuured");
		}

	}

	private static OpenScenarioImpl executeImportParsing(String filename,
			MessageLogger messageLogger,
			IParserMessageLogger catalogMessageLogger)
			throws ScenarioLoaderException {

		IScenarioLoaderFactory loaderFactory = new XmlScenarioImportLoaderFactory(
				catalogMessageLogger, filename);

		IScenarioLoader loader = loaderFactory
				.createLoader(new FileResourceLocator());
		IOpenScenario openScenario = loader.load(messageLogger);
		return (OpenScenarioImpl) openScenario;

	}

}
