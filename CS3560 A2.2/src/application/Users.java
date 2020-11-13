package application;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String name;
	private String uniqueID;
	private List<String> followers = new ArrayList<String>();
	private List<String> following = new ArrayList<String>();
	private List<String> feed = new ArrayList<String>();
	
	public Users(String name,String uniqueID, List<String> followers, List<String> following, List<String> feed) {
		super();
		this.name = name;
		this.uniqueID = uniqueID;
		this.followers = followers;
		this.following = following;
		this.feed = feed;
	}
	
	public Users() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public List<String> getFollowers() {
		return followers;
	}
	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}
	public List<String> getFollowing() {
		return following;
	}
	public void setFollowing(List<String> following) {
		this.following = following;
	}
	public List<String> getFeed() {
		return feed;
	}
	public void setFeed(List<String> feed) {
		this.feed = feed;
	}
	
	

}
