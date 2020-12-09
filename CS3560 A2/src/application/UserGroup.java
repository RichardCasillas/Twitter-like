package application;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 * 
 * Creates a user group using an id 
 * and list
 * also implements the accept and getId methods and
 * is part of composite pattern
 * 
 * 7 December 2020
 * fixed changes from changing method types in interfaces 
 * and removed counters
 */

import Visitor.Statistics;
import java.util.*;

public class UserGroup implements Tree{

	private String id;
	private List<Tree> list;
	
	public UserGroup(String id) {	//constructor 
		this.id = id;
		list = new ArrayList<>();
	}
	
	public void addUser(String id) {
		list.add(new User(id));
	}
	
	public void addGroup(String id) {
		list.add(new UserGroup(id));
	}
	
	public void accept(Statistics visitor) {	//accept a visitor
		//removed counter
		for (Tree tree : list) {
			tree.accept(visitor);
		}
		visitor.visit(this);
	}

	///////// GETTERS AND SETTERS GENERATED /////////
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Tree> getList() {
		return list;
	}

	public void setList(List<Tree> list) {
		this.list = list;
	}
	
	
	
}
