package adress.model;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class creating a new window of the animation catch's
 * @author Etanlink
 *
 */
public class CatchWindowImpl {
	
	private Stage secondaryStage;
	
	private Group rootCatchWindow = new Group();
	
	static final int W_SCENE_SIZE = 800;
	static final int H_SCENE_SIZE = 600;
	
	public CatchWindowImpl(Stage secondaryStage) throws IOException {
		
		secondaryStage.setTitle("Capture de l'animation");
		secondaryStage.setResizable(false);
		this.secondaryStage = secondaryStage;
		
		StackPane sp = new StackPane();
		//Image imgTest = new Image("res/BroFist.jpg");
		Image animationCapture = new Image("res/CaptureAnimation.png");
		ImageView captureAnimationView = new ImageView(animationCapture);
		
		this.rootCatchWindow.getChildren().add(sp);
		this.rootCatchWindow.getChildren().add(captureAnimationView);
		
		Scene catchWindowScene = new Scene(this.rootCatchWindow, W_SCENE_SIZE, H_SCENE_SIZE);
		secondaryStage.setScene(catchWindowScene);
		
		this.secondaryStage.show();
    }
	
	/**
	 * Build the imageView which will contain the captureAnimation png file
	 * @author Etanlink
	 * @return an ImageView
	 */
	public ImageView captureAnimationView(){
		
		ImageView captureImageView = new ImageView();
		
		return captureImageView;
	}

}
