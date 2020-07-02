package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IEntities;
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

import de.rac.openscenario.v1_0.api.IScenarioObject;
import de.rac.openscenario.v1_0.api.IEntitySelection;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IEntities. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IEntities)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class EntitiesImpl extends BaseImpl implements IEntities, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
	}
	
	private List<IScenarioObject> scenarioObjects;
	private List<IEntitySelection> entitySelections;

	@Override
	public List<IScenarioObject> getScenarioObjects()
	{
		return scenarioObjects;
	}
	@Override
	public List<IEntitySelection> getEntitySelections()
	{
		return entitySelections;
	}
	/**
	 * Sets the value of model property scenarioObjects
	 * @param scenarioObjects from OpenSCENARIO class model specification: [A list of scenario object definitions that pairs an
	 * entity object and a controller.]
	 * 
	*/
	public void setScenarioObjects(List<IScenarioObject> scenarioObjects)
	{
		this.scenarioObjects = scenarioObjects;
	}
	/**
	 * Sets the value of model property entitySelections
	 * @param entitySelections from OpenSCENARIO class model specification: [A list of entity selection definitions.]
	 * 
	*/
	public void setEntitySelections(List<IEntitySelection> entitySelections)
	{
		this.entitySelections = entitySelections;
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
		
			List<IScenarioObject> scenarioObjects = null;
			scenarioObjects =  getScenarioObjects();
			if (scenarioObjects != null)
			{
				for(IScenarioObject item : scenarioObjects)
				{
					result.add((BaseImpl) item);
				}
			}
			List<IEntitySelection> entitySelections = null;
			entitySelections =  getEntitySelections();
			if (entitySelections != null)
			{
				for(IEntitySelection item : entitySelections)
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
	public EntitiesImpl clone()
	{
		EntitiesImpl clonedObject = new EntitiesImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// clone children
		List<IScenarioObject> scenarioObjects = null;
			scenarioObjects =  getScenarioObjects();
		if (scenarioObjects != null)
		{
			List<IScenarioObject> clonedList = new ArrayList<IScenarioObject>();
			for(IScenarioObject item : scenarioObjects)
			{
				ScenarioObjectImpl clonedChild = ((ScenarioObjectImpl) item).clone();
				clonedList.add(clonedChild);
				clonedChild.setParent(clonedObject);
			}
			clonedObject.setScenarioObjects(clonedList);
		}
		List<IEntitySelection> entitySelections = null;
			entitySelections =  getEntitySelections();
		if (entitySelections != null)
		{
			List<IEntitySelection> clonedList = new ArrayList<IEntitySelection>();
			for(IEntitySelection item : entitySelections)
			{
				EntitySelectionImpl clonedChild = ((EntitySelectionImpl) item).clone();
				clonedList.add(clonedChild);
				clonedChild.setParent(clonedObject);
			}
			clonedObject.setEntitySelections(clonedList);
		}
		return clonedObject;
	}
	
	
	
}
