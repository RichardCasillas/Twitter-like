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

public class UGTotal implements Statistics{	//visitor pattern
	
	public UGTotal() {
		
	}
	
	@Override 
	public int visit(User user) {
		return 0;
	}
	
	@Override
	public int visit(UserGroup group) {
		return 1;
	}

}
