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
package net.asam.openscenario.v1_0.api.writer;

import net.asam.openscenario.api.IOpenScenarioModelElement;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 *
 * <p>A Writer for the type 'TimeOfDay' From OpenSCENARIO class model specification: Defines the day
 * and time.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public interface ITimeOfDayWriter extends IOpenScenarioModelElement {

  // Getters and setter for all attributes
  /**
   * From OpenSCENARIO class model specification: If true, the timeofday is animated with
   * progressing simulation time, e.g. in order to animate the position of the sun.
   *
   * @return value of model property animation
   */
  public Boolean getAnimation();
  /**
   * From OpenSCENARIO class model specification: Datetime value.
   *
   * @return value of model property dateTime
   */
  public java.util.Date getDateTime();

  /**
   * From OpenSCENARIO class model specification: If true, the timeofday is animated with
   * progressing simulation time, e.g. in order to animate the position of the sun.
   *
   * @param animation value of model property animation
   */
  public void writeToAnimation(Boolean animation);
  /**
   * From OpenSCENARIO class model specification: Datetime value.
   *
   * @param dateTime value of model property dateTime
   */
  public void writeToDateTime(java.util.Date dateTime);

  /**
   * Set a parameter for the attribute animation
   *
   * @param parameterName the name of the parameter (without $)
   */
  public void writeParameterToAnimation(String parameterName);
  /**
   * Set a parameter for the attribute dateTime
   *
   * @param parameterName the name of the parameter (without $)
   */
  public void writeParameterToDateTime(String parameterName);

  /**
   * Get the parameter for the attribute animation
   *
   * @return the name of the parameter (without $). Null if not parameter set or if attribute is
   *     empty.
   */
  public String getParameterFromAnimation();
  /**
   * Get the parameter for the attribute dateTime
   *
   * @return the name of the parameter (without $). Null if not parameter set or if attribute is
   *     empty.
   */
  public String getParameterFromDateTime();

  /**
   * Retrieves whether the attribute animation is parametrized.
   *
   * @return true if ${property.name.toMemberName()} is paramterized.
   */
  public boolean isAnimationParameterized();
  /**
   * Retrieves whether the attribute dateTime is parametrized.
   *
   * @return true if ${property.name.toMemberName()} is paramterized.
   */
  public boolean isDateTimeParameterized();

  // children

}