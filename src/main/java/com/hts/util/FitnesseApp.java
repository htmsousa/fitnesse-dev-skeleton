package com.hts.util;

import java.net.URL;
import java.net.URLClassLoader;

import fitnesseMain.FitNesseMain;

public class FitnesseApp {

	public static void main(String[] args) throws Exception {
		System.setProperty("full.classpath", resolveClasspath());
		FitNesseMain.main(args);
	}

	private static String resolveClasspath() {
		StringBuilder sb = new StringBuilder();

		ClassLoader cl = ClassLoader.getSystemClassLoader();
		URL[] urls = ((URLClassLoader) cl).getURLs();
		for (URL url : urls) {
			sb.append(url.getFile()).append(";");
		}
		return sb.toString();
	}
}
