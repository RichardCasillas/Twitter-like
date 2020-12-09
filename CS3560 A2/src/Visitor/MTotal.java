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
	private int counter;
	
	
	public MTotal() {
		counter = 0;
	}
	
	@Override
	public void visit(User user) {
		counter = counter + user.getTweets().size();
	}
	
	@Override
	public void visit(UserGroup group) {
		//do nothing
	}

	public int getCounter() {return counter;}
	
}
