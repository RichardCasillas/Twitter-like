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
	private int counter;
	
	public UTotal() {counter = 0;}
	
	@Override
	public void visit(User user) {
		counter++;
	}
	
	@Override
	public void visit(UserGroup group) {
		//do nothing
	}

	public int getCounter() {return counter;}

}
