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

import de.rac.openscenario.v1_0.impl.LongitudinalDistanceActionImpl;
import de.rac.openscenario.v1_0.impl.SpeedActionImpl;
import de.rac.openscenario.v1_0.impl.LongitudinalActionImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlChoiceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a LongitudinalActionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class LongitudinalActionXmlParser extends XmlComplexTypeParser<LongitudinalActionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public LongitudinalActionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,LongitudinalActionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing LongitudinalAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing LongitudinalAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<LongitudinalActionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<LongitudinalActionImpl>> result  = new Hashtable<String, IAttributeParser<LongitudinalActionImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlChoiceParser<LongitudinalActionImpl>{
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
		protected  List<IElementParser<LongitudinalActionImpl>> createParserList()
		{
			List<IElementParser<LongitudinalActionImpl>> result = new ArrayList<IElementParser<LongitudinalActionImpl>>();
			result.add(new SubElementSpeedActionParser());
			result.add(new SubElementLongitudinalDistanceActionParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement speedAction
	 */
	private class SubElementSpeedActionParser implements IElementParser<LongitudinalActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementSpeedActionParser()
		{
			super();
			speedActionXmlParser = new SpeedActionXmlParser(messageLogger, filename);
		}
		private SpeedActionXmlParser speedActionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,LongitudinalActionImpl object)
		{
			SpeedActionImpl speedAction = new SpeedActionImpl();
			// Setting the parent
			speedAction.setParent(object);
			speedActionXmlParser.parseElement(indexedElement,parserContext, speedAction);

			object.setSpeedAction( speedAction);
			
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
				elementName.equals(OscConstants.ELEMENT__SPEED_ACTION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__SPEED_ACTION
					};
		}
	}
	/**
	 * A parser for subelement longitudinalDistanceAction
	 */
	private class SubElementLongitudinalDistanceActionParser implements IElementParser<LongitudinalActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementLongitudinalDistanceActionParser()
		{
			super();
			longitudinalDistanceActionXmlParser = new LongitudinalDistanceActionXmlParser(messageLogger, filename);
		}
		private LongitudinalDistanceActionXmlParser longitudinalDistanceActionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,LongitudinalActionImpl object)
		{
			LongitudinalDistanceActionImpl longitudinalDistanceAction = new LongitudinalDistanceActionImpl();
			// Setting the parent
			longitudinalDistanceAction.setParent(object);
			longitudinalDistanceActionXmlParser.parseElement(indexedElement,parserContext, longitudinalDistanceAction);

			object.setLongitudinalDistanceAction( longitudinalDistanceAction);
			
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
				elementName.equals(OscConstants.ELEMENT__LONGITUDINAL_DISTANCE_ACTION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__LONGITUDINAL_DISTANCE_ACTION
					};
		}
	}
}
