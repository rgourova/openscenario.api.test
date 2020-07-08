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

package de.rac.openscenario.v1_0.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.rac.openscenario.api.IOpenScenarioFlexElement;
import de.rac.openscenario.api.KeyNotSupportedException;
import de.rac.openscenario.loader.FileResourceLocator;
import de.rac.openscenario.loader.IScenarioLoader;
import de.rac.openscenario.loader.IScenarioLoaderFactory;
import de.rac.openscenario.loader.MessageLoggerDecorator;
import de.rac.openscenario.loader.ScenarioLoaderException;
import de.rac.openscenario.v1_0.api.IActors;
import de.rac.openscenario.v1_0.api.IEvent;
import de.rac.openscenario.v1_0.api.IFileHeader;
import de.rac.openscenario.v1_0.api.IInit;
import de.rac.openscenario.v1_0.api.IInitActions;
import de.rac.openscenario.v1_0.api.IManeuver;
import de.rac.openscenario.v1_0.api.IOpenScenario;
import de.rac.openscenario.v1_0.api.IOpenScenarioCategory;
import de.rac.openscenario.v1_0.api.IPrivate;
import de.rac.openscenario.v1_0.api.IPrivateAction;
import de.rac.openscenario.v1_0.api.IRelativeLanePosition;
import de.rac.openscenario.v1_0.api.IScenarioDefinition;
import de.rac.openscenario.v1_0.api.ISpeedAction;
import de.rac.openscenario.v1_0.api.IStoryboard;
import de.rac.openscenario.v1_0.api.ITransitionDynamics;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.loader.XmlScenarioLoaderFactory;

