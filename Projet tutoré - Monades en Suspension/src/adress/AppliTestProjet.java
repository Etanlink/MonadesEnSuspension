package adress;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class AppliTestProjet extends Application {
  private static final Random r = new Random();
  public static final int SCENE_SIZE = 800;

  public static void main(String[] args) throws Exception { launch(args); }
  public void start(final Stage stage) throws Exception {
    final Group circles = new Group();
    
    final Timeline animation = new Timeline(
      new KeyFrame(Duration.seconds(0.5),
  
      new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent actionEvent) {
          while (circles.getChildren().size() <= 3){
        	  int radius = 10 * r.nextInt(10);
        	  final Circle circ1 = new Circle(400,400, radius);
        	  circles.getChildren().add(circ1);
          }
          if(circles.getChildren().size() <= 10){
        	  int p = r.nextInt(100);
        	  int q = r.nextInt(100);
        	  if(q>=p)
        	  {
            	  int radius = 10 * r.nextInt(10);
            	  final Circle circ1 = new Circle(400,400, radius);
            	  circles.getChildren().add(circ1);
        	  }
          }
          for(Node circ1 : circles.getChildren()){
        	  TranslateTransition trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/1000), circ1 );
              
              int x = r.nextInt(120);
              int y = 120-x;
              boolean p = r.nextBoolean();
              if(p==true) x = -x;
              p = r.nextBoolean();
              if(p==true) y = -y;
              
              trans.setByX(x);
              trans.setByY(y);
              trans.setInterpolator(Interpolator.LINEAR);
              trans.play();
          }
          
          
        }
      })
    );
    animation.setCycleCount(Animation.INDEFINITE);
    animation.play();

    // display the scene.
    stage.setScene(new Scene(circles, SCENE_SIZE, SCENE_SIZE, Color.CORNSILK));
    stage.show();
  }
}