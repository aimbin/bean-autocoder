/** fun_endless@163.com  2018年12月8日 */
package org.aimbin.autocoder.confconst;

import org.aimbin.commons.javas.FileUtils;
import org.aimbin.commons.javas.StrUtils;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月8日
 */
public class JavaCodes {
	/** Tab = 4 spaces. */
	public static final String TAB = "    ";
	public static final String END = ";";
	/**; \n */
	public static final String END_LINE = ";" + FileUtils.newLine();
	/** } \n */
	public static final String END_BLOCK = "}" + FileUtils.newLine();
	/**  { \n */
	public static final String BLOCK_START = " {" + FileUtils.newLine();
	/** ) { \n */
	public static final String DECLARE_BLOCK = ") {" + FileUtils.newLine();
	public static final String QUOT = "\"";
	
	public static final String PKG_BEAN = ".bean";
	public static final String PKG_DAO = ".dao";
	public static final String PKG_SERV = ".service";
	public static final String PKG_REST = ".rest";
	/**void. */
	public static final String VOID = "void";
	
	/**To "value". */
	public static String toQuotStr(Object value) {
		return StrUtils.join(QUOT, value == null ? "":value,QUOT);
	}
	
	/**Multiple tabs. */
	public static String getTabs(int num) {
		StringBuilder s= new StringBuilder();
		for(int i = 0; i < num; i++) {
			s.append(TAB);
		}
		return s.toString();
	}
	
}
