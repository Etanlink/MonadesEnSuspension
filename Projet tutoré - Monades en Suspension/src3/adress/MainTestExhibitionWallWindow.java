package adress;

import javafx.application.Application;
import javafx.stage.Stage;
import adress.model.ExhibitionWallImpl;

/**
 * Main test creating a new exhibition wall window
 * @author Etanlink
 *
 */
public class MainTestExhibitionWallWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage thirdStage) throws Exception {
		ExhibitionWallImpl exhibitionWallWindow = new ExhibitionWallImpl(thirdStage, 1280, 720);
	}

}
