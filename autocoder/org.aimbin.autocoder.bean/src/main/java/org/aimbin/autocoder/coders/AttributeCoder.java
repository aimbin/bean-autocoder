/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.coders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.aimbin.autocoder.component.Attribute;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.component.LoadedTypeClassed;
import org.aimbin.autocoder.confconst.BeanConfKeys;
import org.aimbin.autocoder.typeexchanger.ShortBriefTypeExchanger;
import org.aimbin.commons.javas.AssertUtils;
import org.aimbin.commons.javas.CollectUtils;
import org.aimbin.commons.javas.MapUtils;
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
	public static List<Attribute> createAttributes(Properties props, ClassContent classContent) throws Exception {
		List<Attribute> attrList = new LinkedList<>();
		String columnsConf =  props.getProperty(BeanConfKeys.COL_NAMES);
		AssertUtils.canNotEmpty(BeanConfKeys.COL_NAMES, columnsConf);
		String notNullsConf =  props.getProperty(BeanConfKeys.COL_NOT_NULL);
		String defaultsConf =  props.getProperty(BeanConfKeys.COL_DEFAULTS);
		String[] columns = columnsConf.split(",");
		Set<String> notNulls = new HashSet<>();
		if(StrUtils.isNotEmpty(notNullsConf)) {
			notNulls = CollectUtils.toSet(notNullsConf.split(",")) ;
		}
		Map<String,String> defaults = new HashMap<>();
		if(StrUtils.isNotEmpty(defaultsConf)) {
			defaults = MapUtils.toMap(defaultsConf);
		}
		Attribute curAttr = null;
		for(String column : columns) {
			curAttr = createOneAttr(column, notNulls, defaults);
			classContent.getImports().addImport(curAttr.getJavaType());
			attrList.add(curAttr);
		}
		return attrList;
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
	public static Attribute createOneAttr(String column, Set<String> notNulls,Map<String,String> defaults) throws Exception {
		Attribute attr = new Attribute();
		createAttrProcessType(attr, column);
		createAttrProcessColumn(attr, notNulls, defaults);
		return attr;
	}
	
	/**Process name:javaType. */
	public static void createAttrProcessType(Attribute attr, String column) throws ClassNotFoundException{
		String[] nameType = column.split(":");
		attr.setName(nameType[0]);
		String typeStr = nameType.length > 1 ? nameType[1]:preProcessTypeByName(attr.getName());
		attr.setJavaType(new LoadedTypeClassed(getJavaType(typeStr)));
		attr.setType(typeStr);
	}
	
	/**Process name:javaType. */
	public static void createAttrProcessColumn(Attribute attr, Set<String> notNulls,Map<String,String> defaults) throws Exception{
		if(notNulls.contains(attr.getName())) {
			attr.setNotNull(true);
		}
		String defualtValue = defaults.get(attr.getName());
		if(defualtValue != null) {
			attr.setDefaultValue(defualtValue);
		}
	}
	
	/**To JavaType by imply suffix of name. */
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
