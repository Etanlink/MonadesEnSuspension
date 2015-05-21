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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * Thread responsible of the instantiation of one Image and defining its animation
 * @author Hugo
 *
 */

/*
 * caca */
public class AnimatedImageThread implements Runnable {

	private final ImageView monade;
	public ImageView getMonade() {
		return monade;
	}

	private Animation animation;

	private TranslateTransition trans;
	private double moveX;
	private double moveY;

	private double speedCoeff;

	public double getMoveX() { return moveX; }
	public double getMoveY() { return moveY; }

	private Random r = new Random();
	//private int compteur;
	
	/* exhibition needs */
	private ExtentedCircle circle;
	

	/**
	 * Builder
	 */
	public AnimatedImageThread(int category) {
		super();
		/* Instantiation of the ExtentedCircle */
		this.monade = new ImageView( new Image("res/monade.png") );
		this.monade.setPreserveRatio(true);
		switch(category){
		case 1 :
			this.monade.setFitWidth(200);
		case 2 :
			this.monade.setFitWidth(100);
		case 3 :
			this.monade.setFitWidth(50);
		case 4 :
			this.monade.setFitWidth(20);
		default:		
		}
			
		//this.monade.setFitWidth(this.r.nextInt(50)+50);
		// ((Shape)circ1).setFill(new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), 1 ) );
		this.speedCoeff = 1;
		shuffleXY(360);
		spawn();
		//this.monade.setX(400);
		//this.monade.setY(300);

		/* DragListeners are added on the circle */
		//setDragListeners((ImageView) this.monade);
	};


	public Node getNode() {
		return this.monade;
	}

	public Animation getAnimation() {
		return animation;
	}

	public boolean isOutOfFrame() {
		return (
				( ((ImageView) this.monade).getX() > WindowImpl2.W_SCENE_SIZE + ((ImageView) this.monade).getFitWidth()) ||
				( ((ImageView) this.monade).getX() < WindowImpl2.W_VBOX_SIZE - ((ImageView) this.monade).getFitWidth()) ||
				( ((ImageView) this.monade).getY() > WindowImpl2.H_SCENE_SIZE + ((ImageView) this.monade).getFitHeight()) ||
				( ((ImageView) this.monade).getY() < 0 - ((ImageView) this.monade).getFitHeight())
				);
	}

	/**
	 * 
	 */
	@Override
	public void run() {

		//shuffleXY(1);
		//this.compteur = this.r.nextInt(10)+5;
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
	 * the monade spawns randomly around the borders of the scene
	 */
	private void spawn() {

		/* boolean choosing between the two areas available */
		boolean p = this.r.nextBoolean();

		/* Monade center's measures*/
		double centerX = this.monade.getFitWidth()/2;
		double centerY = this.monade.getFitHeight()/2;


		if(this.moveX > 0) {
			if(this.moveY > 0) { // x > 0 , y > 0
				if(p) { // left + bottom left corner
					this.monade.setX(WindowImpl2.W_VBOX_SIZE - centerX);
					this.monade.setY(this.r.nextInt( (int) (WindowImpl.H_SCENE_SIZE) ) + centerY );
				}
				else { // bottom + bottom left corner
					this.monade.setX(this.r.nextInt( (int) (WindowImpl.W_SCENE_SIZE) ) - centerX );
					this.monade.setY(0 - centerY);
				}

			}
			else { // x > 0 , y < 0
				if(p) { // top + top left corner
					this.monade.setX(WindowImpl2.W_VBOX_SIZE - centerX);
					this.monade.setY(this.r.nextInt( (int) (WindowImpl.H_SCENE_SIZE) ) - centerY );
				}
				else { // left + top left corner
					this.monade.setX(this.r.nextInt( (int) (WindowImpl.W_SCENE_SIZE) ) - centerX );
					this.monade.setY(WindowImpl.H_SCENE_SIZE + centerY);
				}
			}
		}
		else { 
			if(this.moveY > 0) { // x < 0 , y > 0
				if(p) { // right + bottom right corner
					this.monade.setX(WindowImpl.W_SCENE_SIZE + centerX);
					this.monade.setY(this.r.nextInt( (int) (WindowImpl.H_SCENE_SIZE) ) + centerY );
				}
				else { // bottom + bottom right corner
					this.monade.setX(this.r.nextInt( (int) (WindowImpl.W_SCENE_SIZE) ) + centerX );
					this.monade.setY(0 - centerY);
				}

			}
			else { // x < 0 , y < 0
				if(p) { // right + top right corner
					this.monade.setX(WindowImpl.W_SCENE_SIZE + centerX);
					this.monade.setY(this.r.nextInt( (int) (WindowImpl.H_SCENE_SIZE) ) - centerY );
				}
				else { // top + top right corner
					this.monade.setX(this.r.nextInt( (int) (WindowImpl.W_SCENE_SIZE) ) + centerX );
					this.monade.setY(WindowImpl.H_SCENE_SIZE + centerY);
				}
			}
		}
	}

	/**
	 * apply a Transition to the shape
	 */
	private void applyTranslation(double ms) {

		this.trans = new TranslateTransition(Duration.millis(/*r.nextInt(*/ms), this.monade );

		this.trans.setByX(this.moveX * this.speedCoeff);
		this.trans.setByY(this.moveY * this.speedCoeff);

		this.trans.setInterpolator(Interpolator.LINEAR);
		this.trans.play();

		/* Coordinates updated */
		((ImageView) this.monade).setX(((ImageView) this.monade).getX()+moveX * this.speedCoeff);
		((ImageView) this.monade).setY(((ImageView) this.monade).getY()+moveY * this.speedCoeff);

	}

	/**
	 * generates randomly an X for the Translation
	 */
	public void shuffleXY(double range) {

		if(range == 1){
			this.moveX = (double)r.nextInt((int)range+1);
			this.moveY = 1.0;
		}
		else {
			this.moveX = (r.nextInt((int)range+1))/range;
			this.moveY = 1.0 - this.moveX;
		}
		boolean p = r.nextBoolean();
		if(p==true) moveX = -moveX;
		p = r.nextBoolean();
		if(p==true) moveY = -moveY;
		System.out.println("coord : "+this.moveX+", "+this.moveY);
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
		/*
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
			pathTransition.play();
			shuffleXY(1);
			this.compteur = this.r.nextInt(10)+5;
		}
		 */

		if(this.monade instanceof ImageView){
			applyTranslation(100);
		}
		//this.compteur--;
	}
	public double getSpeedCoeff() {
		return speedCoeff;
	}
	public void setSpeedCoeff(double speedCoeff) {
		this.speedCoeff = speedCoeff;
	}

}
