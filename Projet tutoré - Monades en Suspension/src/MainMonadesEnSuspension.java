
import java.io.IOException;
import java.security.acl.Group;

import javax.print.DocFlavor.URL;

import model.AnimationMonades;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMonadesEnSuspension extends Application {

	private Stage primaryStage;
	private BorderPane UIView;
	
	@Override 
    public void start(Stage primaryStage) {
		AnimationMonades animMonades = AnimationMonades.getPhysicalEngine();
		animMonades.setMainStage(primaryStage);
		animMonades.createAnimation2();
		/*
        final Circle circ1 = new Circle(100, 100, 100);         
        circ1.setFill(Color.RED);
        final Pane root = new Pane(); 
        root.getChildren().setAll(circ1);         
        final Scene scene = new Scene(root, 800, 400);         
        primaryStage.setTitle("Test d'animation de translation"); 
        primaryStage.setScene(scene); 
        primaryStage.show();
        final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2), circ1); 
        translateAnimation.setCycleCount(TranslateTransition.INDEFINITE); 
        translateAnimation.setAutoReverse(true); 
        translateAnimation.setByX(50); 
        translateAnimation.setByY(75); 
        translateAnimation.setInterpolator(Interpolator.LINEAR); 
        translateAnimation.play();
        */
	    } 

	public static void main(String[] args) {
		launch(args); 
	}
}
