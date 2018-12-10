/** fun_endless@163.com  2018年12月9日 */
package org.aimbin.autocoder.typeexchanger;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.aimbin.commons.javas.CollectUtils;
import org.aimbin.commons.javas.StrOps;
import org.aimbin.commons.javas.StrUtils;
import org.aimbin.commons.javas.context.ContextHolder;
import org.aimbin.commons.javas.types.TypeExchanger;
import org.aimbin.commons.javas.types.TypeExchangerManager;

/**Short class name or JDBC to full Java class name.
 * @author aimbin
 * @verison 1.0.0 2018年12月9日
 */
public class ShortBriefTypeExchanger implements TypeExchanger {
	public static final String NAME = "bean.brief.shortclass";
	private static ShortBriefTypeExchanger _ins = null;
	private static final Lock _singleLock = new ReentrantLock();
	private Set<String> stringTypes = new HashSet<>();
	/**Singleton. */
	public static ShortBriefTypeExchanger getInstance() {
		if(_ins == null) {
			_singleLock.lock();
			try {
				if (_ins == null) {
					_ins = new ShortBriefTypeExchanger();
					CollectUtils.add(_ins.stringTypes,
							StrOps.split(ContextHolder.getInstance().get(CONF_STR_TYPES, CONF_STR_TYPES_DEFAULTS)),false);
				}
			} finally {
				_singleLock.unlock();
			}
		}
		return _ins;
	}
	
	private ShortBriefTypeExchanger() {
		
	}
	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.types.TypeExchanger#exchange(java.lang.String)
	 */
	@Override
	public String exchange(String type) {
		if (StrUtils.isEmpty(type) || StrUtils.isContains(type,stringTypes)) {
			return String.class.getName();
		}
		switch (type.toLowerCase()) {
		case "int": {
			return Integer.class.getName();
		}
		case "long": {
			return Long.class.getName();
		}
		case "double": {
			return Double.class.getName();
		}
		case "bool": {
			return Boolean.class.getName();
		}
		case "time": {
			return Date.class.getName();
		}
		case "date": {
			return Date.class.getName();
		}
		case "timestamp": {
			return Date.class.getName();
		}
		default: {
			return type;
		}
		}
	}
	/**
	 * Get default {@link TypeExchanger#EXCG_JDBC_JAVA}, if not set, set self as the default exchanger.
	 * @author aimbin
	 * @version 1.0.0 2018年12月10日
	 * @return
	 */
	public TypeExchanger getJdbc2JavaExchanger() {
		TypeExchanger exchanger = TypeExchangerManager.getInstance().getExchanger(TypeExchanger.EXCG_JDBC_JAVA);
		if(exchanger == null) {
			exchanger = ShortBriefTypeExchanger.getInstance();
			TypeExchangerManager.getInstance().setExchanger(EXCG_JDBC_JAVA, exchanger);
		}
		return exchanger;
	}

}
