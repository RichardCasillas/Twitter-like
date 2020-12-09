/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package application;

/*
 * Richard Casillas
 * Professor Sun
 * CS 3560.01
 * 12 November 2020
 * 
 * Controller class that interacts with Sample.fxml
 * built using scene builder
 * contains methods that add the functionality to the buttons in the GUI
 * 
 * 7 December 2020
 * Added 2 new buttons and their methods
 */

import java.awt.TextArea;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.User;
import Visitor.*;
import application.Tree;
import application.UserGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controller {

	@FXML
	private Image folder = new Image("file:./src/application/folder.png");
	@FXML
	private ImageView CPP; 
	private Alert alert;
	@FXML
	private UserGroup mainRoot;
	@FXML
	private TreeItem<String> rootItem /*= new TreeItem<>("Root", new ImageView(folder))*/;
	@FXML // fx:id="treeView"
	private TreeView<String> treeView ; // Value injected by FXMLLoader

	public Controller() {
		mainRoot = new UserGroup("Root");
	}

	@FXML // fx:id="addUser"
	private Button addUser; // Value injected by FXMLLoader

	@FXML // fx:id="addGroup"
	private Button addGroup; // Value injected by FXMLLoader

	@FXML // fx:id="userId"
	private TextField userId; // Value injected by FXMLLoader

	@FXML // fx:id="groupId"
	private TextField groupId; // Value injected by FXMLLoader

	@FXML // fx:id="openUserView"
	private Button openUserView; // Value injected by FXMLLoader

	@FXML // fx:id="showUserTotal"
	private Button showUserTotal; // Value injected by FXMLLoader

	@FXML // fx:id="showMessageTotal"
	private Button showMessageTotal; // Value injected by FXMLLoader

	@FXML // fx:id="showPositivePercentage"
	private Button showPositivePercentage; // Value injected by FXMLLoader

	@FXML // fx:id="showGroupTotal"
	private Button showGroupTotal; // Value injected by FXMLLoader
	
	@FXML
	private Button latestUpdate;
	
	@FXML
	private Button verify;


	public void initialize() {	//method to initialize the root in tree view
		rootItem = new TreeItem<>("Root", new ImageView(folder));
		treeView.setRoot(rootItem);
	}


	@FXML
	void addUser(ActionEvent event) {	//Add User button

		if(treeView.getSelectionModel().getSelectedItem() == null) {
			alert = new Alert(Alert.AlertType.ERROR, "Select a group first.");
			alert.show();
		}
		else if(userId.getText().equals("")) {
			alert = new Alert(Alert.AlertType.ERROR, "Please enter an id.");
			alert.show();
		}
		else {
			if(treeView.getSelectionModel().getSelectedItem().getValue().equals("Root")) {
				TreeItem<String> treeItem = new TreeItem<>(userId.getText());
				treeView.getSelectionModel().getSelectedItem().getChildren().add(treeItem);
				treeView.getSelectionModel().getSelectedItem().setExpanded(true);
				mainRoot.addUser(userId.getText());
			}
			else {
				for (Tree t : ((UserGroup) mainRoot).getList()) {
					if (t instanceof UserGroup) {
						if (treeView.getSelectionModel().getSelectedItem().getValue().equals(t.getId())) {
							TreeItem<String> treeItem = new TreeItem<>(userId.getText());
							treeView.getSelectionModel().getSelectedItem().getChildren().add(treeItem);
							treeView.getSelectionModel().getSelectedItem().setExpanded(true);
							((UserGroup) t).addUser(userId.getText());
							break;
						}
					}
				}
			}
			userId.clear();
		}

	}

	@FXML
	void addUserGroup(ActionEvent event) {	//add user group button

		if (treeView.getSelectionModel().getSelectedItem() == null) {
			alert = new Alert(Alert.AlertType.ERROR, "Select a group first.");
			alert.show();
		}
		else if (groupId.getText().equals("")) {
			alert = new Alert(Alert.AlertType.ERROR, "Please enter an id.");
			alert.show();
		}
		else {
			if (treeView.getSelectionModel().getSelectedItem().getValue().equals("Root")) {
				TreeItem<String> treeItem = new TreeItem<>(groupId.getText(), new ImageView(folder));
				treeView.getSelectionModel().getSelectedItem().getChildren().add(treeItem);
				treeView.getSelectionModel().getSelectedItem().setExpanded(true);
				mainRoot.addGroup(groupId.getText());
			}
			else {
				
				for (Tree t : ((UserGroup) mainRoot).getList()) {
					if (t instanceof UserGroup) {
						if (treeView.getSelectionModel().getSelectedItem().getValue().equals(t.getId())) {
							TreeItem<String> treeItem = new TreeItem<>(groupId.getText(), new ImageView(folder));
							treeView.getSelectionModel().getSelectedItem().getChildren().add(treeItem);
							treeView.getSelectionModel().getSelectedItem().setExpanded(true);
							((UserGroup) t).addGroup(groupId.getText());
							break;
						}
					}
				}
			}
			groupId.clear();
		}
	}
	
	@FXML void userViewButtonPushed(ActionEvent event) {
		if (treeView.getSelectionModel().getSelectedItem() != null) {
            User user = grabUser(mainRoot, treeView.getSelectionModel().getSelectedItem().getValue());
            if(user != null) {
                user.openWindoUV();
            }
            else {
                alert = new Alert(Alert.AlertType.ERROR, "Please select a user.");
                alert.show();
            }
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR, "Please select a user.");
            alert.show();
        }
	}


	@FXML
	void userTotal(ActionEvent event) {	//add user total button
		UTotal visitor = new UTotal();
		mainRoot.accept(visitor);
		int count = visitor.getCounter();
		Alert registeredUsersalert = new Alert(Alert.AlertType.INFORMATION, "There are currently " + count + " users.");
		registeredUsersalert.show();
	}

	@FXML
	void groupTotal(ActionEvent event) {	//add group total button
		UGTotal visitor = new UGTotal();
		mainRoot.accept(visitor);
		int count = visitor.getCounter() -1;
		Alert userGroupalert = new Alert(Alert.AlertType.INFORMATION, "There are currently " + count + " user group(s).");
		userGroupalert.show();
	}

	@FXML 
	void messageTotal(ActionEvent event) {	//add messages total button
		MTotal visitor = new MTotal();
		mainRoot.accept(visitor);
		int count = visitor.getCounter();
		alert = new Alert(Alert.AlertType.INFORMATION, "Number of Current Messages is : " + count);
		alert.setHeaderText("Message Total");
		alert.show();
	}

	@FXML 
	void positiveTotal(ActionEvent event) {	//add positive percentage total button
		PPTotal pVisitor = new PPTotal();
		MTotal mVisitor = new MTotal();
		mainRoot.accept(pVisitor);
		mainRoot.accept(mVisitor);
		int pCounter = pVisitor.getCounter();
		int mCounter = mVisitor.getCounter();
		
		if(mCounter == 0) {
			alert = new Alert(Alert.AlertType.ERROR, "There are currently no messages.");
		}
		else {
			double percent = (double) pCounter / mCounter;
			alert = new Alert(Alert.AlertType.INFORMATION, (percent * 100) + "% of messages are positive");
		}
		
		alert.setHeaderText("Positive Messages Total");
		alert.show();
	}
	
	@FXML
	void checkUpdates (ActionEvent event) {	//button to check who the last updated user/group is
		LastUpdated visitor = new LastUpdated();
		mainRoot.accept(visitor);
		User user = visitor.getUser();
		
		if(user == null) 
			alert = new Alert(Alert.AlertType.INFORMATION, "There are currently no registered users. Please add users before trying again.");
		else
			alert = new Alert(Alert.AlertType.INFORMATION, "The user that was last updated is: " + user.getId());
		alert.setHeaderText("Updates");
		alert.show();
	}
	
	@FXML
	void verifyCheck (ActionEvent event) {	//button to make sure usernames dont have any spaces 
		UUGVerification visitor = new UUGVerification();
		mainRoot.accept(visitor);
		if(visitor.getVerification())
			alert = new Alert(Alert.AlertType.INFORMATION, "Everyone has valid usernames! ");
		else
			alert = new Alert(Alert.AlertType.INFORMATION, "Someone has an invalid username! ");
		alert.setHeaderText("Verification");
		alert.show();
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

