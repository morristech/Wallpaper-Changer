package com.chrisreading.wallpaperchanger.handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * Parses through a json file on a certain subreddit, and grab direct links to images.
 */
public class ImageGrabber {
	
	private String USER_AGENT = "WallpaperChanger"; // reddit needs this
	
	private List<String> subreddits; // subreddits to scan through
	private List<String> imageLinks; // links to all images found
	
	public ImageGrabber() { 
		subreddits = new ArrayList<String>();
		imageLinks = new ArrayList<String>();
	}
	
	/*
	 * For each subreddit specified, do a search
	 */
	public void look() {
		for(String subreddit : subreddits) {
			System.out.println("Scanning: " + subreddit);
			
			// set the address
			String baseLink = "https://reddit.com/r/";
			String fullLink = baseLink + subreddit + "/hot.json";
			
			// now perform a scan for this subreddit
			String jsonString = readJSONFromURL(fullLink);
			JSONObject jobj = new JSONObject(jsonString);
			
			// get 5 links for now
			for(int i = 0; i < 5; i++) {
				String link = (jobj.getJSONObject("data").getJSONArray("children").getJSONObject(i).getJSONObject("data").getString("url"));
				if(link.contains(".jpg") | link.contains(".jpeg") | link.contains(".png"))
					imageLinks.add(link);
			}
		}
	}
	
	public void addSubreddit(String subreddit) {
		subreddits.add(subreddit);
	}
	
	public void addSubreddits(String[] subreddits) {
		for(String s : subreddits)
			this.subreddits.add(s);
	}
	
	public List<String> getImageLinks() {
		return imageLinks;
	}
	
	public List<String> getSubreddits() {
		return subreddits;
	}
	
	/**
	 * Reads the json file from the given url
	 */
	private String readJSONFromURL(String urlString) {
		System.out.println("Reading JSON from " + urlString);
		StringBuilder sb = new StringBuilder();
		URLConnection uc = null;
		InputStreamReader in = null;
		
		try {
			URL url = new URL(urlString);
			uc = url.openConnection();
			
			Thread.sleep(2000); // to comply with reddit's rate-limiting rules
			uc.setRequestProperty("User-Agent", USER_AGENT); // ^ same here
			
			if(uc != null)
				uc.setReadTimeout(60 * 1000);
			
			if(uc != null && uc.getInputStream() != null) {
				in = new InputStreamReader(uc.getInputStream(),Charset.defaultCharset());
				BufferedReader br = new BufferedReader(in);
				if(br != null) {
					int cp;
					while((cp = br.read()) != -1) {
						sb.append((char) cp);
					}
					br.close();
				}
			}
		in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}

}