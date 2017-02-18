package com.chrisreading.wallpaperchanger.handler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.JSONObject;

import com.chrisreading.wallpaperchanger.model.Image;

public class ImageGrabber {
	
	private String baseLink = "http://reddit.com/r/earthporn";
	private List<String> subreddits;
	private Queue<Image> images;
	
	public ImageGrabber() { }
	
	public ImageGrabber(Queue<Image> images, List<String> subreddits) {
		this.images = new LinkedList<Image>();
		this.subreddits = new ArrayList<String>();
	}
	
	public List<String> getImageLinks() {
		List<String> imageLinks = new ArrayList<String>();
		
		JSONObject obj = new JSONObject(baseLink);
		
		return imageLinks;
		
	}
	
	

}
