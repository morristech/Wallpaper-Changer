package com.chrisreading.wallpaperchanger.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.chrisreading.wallpaperchanger.handler.ImageGrabber;
import com.chrisreading.wallpaperchanger.model.Image;
import com.chrisreading.wallpaperchanger.utility.DownloadUtility;
import com.chrisreading.wallpaperchanger.utility.FileLocations;

/**
 * Uses the list of links provided by ImageGrabber, downloads them.
 */
public class ImageListManager {
	
	private List<Image> images;
	private ImageGrabber ig;
	
	public ImageListManager(ImageGrabber ig) {
		this.ig = ig;
		images = new ArrayList<Image>();
	}
	
	/**
	 * Downloads images from ImageGrabber
	 * @throws IOException
	 */
	public void startDownloads() throws IOException {
		File downloadLoc = new File(FileLocations.DOWNLOAD_FOLDER);
		
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
