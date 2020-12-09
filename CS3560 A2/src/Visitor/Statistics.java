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

	public void visit(User user);		//changed both methods
	public void visit(UserGroup group); //to void
	
}
