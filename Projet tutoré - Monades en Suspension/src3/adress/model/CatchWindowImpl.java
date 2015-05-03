package adress.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
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
		
		//Image imgTest = new Image("res/BroFist.jpg");
		Image animationCapture = new Image("res/CaptureAnimation.png");
		ImageView captureAnimationView = new ImageView(animationCapture);
		
		HBox hb = new HBox();
		Button saveButton = new Button("Enregistrer la capture");
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	FileChooser chooseSaveDestinationDialog = new FileChooser();
            	chooseSaveDestinationDialog.setTitle("Choisissez un emplacement de sauvegarde");
            	chooseSaveDestinationDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier PNG", ".png"));
            	//chooseSaveDestinationDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier JPG", ".jpg"));            	
            	File emplacementToSave = chooseSaveDestinationDialog.showSaveDialog(secondaryStage);
            	if(emplacementToSave != null){
            		BufferedImage imageToSave = SwingFXUtils.fromFXImage(animationCapture, null); 
            		try {
						ImageIO.write(imageToSave, "png", emplacementToSave.getAbsoluteFile());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
        });
		
		hb.setSpacing(20);
		hb.getChildren().add(saveButton);
		this.rootCatchWindow.getChildren().add(hb);
		Scene catchWindowScene = new Scene(this.rootCatchWindow, W_SCENE_SIZE, H_SCENE_SIZE);
		secondaryStage.setScene(catchWindowScene);
		this.secondaryStage.show();
    }

}
