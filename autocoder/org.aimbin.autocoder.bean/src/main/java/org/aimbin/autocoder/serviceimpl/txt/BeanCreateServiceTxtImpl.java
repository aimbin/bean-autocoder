/** fun_endless@163.com  2018年12月1日 */
package org.aimbin.autocoder.serviceimpl.txt;

import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

import org.aimbin.autocoder.annotations.Column;
import org.aimbin.autocoder.coders.AttributeCoder;
import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.confconst.BeanConfKeys;
import org.aimbin.autocoder.confconst.JavaCodeUtils;
import org.aimbin.autocoder.confconst.ModelConfKeys;
import org.aimbin.autocoder.service.BeanCreateService;
import org.aimbin.commons.javas.AssertUtils;
import org.aimbin.commons.javas.MapUtils;
import org.aimbin.commons.javas.ObjUtils;

/**Create bean by properties file.
 * @author aimbin
 * @verison 1.0.0 2018年12月1日
 */
public class BeanCreateServiceTxtImpl implements BeanCreateService {

	/* (non-Javadoc)
	 * @see org.aimbin.autocoder.service.BeanCreateService#createBean(java.lang.Object, java.util.Map)
	 */
	@Override
	public  ClassContent createBean(Object content, Map<String, String> configs) {
		String txt = content.toString();
		Properties props = new Properties();
		StringReader sr = new StringReader(txt);
		String fileName = configs.get(BeanConfKeys.FILE_NAME);
		AssertUtils.canNotEmpty(BeanConfKeys.FILE_NAME, fileName);
		final String typeName = JavaCodeUtils.getTypeName(fileName);
		ClassContent classContent = new ClassContent();
		String pkg = null;
		try {
			props.load(sr);
			pkg = props.getProperty(BeanConfKeys.CLASS_PKG);
			classContent.setName(pkg + "." + typeName);
			classContent.setSimpleName(typeName);
			classContent.setPackg(pkg);
			if(MapUtils.getBool(ModelConfKeys.ANNATATION_ENABLE, configs,true)) {
				classContent.getImports().addImport(Column.class);
			}
			classContent.setAttributes(AttributeCoder.createAttributes(props,classContent));
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}finally {
			ObjUtils.close( sr); 
		}
		JavaCodeUtils.distToFile(classContent, configs, true);
		return classContent;
	}

	
}
