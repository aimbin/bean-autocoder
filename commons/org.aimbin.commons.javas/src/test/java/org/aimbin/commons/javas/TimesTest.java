/** fun_endless@163.com  2018年11月27日 */
package org.aimbin.commons.javas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年11月27日
 */
class TimesTest {

	/**
	 * Test method for {@link org.aimbin.commons.javas.TimeUtils#eliminateTail(java.util.Date, int)}.
	 */
	@Test
	void testEliminateTail() {
		try {
			Date now = new Date();
			Date tail3 = TimeUtils.eliminateTail(now, 3);
			System.out.println(TimeUtils.toStrFullTight(tail3));
			Date tail9 = TimeUtils.eliminateTail(now, 9);
			System.out.println(TimeUtils.toStrFullTight(tail9));
		}catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
