/** fun_endless@163.com  2018年11月28日 */
package org.aimbin.commons.javas.test;

import java.util.Random;

/** Create test data by random etc.
 * @author aimbin
 * @verison 1.0.0 2018年11月28日
 */
public class TestDatas {
	
	/** 0 -- (limit-1). */
	public static int getInt0(int limit) {
		return new Random().nextInt(limit);
	}
	
	/** 1 - limit. */
	public static int getInt1(int limit) {
		return new Random().nextInt(limit) + 1;
	}
	
}