public class TestFlexInterface extends TestBase
{

  
  @Test
  public void testExample() throws ScenarioLoaderException
  {

    MessageLoggerDecorator messageLogger = new MessageLoggerDecorator(this.messageLogger);

    // Instantiating the factory
    IScenarioLoaderFactory loaderFactory = new XmlScenarioLoaderFactory(
        getResourceFile("DoubleLaneChanger.xosc").getAbsolutePath());

    // Creating the loader
    IScenarioLoader loader = loaderFactory.createLoader(new FileResourceLocator());

    // Loading
    IOpenScenario openScenario = (IOpenScenario) loader.load(messageLogger).getAdapter(IOpenScenario.class);

    Assertions.assertFalse(messageLogger.hasErrors());
    
    // Browse through the results
    IFileHeader fileHeader = openScenario.getFileHeader();
      
    IOpenScenarioFlexElement flexElement = (IOpenScenarioFlexElement) fileHeader;
    
    try
    {
      // Date Time
      String expectedDateString  = "2017-02-24 10:00:00";
      Date expectedDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expectedDateString);
      Date date  = flexElement.getDateTimeProperty(OscConstants.ATTRIBUTE__DATE);
      Assertions.assertEquals(expectedDate, date);
      
      // Unsigned Short
      Integer majorRef = flexElement.getUnsignedShortProperty(OscConstants.ATTRIBUTE__REV_MAJOR);    
      Assertions.assertEquals(0, majorRef);
      
      // String 
      String description = flexElement.getStringProperty(OscConstants.ATTRIBUTE__DESCRIPTION);
      Assertions.assertEquals("Sample Scenario - Double Lane Changer", description);
      
      // test Enumeration
      ITransitionDynamics speedActionDynamics = getSpeedActionDynamics(openScenario);
      String enmuerationValue = speedActionDynamics.getEnumerationLiteral(OscConstants.ATTRIBUTE__DYNAMICS_SHAPE);
      Assertions.assertEquals("step", enmuerationValue);
      
      // test Unsigned integer
      IEvent event = getEvent(openScenario);
      Long maximumExecutionCount = event.getUnsignedIntProperty(OscConstants.ATTRIBUTE__MAXIMUM_EXECUTION_COUNT);
      Assertions.assertEquals(2, maximumExecutionCount);
     
      // test Double
      Double value = speedActionDynamics.getDoubleProperty(OscConstants.ATTRIBUTE__VALUE);
      Assertions.assertEquals(2.0D, value);
      
      // testInteger
      IRelativeLanePosition relativeLanePosition = getRelativeLanePosition(event);
      Integer dLane = relativeLanePosition.getIntProperty(OscConstants.ATTRIBUTE__D_LANE);
      Assertions.assertEquals(1, dLane);
      
      // test Boolean
      IActors actors = getActors(openScenario);
      Boolean alongRoute = actors.getBooleanProperty(OscConstants.ATTRIBUTE__SELECT_TRIGGERING_ENTITIES);
      Assertions.assertEquals(Boolean.FALSE, alongRoute);
     
      
      // Test Proxy (Name only)
      String entityRef = relativeLanePosition.getStringProperty(OscConstants.ATTRIBUTE__ENTITY_REF);
      Assertions.assertEquals("Ego", entityRef);
      
      // testParent
      Assertions.assertTrue(event.getParentFlexElement() instanceof IManeuver);
      
      // test type
      Assertions.assertEquals("Event", event.getModelType());
      
      // Exceptions
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getDateTimeProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getUnsignedShortProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getStringProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getDoubleProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getBooleanProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getIntProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getUnsignedIntProperty("Test");
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getReferencedElement("Test", "Ego");
      });
      
      // Exceptions (null Arguments)
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getDateTimeProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getUnsignedShortProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getStringProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getDoubleProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getBooleanProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getIntProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getUnsignedIntProperty(null);
      });
      Assertions.assertThrows(KeyNotSupportedException.class, () -> {
        flexElement.getReferencedElement(null, "Ego");
      });
     
      
    }
    catch (Error | KeyNotSupportedException | ParseException e)
    {
      Assertions.fail();
    }
    
    
  }
  
  private ITransitionDynamics getSpeedActionDynamics(IOpenScenario openScenario)
  {
    IOpenScenarioCategory openScenarioCategory = openScenario.getOpenScenarioCategory();
    Assertions.assertNotNull(openScenarioCategory, "Unexpected null value");
    IScenarioDefinition scenarioDefinition = openScenarioCategory.getScenarioDefinition();
    Assertions.assertNotNull(scenarioDefinition, "Unexpected null value");
    IStoryboard storyboard = scenarioDefinition.getStoryboard();
    Assertions.assertNotNull(storyboard, "Unexpected null value");
    IInit init = storyboard.getInit();
    Assertions.assertNotNull(init, "Unexpected null value");
    IInitActions actions = init.getActions();
    Assertions.assertNotNull(actions, "Unexpected null value");
    List<IPrivate> privates = actions.getPrivates();
    Assertions.assertNotNull(privates, "Unexpected null value");
    Assertions.assertEquals(3, privates.size());
    IPrivate privateAction = privates.get(0);
    List<IPrivateAction> privateActions = privateAction.getPrivateActions();
    Assertions.assertEquals(2, privateActions.size());
    ISpeedAction speedAction  = privateActions.get(0).getLongitudinalAction().getSpeedAction();
    return speedAction.getSpeedActionDynamics();
    
  }
  
  private IEvent getEvent(IOpenScenario openScenario)
  {
    IOpenScenarioCategory openScenarioCategory = openScenario.getOpenScenarioCategory();
    IScenarioDefinition scenarioDefinition = openScenarioCategory.getScenarioDefinition();
    IStoryboard storyboard = scenarioDefinition.getStoryboard();
    return storyboard.getStories().get(0).getActs().get(0).getManeuverGroups().get(0).getManeuvers().get(0).getEvents().get(0);
    
  }
  
  private IRelativeLanePosition getRelativeLanePosition(IEvent event)
  {
   
    return event.getActions().get(1).getPrivateAction().getRoutingAction().getAcquirePositionAction().getPosition().getRelativeLanePosition();
    
  }
  
  private IActors getActors(IOpenScenario openScenario)
  {
    IOpenScenarioCategory openScenarioCategory = openScenario.getOpenScenarioCategory();
    IScenarioDefinition scenarioDefinition = openScenarioCategory.getScenarioDefinition();
    IStoryboard storyboard = scenarioDefinition.getStoryboard();
    return storyboard.getStories().get(0).getActs().get(0).getManeuverGroups().get(0).getActors();
    
  }
  

}