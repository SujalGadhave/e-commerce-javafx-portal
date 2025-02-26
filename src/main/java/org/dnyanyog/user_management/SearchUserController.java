package org.dnyanyog.user_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.SearchUserResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SearchUserController  {
	
	@FXML
	private TextField searchUser;

    @FXML
    private TextField password;


    @FXML
    private TextField userEmail;

    @FXML
    private TextField userId;

    @FXML
    private TextField userName;

    @FXML
    Label errorMessage;
    
    public void searchUser() throws IOException, InterruptedException {
    	
    	String url = "http://localhost:8080/user/"+searchUser.getText();
    	
    	SearchUserResponse response = RestUtil.get(url, SearchUserResponse.class);
    	
		if(response != null && response.getResponseCode().equals("0000")) {
			
			userId.setText(response.getUserId());
			userName.setText(response.getUserName());
			userEmail.setText(response.getUserEmail());
			password.setText(response.getPassword());
			
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText(response.getResponseMessage());
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Product not found...");
		}
    }
    
    public void back() {
    	new UserMenu().show();
    }
       
}
