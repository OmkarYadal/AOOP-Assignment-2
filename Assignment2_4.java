package application;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.geometry.*;

public class Assignment2_4 extends Application {

	Label lheading;
	Label lname;
	Label lgender;
	Label ldob;
	Label lstate;
	Label lquali;
	TextField tname;
	Button bregister;
	ComboBox<String> cbState;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage myStage) {
		//setting the title for the Stage
		myStage.setTitle("JavaFx Registration Form");
		
		//creating a Scene graph
		GridPane rootNode = new GridPane();
		
		//creating a Scene
		Scene myScene = new Scene(rootNode,550,325);
		
		//setting the scene for stage
		myStage.setScene(myScene);
		
		myStage.show();
		
		//creating label for setting the heading
		lheading = new Label("Employee Registration Form");
		
		//setting the font for the heading
		lheading.setFont(Font.font("Arial",FontWeight.BOLD,20));
		
		//creating the labels for all the details
		lname =   new Label("            Enter Your Name:");
		
		lgender = new Label("        Select Your Gender:");
		
		ldob =    new Label("         Enter Date of Birth:");
		
		lstate =  new Label("            Select Your State:");
		
		lquali =  new Label("Select Your Qualification:");
		
		//creating TextField for taking the name inout
		tname = new TextField();
		
		//setting minimum width for the TextField
		tname.setMinWidth(240);
		
		//setting the PromtText in the TextField
		tname.setPromptText("Enter Your Name");
		
		//creating a button
		bregister = new Button("Register");
		
		//creating a toggle group for RadioButtons
		ToggleGroup tg = new ToggleGroup();
		
		//creating the RadioButtons for male and female
		RadioButton r1 = new RadioButton("Male");
		
		RadioButton r2 = new RadioButton("Female");
		
		//adding the RadioButtons to the toggle group
		r1.setToggleGroup(tg);
		
		r2.setToggleGroup(tg);
		
		//creating the DatePicker for selecting the date
		DatePicker dp = new DatePicker();
		
		//creating the ObservableList for selecting the states
		ObservableList<String> states = FXCollections.observableArrayList("Karnataka","Maharastra","Gujarat","Kerala","Goa");
		
		//adding the list to the ComboBox
		cbState = new ComboBox<String>(states);
		
		//setting up the initial state for ComboBox
		cbState.setValue("Karnataka");
		
		//creating the CheckBoxes for selecting the courses
		CheckBox c1 = new CheckBox("UG");
		CheckBox c2 = new CheckBox("PG");
		CheckBox c3 = new CheckBox("PhD");
		
		//creating the HBoxes for each pair of information
		HBox hb0 = new HBox(15);
		HBox hb1 = new HBox(15);
		HBox hb2 = new HBox(15);
		HBox hb3 = new HBox(15);
		HBox hb4 = new HBox(15);
		HBox hb5 = new HBox(15);
		HBox hb6 = new HBox(15);
		
		//setting the gap between the rows and columns
		rootNode.setHgap(15);
		rootNode.setVgap(15);
		
		//adding the components into each group of HBoxes
		hb0.getChildren().add(lheading);
		hb1.getChildren().addAll(lname,tname);
		hb2.getChildren().addAll(lgender,r1,r2);
		hb3.getChildren().addAll(ldob,dp);
		hb4.getChildren().addAll(lstate,cbState);
		hb5.getChildren().addAll(lquali,c1,c2,c3);
		hb6.getChildren().add(bregister);
		
		rootNode.setAlignment(Pos.TOP_CENTER);
		
		//setting the HBoxes according to the requirement
		hb0.setAlignment(Pos.TOP_CENTER);
		hb6.setAlignment(Pos.BOTTOM_CENTER);
		
		//adding the padding for the first HBox 
		hb0.setPadding(new Insets(20,0,0,0));
		
		//adding the HBoxes into the Scene graph according to the requirement
		rootNode.add(hb0, 1, 0,1,1);
		rootNode.add(hb1, 1, 2,1,1);
		rootNode.add(hb2, 1, 3,1,1);
		rootNode.add(hb3, 1, 4,1,1);
		rootNode.add(hb4, 1, 5,1,1);
		rootNode.add(hb5, 1, 6,1,1);
		rootNode.add(hb6, 1, 8,1,1);
		
		//creating an Alert DialogueBox for the response
 		Alert alert = new Alert(AlertType.INFORMATION);
		
 		//setting up the title for the DialogueBox
		alert.setTitle("Registration Scuccessful");
		
		//setting the info in the DialogueBox
		alert.setHeaderText("Registration Status");
		
		alert.setContentText("Employee Registration is Successful!!");
		
		//handling the ActionEvent for the button bregister
		bregister.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				alert.show();
			}
		});
	}
}
