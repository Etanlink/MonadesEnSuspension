package adress;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import adress.model.ExhibitionWallWindowImpl;

public class MainExhibitionWallWindow extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage thirdStage) throws Exception {
		Group testRoot = new Group();
		ExhibitionWallWindowImpl exhibitionWallWindow = new ExhibitionWallWindowImpl(thirdStage, 1280, 720);
	}

}
