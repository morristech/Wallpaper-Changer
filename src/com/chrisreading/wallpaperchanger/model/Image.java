package com.chrisreading.wallpaperchanger.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Model class, contains information about an image:
 * file location, width, height, file type
 */
public class Image {
	
	private int width, height;
	private File imageFile;
	private BufferedImage bufImage; // not sure if this will be used, but useful anyways
	
	public Image(File file) {
		this.imageFile = file;
		
		try {
			bufImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* GETTER & SETTERS */
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public BufferedImage getImage() {
		return bufImage;
	}
	
	public File getFile() {
		return imageFile;
	}

}
