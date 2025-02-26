package org.dnyanyog.product_management;

import java.io.IOException;

import org.dnyanyog.common.RestUtil;
import org.dnyanyog.dto.UpdateProductRequest;
import org.dnyanyog.dto.UpdateProductResponse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class UpdateProductController {

    @FXML
    private Label errorMessage;

    @FXML
    private TextField productId;

    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQuantity;

    @FXML
    private TextField searchProduct;

    public void searchProduct() throws IOException, InterruptedException {
        String url = "http://localhost:8080/product/product/" + searchProduct.getText();

        // Fetch product details
        UpdateProductResponse response = RestUtil.get(url, UpdateProductResponse.class);

        if (response != null && "0000".equals(response.getResponseCode())) {
        	
            productId.setPromptText(String.valueOf(response.getProductId()));
            productName.setPromptText(response.getProductName());
            productPrice.setText(response.getProductPrice());
            productQuantity.setText(response.getProductQuantity());

            errorMessage.setTextFill(Color.GREEN);
            errorMessage.setText("Product found successfully!");
        } else {
            errorMessage.setTextFill(Color.RED);
            errorMessage.setText(response.getResponseMessage());
        }
    }

    // Update Product Details
    public void updateProduct() throws IOException, InterruptedException {
        if (productName.getText().isEmpty()) {
            errorMessage.setTextFill(Color.RED);
            errorMessage.setText("Please search and select a product first.");
            return;
        }

        UpdateProductRequest request = new UpdateProductRequest();
        request.setProductPrice(productPrice.getText());
        request.setProductQuantity(productQuantity.getText());

        String url = "http://localhost:8080/product/product/" + productName.getText();
        UpdateProductResponse response = RestUtil.put(url, request, UpdateProductResponse.class);

        if (response != null && "0000".equals(response.getResponseCode())) {
            errorMessage.setTextFill(Color.GREEN);
            errorMessage.setText("Product updated successfully!");
        } else {
            errorMessage.setTextFill(Color.RED);
            errorMessage.setText(response.getResponseMessage());
        }
    }

    public void back() {
        new MenuProductScreen().show();
    }
}
