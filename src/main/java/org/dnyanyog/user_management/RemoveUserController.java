package org.dnyanyog.user_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.DeleteUserResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class RemoveUserController {
	
	@FXML
	private TextField removeUser;

	@FXML
    private Label errorMessage;
	
	public void removeUser() throws IOException, InterruptedException {
			
		String url = "http://localhost:8080/user/"+removeUser.getText()+"";
		
		DeleteUserResponse response = RestUtil.delete(url, null, DeleteUserResponse.class);
		
		if(response.getResponseCode().equals("0000") && response != null) {
			
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText("User removed...");
			
		}else {
			
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Something went wrong...");
			
		}
	}
	
	public void back() {
    	new UserMenu().show();
    }
}