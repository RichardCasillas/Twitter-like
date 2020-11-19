package application;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 * 
 * Defines a User and implements 
 * the getId and accept methods and 
 * is part of the composite pattern
 */

import Visitor.Observer;
import Visitor.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Visitor.Statistics;
import java.util.ArrayList;
import java.util.List;

public class User extends Subject implements Tree, Observer{
	
	private String id;
	private List<String> followers;
	private List<String> following;
	private List<String> tweets;
	private List<String> feed;
	private ListView<String> foList;
	private ListView<String> feList;
	private Alert alert;
	
	//Constructor
	public User(String id) {
		this.id = id;
		followers = new ArrayList<>();
		following = new ArrayList<>();
		tweets = new ArrayList<>();
		feed = new ArrayList<>();
		//initializeStage();
	}
	
	public int accept(Statistics visitor) {
		return visitor.visit(this);
	}
	
	public void update(Subject sub) {
		User user = (User) sub;
		feed.add(user.getTweets().get(user.getTweets().size()-1));
		ObservableList<String> tweetList = FXCollections.observableArrayList(feed);
		feList.setItems(tweetList);
	}
	
	public void follow(String id) {	//method where a user attaches to the given id 
		AdminPanel admin = AdminPanel.getInstance();
		User user = admin.findUser(id);
		if (user != null) {
			user.attach(this);
			following.add(id);
		}
		else {
			alert = new Alert(Alert.AlertType.ERROR, "User Does Not Exist.");
			alert.show();
		}
	}
	
	
	

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
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

	public List<String> getTweets() {
		return tweets;
	}

	public void setTweets(List<String> tweets) {
		this.tweets = tweets;
	}

	public List<String> getFeed() {
		return feed;
	}

	public void setFeed(List<String> feed) {
		this.feed = feed;
	}

	public ListView<String> getFoList() {
		return foList;
	}

	public void setFoList(ListView<String> foList) {
		this.foList = foList;
	}

	public ListView<String> getFeList() {
		return feList;
	}

	public void setFeList(ListView<String> feList) {
		this.feList = feList;
	}
	
	/*private void initializeStage() { // UI initialization
        windowOpened = false;
        borderPane = new BorderPane();
        stage = new Stage();
        stage.setTitle(id);
        stage.setScene(new Scene(borderPane, 750, 500));
        stage.setOnCloseRequest(event -> {
            windowOpened = false;
        });
    }*/

}
