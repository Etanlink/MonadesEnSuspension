package adress.model;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
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
	
	private TranslateTransition trans;
	private int x;
	private int y;
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	private Random r = new Random();
	private int compteur;
	
	/**
	 * Builder
	 */
	public AnimatedShapeThread() {
		super();
		/* Instantiation of the ExtentedCircle */
		int radius = 10 * r.nextInt(10);
		this.circ1 = new ExtentedCircle(400,400, radius);
		circ1.setFill(/*new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1 )*/Color.GREEN );

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

		shuffleXY(10);
		this.compteur = this.r.nextInt(10)+5;
		this.animation = new Timeline(
				new KeyFrame(Duration.millis(100),

						new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						int sceneSize = WindowImpl.SCENE_SIZE;
						
						if(compteur==0) {
							CubicCurveTo curve = new CubicCurveTo(380, 120, 10, 240, 380, 240);
							
							Path path = new Path();
							path.getElements().add(new MoveTo(x,y));
							//path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
							shuffleXY(10);
							path.getElements().add(new CubicCurveTo(x+180, y-180, x+10, y+240, x, y));
							PathTransition pathTransition = new PathTransition();
							pathTransition.setDuration(Duration.millis(3000));
							pathTransition.setPath(path);
							pathTransition.setNode(circ1);
							pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
							pathTransition.setInterpolator(Interpolator.LINEAR);
							pathTransition.play();
							compteur = r.nextInt(10)+5;
						}

						if(circ1 instanceof ExtentedCircle){
							applyTranslation(100);
						}
						if(
								( ((ExtentedCircle) circ1).getX() >= sceneSize + ((ExtentedCircle) circ1).getRadius()) ||
								( ((ExtentedCircle) circ1).getX( )<= 0 - ((ExtentedCircle) circ1).getRadius()) ||
								( ((ExtentedCircle) circ1).getY() >= sceneSize + ((ExtentedCircle) circ1).getRadius()) ||
								( ((ExtentedCircle) circ1).getY() <= 0 - ((ExtentedCircle) circ1).getRadius()) 
								)
						{
							isOutOfFrame = true;
							circ1.setFill(Color.BLACK);
						}
						else{
							isOutOfFrame = false;
							circ1.setFill(Color.GREEN);
						}
						compteur--;
					}			

				}) );
		animation.setCycleCount(Animation.INDEFINITE);
		animation.play();
	}

	public Animation getAnimation() {
		return animation;
	}
	/**
	 * apply a Transition to the shape
	 */
	private void applyTranslation(double ms) {
		
		TranslateTransition trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/ms), this.circ1 );
		
		trans.setByX(this.x);
		trans.setByY(this.y);

		/* Coordinates updated */
		((ExtentedCircle) this.circ1).setX(((ExtentedCircle) this.circ1).getX()+x);
		((ExtentedCircle) this.circ1).setY(((ExtentedCircle) this.circ1).getY()+y);

		trans.setInterpolator(Interpolator.LINEAR);
		trans.play();

		/*
		
		*/
	
	}
	
	/**
	 * generates randomly an X for the Translation
	 */
	public void shuffleXY(int range) {

		this.x = r.nextInt(range);
		boolean p = r.nextBoolean();
		if(p==true) x = -x;

		this.y = range - this.x;
		p = r.nextBoolean();
		if(p==true) y = -y;
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
		}
				);

		circ12.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ12.setCursor(Cursor.HAND);
				circ12.setX(mouseEvent.getSceneX());
				circ12.setY(mouseEvent.getSceneY());
			}
		}
				);

		circ12.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ12.setLayoutX(mouseEvent.getSceneX() + dragDelta.getX());
				circ12.setLayoutY(mouseEvent.getSceneY() + dragDelta.getY());

				circ12.setX(mouseEvent.getSceneX());
				circ12.setY(mouseEvent.getSceneY());
			}
		}
				);

	}

}
