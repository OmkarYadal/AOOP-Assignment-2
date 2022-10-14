package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.event.*;

public class Assignment2_2 extends Application {
	
	Label response;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage myStage) {
		//setting the title for the Stage
		myStage.setTitle("Menu Demo");
		
		//creating a Scene graph
		BorderPane rootNode = new BorderPane();
		
		//creating a Scene
		Scene myScene = new Scene(rootNode,300,300);
		
		//setting the scene for stage
		myStage.setScene(myScene);
		
		//creating labels for giving the response
		response = new Label("Menu Demo");
		
		//creating a MenuBar for the Menu
		MenuBar mb = new MenuBar();
		
		//creating a Menu
		Menu fileMenu = new Menu("_File");
		
		//creating multiple MenuItems for the fileMenu
		MenuItem new1 = new MenuItem("New");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		
		//creating shortcuts for the MenuItems
		new1.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
		open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
		save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
		
		fileMenu.setMnemonicParsing(true);
		
		//adding MenuItems to the fileMenu
		fileMenu.getItems().addAll(new1,open,save);
		
		//creating a Menu
		Menu edit = new Menu("_Edit");
		
		//creating multiple MenuItems for the fileMenu
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		
		//creating shortcuts for the MenuItems
		cut.setAccelerator(KeyCombination.keyCombination("shortcut+X"));
		copy.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
		paste.setAccelerator(KeyCombination.keyCombination("shortcut+V"));
		edit.setMnemonicParsing(true);
		edit.getItems().addAll(cut,copy,paste);
		
		//creating a Menu
		Menu help = new Menu("_About");
		
		//creating multiple MenuItems for the fileMenu
		MenuItem helpCenter = new MenuItem("Help Center");
		MenuItem about = new MenuItem("About Us");
		
		//creating shortcuts for the MenuItems
		helpCenter.setAccelerator(KeyCombination.keyCombination("shortcut+H"));
		about.setAccelerator(KeyCombination.keyCombination("shortcut+B"));
		help.setMnemonicParsing(true);
		help.getItems().addAll(helpCenter,about);
		
		//adding the Menus for MenuBar
		mb.getMenus().addAll(fileMenu,edit,help);
		
		//handling ActionEvent for the selection of any MenuItem
		EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				//giving the appropriate message on the selection
				response.setText(name + " selected");
			}
		};
		
		//adding the action event for the MenuItems
		new1.setOnAction(MEHandler);
		open.setOnAction(MEHandler);
		save.setOnAction(MEHandler);
		cut.setOnAction(MEHandler);
		copy.setOnAction(MEHandler);
		paste.setOnAction(MEHandler);
		helpCenter.setOnAction(MEHandler);
		about.setOnAction(MEHandler);

		//setting the MenuBar in the Scene Graph
		rootNode.setTop(mb);
		
		//setting the label in the Scene graph
		rootNode.setCenter(response);
		
		myStage.show();
	}
}
