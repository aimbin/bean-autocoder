/** fun_endless@163.com  2018年12月9日 */
package org.aimbin.autocoder.coders;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.aimbin.autocoder.confconst.JavaCodes;
import org.aimbin.autocoder.typeexchanger.ShortBriefTypeExchanger;
import org.aimbin.commons.javas.StrUtils;
import org.aimbin.commons.javas.types.TypeExchanger;
import org.aimbin.commons.javas.types.TypeExchangerManager;

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
	
	public static String genAttributes(String name, String type) {
		TypeExchanger typeExchanger = TypeExchangerManager.getInstance().getExchanger(TypeExchanger.EXCG_JDBC_JAVA);
		if(typeExchanger == null) {
			typeExchanger = ShortBriefTypeExchanger.getInstance();
			TypeExchangerManager.getInstance().setExchanger(TypeExchanger.EXCG_JDBC_JAVA, typeExchanger);
		}
		return StrUtils.join(JavaCodes.TAB, "private ",typeExchanger.exchange(type)," ",name," = null;");
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
