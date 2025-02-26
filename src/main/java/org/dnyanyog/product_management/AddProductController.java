package org.dnyanyog.product_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.AddProductRequest;
import org.dnyanyog.dto.AddProductResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddProductController {

    @FXML
    private TextField productId;

    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQuantity;

    @FXML
    private Label errorMessage;
    
    public void addProduct() throws IOException, InterruptedException {
    	
    	AddProductRequest request = new AddProductRequest();
    	request.setProductId(productId.getText());
    	request.setProductName(productName.getText());
    	request.setProductPrice(productPrice.getText());
    	request.setProductQuantity(productQuantity.getText());
    	   	
    	String url = "http://localhost:8080/product/product";
    	AddProductResponse response = RestUtil.post(url, request, AddProductResponse.class);
    	
		if(response.getResponseCode().equals("0000") && response.getResponseMessage().equals("Product added successfully")) {
			
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText(response.getResponseMessage());
			
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText(response.getResponseMessage());
		}
    }
    
    public void back() {
    	new MenuProductScreen().show();
    }
}