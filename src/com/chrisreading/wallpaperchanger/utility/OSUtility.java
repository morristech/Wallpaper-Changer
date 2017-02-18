package com.chrisreading.wallpaperchanger.utility;

/**
 * Utility for detecting the user's operating system
 */
public class OSUtility {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static boolean isWindows() {
		if(OS.indexOf("win") >= 0) return true;
		return false;
	}
	
	public static boolean isLinux() {
		if(OS.indexOf("nux") >= 0) return true;
		return false;
	}
	
	public static boolean isMac() {
		if(OS.indexOf("mac") >= 0) return true;
		return false;
	}

}
