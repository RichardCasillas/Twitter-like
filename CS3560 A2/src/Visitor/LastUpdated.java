package Visitor;

import application.User;
import application.UserGroup;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 7 December 2020
 * 
 * Created class to check times 
 */

public class LastUpdated implements Statistics{
	private User user;
	private long time;

	public LastUpdated() {
		user = null;
		time = -1;
	}

	@Override
	public void visit(User user) {
		if(user.getUpdatedTime()>time) {
			this.user = user;
			time = user.getUpdatedTime();
		}
	}

	@Override
	public void visit(UserGroup userGroup) {/*do nothing*/}

	public User getUser() {
		return user;
	}

}
