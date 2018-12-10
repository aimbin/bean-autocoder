/** fun_endless@163.com  2018年12月10日 */
package org.aimbin.commons.javas.context;

/** Configuration context.
 * @author aimbin
 * @verison 1.0.0 2018年12月10日
 */
public interface IConfContext {
	/**Get a configuration by key.*/
	public String get(String key);
	
	/**Get a configuration by key.*/
	public String get(String key, String defaultValue);
	/**Get a int configuration. */
	public Integer getInt(String key, Integer defaultValue);
	/**Get a boolean configuration. */
	public Boolean getBool(String key, Boolean defaultValue);
	/**Get a long configuration. */
	public Long getLong(String key, Long defaultValue);
	/**If key: debug.enbale = true. */
	public boolean isDebugEnable();
	
	
}
