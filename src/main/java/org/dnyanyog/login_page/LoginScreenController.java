package org.dnyanyog.login_page;

import java.io.IOException;
import java.sql.SQLException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.home.HomeScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginScreenController{
	@FXML
	private TextField userName;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button login;

	@FXML
	private Label message;

	
	public void login() throws SQLException, IOException, InterruptedException  {
		
		LoginRequest request = new LoginRequest();
		request.setLoginName(userName.getText());
		request.setPassword(password.getText());
		
		String url = "http://localhost:8080/auth/login";
		
		LoginResponse response = RestUtil.post(url, request, LoginResponse.class);
		
		if(response != null && response.getResponseCode().equals("0000")) {
			message.setTextFill(Color.GREEN);
			message.setText(response.getResponseMessage());
	
			new HomeScreen().show();
			
		}else {
			message.setTextFill(Color.RED);
			message.setText(response.getResponseMessage());
		}
	}
}
