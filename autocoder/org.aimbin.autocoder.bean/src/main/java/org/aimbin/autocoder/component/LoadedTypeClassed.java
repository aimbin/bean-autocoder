/** fun_endless@163.com  2018年12月17日 */
package org.aimbin.autocoder.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Already loaded class.
 * @author aimbin
 * @verison 1.0.0 2018年12月17日
 */
public class LoadedTypeClassed implements Classed {
	private final Class<?> claz;
	private List<Classed> genericTypes = null;
	
	public LoadedTypeClassed(Class<?> loadedType) {
		this.claz = loadedType;
	}
	
	public LoadedTypeClassed(Class<?> loadedType, Classed ... generics) {
		this.claz = loadedType;
		this.genericTypes = new ArrayList<>(generics.length);
		for(Classed genType : generics) {
			this.genericTypes.add(genType);
		}
	}
	

	/**
	 * @return the genericTypes
	 */
	public List<Classed> getGenericTypes() {
		return genericTypes;
	}

	/**
	 * @param genericTypes the genericTypes to set
	 */
	public void setGenericTypes(List<Classed> genericTypes) {
		this.genericTypes = genericTypes;
	}

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.ModifierNamed#getModifiers()
	 */
	@Override
	public int getModifiers() {
		return claz.getModifiers();
	}



	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.ModifierNamed#setModifiers(int)
	 */
	@Override
	public void setModifiers(int modifiers) {
		//Not need.
	}

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.ModifierNamed#getName()
	 */
	@Override
	public String getName() {
		return claz.getName();
	}

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.ModifierNamed#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		//Not need.
	}

	/**
	 * @return the claz
	 */
	public Class<?> getClaz() {
		return claz;
	}


	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.Classed#getShortName()
	 */
	@Override
	public String getSimpleName() {
		return this.claz.getSimpleName();
	}

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.Classed#getPackg()
	 */
	@Override
	public String getPackg() {
		return this.claz.getPackage().getName();
	}



	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.component.Classed#getRawType()
	 */
	@Override
	public Class<?> getRawType() {
		return claz;
	}
	
	

}
