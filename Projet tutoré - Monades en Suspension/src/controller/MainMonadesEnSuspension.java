/**
 * @aim Launch the application
 * 
 * @date 30/01/2015
 * @author Etanlink
 * @version 0.0
 *
 **/
package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMonadesEnSuspension extends Application {
	
	/* Creation of the MainStage */
	private Stage primaryStage;
	private BorderPane UIView;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Monades En Suspension");
		
		initUIView();
	}
	
	/**
     * Initializes the UIView.
     */
    public void initUIView() {
        try {
            // Load UIView from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMonadesEnSuspension.class.getResource("view/RootLayout.fxml"));
            UIView = (BorderPane) loader.load();

            // Show the scene containing the UIView.
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
