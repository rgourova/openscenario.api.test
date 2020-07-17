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

import java.util.List;
import net.asam.openscenario.api.IOpenScenarioModelElement;
import net.asam.openscenario.common.INamedReference;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 *
 * <p>From OpenSCENARIO class model specification: Container for private actions assigned to one
 * specific entity and used in the initialization phase of a scenario.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public interface IPrivate extends IOpenScenarioModelElement {

  /**
   * From OpenSCENARIO class model specification:
   *
   * @return value of model property entityRef
   */
  public INamedReference<IEntity> getEntityRef();

  /**
   * From OpenSCENARIO class model specification: List of private actions to be executed when the
   * enclosing container gets triggered.
   *
   * @return value of model property privateActions
   */
  public List<IPrivateAction> getPrivateActions();
}
