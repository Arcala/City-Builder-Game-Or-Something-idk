package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application
{
	public static void main(String[] args)
	{
		System.out.println("Hello");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Test GUI");
		BorderPane root = new BorderPane();
		root.setCenter(new Label("Test GUI even more!"));
		Scene scene = new Scene(root, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
