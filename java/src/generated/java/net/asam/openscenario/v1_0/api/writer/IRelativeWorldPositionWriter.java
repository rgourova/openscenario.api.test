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
import net.asam.openscenario.common.INamedReference;
import net.asam.openscenario.v1_0.api.IEntity;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 *
 * <p>A Writer for the type 'RelativeWorldPosition' From OpenSCENARIO class model specification:
 * Position defined in terms of delta x, y, (z) relative to a reference entity's position.
 * Optionally, an orientation can be defined in either absolute or relative values.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public interface IRelativeWorldPositionWriter extends IOpenScenarioModelElement {

  // Getters and setter for all attributes
  /**
   * From OpenSCENARIO class model specification: Reference entity from which the relative world
   * position is measured.
   *
   * @return value of model property entityRef
   */
  public INamedReference<IEntity> getEntityRef();
  /**
   * From OpenSCENARIO class model specification: Relative x coordinate in the world coordinate
   * system.
   *
   * @return value of model property dx
   */
  public Double getDx();
  /**
   * From OpenSCENARIO class model specification: Relative y coordinate in the world coordinate
   * system.
   *
   * @return value of model property dy
   */
  public Double getDy();
  /**
   * From OpenSCENARIO class model specification: Relative z coordinate in the world coordinate
   * system.
   *
   * @return value of model property dz
   */
  public Double getDz();

  /**
   * From OpenSCENARIO class model specification: Reference entity from which the relative world
   * position is measured.
   *
   * @param entityRef value of model property entityRef
   */
  public void writeToEntityRef(INamedReference<IEntity> entityRef);
  /**
   * From OpenSCENARIO class model specification: Relative x coordinate in the world coordinate
   * system.
   *
   * @param dx value of model property dx
   */
  public void writeToDx(Double dx);
  /**
   * From OpenSCENARIO class model specification: Relative y coordinate in the world coordinate
   * system.
   *
   * @param dy value of model property dy
   */
  public void writeToDy(Double dy);
  /**
   * From OpenSCENARIO class model specification: Relative z coordinate in the world coordinate
   * system.
   *
   * @param dz value of model property dz
   */
  public void writeToDz(Double dz);

  /**
   * Set a parameter for the attribute entityRef
   *
   * @param parameterName the name of the parameter (without $)
   */
  public void writeParameterToEntityRef(String parameterName);
  /**
   * Set a parameter for the attribute dx
   *
   * @param parameterName the name of the parameter (without $)
   */
  public void writeParameterToDx(String parameterName);
  /**
   * Set a parameter for the attribute dy
   *
   * @param parameterName the name of the parameter (without $)
   */
  public void writeParameterToDy(String parameterName);
  /**
   * Set a parameter for the attribute dz
   *
   * @param parameterName the name of the parameter (without $)
   */
  public void writeParameterToDz(String parameterName);

  /**
   * Get the parameter for the attribute entityRef
   *
   * @return the name of the parameter (without $). Null if not parameter set or if attribute is
   *     empty.
   */
  public String getParameterFromEntityRef();
  /**
   * Get the parameter for the attribute dx
   *
   * @return the name of the parameter (without $). Null if not parameter set or if attribute is
   *     empty.
   */
  public String getParameterFromDx();
  /**
   * Get the parameter for the attribute dy
   *
   * @return the name of the parameter (without $). Null if not parameter set or if attribute is
   *     empty.
   */
  public String getParameterFromDy();
  /**
   * Get the parameter for the attribute dz
   *
   * @return the name of the parameter (without $). Null if not parameter set or if attribute is
   *     empty.
   */
  public String getParameterFromDz();

  /**
   * Retrieves whether the attribute entityRef is parametrized.
   *
   * @return true if ${property.name.toMemberName()} is paramterized.
   */
  public boolean isEntityRefParameterized();
  /**
   * Retrieves whether the attribute dx is parametrized.
   *
   * @return true if ${property.name.toMemberName()} is paramterized.
   */
  public boolean isDxParameterized();
  /**
   * Retrieves whether the attribute dy is parametrized.
   *
   * @return true if ${property.name.toMemberName()} is paramterized.
   */
  public boolean isDyParameterized();
  /**
   * Retrieves whether the attribute dz is parametrized.
   *
   * @return true if ${property.name.toMemberName()} is paramterized.
   */
  public boolean isDzParameterized();

  // children
  /**
   * From OpenSCENARIO class model specification: Orientation. The relative reference context refers
   * to the reference entity's orientation.
   *
   * @return a writer for model property orientation
   */
  public IOrientationWriter getOrientationWriter();

  /**
   * From OpenSCENARIO class model specification: Orientation. The relative reference context refers
   * to the reference entity's orientation.
   *
   * @param orientationWriter writer for the model property orientation
   */
  public void writeToOrientationWriter(IOrientationWriter orientationWriter);
}