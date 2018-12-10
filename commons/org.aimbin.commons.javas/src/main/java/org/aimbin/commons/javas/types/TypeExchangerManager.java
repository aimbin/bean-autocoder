/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.commons.javas.types;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Store exchangers with unique name.
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class TypeExchangerManager {
	private static TypeExchangerManager _ins = null;
	private static final Lock _singleLock = new ReentrantLock();
	
	private final Map<String, TypeExchanger> exchangers = new HashMap<>();
	private final Lock exechangerMapLock = new ReentrantLock();

	public static TypeExchangerManager getInstance() {
		if(_ins == null) {
			_singleLock.lock();
			try {
				if(_ins == null) {
					_ins = new TypeExchangerManager();
				}
			} finally {
				_singleLock.unlock();
			}
		}
		return _ins;
	}
	
	private TypeExchangerManager() {
		
	}
	
	public TypeExchanger getExchanger(String name) {
		return exchangers.get(name);
	}
	
	public void setExchanger(String name, TypeExchanger exchanger ) {
		exechangerMapLock.lock();
		try {
			exchangers.put(name,exchanger);
		} finally {
			exechangerMapLock.unlock();
		}
		
	}
	
	
}
