/** fun_endless@163.com  2018年11月26日 */
package org.aimbin.commons.javas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年11月26日
 */
class StrsTest {

	/**
	 * Test method for {@link org.aimbin.commons.javas.StrUtils#toString(java.lang.Object[])}.
	 */
	@Test
	void testToStringObjectArray() {
		String[] arayy = {"a","b","c"};
		String output = StrUtils.toString(arayy);
		System.out.println(output);
		assertEquals("3[a,b,c]", output);
	}

	/**
	 * Test method for {@link StrUtils#toString(java.util.Collection)
	 */
	@Test
	void testToStringList() {
		List<String> strs = new ArrayList<>(3);
		strs.add("a");
		strs.add("b");
		strs.add("c");
		String output = StrUtils.toString(strs);
		assertEquals("3[a,b,c]", output);
	}
	
	/**
	 * Test method for {@link StrUtils#toString(java.util.Map)
	 */
	@Test
	void testToStringMap() {
		Map<String,String> map = new HashMap<>(2);
		map.put("1", "one");
		map.put("2", "two");
		String output = StrUtils.toString(map);
		System.out.println(output);
		assertEquals("2{1:one,2:two}", output);
	}

	
}
