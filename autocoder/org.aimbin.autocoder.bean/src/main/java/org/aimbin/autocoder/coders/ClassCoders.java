/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.autocoder.coders;

import org.aimbin.autocoder.component.Attribute;
import org.aimbin.autocoder.component.Attributes;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.component.ClassImports;
import org.aimbin.autocoder.component.Commented;
import org.aimbin.autocoder.component.EqualHash;
import org.aimbin.autocoder.component.ToString;
import org.aimbin.commons.javas.FileUtils;

/** Write class contents like packages, imports, etc.
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class ClassCoders {
	/** Build class content object to JAVA code string. */
	public static String build(ClassContent content) {
		StringBuilder s = new StringBuilder();
		s.append(BaseLineCoders.genPackage(content.getPackg())).append(FileUtils.newLine());
		s.append(build(content.getImports())).append(FileUtils.newLine());
		s.append(BaseLineCoders.genClassStart(content.getShortName())).append(FileUtils.newLine());
		s.append(build(content.getAttributes()));
		s.append("}");
		return s.toString();
	}
	
	public static String build(ClassImports imports) {
		if(imports == null || imports.getImports() == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for(String imp : imports.getImports()) {
			s.append(BaseLineCoders.genImports(imp)).append(FileUtils.newLine());
		}
		return s.toString();
	}
	
	public static String build(Attributes attrs) {
		if(attrs == null || attrs.getAttributes() == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		for(Attribute attr : attrs.getAttributes()) {
			s.append(BaseLineCoders.genAttributes(attr.getName(), attr.getType())).append(FileUtils.newLine());
		}
		return s.toString();
	}
	
	public static String build(EqualHash equalHash) {
		if(equalHash == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		return s.toString();
	}
	
	public static String build(ToString toString) {
		if(toString == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		return s.toString();
	}
	
	public static String build(Commented comments) {
		if(comments == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		return s.toString();
	}
	
}
