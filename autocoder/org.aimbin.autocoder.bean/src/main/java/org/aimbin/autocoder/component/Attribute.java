/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.component;

import java.util.List;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class Attribute implements Commented{
	private String comment;
	private String modifiers = "private";
	private String name;
	private String type;
	private List<String> annotations;
	private Class<?> javaType;
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
	 * @return the annotations
	 */
	public List<String> getAnnotations() {
		return annotations;
	}
	/**
	 * @param annotations the annotations to set
	 */
	public void setAnnotations(List<String> annotations) {
		this.annotations = annotations;
	}
	/**
	 * @return the modifiers
	 */
	public String getModifiers() {
		return modifiers;
	}
	/**
	 * @param modifiers the modifiers to set
	 */
	public void setModifiers(String modifiers) {
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
	public Class<?> getJavaType() {
		return javaType;
	}
	/**
	 * @param javaType the javaType to set
	 */
	public void setJavaType(Class<?> javaType) {
		this.javaType = javaType;
	}
	
	
	
}
