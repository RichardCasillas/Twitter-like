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

public interface Statistics {	//visitor pattern

	public int visit(User user);
	public int visit(UserGroup group);
	
}
