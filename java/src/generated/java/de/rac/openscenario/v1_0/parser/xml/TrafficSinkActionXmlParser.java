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

import de.rac.openscenario.v1_0.impl.PositionImpl;
import de.rac.openscenario.v1_0.impl.TrafficDefinitionImpl;
import de.rac.openscenario.v1_0.impl.TrafficSinkActionImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlAllParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a TrafficSinkActionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class TrafficSinkActionXmlParser extends XmlComplexTypeParser<TrafficSinkActionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public TrafficSinkActionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,TrafficSinkActionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing TrafficSinkAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing TrafficSinkAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<TrafficSinkActionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<TrafficSinkActionImpl>> result  = new Hashtable<String, IAttributeParser<TrafficSinkActionImpl>>();
		result.put(OscConstants.ATTRIBUTE__RATE, new IAttributeParser<TrafficSinkActionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, TrafficSinkActionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__RATE, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setRate(parseDouble(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__RATE, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__RATE, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 0;
			}
			
		});
		result.put(OscConstants.ATTRIBUTE__RADIUS, new IAttributeParser<TrafficSinkActionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, TrafficSinkActionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__RADIUS, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setRadius(parseDouble(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__RADIUS, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__RADIUS, endMarker);
				
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
	private class SubElementParser extends XmlAllParser<TrafficSinkActionImpl>{
		/**
		 * Constructor
		 * @param messageLogger to log messages during parsing
		 * @param filename to locate the messages in a file
		 */
		public SubElementParser (IParserMessageLogger messageLogger, String filename) {
			super(messageLogger,filename);	
		}
		/*
		 * Creates a list of parser
		 */
		protected  List<IElementParser<TrafficSinkActionImpl>> createParserList()
		{
			List<IElementParser<TrafficSinkActionImpl>> result = new ArrayList<IElementParser<TrafficSinkActionImpl>>();
			result.add(new SubElementPositionParser());
			result.add(new SubElementTrafficDefinitionParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement position
	 */
	private class SubElementPositionParser implements IElementParser<TrafficSinkActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementPositionParser()
		{
			super();
			positionXmlParser = new PositionXmlParser(messageLogger, filename);
		}
		private PositionXmlParser positionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TrafficSinkActionImpl object)
		{
			PositionImpl position = new PositionImpl();
			// Setting the parent
			position.setParent(object);
			positionXmlParser.parseElement(indexedElement,parserContext, position);

			object.setPosition( position);
			
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
				elementName.equals(OscConstants.ELEMENT__POSITION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__POSITION
					};
		}
	}
	/**
	 * A parser for subelement trafficDefinition
	 */
	private class SubElementTrafficDefinitionParser implements IElementParser<TrafficSinkActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTrafficDefinitionParser()
		{
			super();
			trafficDefinitionXmlParser = new TrafficDefinitionXmlParser(messageLogger, filename);
		}
		private TrafficDefinitionXmlParser trafficDefinitionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TrafficSinkActionImpl object)
		{
			TrafficDefinitionImpl trafficDefinition = new TrafficDefinitionImpl();
			// Setting the parent
			trafficDefinition.setParent(object);
			trafficDefinitionXmlParser.parseElement(indexedElement,parserContext, trafficDefinition);

			object.setTrafficDefinition( trafficDefinition);
			
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
				elementName.equals(OscConstants.ELEMENT__TRAFFIC_DEFINITION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__TRAFFIC_DEFINITION
					};
		}
	}
}
