package application;

import java.util.List;
import java.util.ArrayList;

public class AdminPanel {

	private static AdminPanel instance = null;
	static Users userObj = new Users();
	UserGroups groupObj = new UserGroups();
	
	public static List<String> ID = new ArrayList<String>();
	
	private AdminPanel() {}
	
	public static AdminPanel getInstance(){
		if(instance == null) {
			instance = new AdminPanel();
		}
		return instance;
	}
	
	//method to generate a random 9 digit string id
	public static String genID() {
		String numbs = "0123456789";
		int n = 9;
		StringBuilder sb = new StringBuilder(n);
		for(int j = 0; j < n; j++) {
			int index = (int) (numbs.length() * Math.random());
			sb.append(numbs.charAt(index));
		}
		String id = sb.toString();
		return sb.toString();
	}

	public static String userID() {
		String id = genID();
		
		if(userObj.getUniqueID() == id) {
			return "This ID is already taken. Please enter a new ID.";
		}
		else {
			return "NEW ID: " + id;
			
		}
	}
	
	public static void main(String[] args) {
		AdminPanel admin = new AdminPanel();
		System.out.println(admin.genID());
		System.out.print(admin.userID());
		
	}

}
