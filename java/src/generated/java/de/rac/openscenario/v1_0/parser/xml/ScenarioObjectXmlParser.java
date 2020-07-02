package de.rac.openscenario.v1_0.parser.xml;

import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.simple.struct.IndexedElement;
import de.rac.openscenario.v1_0.parser.ParserContext;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.xml.indexer.Position;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import java.util.List;

import de.rac.openscenario.v1_0.impl.ScenarioObjectImpl;
import de.rac.openscenario.v1_0.impl.EntityObjectImpl;
import de.rac.openscenario.v1_0.impl.ObjectControllerImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a ScenarioObjectImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class ScenarioObjectXmlParser extends XmlComplexTypeParser<ScenarioObjectImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public ScenarioObjectXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,ScenarioObjectImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing ScenarioObject", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing ScenarioObject", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<ScenarioObjectImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<ScenarioObjectImpl>> result  = new Hashtable<String, IAttributeParser<ScenarioObjectImpl>>();
		result.put(OscConstants.ATTRIBUTE__NAME, new IAttributeParser<ScenarioObjectImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, ScenarioObjectImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__NAME, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setName(parseString(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__NAME, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__NAME, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 1;
			}
			
		});
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlSequenceParser<ScenarioObjectImpl>{
		/**
		 * Constructor
		 * @param messageLogger to log messages during parsing
		 * @param filename to locate the messages in a file
		 */
		public SubElementParser (IParserMessageLogger messageLogger, String filename) {
			super( messageLogger, filename);	
		}
		/*
		 * Creates a list of parser
		 */
		protected  List<IElementParser<ScenarioObjectImpl>> createParserList()
		{
			List<IElementParser<ScenarioObjectImpl>> result = new ArrayList<IElementParser<ScenarioObjectImpl>>();
			result.add(new SubElementEntityObjectParser());
			result.add(new SubElementObjectControllerParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement entityObject
	 */
	private class SubElementEntityObjectParser implements IElementParser<ScenarioObjectImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementEntityObjectParser()
		{
			super();
			entityObjectXmlParser = new EntityObjectXmlParser(messageLogger, filename);
		}
		private EntityObjectXmlParser entityObjectXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,ScenarioObjectImpl object)
		{
			EntityObjectImpl entityObject = new EntityObjectImpl();
			// Setting the parent
			entityObject.setParent(object);
			entityObjectXmlParser.parseElement(indexedElement,parserContext, entityObject);

			object.setEntityObject( entityObject);
			
		}

		@Override
		public int getMinOccur()
		{
			return 1;
		}
		
		@Override
		public int getMaxOccur()
		{
			return 1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__CATALOG_REFERENCE) || 
				elementName.equals(OscConstants.ELEMENT__VEHICLE) || 
				elementName.equals(OscConstants.ELEMENT__PEDESTRIAN) || 
				elementName.equals(OscConstants.ELEMENT__MISC_OBJECT) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CATALOG_REFERENCE,
				OscConstants.ELEMENT__VEHICLE,
				OscConstants.ELEMENT__PEDESTRIAN,
				OscConstants.ELEMENT__MISC_OBJECT
					};
		}
	}
	/**
	 * A parser for subelement objectController
	 */
	private class SubElementObjectControllerParser implements IElementParser<ScenarioObjectImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementObjectControllerParser()
		{
			super();
			objectControllerXmlParser = new ObjectControllerXmlParser(messageLogger, filename);
		}
		private ObjectControllerXmlParser objectControllerXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,ScenarioObjectImpl object)
		{
			ObjectControllerImpl objectController = new ObjectControllerImpl();
			// Setting the parent
			objectController.setParent(object);
			objectControllerXmlParser.parseElement(indexedElement,parserContext, objectController);

			object.setObjectController( objectController);
			
		}

		@Override
		public int getMinOccur()
		{
			return 0;
		}
		
		@Override
		public int getMaxOccur()
		{
			return 1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__OBJECT_CONTROLLER) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__OBJECT_CONTROLLER
					};
		}
	}
}
