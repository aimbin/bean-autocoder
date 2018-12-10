/** fun_endless@163.com  2018年12月10日 */
package org.aimbin.commons.javas.context;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/** Context holder for {@link IConfContext} and {@link IBeanContext}.
 * @author aimbin
 * @verison 1.0.0 2018年12月10日
 */
public class ContextHolder implements IBeanContext, IConfContext{
	private static ContextHolder _ins = null;
	private static final Lock _singleLock = new ReentrantLock();
	private IConfContext confContext;
	private IBeanContext beanContext;
	private volatile boolean lockAfterSet = true;
	
	private ContextHolder() {
		
	}

	
	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IConfContext#get(java.lang.String)
	 */
	@Override
	public String get(String key) {
		if(confContext == null) {
			return null;
		}
		return confContext.get(key);
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IConfContext#get(java.lang.String, java.lang.String)
	 */
	@Override
	public String get(String key, String defaultValue) {
		if(confContext == null) {
			return defaultValue;
		}
		return confContext.get(key,defaultValue);
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IConfContext#getInt(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer getInt(String key, Integer defaultValue) {
		if(confContext == null) {
			return defaultValue;
		}
		return confContext.getInt(key,defaultValue);
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IConfContext#getBool(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean getBool(String key, Boolean defaultValue) {
		if(confContext == null) {
			return defaultValue;
		}
		return confContext.getBool(key,defaultValue);
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IConfContext#getLong(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long getLong(String key, Long defaultValue) {
		if(confContext == null) {
			return defaultValue;
		}
		return confContext.getLong(key,defaultValue);
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IConfContext#isDebugEnable()
	 */
	@Override
	public boolean isDebugEnable() {
		if(confContext == null) {
			return false;
		}
		return confContext.isDebugEnable();
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IBeanContext#getBean(java.lang.String)
	 */
	@Override
	public <T> T getBean(String name) {
		if(beanContext == null) {
			return null;
		}
		return beanContext.getBean(name);
	}


	/* (non-Javadoc)
	 * @see org.aimbin.commons.javas.context.IBeanContext#getBean(java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> T getBean(String name, T defaultImpl) {
		if(beanContext == defaultImpl) {
			return null;
		}
		return beanContext.getBean(name,defaultImpl);
	}


	/**Singleton. */
	public static ContextHolder getInstance() {
		if(_ins == null) {
			_singleLock.lock();
			try {
				if(_ins == null) {
					_ins = new ContextHolder();
				}
			} finally {
				_singleLock.unlock();
			}
		}
		return _ins;
	}
	
	/**
	 * @return the confContext
	 */
	public IConfContext getConfContext() {
		return confContext;
	}

	/**
	 * @param confContext the confContext to set
	 */
	public void setConfContext(IConfContext confContext) {
		if(this.lockAfterSet && this.confContext != null) {
			throw new IllegalStateException("confContext alreay set to:" + this.confContext);
		}
		this.confContext = confContext;
	}

	/**
	 * @return the beanContext
	 */
	public IBeanContext getBeanContext() {
		return beanContext;
	}

	/**
	 * @param beanContext the beanContext to set
	 */
	public void setBeanContext(IBeanContext beanContext) {
		if(this.lockAfterSet && this.beanContext != null) {
			throw new IllegalStateException("beanContext alreay set to:" + this.beanContext);
		}
		this.beanContext = beanContext;
	}

	/**
	 * @return the lockAfterSet
	 */
	public boolean isLockAfterSet() {
		return lockAfterSet;
	}

	/**
	 * @param lockAfterSet the lockAfterSet to set
	 */
	public void setLockAfterSet(boolean lockAfterSet) {
		this.lockAfterSet = lockAfterSet;
	}
	
}
