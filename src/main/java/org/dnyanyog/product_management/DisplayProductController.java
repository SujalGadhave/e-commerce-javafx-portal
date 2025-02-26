//package org.dnyanyog.product_management;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.dnyanyog.common.RestUtil;
//import org.dnyanyog.dto.DisplayProductRequest;
//import org.dnyanyog.dto.DisplayProductResponse;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class DisplayProductController {
//    @FXML
//    private TableView<Product> productTable;
//
//    @FXML
//    private TableColumn<Product, Integer> columnProductId;
//
//    @FXML
//    private TableColumn<Product, String> columnName;
//
//    @FXML
//    private TableColumn<Product, String> columnQuantity;
//
//    @FXML
//    private TableColumn<Product, String> columnPrice;
//    
//    @FXML
//    private Button back;
//
//    private ObservableList<Product> productList = FXCollections.observableArrayList();
//
//    private void loadDataFromDatabase() {
//    	
//    	 try {
//    		 
//    		 DisplayProductRequest request = new DisplayProductRequest();
//    		 
//    		 
//             String url = "http://localhost:8080/products/all";
//             DisplayProductResponse response = RestUtil.get(url, request, DisplayProductResponse.class);
//
//             if (response != null && response.getResponseCode().equals("0000") && response.getResponseMessage().equals("Product Fetched!") && response.getRequest().add(request)) {
//            	    List<DisplayProductRequest> products = response.getRequest();
//            	    productList.clear();
//
//            	    
//            	    for (DisplayProductRequest p : products) {
//            	        Product product = new Product(
//            	            p.getProductId(),
//            	            p.getProductName(),
//            	            p.getProductQuantity(),
//            	            p.getProductPrice()
//            	        );
//            	        productList.add(product);
//            	    }
//
//            	    // Set data to the TableView
//            	    productTable.setItems(productList);
//            	}
//
//         } catch (IOException | InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
//       
//    public void initialize() {
//        // Set up the columns
//        columnProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
//        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//        // Load data from the database
//        loadDataFromDatabase();
//    }
//
//    
//    public void back() {
//    	new MenuProductScreen().show();
//    }
//}