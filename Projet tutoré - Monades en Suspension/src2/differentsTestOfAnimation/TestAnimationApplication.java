package differentsTestOfAnimation;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import static java.lang.Math.random;
 
public class TestAnimationApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		/* On crée un groupe auquel on va ajouter nos différents objets Cercles*/
		Group root = new Group();
		
		/* On crée une scène de taille 800*600 pixels et de fond noir */
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setTitle("Début d'animation avec trois tailles différentes de cercles - Détection collision in coming !");
        primaryStage.setScene(scene);
        
        /* On crée trois groupes de cercles de tailles différentes */
        /* Grand cercles de taille 50 */
        Group bigCircles = new Group();
        for (int i = 0; i < 5; i++) {
            Circle bigCircle = new Circle(50, Color.web("white", 0.05));
            bigCircle.setStrokeType(StrokeType.OUTSIDE);
            bigCircle.setStroke(Color.web("white", 0.16));
            bigCircle.setStrokeWidth(4);
            bigCircles.getChildren().add(bigCircle);
        }
        /* Cercles moyens de taille 25 */
        Group normalCircles = new Group();
        for (int i = 0; i < 5; i++) {
            Circle normalCircle = new Circle(25, Color.web("white", 0.05));
            normalCircle.setStrokeType(StrokeType.OUTSIDE);
            normalCircle.setStroke(Color.web("white", 0.16));
            normalCircle.setStrokeWidth(4);
            normalCircles.getChildren().add(normalCircle);
        }
        /* Petits cercles de taille 10 */
        Group tinyCircles = new Group();
        for (int i = 0; i < 5; i++) {
        	/* On crée un cercle */
            Circle tinyCircle = new Circle(10, Color.web("white", 0.05));
            /* On ajoute une bordure externe au cercle */
            tinyCircle.setStrokeType(StrokeType.OUTSIDE);
            /* On la définit comme étant blanche avec une opacité de 0.16*/
            tinyCircle.setStroke(Color.web("white", 0.16));
            tinyCircle.setStrokeWidth(4);
            tinyCircles.getChildren().add(tinyCircle);
        }
        
        /* On ajoute à l'aide d'une timeline les différents comportements de nos cercles */
        /* Comportements de nos grands cercles */
        Timeline bigCirclesTimeline = new Timeline();
        for (Node bigCircle : bigCircles.getChildren()) {
        	/* L'animation se répète indéfiniment */
            bigCirclesTimeline.setCycleCount(Animation.INDEFINITE);
        	bigCirclesTimeline.getKeyFrames().addAll(
        			/* On applique au groupe bigCircles, une translation qui dure 40 secondes */
        			new KeyFrame(Duration.ZERO,
        					new KeyValue(bigCircle.translateXProperty(), random() * 800),
        					new KeyValue(bigCircle.translateYProperty(), random() * 600)),
        			new KeyFrame(new Duration(40000),
        					new KeyValue(bigCircle.translateXProperty(), random() * 800),
        					new KeyValue(bigCircle.translateYProperty(), random() * 600)));
        }
        /* Comportements des cercles moyens */
        Timeline normalCirclesTimeline = new Timeline();
        for (Node normalCircle : normalCircles.getChildren()) {
        	/* L'animation se répète indéfiniment */
            normalCirclesTimeline.setCycleCount(Animation.INDEFINITE);
        	normalCirclesTimeline.getKeyFrames().addAll(
        			/* On applique au groupe normalCircles, une translation qui dure 40 secondes */
        			new KeyFrame(Duration.ZERO, // set start position at 0
        					new KeyValue(normalCircle.translateXProperty(), random() * 800),
        					new KeyValue(normalCircle.translateYProperty(), random() * 600)),
        			new KeyFrame(new Duration(40000), // set end position at 40s
        					new KeyValue(normalCircle.translateXProperty(), random() * 800),
        					new KeyValue(normalCircle.translateYProperty(), random() * 600)));
        }
        /* Comportements des petits cercles */
        Timeline tinyCirclesTimeline = new Timeline();
        for (Node tinyCircle : tinyCircles.getChildren()) {
        	/* L'animation se répète indéfiniment */
            tinyCirclesTimeline.setCycleCount(Animation.INDEFINITE);
        	tinyCirclesTimeline.getKeyFrames().addAll(
        			/* On applique au groupe tinyCircles, une translation qui dure 40 secondes */
        			new KeyFrame(Duration.ZERO, // set start position at 0
        					new KeyValue(tinyCircle.translateXProperty(), random() * 800),
        					new KeyValue(tinyCircle.translateYProperty(), random() * 600)),
        			new KeyFrame(new Duration(40000), // set end position at 40s
        					new KeyValue(tinyCircle.translateXProperty(), random() * 800),
        					new KeyValue(tinyCircle.translateYProperty(), random() * 600)));
        }
        
        /* On ajoute les trois groupes de cercles au groupe principal root */
        root.getChildren().add(bigCircles);
        root.getChildren().add(normalCircles);
        root.getChildren().add(tinyCircles);
        /* On lance les trois animations */
        bigCirclesTimeline.play();
        normalCirclesTimeline.play();
        tinyCirclesTimeline.play();
        
        primaryStage.show();
    }
        
    public static void main(String[] args) {
        Application.launch(args);
    }
    
} 