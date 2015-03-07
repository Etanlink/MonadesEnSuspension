package adress;

import adress.model.WindowImpl;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Application for Frédéric Galliano
 * @author Hugo
 *
 */
public class MainTestIHM extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		/* Instantiation of a new window */
		WindowImpl window = new WindowImpl(primaryStage);
		
		
	}

}
