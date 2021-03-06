/** fun_endless@163.com  2018年12月9日 */
package org.aimbin.autocoder.coders;

import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.aimbin.autocoder.annotations.Column;
import org.aimbin.autocoder.component.Attribute;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.component.ClassMethod;
import org.aimbin.autocoder.component.Classed;
import org.aimbin.autocoder.confconst.JavaCodes;
import org.aimbin.commons.javas.CollectUtils;
import org.aimbin.commons.javas.FileUtils;
import org.aimbin.commons.javas.StrOps;
import org.aimbin.commons.javas.StrUtils;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月9日
 */
public class BaseLineCoders {
	/** Add package declaration. */
	public static String genPackage(String pkgName) {
		return StrUtils.join("package ",pkgName,";");
	}
	
	/** One line of import. */
	public static String genImports(String imp) {
		return StrUtils.join("import ",processShortJavaClaz4Import(imp),";");
	}
	/** public class Name { */
	public static String genTypeStart(String className, TypeNames javatype) {
		return StrUtils.join("public ",javatype," ",className," {");
	}
	
	/** One attribute line.
	 * 
	 * @author aimbin
	 * @version 1.0.0 2018年12月18日
	 * @param method
	 * @param isInterface
	 * @param content ClassContent to add imports.
	 * @return
	 */
	public static String genOneMethod(ClassMethod method, boolean isInterface, ClassContent content) {
		StringBuilder s = new StringBuilder();
		s.append(FileUtils.newLine()).append(JavaCodes.TAB).append(Modifier.toString(method.getModifiers())).append(" ");
		if(content != null) {
			content.getImports().addImport(method.getJavaType());
		}
		s.append(genTypeName(method.getJavaType()));
		s.append(" ").append(method.getName()).append(" (");
		s.append(genMethodParams(method.getParamNames(), method.getParamTypes(),content));
		if(isInterface) {
			s.append(") ").append(JavaCodes.END_LINE);
		}else {
			s.append(JavaCodes.DECLARE_BLOCK);
			s.append(JavaCodes.TAB).append(JavaCodes.END_BLOCK);
		}
		return s.toString();
	}
	/** Map&lt;String,Object&gt*/
	public static String genTypeName(Classed classType) {
		StringBuilder s = new StringBuilder();
		if(classType == null) {
			s.append("void");
		}else {
			s.append(classType.getSimpleName()).append(genGenerics(classType.getGenericTypes()));
		}
		return s.toString();
	}
	
	/** &lt; String,Object &gt*/
	public static String genGenerics(List<Classed> generics) {
		StringBuilder s = new StringBuilder();
		if(CollectUtils.isEmpty(generics)) {
			return s.toString();
		}
		Iterator<Classed> itr = generics.iterator();
		s.append("<").append(itr.next().getSimpleName());
		while(itr.hasNext()) {
			s.append(", ").append(itr.next().getSimpleName());
		}
		s.append("> ");
		return s.toString();
	}
	
	/**Method parameters. */
	public static String genMethodParams(List<String> paramNames, Map<String,Classed> paramTypes,  ClassContent content) {
		if(CollectUtils.isEmpty(paramNames)) {
			return "";
		}
		StringBuilder s = new StringBuilder();
		Iterator<String > itr = paramNames.iterator();
		String paramName = itr.next();
		Classed paramType = paramTypes.get(paramName);
		if(content != null) {
			content.getImports().addImport(paramType);
		}
		s.append(genTypeName(paramType)).append(" ").append(paramName);
		while(itr.hasNext()) {
			paramName = itr.next();
			paramType = paramTypes.get(paramName);
			if(content != null) {
				content.getImports().addImport(paramType);
			}
			s.append(", ").append(paramType.getSimpleName()).append(" ").append(paramName);
		}
		return s.toString();
	}

	/** One attribute line. */
	public static String genOneAttribute(Attribute attr, boolean annotated) {
		StringBuilder s = new StringBuilder();
		if(annotated) {
			s.append(genColumnAnnotation(attr));
		}
		s.append(JavaCodes.TAB).append("private ").append(attr.getJavaType().getSimpleName()).append(" ").append(attr.getName()).append(" = null;");
		return s.toString();
	}
	
	/**Annotation {@link Column} for attribute. */
	public static String genColumnAnnotation(Attribute attr) {
		StringBuilder s = new StringBuilder();
		s.append(JavaCodes.TAB).append("@").append(Column.class.getSimpleName()).append("(");
		boolean hasAny = false;
		if(StrUtils.isNotEmpty(attr.getName()) ) {
			s.append("name = ").append(JavaCodes.toQuotStr(attr.getName()));
			hasAny = true;
		}
		if(attr.isNotNull()) {
			if(hasAny) {
				s.append(", ");
			}
			s.append("notNull = true");
			hasAny = true;
		}
		if(StrUtils.isNotEmpty(attr.getJdbcType())) {
			if(hasAny) {
				s.append(", ");
			}
			s.append("jdbcType = ").append(JavaCodes.toQuotStr(attr.getJdbcType()));
			hasAny = true;
		}
		if(attr.getDefaultValue() != null) {
			if(hasAny) {
				s.append(", ");
			}
			s.append("defaultValue = ").append(JavaCodes.toQuotStr(attr.getDefaultValue()));
			hasAny = true;
		}
		s.append(")").append(FileUtils.newLine());
		return s.toString();
	}
	
	/**Generate a setter method. */
	public static String genSetter(String name, Classed type) {
		StringBuilder s = new StringBuilder();
		s.append(JavaCodes.TAB).append("public void set").append(StrOps.upperFirst(name)).append("(")
				.append(type.getSimpleName()).append(" ").append(name).append(JavaCodes.DECLARE_BLOCK);
		s.append(JavaCodes.getTabs(2)).append(" this.").append(name).append(" = ").append(name)
				.append(JavaCodes.END_LINE);
		s.append(JavaCodes.TAB).append(JavaCodes.END_BLOCK);
		return s.toString();
	}
	
	/**Generate a setter method. */
	public static String genGetter(String name, Classed type) {
		StringBuilder s = new StringBuilder();
		s.append(JavaCodes.TAB).append("public ").append(type.getSimpleName());
		s.append(" get").append(StrOps.upperFirst(name));
		s.append("(").append(JavaCodes.DECLARE_BLOCK);
		s.append(JavaCodes.getTabs(2)).append("return this.").append(name).append(JavaCodes.END_LINE);
		s.append(JavaCodes.TAB).append(JavaCodes.END_BLOCK);
		return s.toString();
	}
	
	/**Class shot name change to full name for create imports. */
	public static String processShortJavaClaz4Import(String shortJavaclaz) {
		final String lowShotClaz = shortJavaclaz.toLowerCase();
		switch (lowShotClaz) {
		case "date":
			return Date.class.getName();
		case "time":
			return Date.class.getName();
		case "timestamp":
			return Date.class.getName();
		case "list":
			return List.class.getName();
		case "map":
			return Map.class.getName();
		default:
			return shortJavaclaz;
		}
	}
}
