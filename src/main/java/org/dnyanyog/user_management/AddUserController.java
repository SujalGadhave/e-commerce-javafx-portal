package org.dnyanyog.user_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddUserController {
    @FXML
    private TextField emailId;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField password;

    @FXML
    private TextField userId;

    @FXML
    private TextField userName;
    
    public void addUser() throws IOException, InterruptedException {
 		
    	AddUserRequest request = new AddUserRequest();
    	request.setUserId(userId.getText());
    	request.setUserName(userName.getText());
    	request.setUserEmail(emailId.getText());
    	request.setPassword(password.getText());
		
    	String url = "http://localhost:8080/user";
    	
    	AddUserResponse response = RestUtil.post(url, request, AddUserResponse.class);
    	
		if(response.getResponseCode().equals("0000") && response != null) {
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText(response.getResponseMessage());
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText(response.getResponseMessage());
		}		
    }
    
    public void back() {
    	new UserMenu().show();
    }
}
