package com.chrisreading.wallpaperchanger.gui.controller;

import com.chrisreading.wallpaperchanger.gui.WCApplication;

import javafx.fxml.FXML;

public class RootController {

	private WCApplication wca; // get instance of application
	
	@FXML
	public void initialize() {
		
	}
	
	public void setApplication(WCApplication wca) {
		this.wca = wca;
	}
	
}
