package application;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class Assignment2_1 extends Application {

	String userId = "omkar";
	String pass = "smasher";
	TextField name,password;
	Label response,response2;
	Button validate,goback;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage myStage) throws MyException {
		//setting the title for the Stage
		myStage.setTitle("Validating UserId and PassWord");
		
		//creating a Scene graph
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL,10,20);
		
		//creating another Scene graph for another Scene
		FlowPane rootNode2 = new FlowPane(Orientation.VERTICAL,10,20);
		
		//setting the alignment for center
		rootNode.setAlignment(Pos.CENTER);
		
		rootNode2.setAlignment(Pos.CENTER);
		
		//creating a Scene for home page
		Scene myScene = new Scene(rootNode,450,200);
		
		//creating another Scene for second Welcome page
		Scene myScene2 = new Scene(rootNode2,450,200);
		
		//first setting the home page scene for stage
		myStage.setScene(myScene);
		
		//creating a TextField for taking name as input
		name = new TextField();
		
		//setting the prompt text for the name TextField
		name.setPromptText("Enter your name");
		
		//creating a TextField for taking password as input
		password = new TextField();
		
		//setting the prompt text for the password TextField
		password.setPromptText("Enter your password");
		
		//creating a button for validating the inout
		validate = new Button("Validate");
		
		//creating a button for going back to the Home page
		goback = new Button("Go back");
		
		//creating labels for giving the response
		response = new Label();
		
		response2 = new Label();

		Separator separator = new Separator();
		
		separator.setPrefWidth(100);
		
		Separator separator2 = new Separator();
		separator2.setPrefWidth(180);
		
		//handling the event for validate button
		validate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {	//if both entered name and password are correct then go to the second Scene
					if((name.getText().equals(userId)) && (password.getText().equals(pass))) {
						myStage.setScene(myScene2);		//setting the second Scene

						response2.setText("WelCome here");  //giving appropriate message
					}
					else	//else throwing a user defined Exception
						throw new MyException();
				}
				catch(MyException e) {
					//displaying the toString method of the MyException
					response.setText(e.toString());
				}
			}
		});
		
		//handling the event for goback button
		goback.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				//going back to the home page
				myStage.setScene(myScene);
			}
		});
		
		//adding every element to the Scene
		rootNode.getChildren().addAll(name,password,separator,validate,response);
		
		//adding the Welcome message and goback button to the second Scene
		rootNode2.getChildren().addAll(response2,separator2,goback);
		
		myStage.show();
	}
}

class MyException extends Exception {
	public String toString() {
		return "Exception : Invalid userId or passWord";
	}
}
