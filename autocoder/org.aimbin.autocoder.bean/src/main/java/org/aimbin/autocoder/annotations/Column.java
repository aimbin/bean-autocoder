/** fun_endless@163.com  2018年12月7日 */
package org.aimbin.autocoder.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(SOURCE)
@Target(FIELD)
/**  description of column:name,notNull,defaultValue
 * @author aimbin
 * @verison 1.0.0 2018年12月7日
 */
public @interface Column {
	/** Column name. */
	String name();
	/**Indicate not-null, default is false. */
	boolean notNull() default false;
	/**Default value presented by string. */
	String defaultValue();
	/**JDBC column type.*/
	String jdbcType();
}
