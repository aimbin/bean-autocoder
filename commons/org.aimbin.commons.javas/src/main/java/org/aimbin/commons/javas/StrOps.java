/** fun_endless@163.com  2018年11月28日 */
package org.aimbin.commons.javas;

/** String operations tool like change the value.
 * @author aimbin
 * @verison 1.0.0 2018年11月28日
 */
public class StrOps {
	/** Only upper-case the first char. */
	public static String upperFirst(String value) {
		if(value == null || value.length() == 0) {
			return value;
		}
		if(value.length() == 1) {
			return value.toUpperCase();
		}
		return  Character.toUpperCase(value.charAt(0)) + value.substring(1); 
	}
	
	/** Only lower-case the first char. */
	public static String lowerFirst(String value) {
		if(value == null || value.length() == 0) {
			return value;
		}
		if(value.length() == 1) {
			return value.toLowerCase();
		}
		return  Character.toLowerCase(value.charAt(0)) + value.substring(1); 
	}
	
	/**Safe split, return null is value is null. */
	public static String[] split(String value) {
		if(value == null) {
			return null;
		}
		return value.trim().split(",");
	}
	
	/**Safe split, return null is value is null. */
	public static String[] split(String value, String spliter) {
		if(value == null) {
			return null;
		}
		return value.trim().split(spliter);
	}
}
