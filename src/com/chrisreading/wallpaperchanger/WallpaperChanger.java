package com.chrisreading.wallpaperchanger;

import com.chrisreading.wallpaperchanger.handler.ImageGrabber;

/**
 * Inits the front & backend
 */
public class WallpaperChanger {
	
	public static void main(String[] args) {
		// TODO: init backend
		// TODO: init frontend
		
		// testing
		ImageGrabber ig = new ImageGrabber();
		for(String str : ig.getImageLinks()) {
			System.out.println(str);
		}
	}

}
