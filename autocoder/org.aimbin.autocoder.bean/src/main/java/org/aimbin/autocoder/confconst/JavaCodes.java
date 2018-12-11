/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.confconst;

import org.aimbin.commons.javas.FileUtils;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class JavaCodes {
	/** Tab = 4 spaces. */
	public static final String TAB = "    ";
	public static final String END = ";";
	public static final String END_LINE = ";" + FileUtils.newLine();
	public static final String BLOCK_END = "}" + FileUtils.newLine();
	public static final String BLOCK_START = " {" + FileUtils.newLine();
	public static final String DECLARE_BLOCK = ") {" + FileUtils.newLine();
	
	/**Multiple tabs. */
	public static final String getTabs(int num) {
		StringBuilder s= new StringBuilder();
		for(int i = 0; i < num; i++) {
			s.append(TAB);
		}
		return s.toString();
	}
	
}
