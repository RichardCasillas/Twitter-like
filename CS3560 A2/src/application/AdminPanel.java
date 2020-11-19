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
	private UserGroup rootGroup;
	
	
	private AdminPanel() {
		rootGroup = new UserGroup("Root");
	}
	
	public static AdminPanel getInstance() {
		if (instance == null) {
			instance = new AdminPanel();
		}
		return instance;
	}
	
    private boolean checkUnique(Tree entry, String id) { // checks if id is unique
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
    
}
