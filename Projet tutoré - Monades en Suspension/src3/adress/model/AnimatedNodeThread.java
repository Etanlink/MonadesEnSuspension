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
import javafx.scene.Node;
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

public class AnimatedNodeThread implements Runnable {
	
	private final Node circ1;
	private Animation animation;
	
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
	public AnimatedNodeThread() {
		super();
		/* Instantiation of the ExtentedCircle */
		int radius = 10 * r.nextInt(10);
		this.circ1 = new ExtentedCircle(400,400, radius);
		((Shape)circ1).setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1 ) );

		/* DragListeners are added on the circle */
		setDragListeners((ExtentedCircle) this.circ1);
	};

	public Node getNode() {
		return this.circ1;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public boolean isOutOfFrame() {
		return (
				( ((ExtentedCircle) this.circ1).getX() > WindowImpl.W_SCENE_SIZE + ((ExtentedCircle) this.circ1).getRadius()*3) ||
				( ((ExtentedCircle) this.circ1).getX() < 0 - ((ExtentedCircle) this.circ1).getRadius()*3) ||
				( ((ExtentedCircle) this.circ1).getY() > WindowImpl.H_SCENE_SIZE + ((ExtentedCircle) this.circ1).getRadius()*3) ||
				( ((ExtentedCircle) this.circ1).getY() < 0 - ((ExtentedCircle) this.circ1).getRadius()*3)
				);
	}

	@Override
	public void run() {

		shuffleXY(10);
		this.compteur = this.r.nextInt(10)+5;
		this.animation = buildTimeLine();
		this.animation.setCycleCount(Animation.INDEFINITE);
		this.animation.play();
	}
	
	/**
	 * @return the TimeLine of the thread
	 */
	private Timeline buildTimeLine() {
		return new Timeline(
				new KeyFrame(Duration.millis(100),

						new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						
						handleTimeLine();
					}			

				}) );
	}

	/**
	 * apply a Transition to the shape
	 */
	private void applyTranslation(double ms) {
		
		this.trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/ms), this.circ1 );
		
		this.trans.setByX(this.x);
		this.trans.setByY(this.y);

		this.trans.setInterpolator(Interpolator.LINEAR);
		this.trans.play();

		/* Coordinates updated */
		((ExtentedCircle) this.circ1).setX(((ExtentedCircle) this.circ1).getX()+x);
		((ExtentedCircle) this.circ1).setY(((ExtentedCircle) this.circ1).getY()+y);
	
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
	
	/**
	 * Adds dragListeners on ONE ImageView
	 * @param circ1 : the circle listened
	 */
	protected void setDragListeners(ImageView circ1) {
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
				circ1.setX(mouseEvent.getSceneX());
				circ1.setY(mouseEvent.getSceneY());
			}
		});

		circ1.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				circ1.setLayoutX(mouseEvent.getSceneX() + dragDelta.getX());
				circ1.setLayoutY(mouseEvent.getSceneY() + dragDelta.getY());

				circ1.setX(mouseEvent.getSceneX());
				circ1.setY(mouseEvent.getSceneY());
			}
		});

	}
	
	/**
	 * content of the TimeLine
	 */
	private void handleTimeLine() {
		if(this.compteur==0) {
			/*CubicCurveTo curve = new CubicCurveTo(380, 120, 10, 240, 380, 240);
			
			Path path = new Path();
			path.getElements().add(new MoveTo(x,y));
			//path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
			shuffleXY(10);
			path.getElements().add(new CubicCurveTo(x+180, y-180, x+10, y+240, x, y));
			PathTransition pathTransition = new PathTransition();
			pathTransition.setDuration(Duration.millis(100));
			pathTransition.setPath(path);
			pathTransition.setNode(circ1);
			pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pathTransition.setInterpolator(Interpolator.LINEAR);
			pathTransition.play();*/
			shuffleXY(10);
			this.compteur = this.r.nextInt(10)+5;
		}

		if(this.circ1 instanceof ExtentedCircle){
			applyTranslation(100);
		}
		this.compteur--;
	}

}
