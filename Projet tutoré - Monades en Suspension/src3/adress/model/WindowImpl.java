package adress.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import adress.MainTestCatchWindow;
import adress.MainTestIHM;
import javafx.animation.Animation;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Class binding stage, scene, animation and UI's different parts
 * @author Hugo & Etanlink
 *
 */
public class WindowImpl {

	private Stage primaryStage;

	//private BorderPane rootLayout;

	private Group root = new Group();
	
	private AnimationImpl animation;
	
	private boolean animationRunning = false;

	public static final int SCENE_SIZE = 600;
	
	public static final int W_SCENE_SIZE = 800;
	public static final int H_SCENE_SIZE = 600;
	private MainTestIHM MainApp;
	public VBox MaVBox ;
	
	private static final int PARAMETERS_PANE_SIZE = 620;

	

	public WindowImpl(){


	}
	/**
	 * Initialize the primarystage
	 */
	
	public void PrimaryStageInitialisation(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Monades en suspension");
		primaryStage.setResizable(false);
		
		this.animation = new AnimationImpl(root);

		//MenuBar menuBar = loadMenuBar();
		MenuBar menuBar = manualMenuBar();
		
		FXMLParametersVBox();

		this.primaryStage = primaryStage;
		
		Scene scene = new Scene(this.root, W_SCENE_SIZE, H_SCENE_SIZE);
		primaryStage.setScene(scene);
		/* the different parts of UI are bound AFTER the animation */
		/*									   ^^^^^			   */
		this.root.getChildren().add(this.MaVBox);
		this.root.getChildren().add(menuBar);
		this.primaryStage.show();
	}

