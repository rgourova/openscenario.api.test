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

import de.rac.openscenario.v1_0.impl.TrafficSignalControllerActionImpl;
import de.rac.openscenario.v1_0.impl.TrafficSignalActionImpl;
import de.rac.openscenario.v1_0.impl.TrafficSignalStateActionImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlChoiceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a TrafficSignalActionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class TrafficSignalActionXmlParser extends XmlComplexTypeParser<TrafficSignalActionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public TrafficSignalActionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,TrafficSignalActionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing TrafficSignalAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing TrafficSignalAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<TrafficSignalActionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<TrafficSignalActionImpl>> result  = new Hashtable<String, IAttributeParser<TrafficSignalActionImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlChoiceParser<TrafficSignalActionImpl>{
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
		protected  List<IElementParser<TrafficSignalActionImpl>> createParserList()
		{
			List<IElementParser<TrafficSignalActionImpl>> result = new ArrayList<IElementParser<TrafficSignalActionImpl>>();
			result.add(new SubElementTrafficSignalControllerActionParser());
			result.add(new SubElementTrafficSignalStateActionParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement trafficSignalControllerAction
	 */
	private class SubElementTrafficSignalControllerActionParser implements IElementParser<TrafficSignalActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTrafficSignalControllerActionParser()
		{
			super();
			trafficSignalControllerActionXmlParser = new TrafficSignalControllerActionXmlParser(messageLogger, filename);
		}
		private TrafficSignalControllerActionXmlParser trafficSignalControllerActionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TrafficSignalActionImpl object)
		{
			TrafficSignalControllerActionImpl trafficSignalControllerAction = new TrafficSignalControllerActionImpl();
			// Setting the parent
			trafficSignalControllerAction.setParent(object);
			trafficSignalControllerActionXmlParser.parseElement(indexedElement,parserContext, trafficSignalControllerAction);

			object.setTrafficSignalControllerAction( trafficSignalControllerAction);
			
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
				elementName.equals(OscConstants.ELEMENT__TRAFFIC_SIGNAL_CONTROLLER_ACTION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__TRAFFIC_SIGNAL_CONTROLLER_ACTION
					};
		}
	}
	/**
	 * A parser for subelement trafficSignalStateAction
	 */
	private class SubElementTrafficSignalStateActionParser implements IElementParser<TrafficSignalActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTrafficSignalStateActionParser()
		{
			super();
			trafficSignalStateActionXmlParser = new TrafficSignalStateActionXmlParser(messageLogger, filename);
		}
		private TrafficSignalStateActionXmlParser trafficSignalStateActionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TrafficSignalActionImpl object)
		{
			TrafficSignalStateActionImpl trafficSignalStateAction = new TrafficSignalStateActionImpl();
			// Setting the parent
			trafficSignalStateAction.setParent(object);
			trafficSignalStateActionXmlParser.parseElement(indexedElement,parserContext, trafficSignalStateAction);

			object.setTrafficSignalStateAction( trafficSignalStateAction);
			
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
				elementName.equals(OscConstants.ELEMENT__TRAFFIC_SIGNAL_STATE_ACTION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__TRAFFIC_SIGNAL_STATE_ACTION
					};
		}
	}
}
