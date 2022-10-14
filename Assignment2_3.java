package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.event.*;
import javafx.geometry.Pos;

public class Assignment2_3 extends Application {

	Label response;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage myStage) {
		//setting the title for the Stage
		myStage.setTitle("Context Menu Demo");
		
		//creating a Scene graph
		FlowPane rootNode = new FlowPane();
		
		//creating a Scene
		Scene myScene = new Scene(rootNode,300,300);
		
		//setting the scene for stage
		myStage.setScene(myScene);
		
		//creating label for giving the response
		response = new Label("Menu Demo");
		
		//creating a Menu
		Menu new1 = new Menu("New");
		
		//creating multiple MenuItems for the new1
		MenuItem file = new MenuItem("File");
		MenuItem folder = new MenuItem("Folder");
		MenuItem image = new MenuItem("Image");
		
		//adding MenuItems to the new1
		new1.getItems().addAll(file,folder,image);
		
		//creating a Menu
		Menu view = new Menu("View");
		
		//creating multiple MenuItems for the view
		MenuItem large = new MenuItem("Large");
		MenuItem medium = new MenuItem("Medium");
		MenuItem small = new MenuItem("Small");
		
		//adding MenuItems to the view
		view.getItems().addAll(large,medium,small);
		
		//creating a context menu for the above created menus
		ContextMenu editMenu = new ContextMenu(new1,view);
		
		//action handling for context menu for entire scene
		rootNode.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			public void handle(ContextMenuEvent ae) {
				editMenu.show(rootNode,ae.getScreenX(),ae.getScreenY());
			}
		});
		
		//handling ActionEvent for the selection of any MenuItem
		EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				response.setText(name + " selected");
			}
		};
		
		//adding the action event for the MenuItems
		file.setOnAction(MEHandler);
		folder.setOnAction(MEHandler);
		image.setOnAction(MEHandler);
		large.setOnAction(MEHandler);
		medium.setOnAction(MEHandler);
		small.setOnAction(MEHandler);
		
		rootNode.setAlignment(Pos.CENTER);
		
		//setting the label in the Scene graph
		rootNode.getChildren().add(response);
		
		myStage.show();
	}
}
