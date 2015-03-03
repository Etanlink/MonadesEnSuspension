package adress;

import adress.model.WindowImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainTestIHM extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		WindowImpl window = new WindowImpl(primaryStage);


	}

}
