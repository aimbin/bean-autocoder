/** fun_endless@163.com  2018年11月27日 */
package org.aimbin.commons.javas;

import java.util.Collection;
import java.util.Map;

/**Illegal check assertion tool.
 * @author aimbin
 * @verison 1.0.0 2018年11月27日
 */
public class AssertUtils {
	
	/**Value not null , otherwise raise illegal. */
	public static final void canNotNull(Object name, Object value) {
		if(value == null) {
			throw new IllegalArgumentException(name + " can not be null.");
		}
	}
	
	/**Value not null or empty, otherwise raise illegal. */
	public static final void canNotEmpty(Object name, CharSequence value) {
		if(value == null || value.toString().trim().length() == 0) {
			throw new IllegalArgumentException(name + " can not be empty.");
		}
	}
	
	/**Map not null or empty, otherwise raise illegal. */
	public static final void canNotEmpty(Object name, Map<?,?> value) {
		if(value == null || value.isEmpty()) {
			throw new IllegalArgumentException(name + " can not be empty.");
		}
	}
	
	/**Collection not null or empty, otherwise raise illegal. */
	public static final void canNotEmpty(Object name, Collection<?> value) {
		if(value == null || value.isEmpty()) {
			throw new IllegalArgumentException(name + " can not be empty.");
		}
	}
	
	public static final void shallEqual(Object name, Object actual, Object expected) {
		if(name == actual || (actual == null && expected != null) ) {
			return;
		}
		if(! actual.equals(expected)) {
			throw new IllegalArgumentException(StrUtils.join( name + " should be:" + expected,", but actual:",actual));
		}
	}
	
	public static final void shallTrue(String msg, boolean value) {
		if(value) {
			return;
		}
		throw new IllegalArgumentException(msg);
	}
	
	public static final void shallUnique(Object name, Collection<?> value) {
		if(value == null || value.isEmpty()) {
			throw new IllegalArgumentException(name + " not found.");
		}
		if(value.size() > 1) {
			throw new IllegalArgumentException(name + " shall be unique.");
		}
	}
	
	public static final void shallNotExisted(Object name, Object value) {
		if(value != null) {
			throw new IllegalArgumentException(name + " already existed.");
		}
	}
	
	public static final void shallFound(Object name, Object value) {
		if(value == null) {
			throw new IllegalArgumentException(name + " not found.");
		}
	}
	
	
}
