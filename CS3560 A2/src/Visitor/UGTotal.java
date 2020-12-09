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
	private int counter;
	
	public UGTotal() {
		counter = 0;
	}
	
	@Override 
	public void visit(User user) {
		//do nothing
	}
	
	@Override
	public void visit(UserGroup group) {
		counter++;
	}
	
	public int getCounter() {return counter;}

}
