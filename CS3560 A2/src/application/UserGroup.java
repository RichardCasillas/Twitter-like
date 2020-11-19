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
	
	public int accept(Statistics visitor) {	//accept a visitor
		int count = 0;
		for (Tree tree : list) {
			count += tree.accept(visitor);
		}
		count += visitor.visit(this);
		return count;
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
