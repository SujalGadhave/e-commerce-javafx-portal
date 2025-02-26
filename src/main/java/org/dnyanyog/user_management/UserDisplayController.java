//package org.dnyanyog.user_management;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.dnyanyog.common.DBUtil;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//
//public class UserDisplayController extends DBUtil {
//	 @FXML
//	    private TableView<User> userTable;
//
//	    @FXML
//	    private TableColumn<User, Integer> userId;
//
//	    @FXML
//	    private TableColumn<User, String> userName;
//
//	    @FXML
//	    private TableColumn<User, String> userEmail;
//
//	    @FXML
//	    private TableColumn<User, String> userPassword;
//	    
//	    @FXML
//	    private Button back;
//
//	    private ObservableList<User> userList = FXCollections.observableArrayList();
//
//	    private void loadDataFromDatabase() throws SQLException {
//	    				
//			 String query = "SELECT * FROM ecomlogin.user";
//			
//			ResultSet resultSet = DBUtil.resultQuery(query);
//
//            while (resultSet.next()) {
//                int userId = resultSet.getInt("userid");
//                String userName = resultSet.getString("username");
//                String email = resultSet.getString("emailid");
//                String password = resultSet.getString("password");
//
//                userList.add(new User(userId, userName, email, password));
//            }   
//
//            userTable.setItems(userList);
//
//	    }
//	    public void initialize() throws SQLException {
//	        // Set up the columns
//	    	userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
//	        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
//	        userEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
//	        userPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
//
//	        // Load data from the database
//	        loadDataFromDatabase();
//	    }
//	    
//	    public void back() {
//	    	new UserMenu().show();
//	    }
//}
