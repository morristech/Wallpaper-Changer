package com.chrisreading.wallpaperchanger.gui.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.chrisreading.wallpaperchanger.gui.WCApplication;
import com.chrisreading.wallpaperchanger.handler.BackgroundManager;
import com.chrisreading.wallpaperchanger.handler.DownloadManager;
import com.chrisreading.wallpaperchanger.handler.ImageGrabber;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RootController {

	private WCApplication wca; // get instance of application

	@FXML
	private ListView<String> listView;
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
		stopBtn.setVisible(false); // for now
		
		textField.setPromptText("enter subreddit");
		addBtn.disableProperty().bind(textField.textProperty().isEmpty());
		startBtn.disableProperty().bind(Bindings.isEmpty(listView.getItems()));
	}
	
	@FXML
	public void onAdd() {
		listView.getItems().add(textField.getText());
		textField.setText("");
		textField.requestFocus();
	}
	
	@FXML
	public void onStart() {
		new Thread() {
			public void run() {
				List<String> list = listView.getItems().stream().collect(Collectors.toList());
				String[] listA = new String[list.size()];
				listA = list.toArray(listA);
				
				ImageGrabber grabber = new ImageGrabber();
				grabber.addSubreddits(listA);
				grabber.look();
				
				DownloadManager dm = new DownloadManager(grabber);
				dm.startDownloads();
				BackgroundManager bm = new BackgroundManager(dm.getImages(), 1);
				bm.init();	
			}
		}.start();
	}
	
	@FXML
	public void onStop() {

	}
	
	public void setApplication(WCApplication wca) {
		this.wca = wca;
	}
	
}
