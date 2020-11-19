package Visitor;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 */

import application.User;
import application.UserGroup;

public class MTotal implements Statistics{	//visitor pattern
	
	public MTotal() {
		
	}
	
	@Override
	public int visit(User user) {
		return user.getTweets().size();
	}
	
	@Override
	public int visit(UserGroup group) {
		return 0;
	}

}
