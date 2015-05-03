package adress;

import javafx.application.Application;
import javafx.scene.Group;
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
		Group testRoot = new Group();
		ExhibitionWallImpl exhibitionWallWindow = new ExhibitionWallImpl(thirdStage, testRoot, 1280, 720);
	}

}
