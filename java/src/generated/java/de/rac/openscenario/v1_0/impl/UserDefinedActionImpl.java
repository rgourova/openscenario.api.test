package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IUserDefinedAction;
import de.rac.openscenario.v1_0.impl.BaseImpl;
import de.rac.openscenario.v1_0.common.ILocator;
import de.rac.openscenario.v1_0.common.IParserMessageLogger;
import de.rac.openscenario.v1_0.common.OscConstants;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.api.IOpenScenarioModelElement;
import java.lang.Cloneable;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

import de.rac.openscenario.v1_0.api.ICustomCommandAction;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IUserDefinedAction. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IUserDefinedAction)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class UserDefinedActionImpl extends BaseImpl implements IUserDefinedAction, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
	}
	
	private ICustomCommandAction customCommandAction;

	@Override
	public ICustomCommandAction getCustomCommandAction()
	{
		return customCommandAction;
	}
	/**
	 * Sets the value of model property customCommandAction
	 * @param customCommandAction from OpenSCENARIO class model specification: [The available commands are subject of a 
	 * contract between simulation environment provider and scenario author.]
	 * 
	*/
	public  void setCustomCommandAction (ICustomCommandAction customCommandAction )
	{
		this.customCommandAction = customCommandAction;
	}

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
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
		
			ICustomCommandAction customCommandAction = null;
			customCommandAction =  getCustomCommandAction();
			if (customCommandAction != null)
			{
				result.add((BaseImpl) customCommandAction);
			}	
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public UserDefinedActionImpl clone()
	{
		UserDefinedActionImpl clonedObject = new UserDefinedActionImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// clone children
		ICustomCommandAction customCommandAction = null;
		customCommandAction =  getCustomCommandAction();
		if (customCommandAction != null)
		{
			CustomCommandActionImpl clonedChild = ((CustomCommandActionImpl) customCommandAction).clone();
			clonedObject.setCustomCommandAction(clonedChild);
			clonedChild.setParent(clonedObject);
		}	
		return clonedObject;
	}
	
	
	
}

