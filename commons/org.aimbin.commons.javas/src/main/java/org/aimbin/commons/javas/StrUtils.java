/** fun_endless@163.com  2018年11月25日 */
package org.aimbin.commons.javas;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

/**
 * Mostly used string tools.
 * @author aimbin
 * @verison 1.0.0 2018年11月25日
 */
public class StrUtils {
	
	/**
	 * null or no chars.
	 * @author aimbin
	 * @version 1.0.0 2018年11月25日
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(CharSequence s) {
		if(s == null  || s.length() == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(CharSequence s) {
		return !isEmpty(s);
	}
	
	/**Join to one string. */
	public static String join(Object... vars ) {
		if(vars == null) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		for(Object value : vars) {
			s.append(value);
		}
		return s.toString();
	}
	
	/**Join to one string, null will skipped. */
	public static String joinSkipNull(Object... vars ) {
		if(vars == null) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		for(Object value : vars) {
			if(value != null) {
				s.append(value);
			}
		}
		return s.toString();
	}
	
	/**Join to one , and separated by comma. */
	public static String joinComma(Object... vars) {
		if(vars == null) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		if(vars.length > 0) {
			s.append(vars[0]);
		}
		for(int i = 1; i < vars.length ; i++) {
			s.append(",").append(vars[i]);
		}
		return s.toString();
	}
	
	/**Limit by len. */
	public static String limit(CharSequence s, final int len) {
		if(s == null) {
			return null;
		}
		if(s.length() > len) {
			return s.subSequence(0, len).toString();
		}else {
			return s.toString();
		}
	}
	
	/**String with array mark and length, with values. Used for print logs. */
	public static String toString(Object[] objs) {
		StringBuilder s = new StringBuilder();
		s.append(objs.length).append("[");
		s.append(joinComma(objs));
		s.append("]");
		return s.toString();
	}
	
	/**String with collections mark and length, with values. Used for print logs. */
	public static String toString(Collection<?> collects) {
		if (collects == null || collects.isEmpty()) {
			return "[]";
		}
		StringBuilder s = new StringBuilder();
		s.append(collects.size()).append("[");
		Iterator<?> itr = collects.iterator();
		if (itr.hasNext()) {
			s.append(itr.next());
		}
		while (itr.hasNext()) {
			s.append(",").append(itr.next());
		}
		s.append("]");
		return s.toString();
	}
	
	/** Map to string.- */
	public static String toString(Map<?,?> map) {
		if (map == null || map.isEmpty()) {
			return "{}";
		}
		Iterator<?> itr = map.entrySet().iterator();
		StringBuilder s = new StringBuilder();
		Entry<?, ?> entry = null;
		s.append(map.size()).append("{");
		if (itr.hasNext()) {
			entry = (Entry<?, ?>) itr.next();
			s.append(entry.getKey()).append(":").append(entry.getValue());
		}
		while (itr.hasNext()) {
			entry = (Entry<?, ?>) itr.next();
			s.append(",").append(entry.getKey()).append(":").append(entry.getValue());
		}
		s.append("}");
		return s.toString();
	}
	
	/**Repeat a string many times. */
	public static String repeat(String seed, int repeatTimes) {
		if(seed == null || repeatTimes <= 0) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < repeatTimes; i++  ) {
			s.append(seed);
		}
		return s.toString();
	}
	
	/**32 uuid.*/
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**Contains one ignore case.*/
	public static boolean isContains(String value, Collection<String> toCheckCollections) {
		if(value == null || toCheckCollections == null) {
			return false;
		}
		for(String toCheck : toCheckCollections) {
			if(value.equalsIgnoreCase(toCheck)) {
				return true;
			}
		}
		return false;
	}
	
}
