package adress.model;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExhibitionWallImpl {
	/**
	 * 
	 * @param stage
	 * @param width
	 * @param height
	 */
	public ExhibitionWallImpl(Stage stage, Group root, double width, double height) throws IOException{		
		stage.setTitle("Monades en suspension");
		stage.setResizable(false);
		Scene scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.setHeight(height);
		stage.setWidth(width);
		
		stage.show();
	}

}
