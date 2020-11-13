package application;

import java.awt.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public abstract class FXMLDocumentController implements Initializable {


	@FXML
	private TreeView treeView;

	@FXML
	private TextField userId;

	@FXML
	private TextField groupId;

	@FXML
	private Button openUserView;

	@FXML
	private Button showUserTotal;

	@FXML
	private Button showMessageTotal;

	@FXML
	private Button showGroupTotal;

	@FXML
	private Button showPositivePercentage;

	@FXML
	private void handleButtonAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		TreeItem<String> rootTreeItem = new TreeItem<>("Root"); 

		treeView.setRoot(rootTreeItem);
	}   
}
