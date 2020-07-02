package de.rac.openscenario.v1_0.impl;

import de.rac.openscenario.v1_0.api.IParameterCondition;
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
import de.rac.openscenario.v1_0.impl.NamedReferenceProxy;
import de.rac.openscenario.v1_0.common.INamedReference;
import de.rac.openscenario.v1_0.api.IParameterDeclaration;
import de.rac.openscenario.v1_0.api.Rule;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * <p>
 * Value class that implements IParameterCondition. With setter methods to fill the properties.
 * <ul>
 * <li> getter methods for properties (implemented methods of IParameterCondition)
 * <li> setter methods for properties
 * <li> getChildren method to collect all children
 * <li> clone function to make a deep copy
 * <li> overrides from BaseImpl
 * </ul>
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class ParameterConditionImpl extends BaseImpl implements IParameterCondition, Cloneable{
	
	/**
	 * Filling the property to type map
	 */
	 static{
		propertyToType.put(OscConstants.ATTRIBUTE__PARAMETER_REF, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__VALUE, String.class);
		propertyToType.put(OscConstants.ATTRIBUTE__RULE, String.class);
	}
	
	private NamedReferenceProxy<IParameterDeclaration> parameterRef;
	private String value;
	private Rule rule;

	@Override
	public INamedReference<IParameterDeclaration> getParameterRef()
	{
		return parameterRef;
	}
	@Override
	public String getValue()
	{
		return value;
	}
	@Override
	public Rule getRule()
	{
		return rule;
	}
	/**
	 * Sets the value of model property parameterRef
	 * @param parameterRef from OpenSCENARIO class model specification: [Name of the parameter that must be defined.]
	 * 
	*/
	public  void setParameterRef (NamedReferenceProxy<IParameterDeclaration> parameterRef )
	{
		this.parameterRef = parameterRef;
	}
	/**
	 * Sets the value of model property value
	 * @param value from OpenSCENARIO class model specification: [Value of the parameter.]
	 * 
	*/
	public  void setValue (String value )
	{
		this.value = value;
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

	@Override
	public  void resolveParameterInternal(IParserMessageLogger logger,String attributeKey, String parameterLiteralValue)
	{
		if (attributeKey.equals(OscConstants.ATTRIBUTE__PARAMETER_REF))
		{
			// Proxy
			NamedReferenceProxy<IParameterDeclaration> proxy = new NamedReferenceProxy<IParameterDeclaration> (parameterLiteralValue);
			parameterRef = proxy;
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__VALUE))
		{
			// Simple type
			value = ParserHelper.parseString(logger,parameterLiteralValue,getTextmarker(attributeKey));
			removeResolvedParameter(attributeKey);
				
	 	}
		else if (attributeKey.equals(OscConstants.ATTRIBUTE__RULE))
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
	public ParameterConditionImpl clone()
	{
		ParameterConditionImpl clonedObject = new ParameterConditionImpl();
		cloneStartMarker(clonedObject);
		cloneEndMarker(clonedObject);
		cloneAttributeKeyToStartMarker(clonedObject);
		cloneAttributeKeyToEndMarker(clonedObject);
		cloneAttributeKeyToParameterNameMap(clonedObject);
		// clone attributes;
		// Proxy
		NamedReferenceProxy<IParameterDeclaration> proxy = ((NamedReferenceProxy<IParameterDeclaration>)getParameterRef()).clone();
		clonedObject.setParameterRef(proxy);
		proxy.setParent(clonedObject);
		// Simple type
		clonedObject.setValue(getValue());		
		// Enumeration Type
		Rule rule = getRule();
		if (rule != null)
		{
			clonedObject.setRule(Rule.getFromLiteral(rule.getLiteral()));
		}
		// clone children
		return clonedObject;
	}
	
	
	
}
