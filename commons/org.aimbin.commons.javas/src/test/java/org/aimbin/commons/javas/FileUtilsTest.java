/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.commons.javas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
class FileUtilsTest {

	/**
	 * Test method for {@link org.aimbin.commons.javas.FileUtils#getFolderNameSuffix(java.lang.String)}.
	 */
	@Test
	void testGetFolderNameSuffix() {
		String fileWindows = "J:\\VM_win10\\Enoki.vmdk";
		String[] pns = FileUtils.getFolderNameSuffix(fileWindows);
		System.out.println(StrUtils.toString(pns) );
		assertEquals("J:/VM_win10", pns[0]);
		assertEquals("Enoki", pns[1]);
		assertEquals(".vmdk", pns[2]);
	}
	
	/**
	 * Test method for {@link org.aimbin.commons.javas.FileUtils#getFolderNameSuffix(java.lang.String)}.
	 */
	@Test
	void testGetFolderNameSuffixDisk() {
		String fileWindows = "J:";
		String[] pns = FileUtils.getFolderNameSuffix(fileWindows);
		System.out.println(StrUtils.toString(pns) );
		assertEquals("J:", pns[0]);
		assertEquals(null, pns[1]);
		assertEquals(null, pns[2]);
	}

	/**
	 * Test method for {@link org.aimbin.commons.javas.FileUtils#getFolderNameSuffix(java.lang.String)}.
	 */
	@Test
	void testGetFolderNameSuffix_file() {
		String fileWindows = "ItemType.properties";
		String[] pns = FileUtils.getFolderNameSuffix(fileWindows);
		System.out.println(StrUtils.toString(pns) );
		assertEquals(null, pns[0]);
		assertEquals("ItemType", pns[1]);
		assertEquals(".properties", pns[2]);
	}
	
	@Test
	void testGetClassPath() {
		try {
			System.out.println(FileUtils.getClassPath(null));
			System.out.println(FileUtils.getClassPath(FileUtilsTest.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetParentDir() {
		try {
			System.out.println(FileUtils.getParentDir("/F:/DevWorkspaces/eclipsejavaws/org.aimbin.commons.javas/target/test-classes/"));
			System.out.println(FileUtils.getParentDir("F:\\DevWorkspaces\\eclipsejavaws\\org.aimbin.commons.javas\\target\\test-classes\\"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
