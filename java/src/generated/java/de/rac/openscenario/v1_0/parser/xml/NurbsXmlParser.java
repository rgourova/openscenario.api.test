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
import de.rac.openscenario.v1_0.api.IKnot;
import de.rac.openscenario.v1_0.api.IControlPoint;

import de.rac.openscenario.v1_0.impl.KnotImpl;
import de.rac.openscenario.v1_0.impl.ControlPointImpl;
import de.rac.openscenario.v1_0.impl.NurbsImpl;


import de.rac.openscenario.v1_0.parser.modelgroup.XmlSequenceParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a NurbsImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class NurbsXmlParser extends XmlComplexTypeParser<NurbsImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public NurbsXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,NurbsImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing Nurbs", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing Nurbs", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<NurbsImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<NurbsImpl>> result  = new Hashtable<String, IAttributeParser<NurbsImpl>>();
		result.put(OscConstants.ATTRIBUTE__ORDER, new IAttributeParser<NurbsImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, NurbsImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__ORDER, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setOrder(parseUnsignedInt(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__ORDER, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__ORDER, endMarker);
				
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
	private class SubElementParser extends XmlSequenceParser<NurbsImpl>{
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
		protected  List<IElementParser<NurbsImpl>> createParserList()
		{
			List<IElementParser<NurbsImpl>> result = new ArrayList<IElementParser<NurbsImpl>>();
			result.add(new SubElementControlPointsParser());
			result.add(new SubElementKnotsParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement controlPoints
	 */
	private class SubElementControlPointsParser implements IElementParser<NurbsImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementControlPointsParser()
		{
			super();
			controlPointXmlParser = new ControlPointXmlParser(messageLogger, filename);
		}
		private ControlPointXmlParser controlPointXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,NurbsImpl object)
		{
			ControlPointImpl controlPoints = new ControlPointImpl();
			// Setting the parent
			controlPoints.setParent(object);
			controlPointXmlParser.parseElement(indexedElement,parserContext, controlPoints);
			List<IControlPoint> controlPointsList = object.getControlPoints();
			if (controlPointsList == null)
			{
				controlPointsList = new ArrayList<IControlPoint>();
				object.setControlPoints( controlPointsList);
			}
			controlPointsList.add(controlPoints);
			
		}

		@Override
		public int getMinOccur()
		{
			return 2;
		}
		
		@Override
		public int getMaxOccur()
		{
			return -1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__CONTROL_POINT) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__CONTROL_POINT
					};
		}
	}
	/**
	 * A parser for subelement knots
	 */
	private class SubElementKnotsParser implements IElementParser<NurbsImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementKnotsParser()
		{
			super();
			knotXmlParser = new KnotXmlParser(messageLogger, filename);
		}
		private KnotXmlParser knotXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,NurbsImpl object)
		{
			KnotImpl knots = new KnotImpl();
			// Setting the parent
			knots.setParent(object);
			knotXmlParser.parseElement(indexedElement,parserContext, knots);
			List<IKnot> knotsList = object.getKnots();
			if (knotsList == null)
			{
				knotsList = new ArrayList<IKnot>();
				object.setKnots( knotsList);
			}
			knotsList.add(knots);
			
		}

		@Override
		public int getMinOccur()
		{
			return 2;
		}
		
		@Override
		public int getMaxOccur()
		{
			return -1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__KNOT) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__KNOT
					};
		}
	}
}