	/**
	 * Creates a basic menuBar
	 * @return MenuBar : the menuBar of the window
	 */
	public MenuBar manualMenuBar() {
		final Menu helpMenuItem = new Menu("Aide");
		helpMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            }
        });
		final Menu aboutMenuItem = new Menu("À propos");
		aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            }
        });

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(helpMenuItem, aboutMenuItem);
		menuBar.setMinWidth(W_SCENE_SIZE+10);
		return menuBar;
	}
	
	@FXML
	public void initialize(){
		
	}
	
	
	public void FXMLParametersVBox() {
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WindowImpl.class.getResource("VBox.fxml"));
		VBox vBox = (VBox) loader.load();
		this.MaVBox = vBox ;
		WindowImpl controller = loader.getController();
		controller.setMainApp(this.MainApp);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void setMainApp(MainTestIHM mainapp){
		this.MainApp = mainapp;
	}
	/**
	 * Creates a basic parametersPane
	 * @return parametersPane
	 * @throws IOException 
	 */
	private VBox manualParametersVBox() throws IOException {
		
		final VBox parametersVBox = new VBox();
		parametersVBox.setPrefSize(220, PARAMETERS_PANE_SIZE);
		parametersVBox.setStyle("-fx-background-color: #f5f5f5;");
		
		/* Add of a VBox title */
		Text VBoxTitle = new Text("Paramètres");
		VBoxTitle.setFont(Font.font("System", FontWeight.SEMI_BOLD, 16));
		parametersVBox.getChildren().add(VBoxTitle);
		
		/* Align all of the VBox components to CENTER_LEFT */
		parametersVBox.setAlignment(Pos.BASELINE_CENTER);
		/* Addition of spacing between the VBox Components */
		parametersVBox.setSpacing(20);
		//parametersVBox.setMargin((Node) parametersVBox.getChildren(),new Insets(20));
		
		/* Add of the different controllers */
		Label LabelNBMinObjects = new Label("Nombre minimum de Monades");
		Slider NbMinObjects = new Slider(3, 10, 3);
		NbMinObjects.setShowTickLabels(true);
		
		Label LabelTinyObjectsPercentage = new Label("Pourcentage de petites Monades");
		Slider TinyObjectsPercentage = new Slider(0, 100, 0);//respectively : min, max, beginValue
		TinyObjectsPercentage.setShowTickLabels(true);
		
		Label LabelNormalObjectsPercentage = new Label("Pourcentage de moyennes de Monades");
		Slider NormalObjectsPercentage = new Slider(0, 100, 0);//respectively : min, max, beginValue;
		NormalObjectsPercentage.setShowTickLabels(true);
		
		Label LabelBigObjectsPercentage = new Label("Pourcentage de grandes Monades");
		Slider BigObjectsPercentage = new Slider(0, 100, 0);//respectively : min, max, beginValue;
		BigObjectsPercentage.setShowTickLabels(true);
		
		Button launchAnimationButton = new Button();
		launchAnimationButton.setText("Lancer l'animation");
		launchAnimationButton.setOnAction(new EventHandler<ActionEvent>() {
			
			
		    @Override 
		    public void handle(ActionEvent actionEvent) {
		    	animationRunning = true;
		        /* Get the different parameters specified by the controllers */
		    	double getNbMinObjectsParameter = NbMinObjects.getValue();
		    	double getTinyObjectsPercentage = TinyObjectsPercentage.getValue();
		    	double getNormalObjectsPercentage = NormalObjectsPercentage.getValue();
		    	double getBigObjectsPercentage = BigObjectsPercentage.getValue();
		    	
		    	/* Add of the animation controllers */
		    	/* Launch the animation */
		    	
		    	//animation.animationWithParameters(getNbMinObjectsParameter, getTinyObjectsPercentage, getNormalObjectsPercentage, getBigObjectsPercentage);
				animation.run();
		    } 
		});
		
		Button pauseAnimationButton = new Button();
		pauseAnimationButton.setText("Mettre en pause l'animation");
		pauseAnimationButton.setOnAction(new EventHandler<ActionEvent>() { 
			
			@Override
			public void handle(ActionEvent actionEvent) {
				if(animationRunning){
					animation.getAnimation().stop();
					for(AnimatedImageThread thr1 : animation.getThreadShapes())
					{
						thr1.getAnimation().stop();
					}
					animationRunning = false;
					pauseAnimationButton.setText("Reprendre l'animation");
				}
				else {
					animation.getAnimation().play();
					for(AnimatedImageThread thr1 : animation.getThreadShapes())
					{
						thr1.getAnimation().play();
					}
					animationRunning = true;
					pauseAnimationButton.setText("Mettre en pause l'animation");
				}
			}
		});
		
		Button snapshotAnimationButton = new Button();
		snapshotAnimationButton.setText("Capturer l'animation en cours");
		
		snapshotAnimationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	/* Save the capture in a png file */
            	saveAsPngInResFolder();
            	try {
            		/* Open a new window with the capture in background */
            		Stage secondaryStage = new Stage();
					CatchWindowImpl catchAnimationWindow = new CatchWindowImpl(secondaryStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		
		/* Add of the controllers to the VBox */
		parametersVBox.getChildren().add(LabelNBMinObjects);
		parametersVBox.getChildren().add(NbMinObjects);
		
		parametersVBox.getChildren().add(LabelTinyObjectsPercentage);
		parametersVBox.getChildren().add(TinyObjectsPercentage);
		
		parametersVBox.getChildren().add(LabelNormalObjectsPercentage);
		parametersVBox.getChildren().add(NormalObjectsPercentage);
		
		parametersVBox.getChildren().add(LabelBigObjectsPercentage);
		parametersVBox.getChildren().add(BigObjectsPercentage);
		
		parametersVBox.getChildren().add(launchAnimationButton);
		
		parametersVBox.getChildren().add(pauseAnimationButton);
		
		parametersVBox.getChildren().add(snapshotAnimationButton);
		
		return parametersVBox;
	}
	
	/**
	 * Put the capture of the animation in a res folder
	 * @author Florian, Etanlink
	 * TODO For now it's just possible to save one capture, (each new capture overwrite the previous capture)
	 * it will be necessary to think to fix this.
	 */
	public void saveAsPngInResFolder() {
	    WritableImage image = root.snapshot(new SnapshotParameters(), null);

	    /* Save the capture in a png file in a res folder */
	    File file = new File("src3/res/CaptureAnimation.png");
	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
	    }
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Loads the MenuBar of the UI
	 * @return MenuBar menubar
	 * @throws IOException
	 */
	/*private MenuBar loadMenuBar() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WindowImpl.class.getResource("view/MenuBar.fxml"));
		MenuBar menubar = (MenuBar)loader.load();
		return menubar;
	}*/


	public void LancerAnimationHandler(){
		this.animationRunning = true;
        /* Get the different parameters specified by the controllers */
		/*
    	double getNbMinObjectsParameter = NbMinObjects.getValue();
    	double getTinyObjectsPercentage = TinyObjectsPercentage.getValue();
    	double getNormalObjectsPercentage = NormalObjectsPercentage.getValue();
    	double getBigObjectsPercentage = BigObjectsPercentage.getValue();
    	*/
    	/* Add of the animation controllers */
    	/* Launch the animation */
    	
    	//animation.animationWithParameters(getNbMinObjectsParameter, getTinyObjectsPercentage, getNormalObjectsPercentage, getBigObjectsPercentage);
		this.animation.run();
	}

}
