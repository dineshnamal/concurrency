package com.simple.io.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	public static void copy(InputStream src, OutputStream dest) throws IOException {
		try {
			int value;
			while ((value = src.read()) != -1) {
				dest.write(value);
			}
		} catch (Exception e) {
			e.getMessage();
		}finally {
			src.close();
			dest.close();
		}
	}
	public static void copy(String srcFile, String destFile) throws IOException {
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fout = new FileOutputStream(destFile);
		IOUtils.copy(fis, fout);
	}
}
