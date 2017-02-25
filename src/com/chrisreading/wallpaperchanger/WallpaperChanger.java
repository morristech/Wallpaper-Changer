package com.chrisreading.wallpaperchanger;

import com.chrisreading.wallpaperchanger.gui.WCApplication;
import com.chrisreading.wallpaperchanger.handler.ImageGrabber;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Inits the front & backend
 */
public class WallpaperChanger {
	
	private WCApplication app;
	
	public static void main(String[] args) {
	/*
		ImageGrabber grabber = new ImageGrabber();
		grabber.addSubreddits(new String[] {"earthporn", "wallpapers"});
		grabber.look();
		
		DownloadManager dm = new DownloadManager(grabber);
		dm.startDownloads();		
		
		BackgroundManager bm = new BackgroundManager(dm.getImages(), 1);
		bm.init();
	*/	
		
		Application.launch(WCApplication.class, args);
	}
}
