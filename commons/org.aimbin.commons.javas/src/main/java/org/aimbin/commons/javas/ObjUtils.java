/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.commons.javas;

import java.io.Closeable;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class ObjUtils {
	/**Close {@link Closeable}.*/
	public static void close(Closeable toClose) {
		if(toClose == null) {
			return;
		}
		try {
			toClose.close();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
