package com.chrisreading.wallpaperchanger;

import java.io.IOException;

import com.chrisreading.wallpaperchanger.handler.ImageGrabber;
import com.chrisreading.wallpaperchanger.manager.BackgroundManager;
import com.chrisreading.wallpaperchanger.manager.ImageListManager;

/**
 * Inits the front & backend
 */
public class WallpaperChanger {
	
	public static void main(String[] args) {
		ImageGrabber grabber = new ImageGrabber();
		grabber.addSubreddits(new String[] {"earthporn", "wallpapers"});
		grabber.look();
		
		ImageListManager ilm = new ImageListManager(grabber);
		
		try {
			ilm.startDownloads();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BackgroundManager bm = new BackgroundManager(ilm.getImages(), 1);
		bm.init();
	}

}
