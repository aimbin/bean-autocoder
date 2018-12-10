/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.component;

/** Full class content;
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class ClassContent implements Commented{
	private String shortName;
	private String name;
	private String comment;
	private String packg;
	private ClassImports imports = new ClassImports();
	private Attributes attributes = new Attributes();
	private EqualHash equalHash;
	private ToString toString;
	
	/**Empty constructor. */
	public ClassContent() {
		
	}
	
	/**
	 * @param name Full name.
	 * @param shortName
	 */
	public ClassContent(String name, String shortName) {
		this.name = name;
		this.shortName = shortName;
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
	public Attributes getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
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
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
	
}
