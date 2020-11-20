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
 */

import java.awt.TextArea;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.User;
import Visitor.MTotal;
import Visitor.PPTotal;
import Visitor.UGTotal;
import Visitor.UTotal;
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
				//findForGroup(treeView, mainRoot, groupId);
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
		int registeredUsers = mainRoot.accept(visitor);
		Alert registeredUsersalert = new Alert(Alert.AlertType.INFORMATION, "There are currently " + registeredUsers + " users.");
		registeredUsersalert.show();
	}

	@FXML
	void groupTotal(ActionEvent event) {	//add group total button
		UGTotal visitor = new UGTotal();
		int userGroup = mainRoot.accept(visitor) - 1;
		Alert userGroupalert = new Alert(Alert.AlertType.INFORMATION, "There are currently " + userGroup + " user group(s).");
		userGroupalert.show();
	}

	@FXML 
	void messageTotal(ActionEvent event) {	//add messages total button
		MTotal visitor = new MTotal();
		int count = mainRoot.accept(visitor);
		alert = new Alert(Alert.AlertType.INFORMATION, "Number of Current Messages is : " + count);
		alert.setHeaderText("Message Total");
		alert.show();
	}

	@FXML 
	void positiveTotal(ActionEvent event) {	//add positive percentage total button
		PPTotal pVisitor = new PPTotal();
		MTotal mVisitor = new MTotal();
		int posCount = mainRoot.accept(pVisitor);
		int mesCount = mainRoot.accept(mVisitor);
		double percent = (double) posCount / mesCount;
		alert = new Alert(Alert.AlertType.INFORMATION, (percent * 100) + "% of messages are positive");
		alert.setHeaderText("Positive Messages Total");
		alert.show();
	}


	//moved to Admin Panel class
	/*public User findUser(String id) { // returns corresponding user with id (full search)
        return grabUser(mainRoot, id);
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

	}*/
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

