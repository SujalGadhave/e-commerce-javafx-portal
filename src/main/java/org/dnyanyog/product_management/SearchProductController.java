package org.dnyanyog.product_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.SearchProductResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SearchProductController {

	    @FXML
	    private TextField searchProduct;
	    
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
	    
	    public void searchProduct() {
	    	
	    	String url = "http://localhost:8080/product/product/" + searchProduct.getText();
	    	
	        System.out.println("Requesting URL: " + url);

	        try {
	            SearchProductResponse response = RestUtil.get(url, SearchProductResponse.class);
	            if (response != null && response.getResponseCode().equals("0000")) {
	                productId.setText(response.getProductId());
	                productName.setText(response.getProductName());
	                productPrice.setText(response.getProductPrice());
	                productQuantity.setText(response.getProductQuantity());
	                

	                errorMessage.setTextFill(Color.GREEN);
	                errorMessage.setText(response.getResponseMessage());
	            } else {
	                errorMessage.setTextFill(Color.RED);
	                errorMessage.setText("Product not found...");
	            }
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace(); // Log error
	            errorMessage.setTextFill(Color.RED);
	            errorMessage.setText("Product not found. Please try again.");
	        }
	    }

	    public void back() {
	    	new MenuProductScreen().show();
	    }
}
