package org.dnyanyog.user_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class UpdateUserController {
    @FXML
    private Label errorMessage;

    @FXML
    private TextField password;

    @FXML
    private TextField searchUser;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField userId;

    @FXML
    private TextField userName;
    
    public void searchUser() throws IOException, InterruptedException {
    	String url = "http://localhost:8080/user/"+ searchUser.getText();
    	
    	UpdateUserResponse response = RestUtil.get(url, UpdateUserResponse.class);
    	
    	if(response != null && response.getResponseCode().equals("0000")) {
    		userId.setPromptText(String.valueOf(response.getUserId()));
    		userName.setPromptText(response.getUserName());
    		userEmail.setText(response.getUserEmail());
    		password.setText(response.getPassword());
    		
    		 errorMessage.setTextFill(Color.GREEN);
             errorMessage.setText("User found successfully!");
    	} else {
    		 errorMessage.setTextFill(Color.RED);
             errorMessage.setText("User not found!");
    	}
    }
    
    public void updateUser() throws IOException, InterruptedException {
    	if(userName.getText().isEmpty()) {
    		 errorMessage.setTextFill(Color.RED);
             errorMessage.setText("Please search and select a user first");
             return;
    	}
    	
    	UpdateUserRequest request = new UpdateUserRequest();
    	
    	request.setUserName(userName.getText());
    	request.setUserEmail(userEmail.getText());
    	request.setPassword(password.getText());
    	
    	String url = "http://localhost:8080/user/" +userName.getText();
    	
    	UpdateUserResponse response = RestUtil.put(url, request, UpdateUserResponse.class);
    	
    	if(response != null && response.getResponseCode().equals("0000")) {
    		 errorMessage.setTextFill(Color.GREEN);
             errorMessage.setText("User updated successfully!");
    	} else {
            errorMessage.setTextFill(Color.RED);
            errorMessage.setText("Something went wrong!");
        }
    	
    }
    
    public void back(){
    	new UserMenu().show();
    }
}