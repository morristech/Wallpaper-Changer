package com.chrisreading.wallpaperchanger.utility;

/**
 * Contains all final variables used in the program
 */
public class Vars {
	
	public static final String APP_TITLE = "Wallpaper Changer";

	public static final String DOWNLOAD_FOLDER_WINDOWS = System.getenv("APPDATA") + "/WallpaperChanger/";
	public static final String DOWNLOAD_FOLDER_MAC = System.getProperty("user.home") + "/library/Application Support/WallpaperChanger/";
	public static final String DOWNLOAD_FOLDER_LINUX = System.getProperty("user.home") + "/WallpaperChanger/";
	
	public static final String USER_AGENT = "WallpaperChanger by /u/SwagaliciousC";
	
}
