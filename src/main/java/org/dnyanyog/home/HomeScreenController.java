package org.dnyanyog.home;

import org.dnyanyog.product_management.MenuProductScreen;
import org.dnyanyog.user_management.UserMenu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeScreenController {
	
    @FXML
    private Button productManagement;

    @FXML
    private Button userManagement;
    
    
//	Show Product Management Menu Page 
   public void productMenuShow() {
	   new MenuProductScreen().show();
   }

   
//   //	Show User Management Menu Page
   public void userMenuShow() {
	   new UserMenu().show();
   } 
}
