/** fun_endless@163.com  2018年11月26日 */
package org.aimbin.commons.javas;

import java.util.Map;

/**Tools for map.
 * @author aimbin
 * @verison 1.0.0 2018年11月26日
 */
public class MapUtils {
	/**Null or no item.*/
	public static boolean isEmpty(Map<?,?> m) {
		return m == null || m.isEmpty();
	}
	
	/**Has item.*/
	public static boolean isNotEmpty(Map<?,?> m) {
		return !isEmpty(m);
	}
	
	@SuppressWarnings("unchecked")
	/** Get with sure the real type.*/
	public static <T> T get(Object key, Map<String,?> map) {
		Object value = map.get(key);
		return (T)value;
	}
}
