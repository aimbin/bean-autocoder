/** fun_endless@163.com  2018年12月14日 */
package org.aimbin.autocoder.coders;

/**
 * Java types: class, interface, enum, @interface.
 * 
 * @author aimbin
 * @verison 1.0.0 2018年12月14日
 */
public enum TypeNames {
	/** class */
	CLASS {
		@Override
		public String toString() {
			return "class";
		}
	},
	/** interface */
	INTERFACE {
		@Override
		public String toString() {
			return "interface";
		}
	},
	/** enum*/
	ENUM {
		@Override
		public String toString() {
			return "enum";
		}
	},
	/** @interface */
	ANNOCATION {
		@Override
		public String toString() {
			return "@interface";
		}
	}
}
