package de.rac.openscenario.v1_0.simple.struct;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.rac.xml.indexer.PositionIndex;

/**
 * Connects a dom node and textural positions to a IndexedElement
 * The dom nodes are located in a document. The textual informations are located in a indexed list.
 * 
 * @author Andreas Hege - RA Consulting
 *
 */
public class XmlToSimpleNodeConverter {

	private int counter = 0;
	private PositionIndex positionIndex;

	/**
	 * Constructor
	 * @param positionIndex position of the DOM Node and the textual information.
	 */
	public XmlToSimpleNodeConverter(PositionIndex positionIndex) {
		super();
		this.positionIndex = positionIndex;
	}
	
	/**
	 * Creates a IndexedElement root element from a DOM document
	 * @param document
	 * @return
	 */
	public IndexedElement convert(Document document)
	{
		Element element = document.getDocumentElement();
		IndexedElement indexedElement = new IndexedElement(element,positionIndex.getElementNode(counter++), null);
		convertInternal(indexedElement);
		return indexedElement;
		
	}
	/**
	 * Internal conversion method
	 * @param indexedElement the indexed element
	 */
	private void convertInternal(IndexedElement indexedElement)
	{
		Element element = indexedElement.getElement();
		
		NodeList childNodes = element.getChildNodes();
		boolean hasChildren = false;
		boolean hasNonIgnorableText = false;
		StringBuffer buffer = new StringBuffer();
		for( int i = 0; i< childNodes.getLength();i++)
		{
			Node node = childNodes.item(i);
			short nodeType = node.getNodeType();
			if (nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE)
			{
				String text = node.getTextContent();
				hasNonIgnorableText = hasNonIgnorableText | !isIgnorableWhitespace(text);
				buffer.append(text);
				
			}
			else if (nodeType == Node.ELEMENT_NODE)
			{
				hasChildren = true;
				IndexedElement indexedSubElement= new IndexedElement((Element) node,positionIndex.getElementNode(counter++), indexedElement);
				indexedElement.addSubElement(indexedSubElement);
				convertInternal(indexedSubElement);
			}
			
			
		}
		if (!hasChildren && hasNonIgnorableText)
		{
			indexedElement.setCharacters(buffer.toString());
		}else if (hasChildren && hasNonIgnorableText)
		{
			indexedElement.setMixedNode(true);
		}
	}
	/**
	 * Check whether the characters in data are all ignorable whitespaces 
	 * @param data data to test
	 * @return true if characters are all ignorable whitespace characters
	 */
	private boolean isIgnorableWhitespace(String data) {

		return data.matches("^(\\r\\n| \\n|\\s)+$");
	}
	
	
}