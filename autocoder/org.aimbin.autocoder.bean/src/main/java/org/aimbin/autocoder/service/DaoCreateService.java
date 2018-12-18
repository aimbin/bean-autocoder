/** fun_endless@163.com  2018年11月28日 */
package org.aimbin.autocoder.service;

import java.util.Map;

import org.aimbin.autocoder.component.ClassContent;

/**Create a data access object.
 * @author aimbin
 * @verison 1.0.0 2018年11月28日
 */
public interface DaoCreateService {
	/**
	 * Create a DAO like MyBatis-Mapper from bean class info.
	 * @author aimbin
	 * @version 1.0.0 2018年12月13日
	 * @param beanClaz
	 * @param configs
	 */
	public ClassContent createDao(Object beanClaz,  Map<String,String> configs );
}
