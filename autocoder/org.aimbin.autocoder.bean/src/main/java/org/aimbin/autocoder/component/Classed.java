/** fun_endless@163.com  2018年12月16日 */
package org.aimbin.autocoder.component;

import java.util.List;

/** A class definition.
 * @author aimbin
 * @verison 1.0.0 2018年12月16日
 */
public interface Classed extends ModifierNamed {
	/**Short name.*/
	public String getSimpleName();
	/**Package */
	public String getPackg();
	/**Raw and loaded type. /*/
	public Class<?> getRawType();
	/**GenericTypes*/
	public List<Classed> getGenericTypes();
	
}
