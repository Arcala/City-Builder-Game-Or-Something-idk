package controller;

import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Game;
import view.CityView;

public class Launcher extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}

	private Game theGame;
	private Observer currentView;
	private Observer cityView;

	private BorderPane window;
	public static final int width = 800;
	public static final int height = 800;

	@Override
	public void start(Stage stage) throws Exception
	{

		stage.setTitle("City Builder or Something Idk");
		window = new BorderPane();
		Scene scene = new Scene(window, width, height);

		theGame = new Game();

		cityView = new CityView(theGame);

		theGame.addObserver(cityView);

		setViewTo(cityView);
		stage.setScene(scene);
		stage.show();
	}

	private void setViewTo(Observer newView)
	{
		window.setCenter(null);
		currentView = newView;
		window.setCenter((Node) currentView);
	}

}
