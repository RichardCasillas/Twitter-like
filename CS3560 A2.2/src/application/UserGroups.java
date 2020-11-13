package application;

import java.util.List;
import java.util.ArrayList;

public class UserGroups {
	private String uniqueID;
	private int numOfUsers;
	private List<String> memberList = new ArrayList<String>();
	
	public UserGroups(String uniqueID, int numOfUsers, List<String> memberList) {
		super();
		this.uniqueID = uniqueID;
		this.numOfUsers = numOfUsers;
		this.memberList = memberList;
	}
	
	public UserGroups() {
		super();
	}

	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public int getNumOfUsers() {
		return numOfUsers;
	}
	public void setNumOfUsers(int numOfUsers) {
		this.numOfUsers = numOfUsers;
	}
	public List<String> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<String> memberList) {
		this.memberList = memberList;
	}
	
	

}
