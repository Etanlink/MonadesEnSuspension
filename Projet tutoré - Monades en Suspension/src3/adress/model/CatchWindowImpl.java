package adress.model;

import java.awt.Dialog;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
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
            	DirectoryChooser directoryToChoose = new DirectoryChooser();
            	directoryToChoose.setTitle("Choisissez un répertoire où sauvegarder la capture");
            	File directoryChosen = directoryToChoose.showDialog(secondaryStage); 
            	if(directoryChosen != null){
            		System.out.println("Le répertoire choisit est : "+directoryChosen.toString());
            		/* Save the capture in a png file in a res folder */
            	    File captureAnimationFile = new File("src3/res/CaptureAnimation.png");
            	    try {
            	    	ImageIO.write(captureAnimationFile, "png", output);
            	    }
            	    catch (IOException e) {
            			// TODO Auto-generated catch block
            			e.printStackTrace();
            		}
            	}
            }
        });
		Button printButton = new Button("Imprimer la capture");
		hb.setSpacing(20);
		hb.getChildren().addAll(saveButton, printButton);
		
		this.rootCatchWindow.getChildren().addAll(captureAnimationView, hb);
		
		Scene catchWindowScene = new Scene(this.rootCatchWindow, W_SCENE_SIZE, H_SCENE_SIZE);
		secondaryStage.setScene(catchWindowScene);
		
		this.secondaryStage.show();
    }

}
