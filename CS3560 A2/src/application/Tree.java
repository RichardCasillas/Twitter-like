package application;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 */

import Visitor.VisitorInterface;

public interface Tree  extends VisitorInterface{	//composite pattern
	
	public String getId();

}
