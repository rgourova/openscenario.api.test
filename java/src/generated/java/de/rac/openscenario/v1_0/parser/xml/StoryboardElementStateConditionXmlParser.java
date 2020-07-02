package de.rac.openscenario.v1_0.parser.xml;

import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.simple.struct.IndexedElement;
import de.rac.openscenario.v1_0.parser.ParserContext;
import de.rac.openscenario.v1_0.impl.NamedReferenceProxy;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.xml.indexer.Position;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.common.ErrorLevel;

import java.util.List;
import de.rac.openscenario.v1_0.api.IStoryboardElement;
import de.rac.openscenario.v1_0.api.StoryboardElementState;
import de.rac.openscenario.v1_0.api.StoryboardElementType;

import de.rac.openscenario.v1_0.impl.StoryboardElementStateConditionImpl;

import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a StoryboardElementStateConditionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class StoryboardElementStateConditionXmlParser extends XmlComplexTypeParser<StoryboardElementStateConditionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public StoryboardElementStateConditionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,StoryboardElementStateConditionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing StoryboardElementStateCondition", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing StoryboardElementStateCondition", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<StoryboardElementStateConditionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<StoryboardElementStateConditionImpl>> result  = new Hashtable<String, IAttributeParser<StoryboardElementStateConditionImpl>>();
		result.put(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_TYPE, new IAttributeParser<StoryboardElementStateConditionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, StoryboardElementStateConditionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_TYPE, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Enumeration Type
					StoryboardElementType result = StoryboardElementType.getFromLiteral(attributeValue);
					if (result != null)
					{
						object.setStoryboardElementType(result);
					}else
					{
						messageLogger.logMessage(new FileContentMessage( "Value '"+attributeValue+"' is not allowed.",ErrorLevel.ERROR, startMarker));
					}
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_TYPE, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_TYPE, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 1;
			}
			
		});
		result.put(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_REF, new IAttributeParser<StoryboardElementStateConditionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, StoryboardElementStateConditionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_REF, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Proxy
					NamedReferenceProxy<IStoryboardElement> proxy = new NamedReferenceProxy<IStoryboardElement> (attributeValue);
					proxy.setParent(object);
					object.setStoryboardElementRef(proxy);
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_REF, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__STORYBOARD_ELEMENT_REF, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 1;
			}
			
		});
		result.put(OscConstants.ATTRIBUTE__STATE, new IAttributeParser<StoryboardElementStateConditionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, StoryboardElementStateConditionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__STATE, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Enumeration Type
					StoryboardElementState result = StoryboardElementState.getFromLiteral(attributeValue);
					if (result != null)
					{
						object.setState(result);
					}else
					{
						messageLogger.logMessage(new FileContentMessage( "Value '"+attributeValue+"' is not allowed.",ErrorLevel.ERROR, startMarker));
					}
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__STATE, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__STATE, endMarker);
				
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
	private class SubElementParser extends XmlSequenceParser<StoryboardElementStateConditionImpl>{
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
		protected  List<IElementParser<StoryboardElementStateConditionImpl>> createParserList()
		{
			List<IElementParser<StoryboardElementStateConditionImpl>> result = new ArrayList<IElementParser<StoryboardElementStateConditionImpl>>();
			return result;
		
		}	
	}
}
