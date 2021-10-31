package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		//Right side (AddTask)
		Label labelAddTaskField = new Label("Task Name: ");
		labelAddTaskField.setFont(new Font("Arial", 15));
		labelAddTaskField.setStyle("-fx-font-weight: bold; -fx-text-fill: white");
		TextField userAddTaskField = new TextField();
		userAddTaskField.setMaxWidth(200.00);
		Button bt = new Button("Add Task");
		
		//Left side (Display List)
		toDo toDoList = new toDo();
		toDoList.addTask(new Task("Math HW"));
		toDoList.addTask(new Task("Chemistry HW"));
		Text[] displayTaskList = new Text[toDoList.getNumOfTasks()];
		for(int i=0; i<toDoList.getNumOfTasks(); i++) {
			displayTaskList[i] = new Text(toDoList.getTask(i).toString());
			displayTaskList[i].setFill(Color.WHITE);
			displayTaskList[i].setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		}
		
		//Bottom (Sort buttons)
		Label buttonsLabel = new Label("Sort by:");
		buttonsLabel.setStyle("-fx-font-size: 16px");
		Button az = new Button("A-Z");
		Button dd = new Button("Due Date");
		Button complete = new Button("Completion");
		Button category = new Button("Category");
		Button priority = new Button("Priority");
		
		//Constructing right side
		VBox vbRight = new VBox();
		vbRight.setId("rightSide");
		vbRight.setPrefWidth(300.00);
		vbRight.setPadding(new Insets(50.00, 20.00, 0, 35.00));
		vbRight.getChildren().addAll(labelAddTaskField, userAddTaskField, bt);
		
		//Constructing left side
		VBox vbCenter = new VBox();
		vbCenter.setId("center");
		vbCenter.setPadding(new Insets(50.00, 0, 0, 20.00));
		for(int i=0; i<displayTaskList.length; i++) {
			vbCenter.getChildren().add(displayTaskList[i]);
		}
		
		//Constructing bottom
		HBox hb = new HBox(80);
		hb.setId("sorting");
		hb.setPrefHeight(55.00);
		hb.setPadding(new Insets(15.00, 0, 10.00, 230.00));
		hb.getChildren().addAll(buttonsLabel, az, dd, complete, category, priority);
		
		//Constructing full BorderPane/root/scene
		BorderPane root = new BorderPane();
		root.setCenter(vbCenter);
		root.setRight(vbRight);
		root.setBottom(hb);
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("To-Do List");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
