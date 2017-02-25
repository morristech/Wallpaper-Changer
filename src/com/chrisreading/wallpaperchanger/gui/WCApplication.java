package com.chrisreading.wallpaperchanger.gui;

import java.io.IOException;

import com.chrisreading.wallpaperchanger.WallpaperChanger;
import com.chrisreading.wallpaperchanger.gui.controller.RootController;
import com.chrisreading.wallpaperchanger.utility.Vars;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class for initializing all gui stuff
 * Hopefully I'll think of a better name
 */
public class WCApplication extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private RootController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(Vars.APP_TITLE);
		
		initRootLayout();
	}
	
	public void initRootLayout() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WallpaperChanger.class.getResource("gui/view/RootLayout.fxml"));
		rootLayout = (BorderPane) loader.load();
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		controller = new RootController();
		controller.setApplication(this);
	}
	
	public RootController getRootController() {
		return controller;
	}

}
