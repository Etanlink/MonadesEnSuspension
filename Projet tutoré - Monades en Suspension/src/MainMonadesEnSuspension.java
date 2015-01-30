
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMonadesEnSuspension extends Application {

	private Stage primaryStage;
	private BorderPane UIView;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MonadesEnSuspension");
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("prout prout");
	}
}
