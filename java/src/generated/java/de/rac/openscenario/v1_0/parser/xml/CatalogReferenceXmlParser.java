package de.rac.openscenario.v1_0.parser.xml;

import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.simple.struct.IndexedElement;
import de.rac.openscenario.v1_0.parser.ParserContext;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.xml.indexer.Position;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.parser.WrappedListParser;
import java.util.List;
import de.rac.openscenario.v1_0.api.IParameterAssignment;

import de.rac.openscenario.v1_0.impl.ParameterAssignmentImpl;
import de.rac.openscenario.v1_0.impl.CatalogReferenceImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a CatalogReferenceImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class CatalogReferenceXmlParser extends XmlComplexTypeParser<CatalogReferenceImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public CatalogReferenceXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,CatalogReferenceImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing CatalogReference", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing CatalogReference", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<CatalogReferenceImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<CatalogReferenceImpl>> result  = new Hashtable<String, IAttributeParser<CatalogReferenceImpl>>();
		result.put(OscConstants.ATTRIBUTE__CATALOG_NAME, new IAttributeParser<CatalogReferenceImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, CatalogReferenceImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__CATALOG_NAME, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setCatalogName(parseString(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__CATALOG_NAME, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__CATALOG_NAME, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 1;
			}
			
		});
		result.put(OscConstants.ATTRIBUTE__ENTRY_NAME, new IAttributeParser<CatalogReferenceImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, CatalogReferenceImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__ENTRY_NAME, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setEntryName(parseString(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__ENTRY_NAME, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__ENTRY_NAME, endMarker);
				
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
	private class SubElementParser extends XmlSequenceParser<CatalogReferenceImpl>{
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
		protected  List<IElementParser<CatalogReferenceImpl>> createParserList()
		{
			List<IElementParser<CatalogReferenceImpl>> result = new ArrayList<IElementParser<CatalogReferenceImpl>>();
			result.add(new WrappedListParser<CatalogReferenceImpl>(messageLogger,filename,new SubElementParameterAssignmentsParser(), OscConstants.ELEMENT__PARAMETER_ASSIGNMENTS) );
			return result;
		
		}	
	}
	/**
	 * A parser for subelement parameterAssignments
	 */
	private class SubElementParameterAssignmentsParser implements IElementParser<CatalogReferenceImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementParameterAssignmentsParser()
		{
			super();
			parameterAssignmentXmlParser = new ParameterAssignmentXmlParser(messageLogger, filename);
		}
		private ParameterAssignmentXmlParser parameterAssignmentXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,CatalogReferenceImpl object)
		{
			ParameterAssignmentImpl parameterAssignments = new ParameterAssignmentImpl();
			// Setting the parent
			parameterAssignments.setParent(object);
			parameterAssignmentXmlParser.parseElement(indexedElement,parserContext, parameterAssignments);
			List<IParameterAssignment> parameterAssignmentsList = object.getParameterAssignments();
			if (parameterAssignmentsList == null)
			{
				parameterAssignmentsList = new ArrayList<IParameterAssignment>();
				object.setParameterAssignments( parameterAssignmentsList);
			}
			parameterAssignmentsList.add(parameterAssignments);
			
		}

		@Override
		public int getMinOccur()
		{
			return 0;
		}
		
		@Override
		public int getMaxOccur()
		{
			return -1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return elementName.equals(OscConstants.ELEMENT__PARAMETER_ASSIGNMENT);			
		}
		
		@Override
		public String[] getExpectedTagNames()
		{			return new String[]{OscConstants.ELEMENT__PARAMETER_ASSIGNMENT};
		}
	}
}

