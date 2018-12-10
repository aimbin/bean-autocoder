/** fun_endless@163.com  2018年12月10日 */
package org.aimbin.commons.javas.context;

/** Spring content
 * @author aimbin
 * @verison 1.0.0 2018年12月10日
 */
public interface IBeanContext {
	/**Get bean by name. */
	public <T> T getBean(String name);
	/**Get bean by name, if not found, return the default implementation provided. */
	public <T> T getBean(String name,T defaultImpl);
}
