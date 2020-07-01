package de.rac.openscenario.v1_0.parser.type;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.impl.BaseImpl;
import de.rac.openscenario.v1_0.parser.ParserContext;
import de.rac.openscenario.v1_0.parser.XmlModelGroupParser;
import de.rac.openscenario.v1_0.parser.XmlParserBase;
import de.rac.openscenario.v1_0.simple.struct.IndexedElement;
import de.rac.xml.indexer.Position;

/**
 * Parsing an XSD:complexType
 * 
 * @author Andreas Hege - RA Consulting
 *
 */
public abstract class XmlComplexTypeParser<T extends BaseImpl> extends XmlParserBase<T> implements IXmlTypeParser<T> {
	
	protected XmlModelGroupParser<T> subElementParser;
	private Map<String, IAttributeParser<T>> attributeNameToAttributeParser;

	/**
	 * A dictionary that maps an attribute names to their parser.
	 * @return the name to parser dictionary
	 */
	protected abstract Map<String, IAttributeParser<T>> getAttributeNameToAttributeParserMap();
	
	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing process
	 * @param filename of the file the parser is operating on.
	 */
	public XmlComplexTypeParser(
			IParserMessageLogger messageLogger, String filename ) {
		super( messageLogger, filename);

		
	}
	/**
	 * parses all atrributes and fills them into the object
	 * @param indexedElement the element to be parsed
	 * @param object the object that will be filled during the parsing process.
	 */
	protected void parseAttributes(IndexedElement indexedElement, T object) {
		attributeNameToAttributeParser = getAttributeNameToAttributeParserMap();
		Element element = indexedElement.getElement();
		NamedNodeMap attributeMap = element.getAttributes();
		Position position = indexedElement.getStartElementLocation();
		for (int i = 0; i< attributeMap.getLength(); i++)
		{
			Node attributeNode = attributeMap.item(i);
			
			String attributeName = attributeNode.getNodeName();
			String attributeValue = attributeNode.getNodeValue();
			IAttributeParser<T> parser = attributeNameToAttributeParser.get(attributeName);
			Position attributeStartPosition = indexedElement.getAttributeStartPosition(attributeName);
			Position attributeEndPosition = indexedElement.getAttributeEndPosition(attributeName);
			
			if (attributeName.contains(":"))
			{
				messageLogger.logMessage(new FileContentMessage("Ignoring attribute '"+attributeName+"'", ErrorLevel.INFO,  new Textmarker(attributeStartPosition.getLine(), attributeStartPosition.getColumn(), filename)));
			}
			else if (parser == null )
			{
				messageLogger.logMessage(new FileContentMessage("Unknown attribute '"+attributeName+"'", ErrorLevel.ERROR,  new Textmarker(attributeStartPosition.getLine(), attributeStartPosition.getColumn(), filename)));
			}else
			{
				parser.parse(attributeStartPosition, attributeEndPosition, attributeName, attributeValue, object);
				// Remove 
				attributeNameToAttributeParser.remove(attributeName);
			}
		}
		
		for (String attributeName : attributeNameToAttributeParser.keySet()) {
			if (attributeNameToAttributeParser.get(attributeName).getMinOccur()> 0)
			{
				messageLogger.logMessage(new FileContentMessage("Required attribute '"+attributeName+"' is missing ", ErrorLevel.ERROR,  new Textmarker(position.getLine(), position.getColumn(), filename)));
			}
		}

		
	}
	
	

	@Override
	public void parseElement(IndexedElement indexedElement,ParserContext parserContext, T object)  {
		// The element was requested before, so it cannot be null
		Position position = indexedElement.getStartElementLocation();
		String elementName = indexedElement.getElement().getNodeName();
		if (indexedElement.isMixedNode())
		{
			messageLogger.logMessage(new FileContentMessage("Element '"+elementName+"' contains text. Only subelements allowed.", ErrorLevel.ERROR,  new Textmarker(position.getLine(), position.getColumn(), filename)));
		}
		parseAttributes(indexedElement, object);
		parseSubElements(indexedElement.getSubElements(),parserContext, object);
		parserContext.setLastElementParsed(indexedElement);
		Position startPosition = indexedElement.getStartElementLocation();
		object.setStartMarker(new Textmarker(startPosition.getLine(), startPosition.getColumn(), filename));
		Position endPosition = indexedElement.getStartElementLocation();
		object.setEndMarker(new Textmarker(endPosition.getLine(), endPosition.getColumn(), filename));
		
	}

	/**
	 * Checks for paramterized value ($-notation)
	 * @param value value
	 * @return tue if the attribute has a prameter instead of a literal value
	 */
	protected boolean isParametrized(String value)
	{
		// Only Dollar will result in "$"
		return value.startsWith("$") && value.length() > 1;
	}
	/**
	 * Stripes the '$' from a name when the value starts with '$'
	 * @param value value that might start with a '$'
	 * @return value without a starting '$'
	 */
	protected String stripDollarSign(String value)
	{
		if (value.startsWith("$"))
		{
			if (value.length() > 1)
			{
				return value.substring(1);
			}else
			{
				return "";
			}
		}else
		{
			return value;
		}
	}
	
	@Override
	public void parseSubElements(List<IndexedElement> indexedElements,ParserContext parserContext, T object) {
		
		subElementParser.parseSubElements(indexedElements,parserContext, object);
		
		
	}
	
	
	

}
