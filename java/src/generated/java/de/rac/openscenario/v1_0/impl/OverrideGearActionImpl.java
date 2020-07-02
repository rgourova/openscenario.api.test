package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IOverrideGearAction;
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



/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IOverrideGearAction. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IOverrideGearAction)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class OverrideGearActionImpl extends BaseImpl implements IOverrideGearAction, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__NUMBER, Double.class);
		propertyToType.put(OscConstants.ATTRIBUTE__ACTIVE, Boolean.class);
	}
	
	private Double number;
	private Boolean active;

	@Override
	public Double getNumber()
	{
		return number;
	}
	@Override
	public Boolean getActive()
	{
		return active;
	}
	/**
	 * Sets the value of model property number
	 * @param number from OpenSCENARIO class model specification: [Gear number.]
	 * 
	*/
	public  void setNumber (Double number )
	{
		this.number = number;
	}
	/**
	 * Sets the value of model property active
	 * @param active from OpenSCENARIO class model specification: [True: override; false: stop overriding.]
	 * 
	*/
	public  void setActive (Boolean active )
	{
		this.active = active;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__NUMBER))
		{
			// Simple type
			number = ParserHelper.parseDouble(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__ACTIVE))
		{
			// Simple type
			active = ParserHelper.parseBoolean(logger,parameterLiteralValue,getTextmarker(attributeKey));
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
	public OverrideGearActionImpl clone()
	{
		OverrideGearActionImpl clonedObject = new OverrideGearActionImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Simple type
		clonedObject.setNumber(getNumber());		
		// Simple type
		clonedObject.setActive(getActive());		
		// clone children
		return clonedObject;
	}
	
	
	
}
