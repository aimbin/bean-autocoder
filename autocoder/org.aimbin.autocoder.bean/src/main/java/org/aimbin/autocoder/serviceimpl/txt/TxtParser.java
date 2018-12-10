/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.autocoder.serviceimpl.txt;

/**Txt parse tool.
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class TxtParser {
	
	/**TypeName at the first part. */
	public static String getTypeName(final String fileName) {
		return fileName.split("\\.")[0];
	}
}
