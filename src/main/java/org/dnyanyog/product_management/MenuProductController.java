package org.dnyanyog.product_management;

import org.dnyanyog.home.HomeScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuProductController {
	
	@FXML
    private Button addProduct;

    @FXML
    private Button displayProduct;

    @FXML
    private Button removeProduct;

    @FXML
    private Button searchProduct;
	    
    @FXML
    private Button back;

	
	public void addProduct() {
		new AddProductScreen().show();
	}
	
	public void searchProduct() {
		new SearchProductScreen().show();
	}
	
	public void removeProduct() {
		new RemoveProductScreen().show();
	}

	public void displayProduct() {
		new UpdateProductScreen().show();
	}
	
	public void back() {
		new HomeScreen().show();
	}
}
