/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.commons.javas.types;

/** Type exchanger.
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public interface TypeExchanger {
	/**Default JDBC type to Java type.*/
	public static final String EXCG_JDBC_JAVA = "jdbcType2javaType";
	/**Default Java type to  JDBC type .*/
	public static final String EXCG_JAVA_JDBC = "javaType2jdbcType";
	/**This type will take as String in TypeExchanger, e.g.:type.string.types=varchar2,nvarchar2,char  */
	public static final String CONF_STR_TYPES = "type.string.types";
	/**Default value of {@value #CONF_STR_TYPES}.  */
	public static final String CONF_STR_TYPES_DEFAULTS = "varchar,varchar2,nvarchar2,char";
	
	/**Type exchange from one domain to another, like jdbcType to javaType. */
	public String exchange(String type);
}
