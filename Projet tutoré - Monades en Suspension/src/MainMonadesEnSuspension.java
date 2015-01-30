
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
		
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.getLocation(MainMonadesEnSuspension.class.getResource("view/UIView.fxml"));
            UIView = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(UIView);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
