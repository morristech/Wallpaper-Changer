package com.chrisreading.wallpaperchanger.gui.controller;


import com.chrisreading.wallpaperchanger.gui.WCApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RootController {

	private WCApplication wca; // get instance of application
	
	@FXML
	private ListView listView;
	@FXML
	private Button addBtn;
	@FXML
	private Button startBtn;
	@FXML
	private Button stopBtn;
	@FXML
	private TextField textField;
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void onAdd() {
		
	}
	
	@FXML
	public void onStart() {
		
	}
	
	@FXML
	public void onStop() {
		
	}
	
	public void setApplication(WCApplication wca) {
		this.wca = wca;
	}
	
}
