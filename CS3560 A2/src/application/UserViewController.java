/**
 * Sample Skeleton for 'UserView.fxml' Controller Class
 */

package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UserViewController {

    @FXML // fx:id="followButton"
    private Button followButton; // Value injected by FXMLLoader

    @FXML // fx:id="followText"
    private TextField followText; // Value injected by FXMLLoader

    @FXML // fx:id="followLabel"
    private Label followLabel; // Value injected by FXMLLoader

    @FXML // fx:id="postButton"
    private Button postButton; // Value injected by FXMLLoader

    @FXML // fx:id="feedTextField"
    private TextField feedTextField; // Value injected by FXMLLoader

    @FXML // fx:id="feedText"
    private Label feedText; // Value injected by FXMLLoader

    @FXML // fx:id="foList"
    private ListView<String> foList; // Value injected by FXMLLoader

    @FXML // fx:id="feList"
    private ListView<String> feList; // Value injected by FXMLLoader
    
    @FXML private Label id;
    
    private User user;
    
    private UserGroup mainRoot;
	@FXML
	private TreeItem<String> rootItem = new TreeItem<>("Root");
	@FXML // fx:id="treeView"
	private TreeView<String> treeView ; // Value injected by FXMLLoader

	public UserViewController() {
		mainRoot = new UserGroup("Root");
	}
    
    
    public void initData(User user) {
    	this.user = user;
    	id.setText(this.user.getId());
    	rootItem = new TreeItem<>("Root");
		treeView.setRoot(rootItem);
    }
    //private String id = user.getId();

    /*@FXML
    void followUser(ActionEvent event) {

    	Alert alert;
		if(id.equals(followText.getText())) {
    		alert = new Alert(Alert.AlertType.ERROR, "You must follow a different user.");
    		alert.show();
    	}
    	else if (user.getFollowing().contains(followText.getText())) {
    		alert = new Alert(Alert.AlertType.ERROR, "You are already following this user. Please enter a different ID to follow.");
    		alert.show();
    	}
    	else {
    		user.follow(followText.getText());
    		ObservableList<String> followList = FXCollections.observableArrayList(user.getFollowing());
    		foList.setItems(followList);
    	}
    	followText.clear();
    	
    }

    @FXML
    void postMessage(ActionEvent event) {
    	
    	if(feedText.getText().equals("")) {
    		Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a message.");
    		alert.show();
    	}
    	user.post(id + ": " + feedText.getText());
    	ObservableList<String> tList = FXCollections.observableArrayList(user.getFeed());
    	feList.setItems(tList);
    	feedTextField.clear();
    }*/


    @FXML
	void userViewButtonPushed(ActionEvent event) throws IOException {
		Parent userViewParent = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene userViewScene = new Scene(userViewParent);
		
		//This line gets the Stage info
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(userViewScene);
		window.show();
	}

}
