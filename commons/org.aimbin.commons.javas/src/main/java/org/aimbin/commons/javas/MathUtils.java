/** fun_endless@163.com  2018年11月27日 */
package org.aimbin.commons.javas;

/**Math tools.
 * @author aimbin
 * @verison 1.0.0 2018年11月27日
 */
public class MathUtils {
	/** Divide and cell if has remainder. */
	public static int divideCell(int value, int dividend) {
		return (value/dividend) + (value%dividend == 0 ? 0: 1);
	}
}
