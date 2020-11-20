package application;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 * 
 * Admin class that implements the singleton
 * pattern. also contains a helper method
 * 
 */

import application.Tree;
import application.User;
import application.UserGroup;

public class AdminPanel {
	
	private static AdminPanel instance = null;
	private UserGroup mainRoot;
	
	
	private AdminPanel() {
		mainRoot = new UserGroup("Root");
	}
	
	public static AdminPanel getInstance() {
		if (instance == null) {
			instance = new AdminPanel();
		}
		return instance;
	}
	
	public User findUser(String id) { //locates user by doing a search 
        return grabUser(mainRoot, id);
    }
	
    private boolean checkUnique(Tree entry, String id) { //compares id and checks to make sure it is unique
        for  (Tree t : ((UserGroup) entry).getList()) {
            if (t.getId().equals(id)) {
                return false;
            }
            if (t instanceof UserGroup) {
                if (!checkUnique(t, id)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private User grabUser(Tree entry, String id) { // returns user with corresponding id
		if (entry instanceof User && entry.getId().equals(id)) {
			return (User) entry;
		}

		if (entry instanceof UserGroup) {
			for (Tree t : ((UserGroup) entry).getList()) {
				User user = grabUser(t, id);
				if (user != null) {
					return user;
				}
			}
		}
		return null;
	}
    
}
