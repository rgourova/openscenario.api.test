/*
 * Copyright 2020 RA Consulting
 *
 * RA Consulting GmbH licenses this file under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except 
 * in compliance with the License. 
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.asam.openscenario.v1_0.parser.xml;

import net.asam.openscenario.common.IParserMessageLogger;
import net.asam.openscenario.v1_0.common.OscConstants;
import net.asam.openscenario.simple.struct.IndexedElement;
import net.asam.openscenario.parser.ParserContext;
import net.asam.openscenario.v1_0.parser.CatalogReferenceParserContext;
import net.asam.openscenario.common.FileContentMessage;
import net.asam.xml.indexer.Position;
import net.asam.openscenario.common.Textmarker;
import net.asam.openscenario.common.ErrorLevel;
import java.util.List;

import net.asam.openscenario.v1_0.impl.ControllerImpl;
import net.asam.openscenario.v1_0.impl.AssignControllerActionImpl;
import net.asam.openscenario.v1_0.impl.CatalogReferenceImpl;


import net.asam.openscenario.parser.modelgroup.XmlChoiceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import net.asam.openscenario.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a AssignControllerActionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class AssignControllerActionXmlParser extends XmlComplexTypeParser<AssignControllerActionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public AssignControllerActionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,AssignControllerActionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing AssignControllerAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing AssignControllerAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<AssignControllerActionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<AssignControllerActionImpl>> result  = new Hashtable<String, IAttributeParser<AssignControllerActionImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlChoiceParser<AssignControllerActionImpl>{
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
		protected  List<IElementParser<AssignControllerActionImpl>> createParserList()
		{
			List<IElementParser<AssignControllerActionImpl>> result = new ArrayList<IElementParser<AssignControllerActionImpl>>();
			result.add(new SubElementControllerParser());
			result.add(new SubElementCatalogReferenceParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement controller
	 */
	private class SubElementControllerParser implements IElementParser<AssignControllerActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementControllerParser()
		{
			super();
			controllerXmlParser = new ControllerXmlParser(messageLogger, filename);
		}
		private ControllerXmlParser controllerXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,AssignControllerActionImpl object)
		{
			ControllerImpl controller = new ControllerImpl();
			// Setting the parent
			controller.setParent(object);
			controllerXmlParser.parseElement(indexedElement,parserContext, controller);

			object.setController( controller);
			
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
				elementName.equals(OscConstants.ELEMENT__CONTROLLER) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CONTROLLER
					};
		}
	}
	/**
	 * A parser for subelement catalogReference
	 */
	private class SubElementCatalogReferenceParser implements IElementParser<AssignControllerActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementCatalogReferenceParser()
		{
			super();
			catalogReferenceXmlParser = new CatalogReferenceXmlParser(messageLogger, filename);
		}
		private CatalogReferenceXmlParser catalogReferenceXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,AssignControllerActionImpl object)
		{
			CatalogReferenceImpl catalogReference = new CatalogReferenceImpl();
			// Setting the parent
			catalogReference.setParent(object);
			catalogReferenceXmlParser.parseElement(indexedElement,parserContext, catalogReference);

			object.setCatalogReference( catalogReference);
			((CatalogReferenceParserContext)parserContext).addCatalogReference(catalogReference);
			
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
				elementName.equals(OscConstants.ELEMENT__CATALOG_REFERENCE) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CATALOG_REFERENCE
					};
		}
	}
}

