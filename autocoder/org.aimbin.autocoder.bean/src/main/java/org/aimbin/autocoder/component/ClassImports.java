/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.component;

import java.util.HashSet;
import java.util.Set;

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
	
	
}
