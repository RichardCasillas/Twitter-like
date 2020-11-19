package Visitor;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Subject {	//observer pattern pt2
	
	private List<Observer> obs = new ArrayList<Observer>();
	
	public void attach(Observer obs) {
		this.obs.add(obs);
	}
	
	public void updateAllObservers() {
		for (Observer obs : this.obs) {
			obs.update(this);
		} 
	}

}
