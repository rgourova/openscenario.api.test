package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.ISelectedEntities;
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

import de.rac.openscenario.v1_0.api.IByType;
import de.rac.openscenario.v1_0.api.IEntityRef;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements ISelectedEntities. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of ISelectedEntities)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class SelectedEntitiesImpl extends BaseImpl implements ISelectedEntities, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
	}
	
	private List<IEntityRef> entityRef;
	private List<IByType> byType;

	@Override
	public List<IEntityRef> getEntityRef()
	{
		return entityRef;
	}
	@Override
	public List<IByType> getByType()
	{
		return byType;
	}
	/**
	 * Sets the value of model property entityRef
	 * @param entityRef from OpenSCENARIO class model specification: [References to the selected entities.]
	 * 
	*/
	public void setEntityRef(List<IEntityRef> entityRef)
	{
		this.entityRef = entityRef;
	}
	/**
	 * Sets the value of model property byType
	 * @param byType from OpenSCENARIO class model specification: [Defines the type to determine that all entities of a 
	 * specific type are members.]
	 * 
	*/
	public void setByType(List<IByType> byType)
	{
		this.byType = byType;
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
		
			List<IEntityRef> entityRef = null;
			entityRef =  getEntityRef();
			if (entityRef != null)
			{
				for(IEntityRef item : entityRef)
				{
					result.add((BaseImpl) item);
				}
			}
			List<IByType> byType = null;
			byType =  getByType();
			if (byType != null)
			{
				for(IByType item : byType)
				{
					result.add((BaseImpl) item);
				}
			}
		return result;
	}
	
	/**
	 * Making a (deep) clone this object. This is useful and used for importing elements from catalogs.
	 * @return a deep copy of the object.
	 */
	public SelectedEntitiesImpl clone()
	{
		SelectedEntitiesImpl clonedObject = new SelectedEntitiesImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// clone children
		List<IEntityRef> entityRef = null;
			entityRef =  getEntityRef();
		if (entityRef != null)
		{
			List<IEntityRef> clonedList = new ArrayList<IEntityRef>();
			for(IEntityRef item : entityRef)
			{
				EntityRefImpl clonedChild = ((EntityRefImpl) item).clone();
				clonedList.add(clonedChild);
				clonedChild.setParent(clonedObject);
			}
			clonedObject.setEntityRef(clonedList);
		}
		List<IByType> byType = null;
			byType =  getByType();
		if (byType != null)
		{
			List<IByType> clonedList = new ArrayList<IByType>();
			for(IByType item : byType)
			{
				ByTypeImpl clonedChild = ((ByTypeImpl) item).clone();
				clonedList.add(clonedChild);
				clonedChild.setParent(clonedObject);
			}
			clonedObject.setByType(clonedList);
		}
		return clonedObject;
	}
	
	
	
}

