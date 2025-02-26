package org.dnyanyog.ecom_main;

import org.dnyanyog.common.StageFactory;
import org.dnyanyog.login_page.LoginScreen;

import javafx.application.Application;
import javafx.stage.Stage;

public class EcomMain extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		StageFactory.setStage(primaryStage);
		new LoginScreen().show();
	}
}