/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.component;

import java.lang.reflect.Modifier;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class Attribute implements Commented,ModifierNamed, Typed{
	private String comment;
	private int modifiers = Modifier.PRIVATE;
	private String name;
	private String type;
	private Classed javaType;
	private String jdbcType;
	private  boolean notNull = false;
	private Object defaultValue;
	
	public Attribute() {
		
	}

	public Attribute(String name) {
		this.name = name;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the jdbcType
	 */
	public String getJdbcType() {
		return jdbcType;
	}

	/**
	 * @param jdbcType the jdbcType to set
	 */
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	/**
	 * @return the notNull
	 */
	public boolean isNotNull() {
		return notNull;
	}

	/**
	 * @param notNull the notNull to set
	 */
	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}

	/**
	 * @return the defaultValue
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
	
}
