package com.yz.jvm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;

public abstract class FileUtil {
	/**
	 * 根据class path读取资源内容
	 * 
	 * @param classPath
	 * @return
	 * @throws IOException
	 */
	public static String getResourceContent(String classPath) throws IOException {
		byte[] data = getClassPathResourceData(classPath);
		if (data != null) {
			return new String(data);
		}
		return null;
	}

	/**
	 * 根据class path读取资源内容
	 * 
	 * @param classPath
	 * @return
	 * @throws IOException
	 */
	public static byte[] getClassPathResourceData(String classPath) throws IOException {
		InputStream inputStream = null;
		try {
			ClassPathResource classPathResource = new ClassPathResource(classPath);
			inputStream = classPathResource.getInputStream();
			int length = inputStream.available();
			byte[] data = new byte[length];
			inputStream.read(data, 0, length);
			return data;
		} finally {
			if (inputStream != null) {
				inputStream.close();
				inputStream = null;
			}
		}
	}

	/**
	 * 写文件
	 * 
	 * @param fileName
	 *            完整文件名(类似：/usr/a/b/c/d.txt)
	 * @param contentBytes
	 *            文件内容的字节数组
	 * @param autoCreateDir
	 *            目录不存在时，是否自动创建(多级)目录
	 * @param autoOverWrite
	 *            目标文件存在时，是否自动覆盖
	 * @return
	 * @throws IOException
	 */
	public static boolean write(String fileName, byte[] contentBytes, boolean autoCreateDir, boolean autoOverwrite)
			throws IOException {
		boolean result = false;
		if (autoCreateDir) {
			createDirs(fileName);
		}
		if (autoOverwrite) {
			delete(fileName);
		}
		File f = new File(fileName);

		FileOutputStream fs = new FileOutputStream(f);
		fs.write(contentBytes);
		fs.flush();
		fs.close();
		result = true;
		return result;
	}

	/**
	 * 创建(多级)目录
	 * 
	 * @param filePath
	 *            完整的文件名(类似：/usr/a/b/c/d.xml)
	 */
	public static void createDirs(String filePath) {
		File file = new File(filePath);
		File parent = file.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdirs();
		}

	}

	/**
	 * 删除文件
	 * 
	 * @param fileName
	 *            待删除的完整文件名
	 * @return
	 */
	public static boolean delete(String fileName) {
		boolean result = false;
		File f = new File(fileName);
		if (f.exists()) {
			result = f.delete();

		} else {
			result = true;
		}
		return result;
	}

}
