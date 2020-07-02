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

import de.rac.openscenario.v1_0.impl.MiscObjectCatalogLocationImpl;
import de.rac.openscenario.v1_0.impl.DirectoryImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlAllParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a MiscObjectCatalogLocationImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class MiscObjectCatalogLocationXmlParser extends XmlComplexTypeParser<MiscObjectCatalogLocationImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public MiscObjectCatalogLocationXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,MiscObjectCatalogLocationImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing MiscObjectCatalogLocation", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing MiscObjectCatalogLocation", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<MiscObjectCatalogLocationImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<MiscObjectCatalogLocationImpl>> result  = new Hashtable<String, IAttributeParser<MiscObjectCatalogLocationImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlAllParser<MiscObjectCatalogLocationImpl>{
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
		protected  List<IElementParser<MiscObjectCatalogLocationImpl>> createParserList()
		{
			List<IElementParser<MiscObjectCatalogLocationImpl>> result = new ArrayList<IElementParser<MiscObjectCatalogLocationImpl>>();
			result.add(new SubElementDirectoryParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement directory
	 */
	private class SubElementDirectoryParser implements IElementParser<MiscObjectCatalogLocationImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementDirectoryParser()
		{
			super();
			directoryXmlParser = new DirectoryXmlParser(messageLogger, filename);
		}
		private DirectoryXmlParser directoryXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,MiscObjectCatalogLocationImpl object)
		{
			DirectoryImpl directory = new DirectoryImpl();
			// Setting the parent
			directory.setParent(object);
			directoryXmlParser.parseElement(indexedElement,parserContext, directory);

			object.setDirectory( directory);
			
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
				elementName.equals(OscConstants.ELEMENT__DIRECTORY) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__DIRECTORY
					};
		}
	}
}
