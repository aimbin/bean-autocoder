/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.coders;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.aimbin.autocoder.component.Attribute;
import org.aimbin.autocoder.component.Attributes;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.confconst.BeanConfKeys;
import org.aimbin.autocoder.typeexchanger.ShortBriefTypeExchanger;
import org.aimbin.commons.javas.AssertUtils;
import org.aimbin.commons.javas.CollectUtils;
import org.aimbin.commons.javas.StrUtils;

/**Tools for create attribute by column.
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class AttributeCoder {
	
	/**
	 * Create attribute list via properties configuration, key is "columns".
	 * @author aimbin
	 * @version 1.0.0 2018年12月10日
	 * @param props
	 * @return
	 * @throws ClassNotFoundException when type implied by the column name like "name:varchar2"
	 */
	public static Attributes createAttributes(Properties props, ClassContent classContent) throws ClassNotFoundException {
		Attributes attrsObj = new Attributes();
		List<Attribute> attrList = new LinkedList<>();
		attrsObj.setAttributes(attrList);
		String columnsConf =  props.getProperty(BeanConfKeys.COL_NAMES);
		AssertUtils.canNotEmpty(BeanConfKeys.COL_NAMES, columnsConf);
		String notNullsConf =  props.getProperty(BeanConfKeys.COL_NOT_NULL);
		String defaultsConf =  props.getProperty(BeanConfKeys.COL_DEFAULTS);
		String[] columns = columnsConf.split(",");
		Set<String> notNulls = new HashSet<>();
		if(StrUtils.isNotEmpty(notNullsConf)) {
			notNulls = CollectUtils.toSet(notNullsConf.split(",")) ;
		}
		Set<String> defaults = new HashSet<>();
		if(StrUtils.isNotEmpty(defaultsConf)) {
			defaults = CollectUtils.toSet(defaultsConf.split(","));
		}
		Attribute curAttr = null;
		for(String column : columns) {
			curAttr = createOneAttr(column, notNulls, defaults);
			classContent.getImports().addImport(curAttr.getJavaType());
			attrList.add(curAttr);
		}
		return attrsObj;
	}
	
	/**
	 * Create one attribute object. The Java-Type of the attribute(field) determined there.
	 * @author aimbin
	 * @version 1.0.0 2018年12月10日
	 * @param column
	 * @param notNulls
	 * @param defaults
	 * @return
	 * @throws ClassNotFoundException when type implied by the column name like "name:varchar2"
	 */
	public static Attribute createOneAttr(String column, Set<String> notNulls,Set<String> defaults) throws ClassNotFoundException {
		Attribute attr = new Attribute();
		String[] nameType = column.split(":");
		attr.setName(nameType[0]);
		String typeStr = nameType.length > 1 ? nameType[1]:preProcessTypeByName(attr.getName());
		attr.setJavaType(getJavaType(typeStr));
		attr.setType(typeStr);
		return attr;
	}
	
	public static String preProcessTypeByName(String columnName) {
		if (columnName.endsWith("Time")) {
			return "time";
		} else if (columnName.endsWith("Date")) {
			return "date";
		} else if (columnName.toLowerCase().endsWith("timestamp")) {
			return "timestamp";
		}else if (columnName.endsWith("Num")) {
			return "int";
		}
		return null;
	}
	
	/**Exchange type from short-java-class-name or JDBC type to Java-Type. Default is String.class.
	 * @throws ClassNotFoundException */
	public static Class<?> getJavaType(String typeStr) throws ClassNotFoundException {
		if(typeStr == null) {
			return String.class;
		}else {
			return Class.forName(ShortBriefTypeExchanger.getInstance().getJdbc2JavaExchanger().exchange(typeStr));
		}
	}
}
