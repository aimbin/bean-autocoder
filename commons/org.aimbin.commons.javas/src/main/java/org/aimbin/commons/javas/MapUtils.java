/** fun_endless@163.com  2018年11月26日 */
package org.aimbin.commons.javas;

import java.util.HashMap;
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
	public static <T> T get(String key, Map<String,?> map) {
		Object value = map.get(key);
		return (T)value;
	}
	/**Get to boolean. */
	public static boolean getBool(String key,  Map<String,?> map,boolean defaultValue) {
		if(map == null || map.get(key) == null) {
			return defaultValue;
		}
		String value = map.get(key).toString();
		return Boolean.parseBoolean(value);
	}
	/** A:a, B,b split to map.*/
	public static Map<String, String> toMap(String likeSimpleJson){
		Map<String, String> result = new HashMap<>();
		if(likeSimpleJson == null) {
			return result;
		}
		String likeJson = likeSimpleJson.trim();
		if(likeJson.startsWith("{") && likeJson.endsWith("}")) {
			likeJson = likeJson.substring(1);
			likeJson = likeJson.substring(0, likeJson.length() - 1);
		}
		String[] pairs = likeJson.split(",");
		String[] keyValue = null;
		for(String onePair : pairs) {
			keyValue = onePair.trim().split(":");
			result.put(keyValue[0].trim(), keyValue[1].trim());
		}
		return result;
	}
}
