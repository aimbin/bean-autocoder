/** fun_endless@163.com  2018年11月28日 */
package org.aimbin.commons.javas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年11月28日
 */
class StrOpsTest {

	/**
	 * Test method for {@link org.aimbin.commons.javas.StrOps#upperFirst(java.lang.String)}.
	 */
	@Test
	void testUpperFirst() {
		assertEquals("Upercase", StrOps.upperFirst("upercase"));
	}

}
