package adress.model;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExhibitionWallImpl {
	
	public Group testRoot = new Group();
	/**
	 * 
	 * @param stage
	 * @param width
	 * @param height
	 */
	public ExhibitionWallImpl(Stage stage, double width, double height) throws IOException{		
		stage.setTitle("Monades en suspension");
		stage.setResizable(false);
		Scene scene = new Scene(testRoot, width, height);
		stage.setScene(scene);
		stage.setHeight(height);
		stage.setWidth(width);
		
		stage.show();
	}

}
