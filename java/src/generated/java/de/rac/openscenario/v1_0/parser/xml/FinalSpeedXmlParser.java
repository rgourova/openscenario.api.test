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

import de.rac.openscenario.v1_0.impl.AbsoluteSpeedImpl;
import de.rac.openscenario.v1_0.impl.RelativeSpeedToMasterImpl;
import de.rac.openscenario.v1_0.impl.FinalSpeedImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlChoiceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a FinalSpeedImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class FinalSpeedXmlParser extends XmlComplexTypeParser<FinalSpeedImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public FinalSpeedXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,FinalSpeedImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing FinalSpeed", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing FinalSpeed", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<FinalSpeedImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<FinalSpeedImpl>> result  = new Hashtable<String, IAttributeParser<FinalSpeedImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlChoiceParser<FinalSpeedImpl>{
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
		protected  List<IElementParser<FinalSpeedImpl>> createParserList()
		{
			List<IElementParser<FinalSpeedImpl>> result = new ArrayList<IElementParser<FinalSpeedImpl>>();
			result.add(new SubElementAbsoluteSpeedParser());
			result.add(new SubElementRelativeSpeedToMasterParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement absoluteSpeed
	 */
	private class SubElementAbsoluteSpeedParser implements IElementParser<FinalSpeedImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementAbsoluteSpeedParser()
		{
			super();
			absoluteSpeedXmlParser = new AbsoluteSpeedXmlParser(messageLogger, filename);
		}
		private AbsoluteSpeedXmlParser absoluteSpeedXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,FinalSpeedImpl object)
		{
			AbsoluteSpeedImpl absoluteSpeed = new AbsoluteSpeedImpl();
			// Setting the parent
			absoluteSpeed.setParent(object);
			absoluteSpeedXmlParser.parseElement(indexedElement,parserContext, absoluteSpeed);

			object.setAbsoluteSpeed( absoluteSpeed);
			
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
				elementName.equals(OscConstants.ELEMENT__ABSOLUTE_SPEED) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__ABSOLUTE_SPEED
					};
		}
	}
	/**
	 * A parser for subelement relativeSpeedToMaster
	 */
	private class SubElementRelativeSpeedToMasterParser implements IElementParser<FinalSpeedImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementRelativeSpeedToMasterParser()
		{
			super();
			relativeSpeedToMasterXmlParser = new RelativeSpeedToMasterXmlParser(messageLogger, filename);
		}
		private RelativeSpeedToMasterXmlParser relativeSpeedToMasterXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,FinalSpeedImpl object)
		{
			RelativeSpeedToMasterImpl relativeSpeedToMaster = new RelativeSpeedToMasterImpl();
			// Setting the parent
			relativeSpeedToMaster.setParent(object);
			relativeSpeedToMasterXmlParser.parseElement(indexedElement,parserContext, relativeSpeedToMaster);

			object.setRelativeSpeedToMaster( relativeSpeedToMaster);
			
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
				elementName.equals(OscConstants.ELEMENT__RELATIVE_SPEED_TO_MASTER) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__RELATIVE_SPEED_TO_MASTER
					};
		}
	}
}
