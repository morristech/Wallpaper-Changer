package com.chrisreading.wallpaperchanger.handler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import com.chrisreading.wallpaperchanger.model.Image;

/**
 * Handles changing the background to a new image
 * using a timer
 */
public class BackgroundManager {

	private ChangeHandler ch;
	private Queue<Image> images;
	private int duration;
	
	public BackgroundManager(List<Image> list, int duration) {
		this.duration = duration;
		ch = new ChangeHandler();
		
		images = new LinkedList<Image>(list);
	}
	
	/**
	 * Changes the wallpaper set on an interval
	 */
	public void init() {
		System.out.println("Started " + duration + " minute timer.");
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(!images.isEmpty()) {
					try {
						ch.change(images.poll().getFile().getAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					System.out.println("Changed wallpaper");
				} else {
					System.out.println("Out of wallpapers, program exiting.");
					System.exit(0);
				}
			}
		}, 0, duration * 60 * 1000);
	}
	
}
