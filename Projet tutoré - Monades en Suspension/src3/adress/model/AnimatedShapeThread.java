package adress.model;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * Thread responsible of the instantiation of one shape and defining its animation
 * @author Hugo
 *
 */

public class AnimatedShapeThread implements Runnable {
	
	private final Shape circ1;
	
	private Animation animation;
	
	private boolean isOutOfFrame;
	
	private Random r = new Random();
	
	public AnimatedShapeThread() {
		super();
		/* Instantiation of the ExtentedCircle */
		int radius = 10 * r.nextInt(10);
		this.circ1 = new ExtentedCircle(400,400, radius);
		circ1.setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1 ) );

		/* DragListeners are added on the circle */
		setDragListeners((ExtentedCircle) circ1);
		this.isOutOfFrame = false;
		
	};
	
	public Shape getShape() {
		return this.circ1;
	}
	
	public boolean isOutOfFrame() {
		return isOutOfFrame;
	}

	@Override
	public void run() {

		this.animation = new Timeline(
				new KeyFrame(Duration.millis(3000),

						new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						int sceneSize = WindowImpl.SCENE_SIZE;

						if(circ1 instanceof ExtentedCircle){
							TranslateTransition trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/3000), circ1 );

							/* Generation of the coordinates of the move */
							int x = r.nextInt(120);
							int y = 120-x;
							boolean p = r.nextBoolean();
							if(p==true) x = -x;
							p = r.nextBoolean();
							if(p==true) y = -y;

							trans.setByX(x);
							trans.setByY(y);
							/* Coordinates updated */
							((ExtentedCircle)circ1).setX(((ExtentedCircle) circ1).getX()+x);
							((ExtentedCircle)circ1).setY(((ExtentedCircle) circ1).getY()+y);

							trans.setInterpolator(Interpolator.LINEAR);
							trans.play();
						}
						if(
								( ((ExtentedCircle) circ1).getX() >= sceneSize + ((ExtentedCircle) circ1).getRadius()) ||
								( ((ExtentedCircle) circ1).getX( )<= 0 - ((ExtentedCircle) circ1).getRadius()) ||
								( ((ExtentedCircle) circ1).getY() >= sceneSize + ((ExtentedCircle) circ1).getRadius()) ||
								( ((ExtentedCircle) circ1).getY() <= 0 - ((ExtentedCircle) circ1).getRadius()) 
								)
						{
							isOutOfFrame = true;
						}
					}

				}) );
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
	}

	/**
	 * Adds dragListeners on ONE circle
	 * @param circ12 : the circle listened
	 */
	protected void setDragListeners(ExtentedCircle circ12) {
		final Delta dragDelta = new Delta();

		circ12.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				// record a delta distance for the drag and drop operation.
				dragDelta.setX((double)(circ12.getLayoutX() - mouseEvent.getSceneX()));
				dragDelta.setY((double)(circ12.getLayoutY() - mouseEvent.getSceneY()));
				circ12.setCursor(Cursor.NONE);
			}
		});

		circ12.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ12.setCursor(Cursor.HAND);
				circ12.setX(mouseEvent.getSceneX());
				circ12.setY(mouseEvent.getSceneY());
			}
		});

		circ12.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ12.setLayoutX(mouseEvent.getSceneX() + dragDelta.getX());
				circ12.setLayoutY(mouseEvent.getSceneY() + dragDelta.getY());

				circ12.setX(mouseEvent.getSceneX());
				circ12.setY(mouseEvent.getSceneY());
			}
		});

	}

}
