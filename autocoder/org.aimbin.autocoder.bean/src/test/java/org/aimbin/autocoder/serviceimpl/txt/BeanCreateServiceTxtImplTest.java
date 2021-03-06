/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.autocoder.serviceimpl.txt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
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
			assertNotNull(content);
			Map<String,String> configs = new HashMap<>();
			configs.put(BeanConfKeys.FILE_NAME, fileName);
			String baseDirPath = FileUtils.getParentDir(FileUtils.getClassPath(null));
			File baseDir = new File(baseDirPath);
			String distDir = baseDir.getParentFile().getPath() + "/src/test/java";
			distDir = FileUtils.toUnixPath(distDir);
			baseDir = new File(distDir);
			baseDir.mkdirs();
			System.out.println("distDir:" + distDir);
			configs.put(BeanConfKeys.FILE_DIST_DIR, distDir);
			impl.createBean(content, configs);
			System.out.println("distFile:" + configs.get(BeanConfKeys.FILE_DIST_OUT));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	
	}

}
