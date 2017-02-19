package com.chrisreading.wallpaperchanger;

import java.io.IOException;

import com.chrisreading.wallpaperchanger.manager.ImageListManager;

/**
 * Inits the front & backend
 */
public class WallpaperChanger {
	
	public static void main(String[] args) {
		// TODO: init backend
		// TODO: init frontend
		
		ImageListManager list = new ImageListManager("earthporn");
		try {
			list.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
