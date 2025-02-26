package org.dnyanyog.product_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.DeleteProductResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class RemoveProductController {
	
	@FXML
	private TextField removeProduct;
		
	@FXML
    private Label errorMessage;
		
	public void removeProduct() throws IOException, InterruptedException {
		
		String url = "http://localhost:8080/product/product/"+removeProduct.getText()+"";
		
		DeleteProductResponse response = RestUtil.delete(url, null, DeleteProductResponse.class);
		
		if(response != null && response.getResponseCode().equals("0000")) {
			
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