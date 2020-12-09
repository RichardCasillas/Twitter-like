package Visitor;

import application.User;
import application.UserGroup;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 7 December 2020
 * 
 * This class handles the verification
 * process of usernames for both
 * users and user-groups
 */

public class UUGVerification implements Statistics{
	private boolean isValid;
	
	public UUGVerification() {isValid = true;}
	
	@Override
	public void visit(User user) {
		if(user.getId().contains(" ")) {
			isValid = false;
		}
	}
	
	@Override
	public void visit(UserGroup userGroup) {
		if(userGroup.getId().contains(" ")) {
			isValid = false;
		}
	}
	
	public boolean getVerification() {return isValid;}
	
}
