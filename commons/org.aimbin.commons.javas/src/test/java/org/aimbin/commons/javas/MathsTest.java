/** fun_endless@163.com  2018年11月27日 */
package org.aimbin.commons.javas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年11月27日
 */
class MathsTest {

	/**
	 * Test method for {@link org.aimbin.commons.javas.MathUtils#divideCell(int, int)}.
	 */
	@Test
	void testDivideCell() {
		assertEquals(1, MathUtils.divideCell(1, 3));
		assertEquals(1, MathUtils.divideCell(3, 3));
		assertEquals(2, MathUtils.divideCell(4, 3));
	}

}
