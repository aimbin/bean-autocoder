/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.autocoder.coders;

import java.util.List;
import java.util.Map;

import org.aimbin.autocoder.annotations.Column;
import org.aimbin.autocoder.component.Attribute;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.component.ClassImports;
import org.aimbin.autocoder.component.ClassMethod;
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
	public static String build(ClassContent content,Map<String, String> configs) {
		StringBuilder startAndImport = new StringBuilder();
		startAndImport.append(BaseLineCoders.genPackage(content.getPackg())).append(FileUtils.newLine()).append(FileUtils.newLine());
		StringBuilder classBody = new StringBuilder();
		classBody.append(BaseLineCoders.genTypeStart(content.getSimpleName(),content.getTypeName())).append(FileUtils.newLine());
		classBody.append(buildAttrs(content.getAttributes(),configs,content));
		classBody.append(buildMethods(content.getMethods(), configs, content));
		classBody.append("}");
		startAndImport.append(build(content.getImports())).append(FileUtils.newLine());
		startAndImport.append(classBody);
		return startAndImport.toString();
	}
	
	/**Build import part.*/
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
	/**Build all attributes.*/
	public static String buildAttrs(List<Attribute> attrs, Map<String, String> configs,ClassContent content) {
		if(attrs == null ) {
			return "";
		}
		StringBuilder attrBuilder = new StringBuilder(FileUtils.newLine());
		StringBuilder accessorBuilder = new StringBuilder(FileUtils.newLine());
		boolean annatated = content.getImports().contains(Column.class.getName());
		for(Attribute attr : attrs) {
			content.getImports().addImport(attr.getJavaType());
			attrBuilder.append(BaseLineCoders.genOneAttribute(attr,annatated)).append(FileUtils.newLine());
			accessorBuilder.append(BaseLineCoders.genSetter(attr.getName(), attr.getJavaType()));
			accessorBuilder.append(BaseLineCoders.genGetter(attr.getName(), attr.getJavaType()));
		}
		attrBuilder.append(accessorBuilder);
		return attrBuilder.toString();
	}
	
	/**Build all attributes.*/
	public static String buildMethods(List<ClassMethod> methods, Map<String, String> configs,ClassContent content) {
		if(methods == null ) {
			return "";
		}
		StringBuilder attrBuilder = new StringBuilder(FileUtils.newLine());
		for(ClassMethod method : methods) {
			attrBuilder.append(BaseLineCoders.genOneMethod(method, content.getTypeName().equals(TypeNames.INTERFACE),content));
		}
		return attrBuilder.toString();
	}
	
	/**Build equal and hashCode method.*/
	public static String build(EqualHash equalHash) {
		if(equalHash == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		return s.toString();
	}
	/**Build toString method.*/
	public static String build(ToString toString) {
		if(toString == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		return s.toString();
	}
	/**Build comments. */
	public static String build(Commented comments) {
		if(comments == null) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		return s.toString();
	}
	
}
