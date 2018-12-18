/** fun_endless@163.com  2018年12月4日 */
package org.aimbin.commons.javas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * File tools.
 * 
 * @author aimbin
 * @verison 1.0.0 2018年12月4日
 */
public class FileUtils {
	/**Use UNIX path style. */
	public static final String PATH_SEP = "/";
	/**Windows path style. */
	public static final String PATH_SEP_WIN = "\\";
	
	/**Get line-breaks， windows is \r\n, unix is \n. */
	public static String newLine() {
		return File.pathSeparator.equals("/") ? "\n" : "\r\n";
	}
	
	/**Root classpath. */
	public static String getClassPath(Class<?> anchor) {
		if(anchor == null) {
			return ClassLoader.getSystemResource(".").getFile();
		}else {
			return anchor.getClassLoader().getResource(".").getFile();
		}
	}

	/**
	 * Read file to string.
	 * @author aimbin
	 * @version 1.0.0 2018年12月4日
	 * @param fileName
	 * @param claz
	 * @return
	 */
	public static String read(String fileName, Class<?> claz) {
		URL fileUrl = null;
		try {
			fileUrl = claz.getResource(fileName);
			if (fileUrl == null) {
				fileUrl = claz.getClassLoader().getResource(fileName);
			}
			if (fileUrl == null) {
				fileUrl = ClassLoader.getSystemResource(fileName);
			}
			if (fileUrl == null) {
				return null;
			}
			StringBuilder sb = new StringBuilder();
			try (Stream<String> stream = Files.lines(Paths.get(fileUrl.toURI()), StandardCharsets.UTF_8)) {
				stream.forEach(s -> sb.append(s).append(newLine()));
			} catch (IOException ioe) {
				throw new IllegalArgumentException("Read by stream failed:" + fileName,ioe);
			}
			return sb.toString();
		} catch (Exception e) {
			throw new IllegalArgumentException("Read failed:" + fileName,e);
		}
	}
	
	/**
	 * Write string to file.
	 * @author aimbin
	 * @version 1.0.0 2018年12月5日
	 * @param content
	 * @param filePath
	 */
	public static void write(String content, String filePath) {
		String[] folderNameSuffix = getFolderNameSuffix(filePath);
		if(folderNameSuffix[0] != null) {
			File folder = new File(folderNameSuffix[0]);
			if(!folder.exists()) {
				folder.mkdirs();
			}
		}
		File file = new File(filePath);
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(file);
			byte[] bit = content.getBytes(StandardCharsets.UTF_8);
			ByteBuffer buffer = ByteBuffer.allocate(bit.length);
			FileChannel channel = fout.getChannel();
			buffer.put(content.getBytes(StandardCharsets.UTF_8));
			buffer.flip();
			channel.write(buffer);
		} catch (Exception e) {
			throw new IllegalArgumentException("Write failed:" + filePath,e);
		}finally {
			ObjUtils.close(fout);
		}
		
	}
	/**To UNIX style path. */
	public static String toUnixPath(final String filePath) {
		if(filePath.indexOf(PATH_SEP_WIN) >= 0) {
			return filePath.replace(PATH_SEP_WIN, PATH_SEP);
		}else {
			return filePath;
		}
	}
	
	/**Get folder path, is filePath is a folder, last char should be the path-seperator. */
	public static String[] getFolderNameSuffix(final String filePath) {
		String path = toUnixPath(filePath);
		String[] parts = new String[3];
		final int lastIdxOfSep = path.lastIndexOf(PATH_SEP) ;
		String names = null;
		if(lastIdxOfSep < 0 ) {
			if(path.indexOf(".") < 0) {
				parts[0] = path;
			}else {
				names = path;
				parts[0] = null;
			}
		}else {
			parts[0] = path.substring(0,lastIdxOfSep);
			if(path.length() > lastIdxOfSep + 1) {
				names = path.substring(lastIdxOfSep + 1);
			}
		}
		String[] nameSuffix = getNameSuffix(names);
		if(nameSuffix == null) {
			parts[1] = null;
			parts[2] = null;
		}else {
			parts[1] = nameSuffix[0];
			parts[2] = nameSuffix[1];
		}
		return parts;
	}
	
	/**File name and suffix, suffix include the dot.*/
	public static String[] getNameSuffix(String fileName) {
		if(fileName == null) {
			return null;
		}
		final int dotIdx = fileName.lastIndexOf(".");
		String[] parts = new String[2];
		if(dotIdx < 0) {
			parts[0] = fileName;
			parts[1] = null;
		}else {
			parts[0] = fileName.substring(0, dotIdx);
			parts[1] = fileName.substring(dotIdx);
		}
		return parts;
	}
	
	/**Parent folder. */
	public static String getParentDir(String path) {
		String folder = getFolderNameSuffix(path)[0];
		if(folder == null) {
			return null;
		} 
		if(folder.endsWith(PATH_SEP)) {
			folder = folder.substring(0,folder.length() - 1);
		}
		int lastSep = folder.lastIndexOf(PATH_SEP);
		if(lastSep <= 0) {
			return null;
		}else {
			return folder.substring(0, lastSep);
		}
	}
}
