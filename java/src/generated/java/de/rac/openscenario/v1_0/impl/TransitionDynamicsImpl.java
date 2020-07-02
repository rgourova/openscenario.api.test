package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.ITransitionDynamics;
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

import de.rac.openscenario.v1_0.api.DynamicsDimension;
import de.rac.openscenario.v1_0.api.DynamicsShape;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements ITransitionDynamics. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of ITransitionDynamics)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class TransitionDynamicsImpl extends BaseImpl implements ITransitionDynamics, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__DYNAMICS_SHAPE, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__VALUE, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__DYNAMICS_DIMENSION, String.class);
	}
	
	private DynamicsShape dynamicsShape;
	private Double value;
	private DynamicsDimension dynamicsDimension;

	@Override
	public DynamicsShape getDynamicsShape()
	{
		return dynamicsShape;
	}
	@Override
	public Double getValue()
	{
		return value;
	}
	@Override
	public DynamicsDimension getDynamicsDimension()
	{
		return dynamicsDimension;
	}
	/**
	 * Sets the value of model property dynamicsShape
	 * @param dynamicsShape from OpenSCENARIO class model specification: [The shape of the transition function f(x) between 
	 * current and target value.]
	 * 
	*/
	public  void setDynamicsShape (DynamicsShape dynamicsShape )
	{
		this.dynamicsShape = dynamicsShape;
	}
	/**
	 * Sets the value of model property value
	 * @param value from OpenSCENARIO class model specification: [The value for a predefined rate (Unit: delta/s), time (Unit: 
	 * s) or distance (Unit: m) to acquire the target value. , Range: [0..inf[.]
	 * 
	*/
	public  void setValue (Double value )
	{
		this.value = value;
	}
	/**
	 * Sets the value of model property dynamicsDimension
	 * @param dynamicsDimension from OpenSCENARIO class model specification: [The semantics of the value: 'rate', 'time' or 
	 * 'distance'.]
	 * 
	*/
	public  void setDynamicsDimension (DynamicsDimension dynamicsDimension )
	{
		this.dynamicsDimension = dynamicsDimension;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__DYNAMICS_SHAPE))
		{
			// Enumeration Type
			DynamicsShape result = DynamicsShape.getFromLiteral(parameterLiteralValue);
			if (result != null)
			{
				dynamicsShape = result;
				removeResolvedParameter(attributeKey);
			}else
			{
				logger.logMessage(new FileContentMessage( "Value '" + parameterLiteralValue + "' is not allowed.",ErrorLevel.ERROR, getTextmarker(attributeKey)));
			}
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__VALUE))
		{
			// Simple type
			value = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__DYNAMICS_DIMENSION))
		{
			// Enumeration Type
			DynamicsDimension result = DynamicsDimension.getFromLiteral(parameterLiteralValue);
			if (result != null)
			{
				dynamicsDimension = result;
				removeResolvedParameter(attributeKey);
			}else
			{
				logger.logMessage(new FileContentMessage( "Value '" + parameterLiteralValue + "' is not allowed.",ErrorLevel.ERROR, getTextmarker(attributeKey)));
			}
				
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
	public TransitionDynamicsImpl clone()
	{
		TransitionDynamicsImpl clonedObject = new TransitionDynamicsImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Enumeration Type
		DynamicsShape dynamicsShape = getDynamicsShape();
		if (dynamicsShape != null)
		{
			clonedObject.setDynamicsShape(DynamicsShape.getFromLiteral(dynamicsShape.getLiteral()));
		}
		// Simple type
		clonedObject.setValue(getValue());		
		// Enumeration Type
		DynamicsDimension dynamicsDimension = getDynamicsDimension();
		if (dynamicsDimension != null)
		{
			clonedObject.setDynamicsDimension(DynamicsDimension.getFromLiteral(dynamicsDimension.getLiteral()));
		}
		// clone children
		return clonedObject;
	}
	
	
	
}
