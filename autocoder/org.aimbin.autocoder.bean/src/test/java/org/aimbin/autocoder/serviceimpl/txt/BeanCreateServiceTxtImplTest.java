/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.autocoder.serviceimpl.txt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.aimbin.autocoder.confconst.BeanConfKeys;
import org.aimbin.commons.javas.FileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class BeanCreateServiceTxtImplTest {
	BeanCreateServiceTxtImpl impl = new BeanCreateServiceTxtImpl();

	/**
	 * Test method for {@link org.aimbin.autocoder.serviceimpl.txt.BeanCreateServiceTxtImpl#createBean(java.lang.Object, java.util.Map)}.
	 */
	@Test
	void testCreateBean() {
		try {
			String fileName = "ItemType.properties";
			String content = FileUtils.read(fileName, BeanCreateServiceTxtImplTest.class);
			Map<String,String> configs = new HashMap<>();
			configs.put(BeanConfKeys.FILE_NAME, fileName);
			configs.put(BeanConfKeys.FILE_DIST_DIR, FileUtils.getParentDir(FileUtils.getClassPath(null)));
			impl.createBean(content, configs);
			assertNotNull(content);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	
	}

}
