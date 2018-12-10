/** fun_endless@163.com  2018年11月28日 */
package org.aimbin.commons.javas.test;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年11月28日
 */
class TestDatasTest {

	@Test
	void testGetInt() {
		StringBuilder s = new StringBuilder();
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append(TestDatas.getInt0(10)).append(",");
		s.append("\n");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		s.append(TestDatas.getInt1(10)).append(",");
		System.out.println(s.toString());
	}

}
