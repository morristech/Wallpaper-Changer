package com.chrisreading.wallpaperchanger.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.chrisreading.wallpaperchanger.model.Image;
import com.chrisreading.wallpaperchanger.utility.DownloadUtility;
import com.chrisreading.wallpaperchanger.utility.OSUtility;
import com.chrisreading.wallpaperchanger.utility.Vars;

/**
 * Downloads image links from ImageGrabber
 */
public class DownloadManager {
	
	private List<Image> images;
	private ImageGrabber ig;
	
	public DownloadManager(ImageGrabber ig) {
		this.ig = ig;
		images = new ArrayList<Image>();
	}
	
	/**
	 * Downloads images from ImageGrabber
	 * @throws IOException
	 */
	public void startDownloads() throws IOException {
		File downloadLoc = null;
		
		// find out where to save images
		if(OSUtility.isWindows())
			downloadLoc = new File(Vars.DOWNLOAD_FOLDER_WINDOWS);
		else if(OSUtility.isMac())
			downloadLoc = new File(Vars.DOWNLOAD_FOLDER_MAC);
		else if(OSUtility.isLinux())
			downloadLoc = new File(Vars.DOWNLOAD_FOLDER_LINUX);
		
		// check if download folder exists, create if doesn't
		if(!downloadLoc.exists())
			downloadLoc.mkdir();
		
		// start downloading of images and then create new Image objects from them
		for(int i = 0; i < ig.getImageLinks().size(); i++) {
			String link = ig.getImageLinks().get(i);
			System.out.println("Downloading: " + link);
			images.add(new Image(DownloadUtility.download(link, downloadLoc.getAbsolutePath() + "\\" + i + ".jpg")));
		}
	}
	
	public List<Image> getImages() {
		return images;
	}

}
