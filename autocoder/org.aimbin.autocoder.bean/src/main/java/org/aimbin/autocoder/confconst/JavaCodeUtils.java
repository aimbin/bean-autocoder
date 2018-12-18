/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.autocoder.confconst;

import java.util.Map;

import org.aimbin.autocoder.coders.ClassCoders;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.commons.javas.AssertUtils;
import org.aimbin.commons.javas.FileUtils;
import org.aimbin.commons.javas.StrUtils;

/**Txt parse tool.
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class JavaCodeUtils {
	
	/**TypeName at the first part. */
	public static String getTypeName(final String fileName) {
		return fileName.split("\\.")[0];
	}
	/**Package to file path.*/
	public static String packageToPath(String pkg) {
		return pkg.replace(".", "/");
	}
	
	/**If end match ,replace the end to the new end. If not ,return the str + toNewEnd.*/
	public static String replaceEnd(String str, String orgEnd, String toNewEnd) {
		if(str.endsWith(orgEnd)) {
			return str.substring(0,(str.length() - orgEnd.length())) + toNewEnd;
		}
		return str + toNewEnd;
	}
	
	/**Generate the output file for the class content. 
	 * @return distFile path. */
	public static String distToFile(ClassContent content,Map<String, String> configs, boolean output) {
		String baseDir = configs.getOrDefault(BeanConfKeys.FILE_DIST_DIR, "/");
		String fileName = configs.get(BeanConfKeys.FILE_NAME);
		AssertUtils.canNotEmpty(BeanConfKeys.FILE_NAME, fileName);
		String distFile = StrUtils.join( baseDir ,"/", JavaCodeUtils.packageToPath(content.getPackg()),"/",content.getSimpleName(), ".java");
		if(output) {
			String javaTxt = ClassCoders.build(content,configs);
			FileUtils.write(javaTxt, distFile);
			configs.put(BeanConfKeys.FILE_DIST_OUT, distFile);
		}
		return distFile;
	}
}
