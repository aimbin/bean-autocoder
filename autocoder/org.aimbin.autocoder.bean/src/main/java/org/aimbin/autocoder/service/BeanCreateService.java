/** fun_endless@163.com  2018年11月28日 */
package org.aimbin.autocoder.service;

import java.util.Map;

/** Create a POJO, java bean class.
 * @author aimbin
 * @verison 1.0.0 2018年11月28日
 */
public interface BeanCreateService {
	/***
	 * Create java bean, as POJO.
	 * @author aimbin
	 * @version 1.0.0 2018年12月4日
	 * @param content
	 * @param configs
	 * @return
	 */
	public void createBean(Object content, Map<String,String> configs);
}
