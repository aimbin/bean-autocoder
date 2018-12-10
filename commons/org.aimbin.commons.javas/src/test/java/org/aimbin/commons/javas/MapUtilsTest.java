/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.commons.javas;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
class MapUtilsTest {

	/**
	 * Test method for {@link org.aimbin.commons.javas.MapUtils#get(java.lang.Object, java.util.Map)}.
	 */
	@Test
	void testGet() {
		Map<String,Object> map = new HashMap<>();
		map.put("first", 1);
		map.put("second", 2);
		int value = MapUtils.get("first", map);
		System.out.println("first:" + value);
	}

}
