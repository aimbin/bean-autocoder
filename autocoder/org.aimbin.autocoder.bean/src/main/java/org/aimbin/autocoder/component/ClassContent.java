/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.component;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.aimbin.autocoder.coders.TypeNames;

/** Full class content;
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class ClassContent implements Commented, Classed{
	private TypeNames typeName = TypeNames.CLASS;
	private String simpleName;
	/** Full name. */
	private String name;
	private String comment;
	private int modifiers = Modifier.PUBLIC;
	private String packg;
	private ClassImports imports = new ClassImports();
	private List<Attribute> attributes;
	private List<ClassMethod> methods;
	private EqualHash equalHash;
	private ToString toString;
	private List<Classed> genericTypes = null;
	
	/**Empty constructor. */
	public ClassContent() {
		
	}
	
	/**
	 * @param name Full name.
	 * @param shortName
	 */
	public ClassContent(String name, String simpleName) {
		this.name = name;
		this.simpleName = simpleName;
	}
	
	/**Add a method. */
	public ClassContent addMethod(ClassMethod method) {
		if(this.methods == null) {
			this.methods = new LinkedList<>();
		}
		this.methods.add(method);
		return this;
	}
	
	
	/**
	 * @return the genericTypes
	 */
	public List<Classed> getGenericTypes() {
		return genericTypes;
	}

	/**
	 * @param genericTypes the genericTypes to set
	 */
	public void setGenericTypes(List<Classed> genericTypes) {
		this.genericTypes = genericTypes;
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
	 * @return the packg
	 */
	public String getPackg() {
		return packg;
	}

	/**
	 * @param packg the packg to set
	 */
	public void setPackg(String packg) {
		this.packg = packg;
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
	 * @return the imports
	 */
	public ClassImports getImports() {
		return imports;
	}
	/**
	 * @param imports the imports to set
	 */
	public void setImports(ClassImports imports) {
		this.imports = imports;
	}
	
	/**
	 * @return the attributes
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the methods
	 */
	public List<ClassMethod> getMethods() {
		return methods;
	}

	/**
	 * @param methods the methods to set
	 */
	public void setMethods(List<ClassMethod> methods) {
		this.methods = methods;
	}

	/**
	 * @return the equalHash
	 */
	public EqualHash getEqualHash() {
		return equalHash;
	}
	/**
	 * @param equalHash the equalHash to set
	 */
	public void setEqualHash(EqualHash equalHash) {
		this.equalHash = equalHash;
	}
	/**
	 * @return the toString
	 */
	public ToString getToString() {
		return toString;
	}
	/**
	 * @param toString the toString to set
	 */
	public void setToString(ToString toString) {
		this.toString = toString;
	}


	/**
	 * @return the simpleName
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * @param simpleName the simpleName to set
	 */
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	/**
	 * @return the typeName
	 */
	public TypeNames getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(TypeNames typeName) {
		this.typeName = typeName;
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

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.Classed#getRawType()
	 */
	@Override
	public Class<?> getRawType() {
		return null;
	}
	

	
}
