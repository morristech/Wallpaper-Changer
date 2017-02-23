package com.chrisreading.wallpaperchanger;

import java.io.IOException;

import com.chrisreading.wallpaperchanger.handler.BackgroundManager;
import com.chrisreading.wallpaperchanger.handler.DownloadManager;
import com.chrisreading.wallpaperchanger.handler.ImageGrabber;

/**
 * Inits the front & backend
 */
public class WallpaperChanger {
	
	public static void main(String[] args) {
		ImageGrabber grabber = new ImageGrabber();
		grabber.addSubreddits(new String[] {"earthporn", "wallpapers"});
		grabber.look();
		
		DownloadManager dm = new DownloadManager(grabber);
		dm.startDownloads();		
		
		BackgroundManager bm = new BackgroundManager(dm.getImages(), 1);
		bm.init();
	}

}
