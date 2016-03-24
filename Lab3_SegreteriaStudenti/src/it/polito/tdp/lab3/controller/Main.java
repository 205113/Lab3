package it.polito.tdp.lab3.controller;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("SegreteriaStudenti.fxml"));
			
			FXMLLoader loader= new FXMLLoader(getClass().getResource("SegreteriaStudenti.fxml"));
			BorderPane root=(BorderPane)loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			SegreteriaStudentiController controller=loader.getController();
			SegreteriaStudentiModel model= new SegreteriaStudentiModel();
			controller.setModel(model);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
