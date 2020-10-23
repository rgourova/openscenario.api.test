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
 * <p>A Writer for the type 'FinalSpeed' From OpenSCENARIO class model specification: Final speed
 * definition for a SynchronizeAction.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public interface IFinalSpeedWriter extends IOpenScenarioModelElement {

  // children
  /**
   * From OpenSCENARIO class model specification: The absolute speed a synchronized entity should
   * have at its target position.
   *
   * @return a writer for model property absoluteSpeed
   */
  public IAbsoluteSpeedWriter getAbsoluteSpeedWriter();
  /**
   * From OpenSCENARIO class model specification: The speed a synchronized entity should have
   * relative to its master entity at its target position.
   *
   * @return a writer for model property relativeSpeedToMaster
   */
  public IRelativeSpeedToMasterWriter getRelativeSpeedToMasterWriter();

  /**
   * From OpenSCENARIO class model specification: The absolute speed a synchronized entity should
   * have at its target position.
   *
   * @param absoluteSpeedWriter writer for the model property absoluteSpeed
   */
  public void writeToAbsoluteSpeedWriter(IAbsoluteSpeedWriter absoluteSpeedWriter);
  /**
   * From OpenSCENARIO class model specification: The speed a synchronized entity should have
   * relative to its master entity at its target position.
   *
   * @param relativeSpeedToMasterWriter writer for the model property relativeSpeedToMaster
   */
  public void writeToRelativeSpeedToMasterWriter(
      IRelativeSpeedToMasterWriter relativeSpeedToMasterWriter);
}