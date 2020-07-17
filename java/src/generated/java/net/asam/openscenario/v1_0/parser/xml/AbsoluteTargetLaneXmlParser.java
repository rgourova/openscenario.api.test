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

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import net.asam.openscenario.common.ErrorLevel;
import net.asam.openscenario.common.FileContentMessage;
import net.asam.openscenario.common.IParserMessageLogger;
import net.asam.openscenario.common.Textmarker;
import net.asam.openscenario.parser.ParserContext;
import net.asam.openscenario.parser.modelgroup.XmlSequenceParser;
import net.asam.openscenario.parser.type.XmlComplexTypeParser;
import net.asam.openscenario.simple.struct.IndexedElement;
import net.asam.openscenario.v1_0.common.OscConstants;
import net.asam.openscenario.v1_0.impl.AbsoluteTargetLaneImpl;
import net.asam.xml.indexer.Position;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a AbsoluteTargetLaneImpl instance from an xml tree.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public class AbsoluteTargetLaneXmlParser extends XmlComplexTypeParser<AbsoluteTargetLaneImpl> {

  /**
   * Constructor
   *
   * @param messageLogger to log messages during parsing
   * @param filename to locate the messages in a file
   */
  public AbsoluteTargetLaneXmlParser(IParserMessageLogger messageLogger, String filename) {
    super(messageLogger, filename);
    subElementParser = new SubElementParser(messageLogger, filename);
  }

  @Override
  public void parseElement(
      IndexedElement indexedElement, ParserContext parserContext, AbsoluteTargetLaneImpl object) {
    messageLogger.logMessage(
        new FileContentMessage(
            "Start Parsing AbsoluteTargetLane",
            ErrorLevel.DEBUG,
            new Textmarker(
                indexedElement.getStartElementLocation().getLine(),
                indexedElement.getStartElementLocation().getColumn(),
                filename)));
    super.parseElement(indexedElement, parserContext, object);
    messageLogger.logMessage(
        new FileContentMessage(
            "End Parsing AbsoluteTargetLane",
            ErrorLevel.DEBUG,
            new Textmarker(
                indexedElement.getEndElementLocation().getLine(),
                indexedElement.getEndElementLocation().getColumn(),
                filename)));
  }

  @Override
  protected Map<String, IAttributeParser<AbsoluteTargetLaneImpl>>
      getAttributeNameToAttributeParserMap() {
    Map<String, IAttributeParser<AbsoluteTargetLaneImpl>> result =
        new Hashtable<String, IAttributeParser<AbsoluteTargetLaneImpl>>();
    result.put(
        OscConstants.ATTRIBUTE__VALUE,
        new IAttributeParser<AbsoluteTargetLaneImpl>() {
          @Override
          public void parse(
              Position startPosition,
              Position endPosition,
              String attributeName,
              String attributeValue,
              AbsoluteTargetLaneImpl object) {

            Textmarker startMarker =
                new Textmarker(startPosition.getLine(), startPosition.getColumn(), filename);
            Textmarker endMarker =
                new Textmarker(endPosition.getLine(), endPosition.getColumn(), filename);
            if (isParametrized(attributeValue)) {
              object.setAttributeParameter(
                  OscConstants.ATTRIBUTE__VALUE, stripDollarSign(attributeValue), startMarker);
            } else {
              // Parse value
              // Simple type
              object.setValue(parseString(attributeValue, startMarker));
            }
            object.putPropertyStartMarker(OscConstants.ATTRIBUTE__VALUE, startMarker);
            object.putPropertyEndMarker(OscConstants.ATTRIBUTE__VALUE, endMarker);
          }

          @Override
          public int getMinOccur() {
            return 1;
          }
        });
    return result;
  }

  /** Parser for all subelements */
  private class SubElementParser extends XmlSequenceParser<AbsoluteTargetLaneImpl> {
    /**
     * Constructor
     *
     * @param messageLogger to log messages during parsing
     * @param filename to locate the messages in a file
     */
    public SubElementParser(IParserMessageLogger messageLogger, String filename) {
      super(messageLogger, filename);
    }
    /*
     * Creates a list of parser
     */
    protected List<IElementParser<AbsoluteTargetLaneImpl>> createParserList() {
      List<IElementParser<AbsoluteTargetLaneImpl>> result =
          new ArrayList<IElementParser<AbsoluteTargetLaneImpl>>();
      return result;
    }
  }
}
