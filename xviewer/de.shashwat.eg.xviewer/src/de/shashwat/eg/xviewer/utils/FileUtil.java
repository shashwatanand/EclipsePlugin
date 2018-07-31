package de.shashwat.eg.xviewer.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.nebula.widgets.xviewer.util.XViewerException;

import de.shashwat.eg.xviewer.Activator;

public class FileUtil {
	public static String getFileName(String filename) {
		File file = new File(filename);
		return file.getName();
	}

	public static String getFilePath(String filename) {
		File file = new File(filename);
		filename = filename.replaceAll(file.getName(), "");
		return filename;
	}

	public static String readFile(String filename) throws XViewerException {
		return readFile(new File(filename));
	}

	/**
	 * Use the Lib method directly - the original implementation of this method was
	 * not memory efficient and suppressed exceptions
	 * 
	 * @throws IOException
	 */
	public static String readFile(File file) throws XViewerException {
		return fileToString(file);
	}

	public static String fileToString(File file) throws XViewerException {
		try {
			StringBuffer buffer = new StringBuffer();
			Reader inStream = new InputStreamReader(new FileInputStream(file), "UTF-8");
			Reader in = new BufferedReader(inStream);
			int ch;
			while ((ch = in.read()) > -1) {
				buffer.append((char) ch);
			}
			in.close();
			return buffer.toString();
		} catch (IOException ex) {
			throw new XViewerException(ex);
		}
	}

	public static void writeStringToFile(String str, File file) throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		char[] chars = str.toCharArray();
		out.write(chars, 0, chars.length);
		out.close();
	}

	public static List<String> readListFromDir(File directory, FilenameFilter filter) {
		List<String> list = new ArrayList<String>(400);

		if (directory == null) {
			XViewerLogger.log(Activator.class, Level.SEVERE, "Invalid directory path");
			return list;
		}

		File[] files = directory.listFiles(filter);
		if (files == null) {
			XViewerLogger.log(Activator.class, Level.SEVERE, "Invalid path: " + directory);
			return list;
		}
		if (files.length > 0) {
			Arrays.sort(files);
		}

		for (int i = 0; i < files.length; i++) {
			list.add(files[i].getName());
		}

		return list;
	}
}
