package MyApplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	

	public Controller controller;
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = loader.load();

		controller = loader.getController();
		controller.Playground();

		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene = new Scene(rootGridPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("CONNECT FOUR GAME");
		primaryStage.setResizable(false);
		primaryStage.show();
	}


	private MenuBar createMenu() {

		Menu file = new Menu("File");
		MenuItem new_game = new MenuItem("New Game");
		new_game.setOnAction(event -> controller.resetGame());

		MenuItem reset_game = new MenuItem("Reset Game");
		reset_game.setOnAction(event -> controller.resetGame());


		SeparatorMenuItem separator = new SeparatorMenuItem();


		MenuItem quit = new MenuItem("Quit");
		quit.setOnAction(event -> quitGame());

		file.getItems().addAll(new_game, reset_game, separator, quit);


		Menu help = new Menu("Help");

		MenuItem about_game = new MenuItem("About Connect4");
		about_game.setOnAction(event -> aboutApp());


		SeparatorMenuItem separatorMenu = new SeparatorMenuItem();


		MenuItem about_the_developer = new MenuItem("About the Developer");
		about_the_developer.setOnAction(event -> aboutMe());

		help.getItems().addAll(about_game, separatorMenu, about_the_developer);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(file, help);

		return menuBar;
	}


	private void quitGame() {
		Platform.exit();
		System.exit(0);
	}


	private void aboutApp() {
		Alert ad = new Alert(Alert.AlertType.INFORMATION);
		ad.setTitle("ABOUT GAME");
		ad.setHeaderText("How To Play?");
		ad.setContentText("Connect Four is a two-player connection game in which the players "+"" +
				"first choose a color and then take turns dropping colored discs from the top into a seven-column," +
				" six-row vertically suspended grid. The pieces fall straight down, occupying the next available space " +
				"within the column. The objective of the game is to be the first to form a horizontal, vertical, or " +
				"diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.");
		ad.show();
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ABOUT THE DEVELOPER");
		alert.setHeaderText("KHYAATI SHRIKANT");
		alert.setContentText("I am pursuing Computer Engineering." + "This amazing game is developed by me.");
		alert.show();
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		launch(args);
	}
	
}