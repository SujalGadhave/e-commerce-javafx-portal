package org.dnyanyog.user_management;

import org.dnyanyog.home.HomeScreen;

public class UserMenuController {
	
	public void addUser() {
		new AddUserScreen().show();
	}
	
	public void searchUser() {
		new SearchUserScreen().show();
	}
	
	public void displayUser() {
		new UpdateUserScreen().show();
	}
	
	public void removeUser() {
		new RemoveUserScreen().show();
	}
	
	public void back() {
		new HomeScreen().show();
	}
}
