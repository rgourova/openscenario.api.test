package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.ITimeOfDayCondition;
import de.rac.openscenario.v1_0.impl.BaseImpl;
import de.rac.openscenario.v1_0.common.ILocator;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.api.IOpenScenarioModelElement;
import java.lang.Cloneable;
import de.rac.openscenario.v1_0.parser.ParserHelper;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import de.rac.openscenario.v1_0.common.ErrorLevel;

import de.rac.openscenario.v1_0.api.Rule;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements ITimeOfDayCondition. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of ITimeOfDayCondition)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class TimeOfDayConditionImpl extends BaseImpl implements ITimeOfDayCondition, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__RULE, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__DATE_TIME, java.util.Date.class);
	}
	
	private Rule rule;
	private java.util.Date dateTime;

	@Override
	public Rule getRule()
	{
		return rule;
	}
	@Override
	public java.util.Date getDateTime()
	{
		return dateTime;
	}
	/**
	 * Sets the value of model property rule
	 * @param rule from OpenSCENARIO class model specification: [The operator (less, greater, equal).]
	 * 
	*/
	public  void setRule (Rule rule )
	{
		this.rule = rule;
	}
	/**
	 * Sets the value of model property dateTime
	 * @param dateTime from OpenSCENARIO class model specification: [Datetime value for comparison.]
	 * 
	*/
	public  void setDateTime (java.util.Date dateTime )
	{
		this.dateTime = dateTime;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__RULE))
		{
			// Enumeration Type
			Rule result = Rule.getFromLiteral(parameterLiteralValue);
			if (result != null)
			{
				rule = result;
				removeResolvedParameter(attributeKey);
			}else
			{
				logger.logMessage(new FileContentMessage( "Value '" + parameterLiteralValue + "' is not allowed.",ErrorLevel.ERROR, getTextmarker(attributeKey)));
			}
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__DATE_TIME))
		{
			// Simple type
			dateTime = ParserHelper.parseDateTime(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
	}
	
	@Override
	public  Class<?> getTypeFromAttributeName(String attributeKey)
	{
		return propertyToType.get(attributeKey);
	}

	/**
	 * A list of all aggregated children (lists are flattened). This may be used for applying a specific 
	 * method for any child.
	 * @return a list with all children (as BaseImpl)
	 */
	public List<BaseImpl> getChildren()
	{
		List<BaseImpl> result = new ArrayList<BaseImpl>();
		
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public TimeOfDayConditionImpl clone()
	{
		TimeOfDayConditionImpl clonedObject = new TimeOfDayConditionImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Enumeration Type
		Rule rule = getRule();
		if (rule != null)
		{
			clonedObject.setRule(Rule.getFromLiteral(rule.getLiteral()));
		}
		// Simple type
		clonedObject.setDateTime(getDateTime());		
		// clone children
		return clonedObject;
	}
	
	
	
}

