/** fun_endless@163.com  2018年11月26日 */
package org.aimbin.commons.javas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Tools for collections.
 * @author aimbin
 * @verison 1.0.0 2018年11月26日
 */
public class CollectUtils {
	/**Null or no item.*/
	public static boolean isEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}
	
	/**Has item.*/
	public static boolean isNotEmpty(Collection<?> c) {
		return !isEmpty(c);
	}
	
	/**Null or no item.*/
	public static boolean isEmpty(Object[] objArray) {
		return objArray == null || objArray.length == 0;
	}
	
	/**Get one from the first. */
	public static <T> T getOne(Collection<T> c) {
		if(isEmpty(c)) {
			return null;
		}
		return c.iterator().next();
	}
	
	/**Array to ArrayList. */
	public static <T> List<T> toList(T[] array){
		if(array == null) {
			return new ArrayList<>(0);
		}
		List<T> list = new ArrayList<>(array.length);
		for(T item: array) {
			list.add(item);
		}
		return list;
	} 
	
	/**Array to set by HashSet. */
	public static <T> Set<T> toSet(T[] array){
		if(array == null) {
			return new HashSet<T>(0);
		}
		Set<T> set = new HashSet<>(array.length);
		for(T item: array) {
			set.add(item);
		}
		return set;
	}
	/**Add to collections. */
	public static <T> void add(Collection<T> collects,T[] array, boolean skipNull){
		if(collects == null || array == null) {
			return;
		}
		for(T inArray : array) {
			if(skipNull && inArray == null) {
				continue;
			}
			collects.add(inArray);
		}
	}
}
