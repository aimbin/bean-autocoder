/** fun_endless@163.com  2018年12月9日 */
package org.aimbin.autocoder.coders;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.aimbin.autocoder.confconst.JavaCodes;
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
	
	public static String genClassStart(String className) {
		return StrUtils.join("public class  ",className," {");
	}

	/** One attribute line. */
	public static String genOneAttribute(String name, Class<?> type) {
		return StrUtils.join(JavaCodes.TAB, "private ", type.getSimpleName(), " ", name, " = null;");
	}
	
	/**Generate a setter method. */
	public static String genSetter(String name, Class<?> type) {
		StringBuilder s = new StringBuilder();
		s.append(JavaCodes.TAB).append("public void set").append(StrOps.upperFirst(name)).append("(")
				.append(type.getSimpleName()).append(" ").append(name).append(JavaCodes.DECLARE_BLOCK);
		s.append(JavaCodes.getTabs(2)).append(" this.").append(name).append(" = ").append(name)
				.append(JavaCodes.END_LINE);
		s.append(JavaCodes.TAB).append(JavaCodes.BLOCK_END);
		return s.toString();
	}
	
	/**Generate a setter method. */
	public static String genGetter(String name, Class<?> type) {
		StringBuilder s = new StringBuilder();
		s.append(JavaCodes.TAB).append("public ").append(type.getSimpleName());
		s.append(" get").append(StrOps.upperFirst(name));
		s.append("(").append(JavaCodes.DECLARE_BLOCK);
		s.append(JavaCodes.getTabs(2)).append("return this.").append(name).append(JavaCodes.END_LINE);
		s.append(JavaCodes.TAB).append(JavaCodes.BLOCK_END);
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
