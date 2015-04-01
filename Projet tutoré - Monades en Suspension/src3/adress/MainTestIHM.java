package adress;

import java.io.IOException;

import ch.makery.address.MainApp;
import adress.model.WindowImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Application for Frédéric Galliano
 * @author Hugo
 *
 */
public class MainTestIHM extends Application {

    public Stage primaryStage;

    
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		/* Instantiation of a new window */
		this.primaryStage = primaryStage ;
		WindowImpl window = new WindowImpl();
		window.primaryStageInitialisation(primaryStage);
		window.setMainApp(this);

	}

}
