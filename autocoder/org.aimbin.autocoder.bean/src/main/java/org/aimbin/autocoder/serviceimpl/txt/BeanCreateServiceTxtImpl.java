/** fun_endless@163.com  2018年12月1日 */
package org.aimbin.autocoder.serviceimpl.txt;

import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

import org.aimbin.autocoder.coders.AttributeCoder;
import org.aimbin.autocoder.coders.ClassCoders;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.confconst.BeanConfKeys;
import org.aimbin.autocoder.service.BeanCreateService;
import org.aimbin.commons.javas.AssertUtils;
import org.aimbin.commons.javas.FileUtils;
import org.aimbin.commons.javas.ObjUtils;
import org.aimbin.commons.javas.StrUtils;

/**Create bean by properties file.
 * @author aimbin
 * @verison 1.0.0 2018年12月1日
 */
public class BeanCreateServiceTxtImpl implements BeanCreateService {

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.service.BeanCreateService#createBean(java.lang.Object, java.util.Map)
	 */
	@Override
	public  void createBean(Object content, Map<String, String> configs) {
		String txt = content.toString();
		Properties props = new Properties();
		StringReader sr = new StringReader(txt);
		String baseDir = configs.getOrDefault(BeanConfKeys.FILE_DIST_DIR, "/");
		String fileName = configs.get(BeanConfKeys.FILE_NAME);
		AssertUtils.canNotEmpty(BeanConfKeys.FILE_NAME, fileName);
		final String typeName = TxtParser.getTypeName(fileName);
		ClassContent classContent = new ClassContent();;
		try {
			props.load(sr);
			String pkg = props.getProperty(BeanConfKeys.CLASS_PKG);
			classContent.setName(pkg + "." + typeName);
			classContent.setShortName(typeName);
			classContent.setPackg(pkg);
			classContent.setAttributes(AttributeCoder.createAttributes(props,classContent));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}finally {
			ObjUtils.close( sr); 
		}
		String outFile = StrUtils.join( baseDir ,"/", classContent.getName(), ".java");
		System.out.println("outFile:" + outFile);
		String javaTxt = ClassCoders.build(classContent);
		System.out.println(javaTxt);
		FileUtils.write(javaTxt, outFile);
	}

	
}
