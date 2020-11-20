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
import java.util.List;

public class PPTotal implements Statistics{	//visitor pattern
	
	@Override
	public int visit(User user) {
		return checkPositive(user.getTweets());
	}
	
	@Override
	public int visit(UserGroup group) {
		return 0;
	}
	
	public int checkPositive(List<String> list) {
		int count = 0;
		for(String message : list) {
			String [] arr = message.split(" ");
			for (String positiveWord : arr) {
				if (positiveWord.equals("happy") || positiveWord.equals("good") || 
				    positiveWord.equals("love") || positiveWord.equals("blessed") ||
				    positiveWord.equals("cute") || positiveWord.equals("awsome")) {
					count++;
					break;
				}
			}
		}
		return count;
	}

}
