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

public class UTotal implements Statistics{	//visitor pattern
	
	public UTotal() {}
	
	@Override
	public int visit(User user) {
		return 1;
	}
	
	@Override
	public int visit(UserGroup group) {
		return 0;
	}
	

}
