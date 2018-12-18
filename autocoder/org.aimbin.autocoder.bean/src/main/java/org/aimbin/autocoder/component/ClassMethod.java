/** fun_endless@163.com  2018年12月15日 */
package org.aimbin.autocoder.component;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Method. 
 * @author aimbin
 * @verison 1.0.0 2018年12月15日
 */
public class ClassMethod implements ModifierNamed, Typed{
	private int modifiers = Modifier.PUBLIC;
	private String name;
	private Classed javaType = null;
	private List<String> paramNames;
	private Map<String,Classed> paramTypes;
	
	public ClassMethod() {
		
	}
	
	public ClassMethod(String name) {
		this.name = name;
	}
	
	public ClassMethod(String name,Classed javaType) {
		this.name = name;
		this.javaType = javaType;
	}
	
	/**
	 * @return the modifiers
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * @param modifiers the modifiers to set
	 */
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the javaType
	 */
	public Classed getJavaType() {
		return javaType;
	}

	/**
	 * @param javaType the javaType to set
	 */
	public void setJavaType(Classed javaType) {
		this.javaType = javaType;
	}

	/**
	 * @return the paramNames
	 */
	public List<String> getParamNames() {
		return paramNames;
	}
	/**
	 * @param paramNames the paramNames to set
	 */
	public void setParamNames(List<String> paramNames) {
		this.paramNames = paramNames;
	}
	
	/**
	 * @return the paramTypes
	 */
	public Map<String, Classed> getParamTypes() {
		return paramTypes;
	}

	/**
	 * @param paramTypes the paramTypes to set
	 */
	public void setParamTypes(Map<String, Classed> paramTypes) {
		this.paramTypes = paramTypes;
	}
	/**Add a parameter. */
	public ClassMethod addParameter(String name, Classed type) {
		if (this.paramNames == null) {
			this.paramNames = new ArrayList<>();
		}
		if (this.paramTypes == null) {
			this.paramTypes = new HashMap<>();
		}
		if (this.paramNames.contains(name)) {
			throw new IllegalStateException("paramter " + name + " existed");
		}
		this.paramNames.add(name);
		this.paramTypes.put(name, type);
		return this;
	}
	
	
}
