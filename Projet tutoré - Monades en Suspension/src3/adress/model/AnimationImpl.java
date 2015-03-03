package adress.model;

import java.io.IOException;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class AnimationImpl {

	private Group root;

	private static final Random r = new Random();

	public AnimationImpl(Group root) {
		super();
		this.root = root;
	}

	public void addCircles() throws IOException {
		final Group circles = new Group();
		this.root.getChildren().add(circles);

		final Timeline animation = new Timeline(
				new KeyFrame(Duration.seconds(0.5),

						new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent actionEvent) {
						while (circles.getChildren().size() <= 3){
							int radius = 10 * r.nextInt(10);
							final Circle circ1 = new Circle(400,400, radius);
							setDragListeners(circ1);
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
							if(circ1 instanceof Circle){
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
					
					}
				})
				);
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
	}

	protected void setDragListeners(Circle circ1) {
		final Delta dragDelta = new Delta();

		circ1.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				// record a delta distance for the drag and drop operation.
				dragDelta.setX((double)(circ1.getLayoutX() - mouseEvent.getSceneX()));
				dragDelta.setY((double)(circ1.getLayoutY() - mouseEvent.getSceneY()));
				circ1.setCursor(Cursor.NONE);
			}
		});
		circ1.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ1.setCursor(Cursor.HAND);
			}
		});
		circ1.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ1.setLayoutX(mouseEvent.getSceneX() + dragDelta.getX());
				circ1.setLayoutY(mouseEvent.getSceneY() + dragDelta.getY());
			}
		});

	}
}
