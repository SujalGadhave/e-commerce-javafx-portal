package org.dnyanyog.user_management;

import org.dnyanyog.common.StageFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UpdateUserScreen {
	public void show() {
		StageFactory.getStage();
		StageFactory.getStage().setTitle("Update User");
		
		Parent actorGroup = null;
		try {
			actorGroup = FXMLLoader.load(getClass().getResource("/User/UpdateUser.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(actorGroup);
		StageFactory.getStage().setScene(scene);
		
		StageFactory.getStage().show();
	}
}
