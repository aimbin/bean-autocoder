/** fun_endless@163.com  2018年12月17日 */
package org.aimbin.autocoder.serviceimpl.txt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.aimbin.autocoder.component.ClassContent;
import org.aimbin.autocoder.confconst.BeanConfKeys;
import org.aimbin.commons.javas.FileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月17日
 */
public class DaoCreateServiceMyBatisImplTest {
	DaoCreateServiceMyBatisImpl daoImpl = new DaoCreateServiceMyBatisImpl();
	BeanCreateServiceTxtImpl beanImpl = new BeanCreateServiceTxtImpl();
	/**
	 * Test method for {@link org.aimbin.autocoder.serviceimpl.txt.DaoCreateServiceMyBatisImpl#createDao(java.lang.Object, java.util.Map)}.
	 */
	@Test
	void testCreateDao() {
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
			ClassContent beanContent = beanImpl.createBean(content, configs);
			daoImpl.createDao(beanContent, configs);
			System.out.println("distFile:" + configs.get(BeanConfKeys.FILE_DIST_OUT));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
