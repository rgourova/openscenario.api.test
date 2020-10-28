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
package net.asam.openscenario.v1_0.api;

import net.asam.openscenario.api.IOpenScenarioModelElement;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 *
 * <p>From OpenSCENARIO class model specification: A set of the axles of a vehicle. A vehicle must
 * have a front axle and a rear axle. It might have additional axles.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public interface IAxles extends IOpenScenarioModelElement {
  /**
   * From OpenSCENARIO class model specification: Front axle.
   *
   * @return value of model property frontAxle
   */
  public IAxle getFrontAxle();
  /**
   * From OpenSCENARIO class model specification: Rear axle.
   *
   * @return value of model property rearAxle
   */
  public IAxle getRearAxle();
  /**
   * From OpenSCENARIO class model specification: A list of optional additional axles.
   *
   * @return value of model property additionalAxles
   */
  public Iterable<IAxle> getAdditionalAxles();

  /**
   * Retrieves the size of the list
   *
   * @return the size of the list
   */
  public int getAdditionalAxlesSize();
  /**
   * The element at specific index
   *
   * @param index the index of the list
   * @return the element at index
   */
  public IAxle getAdditionalAxlesAtIndex(int index);
}
