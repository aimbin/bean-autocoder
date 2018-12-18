/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.component;

import java.util.HashSet;
import java.util.Set;

import org.aimbin.commons.javas.CollectUtils;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class ClassImports {
	private Set<String> imports = null;

	/**
	 * @return the imports
	 */
	public Set<String> getImports() {
		return imports;
	}

	/**
	 * @param imports the imports to set
	 */
	public void setImports(Set<String> imports) {
		this.imports = imports;
	}
	
	/**contains */
	public boolean contains(String fullType) {
		if(getImports() == null) {
			return false;
		}
		return getImports().contains(fullType);
	}
	
	/**contains */
	public boolean contains(Classed fullType) {
		if(getImports() == null) {
			return false;
		}
		return getImports().contains(fullType.getName());
	}
	
	/**Add an import, skip not-need. */
	public boolean addImport(Class<?> fullType) {
		if(imports == null) {
			imports = new HashSet<>();
		}
		if(fullType.isPrimitive() || fullType.getName().startsWith("java.lang.")) {
			//No need declare import.
			return false;
		}else if(imports.contains(fullType.getName())) {
			return false;
		}else {
			imports.add(fullType.getName());
			return true;
		}
	}
	
	/**Add an import, skip not-need. */
	public boolean addImport(Classed fullType) {
		if(fullType == null) {
			return false;
		}
		if(imports == null) {
			imports = new HashSet<>();
		}
		Class<?> loadedType  = fullType.getRawType();
		if(loadedType != null) {
			return addImport(loadedType);
		}else if(imports.contains(fullType.getName())) {
			return false;
		}else {
			imports.add(fullType.getName());
			if(CollectUtils.isNotEmpty(fullType.getGenericTypes())) {
				fullType.getGenericTypes().stream().forEach( genType -> addImport(genType));
			}
			return true;
		}
	}
	
}
