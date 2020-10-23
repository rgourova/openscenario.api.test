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
package net.asam.openscenario.v1_0.checker.model;

import java.util.ArrayList;
import java.util.List;
import net.asam.openscenario.checker.model.CardinalityCheckerRule;
import net.asam.openscenario.checker.tree.PropertyTreeContext;
import net.asam.openscenario.common.ErrorLevel;
import net.asam.openscenario.common.FileContentMessage;
import net.asam.openscenario.common.IParserMessageLogger;
import net.asam.openscenario.common.ITreeMessageLogger;
import net.asam.openscenario.common.TreeContentMessage;
import net.asam.openscenario.v1_0.api.IVehicleCategoryDistribution;
import net.asam.openscenario.v1_0.api.IVehicleCategoryDistributionEntry;
import net.asam.openscenario.v1_0.common.OscConstants;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0 A
 * cardinality checker rule class for the type IVehicleCategoryDistribution according to
 * OpenSCENARIO standard all properties and children are checked if they are not optinal
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public class VehicleCategoryDistributionCardinalityCheckerRule
    extends CardinalityCheckerRule<IVehicleCategoryDistribution> {

  /** Default constructor */
  public VehicleCategoryDistributionCardinalityCheckerRule() {
    super();
  }

  @Override
  public void applyRuleInFileContext(
      IParserMessageLogger messageLogger, IVehicleCategoryDistribution object) {
    List<CardinalityViolation> violations = getAllViolations(object);
    for (CardinalityViolation violation : violations) {
      String message = getMessage(violation);

      messageLogger.logMessage(
          new FileContentMessage(message, ErrorLevel.ERROR, getTextmarker(object)));
    }
  }

  private String getMessage(CardinalityViolation violation) {
    String message = null;
    if (violation.violationType == ViolationType.REQUIRED) {
      message = getRequiredMessage(violation.propertyName);

    } else if (violation.violationType == ViolationType.TOO_FEW) {
      message = getTooFewMessage(violation.propertyName, violation.expected, violation.actual);
    } else if (violation.violationType == ViolationType.TOO_MANY) {
      message = getTooManyMessage(violation.propertyName, violation.expected, violation.actual);
    } else {
      message = getRequiredContentMessage();
    }
    return message;
  }

  private List<CardinalityViolation> getAllViolations(IVehicleCategoryDistribution object) {
    List<CardinalityViolation> violations = new ArrayList<>();
    // Check violation
    List<IVehicleCategoryDistributionEntry> vehicleCategoryDistributionEntries =
        object.getVehicleCategoryDistributionEntries();
    // Check too few elements
    if (vehicleCategoryDistributionEntries == null
        || vehicleCategoryDistributionEntries.size() < 1) {
      violations.add(
          new CardinalityViolation(
              OscConstants.ELEMENT__VEHICLE_CATEGORY_DISTRIBUTION_ENTRY,
              1,
              vehicleCategoryDistributionEntries == null
                  ? 0
                  : vehicleCategoryDistributionEntries.size(),
              ViolationType.TOO_FEW));
    }
    return violations;
  }

  @Override
  public void applyRuleInTreeContext(
      ITreeMessageLogger messageLogger, IVehicleCategoryDistribution object) {
    List<CardinalityViolation> violations = getAllViolations(object);
    for (CardinalityViolation violation : violations) {
      String message = getMessage(violation);

      messageLogger.logMessage(
          new TreeContentMessage(
              message,
              ErrorLevel.ERROR,
              PropertyTreeContext.create(object, violation.propertyName)));
    }
  }
}