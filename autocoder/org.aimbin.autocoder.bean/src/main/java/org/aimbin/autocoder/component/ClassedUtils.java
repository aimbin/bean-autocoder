/** fun_endless@163.com  2018年12月19日 */
package org.aimbin.autocoder.component;

import java.util.ArrayList;
import java.util.List;

/** Tools for {@link Classed}.
 * @author aimbin
 * @verison 1.0.0 2018年12月19日
 */
public class ClassedUtils {
	/**To {@link Classed}.*/
	public static Classed toClassed(Class<?> claz) {
		return new LoadedTypeClassed(claz);
	}
	
	/**To {@link Classed}.*/
	public static Classed toClassed(Class<?> claz, Class<?>... genTypes) {
		LoadedTypeClassed loadedType = new LoadedTypeClassed(claz);
		List<Classed> generics = new ArrayList<>(genTypes.length);
		for(Class<?> type : genTypes) {
			generics.add(toClassed(type));
		}
		loadedType.setGenericTypes(generics);
		return loadedType;
	}
	/**To {@link Classed}.*/
	public static Classed toClassed(Class<?> claz, Classed... genTypes) {
		LoadedTypeClassed loadedType = new LoadedTypeClassed(claz);
		List<Classed> generics = new ArrayList<>(genTypes.length);
		for(Classed type : genTypes) {
			generics.add(type);
		}
		loadedType.setGenericTypes(generics);
		return loadedType;
	}
}
