package adress.model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.controlsfx.dialog.Dialogs;

import com.sun.javafx.scene.accessibility.Action;

import adress.MainApp2;
import adress.MainTestCatchWindow;
import adress.MainTestIHM;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowImpl2 {

	private Stage primaryStage;

	//private BorderPane rootLayout;

	private Group root = new Group();
	
	public AnimationImpl animation;
	
	public boolean animationRunning = false;
	public boolean animationStarted = false;

	public static final int SCENE_SIZE = 600;
	
	public static final int W_SCENE_SIZE = 800;
	public static final int H_SCENE_SIZE = 600;
	private MainApp2 MainApp;
	public VBox MaVBox ;
	private Rectangle snapshotRectangle = new Rectangle(225, 25, 585, 600);
	
	public final int PARAMETERS_PANE_WIDTH = 224;
	private static final int PARAMETERS_PANE_SIZE = 609;
	
	@FXML
	public Button BoutonLancerAnim ;

	
	@FXML
	public TextField textField1 ;
	
	@FXML
	public TextField textField2 ;
	
	@FXML
	public TextField textField3 ;
	
	@FXML
	public TextField textField4 ;
	
	@FXML
	public Slider Slider1;
	
	@FXML
	public Slider Slider2;
	
	@FXML
	public Slider Slider3;
	
	@FXML
	public Slider Slider4;
	
	public Slider SliderVitesse;
	
	public EventHandler<MouseEvent> SliderHandler1 = new EventHandler<MouseEvent>(){
		 public void handle(MouseEvent actionEvent){
				int j = (int) Slider1.getValue();
				textField1.setText(String.valueOf(j));
				Slider1.setValue(j);
		 }
	};

	public EventHandler TextFieldHandler1 = new EventHandler(){
		
		public void handle(Event actionEvent){
			Slider1.setValue(Double.parseDouble(textField1.getText()));
		}
	};
	
	public EventHandler<MouseEvent> SliderHandler2 = new EventHandler<MouseEvent>(){
		 public void handle(MouseEvent actionEvent){
				int j = (int) Slider2.getValue();
				textField2.setText(String.valueOf(j));
				Slider2.setValue(j);
		 }
	};

	public EventHandler TextFieldHandler2 = new EventHandler(){
		
		public void handle(Event actionEvent){
			Slider2.setValue(Double.parseDouble(textField2.getText()));
		}
	};
	
	public EventHandler<MouseEvent> SliderHandler3 = new EventHandler<MouseEvent>(){
		 public void handle(MouseEvent actionEvent){
				int j = (int) Slider3.getValue();
				textField3.setText(String.valueOf(j));
				Slider3.setValue(j);
		 }
	};

	public EventHandler TextFieldHandler3 = new EventHandler(){
		
		public void handle(Event actionEvent){
			Slider3.setValue(Double.parseDouble(textField3.getText()));
		}
	};
	
	public EventHandler<MouseEvent> SliderHandler4 = new EventHandler<MouseEvent>(){
		 public void handle(MouseEvent actionEvent){
				int j = (int) Slider4.getValue();
				textField4.setText(String.valueOf(j));
				Slider4.setValue(j);
		 }
	};

	public EventHandler TextFieldHandler4 = new EventHandler(){
		
		public void handle(Event actionEvent){
			Slider4.setValue(Double.parseDouble(textField4.getText()));
		}
	};

	public EventHandler<MouseEvent> VitesseHandler = new EventHandler<MouseEvent>(){
		public void handle(MouseEvent actionEvent){
			animation.changeSpeedCoeff(SliderVitesse.getValue());
		}
	};
	public WindowImpl2() {	}
	/**
	 * Initialize the primarystage
	 */
	public void primaryStageInitialisation(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Monades en suspension");
		primaryStage.setResizable(false);
		
		this.animation = new AnimationImpl(this.root);

		//MenuBar menuBar = loadMenuBar();
		MenuBar menuBar = manualMenuBar();
		
		this.MaVBox = manualParametersVBox();
		//FXMLParametersVBox();

		this.primaryStage = primaryStage;
		
		this.snapshotRectangle.setFill(Color.TRANSPARENT);
		
		Scene scene = new Scene(this.root, W_SCENE_SIZE, H_SCENE_SIZE);
		primaryStage.setScene(scene);
		/* the different parts of UI are bound AFTER the animation */
		/*									   ^^^^^			   */
		this.root.getChildren().add(this.MaVBox);
		this.root.getChildren().add(menuBar);
		this.root.getChildren().add(this.snapshotRectangle);
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
	public void initialize() {
		
	}
	
	
	public void FXMLParametersVBox() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(WindowImpl2.class.getResource("VBox.fxml"));
			VBox vBox = (VBox)loader.load();
			this.MaVBox = vBox ;
			WindowImpl2 controller = loader.getController();
			controller.setMainApp(this.MainApp);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void setMainApp(MainApp2 mainapp){
		this.MainApp = mainapp;
	}
	/**
	 * Creates a basic parametersPane
	 * @return parametersPane
	 * @throws IOException 
	 */
	private VBox manualParametersVBox() throws IOException {
		
		final VBox parametersVBox = new VBox();
		parametersVBox.setPrefSize(224, 609);
		parametersVBox.setMinSize(parametersVBox.getPrefWidth(), parametersVBox.getPrefHeight());
		parametersVBox.setMaxSize(parametersVBox.getPrefWidth(), parametersVBox.getPrefHeight());
		parametersVBox.setStyle("-fx-background-color:  #c9c7c7;");
		parametersVBox.setFillWidth(true);;
		
		/* Add of a VBox title */
		Text VBoxTitle = new Text("Paramètres");
		VBoxTitle.setFont(Font.font("System", FontWeight.SEMI_BOLD, 16));
		parametersVBox.getChildren().add(VBoxTitle);
		
		/* Align all of the VBox components to CENTER_LEFT */
		parametersVBox.setAlignment(Pos.BASELINE_CENTER);
		/* Addition of spacing between the VBox Components */
		parametersVBox.setSpacing(7);
		//parametersVBox.setMargin((Node) parametersVBox.getChildren(),new Insets(20));
		
		/* Add of the different controllers */
		Label LabelNBMinObjects = new Label("Nombre de Monades");
		Slider NbObjects = new Slider(3, 10, 3);
		NbObjects.setShowTickLabels(true);
		NbObjects.setMajorTickUnit(1);
		NbObjects.setOnDragDetected(SliderHandler1);
		NbObjects.setOnMouseClicked(SliderHandler1);
		this.Slider1=NbObjects;
		TextField NbObjects2 = new TextField();
		NbObjects2.setOnAction(TextFieldHandler1);
		NbObjects2.setOnKeyReleased(TextFieldHandler1);
		NbObjects2.setText("3");
		this.textField1 = NbObjects2 ;
		
		Label LabelTinyObjectsPercentage = new Label("Nombre de petites Monades");
		Slider TinyObjectsNumber = new Slider(0, 10, 0);//respectively : min, max, beginValue
		TinyObjectsNumber.setShowTickLabels(true);
		TinyObjectsNumber.setMajorTickUnit(1);
		TinyObjectsNumber.setOnDragDetected(SliderHandler2);
		TinyObjectsNumber.setOnMouseClicked(SliderHandler2);
		this.Slider2 = TinyObjectsNumber;
		TextField TinyObjectsNumber2 = new TextField();
		TinyObjectsNumber2.setOnAction(TextFieldHandler2);
		TinyObjectsNumber2.setOnKeyReleased(TextFieldHandler2);
		TinyObjectsNumber2.setText("0");
		this.textField2=TinyObjectsNumber2;
		
		Label LabelNormalObjectsPercentage = new Label("Nombre de moyennes de Monades");
		Slider NormalObjectsNumber = new Slider(0, 10, 0);//respectively : min, max, beginValue;
		NormalObjectsNumber.setShowTickLabels(true);
		NormalObjectsNumber.setMajorTickUnit(1);
		NormalObjectsNumber.setOnDragDetected(SliderHandler3);
		NormalObjectsNumber.setOnMouseClicked(SliderHandler3);
		this.Slider3 = NormalObjectsNumber;
		TextField NormalObjectsNumber2 = new TextField();
		NormalObjectsNumber2.setOnAction(TextFieldHandler3);
		NormalObjectsNumber2.setOnKeyReleased(TextFieldHandler3);
		NormalObjectsNumber2.setText("0");
		this.textField3=NormalObjectsNumber2;
		
		Label LabelBigObjectsPercentage = new Label("Nombre de grandes Monades");
		Slider BigObjectsNumber = new Slider(0, 10, 0);//respectively : min, max, beginValue;
		BigObjectsNumber.setShowTickLabels(true);
		BigObjectsNumber.setMajorTickUnit(1);
		BigObjectsNumber.setOnDragDetected(SliderHandler4);
		BigObjectsNumber.setOnMouseClicked(SliderHandler4);
		this.Slider4 = BigObjectsNumber;
		TextField BigObjectsNumber2 = new TextField();
		BigObjectsNumber2.setOnAction(TextFieldHandler4);
		BigObjectsNumber2.setOnKeyReleased(TextFieldHandler4);
		BigObjectsNumber2.setText("0");
		this.textField4=BigObjectsNumber2;
		
		Label LabelSpeed = new Label("Vitesse de l'animation");
		Slider SpeedSlider = new Slider (0, 42, 30);
		SpeedSlider.setShowTickLabels(true);
		SpeedSlider.setMajorTickUnit(7);
		SpeedSlider.setOnDragDetected(VitesseHandler);
		SpeedSlider.setOnMouseClicked(VitesseHandler);
		SliderVitesse = SpeedSlider ;
				
		Button launchAnimationButton = new Button();
		launchAnimationButton.setText("Lancer l'animation");
		launchAnimationButton.setOnAction(new EventHandler<ActionEvent>() {
			
		    @Override 
		    public void handle(ActionEvent actionEvent) {
				double result = Slider3.getValue()+Slider2.getValue()+Slider4.getValue();
				if (result < Slider1.getValue() || result > Slider1.getValue()){
					Dialogs.create()
							.owner(primaryStage)
							.title("Erreur")
							.masthead(null)
							.message("Le nombre de monades demandé est erroné")
							.showInformation();
				}
				if(animationStarted){
					Dialogs.create()
					.owner(primaryStage)
					.title("Erreur")
					.masthead(null)
					.message("Une animation est déjà lancée, veuillez relancer l'application pour générer une nouvelle animation")
					.showInformation();
				}
				if (result == Slider1.getValue() && !animationStarted){
					Dialogs.create()
					.owner(primaryStage)
					.title("Animation")
					.masthead(null)
					.message("Animation lancée")
					.showInformation();
			    	animationRunning = true;
			    	/* Launch the animation */
			    	
			    	//animation.animationWithParameters(getNbMinObjectsParameter, getTinyObjectsPercentage, getNormalObjectsPercentage, getBigObjectsPercentage);
					animation.run();
					animationStarted = true ;
				}
				

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
		parametersVBox.getChildren().add(this.Slider1);
		parametersVBox.getChildren().add(this.textField1);
		
		parametersVBox.getChildren().add(LabelTinyObjectsPercentage);
		parametersVBox.getChildren().add(this.Slider2);
		parametersVBox.getChildren().add(this.textField2);
		
		parametersVBox.getChildren().add(LabelNormalObjectsPercentage);
		parametersVBox.getChildren().add(this.Slider3);
		parametersVBox.getChildren().add(this.textField3);
		
		parametersVBox.getChildren().add(LabelBigObjectsPercentage);
		parametersVBox.getChildren().add(this.Slider4);
		parametersVBox.getChildren().add(this.textField4);
		
		parametersVBox.getChildren().add(LabelSpeed);
		parametersVBox.getChildren().add(this.SliderVitesse);
		
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
	    WritableImage image = this.snapshotRectangle.snapshot(new SnapshotParameters(), null);

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

	@FXML
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

	@FXML
	public void DragHandler1(){
		int j = (int) this.Slider1.getValue();
		this.textField1.setText(String.valueOf(j));
		this.Slider1.setValue(j);
	}
	
	@FXML
	public void TextAreaHandler1(){
		this.Slider1.setValue(Double.parseDouble(this.textField1.getText()));
	}

	@FXML
	public void DragHandler2(){
		int j = (int) this.Slider2.getValue();
		this.textField2.setText(String.valueOf(j));
		this.Slider2.setValue(j);
	}
	
	@FXML
	public void TextAreaHandler2(){
		this.Slider2.setValue(Double.parseDouble(this.textField2.getText()));
	}
	@FXML
	public void DragHandler3(){
		int j = (int) this.Slider3.getValue();
		this.textField3.setText(String.valueOf(j));
		this.Slider3.setValue(j);
	}
	
	@FXML
	public void TextAreaHandler3(){
		this.Slider3.setValue(Double.parseDouble(this.textField3.getText()));
	}
	@FXML
	public void DragHandler4(){
		int j = (int) this.Slider4.getValue();
		this.textField4.setText(String.valueOf(j));
		this.Slider4.setValue(j);
	}
	
	@FXML
	public void TextAreaHandler4(){
		this.Slider4.setValue(Double.parseDouble(this.textField4.getText()));
	}
	
	@SuppressWarnings("deprecation")
	@FXML
	public void CheckPourcentage(){
		double result = this.Slider3.getValue()+this.Slider2.getValue()+this.Slider4.getValue();
		if (result < this.Slider1.getValue() || result > this.Slider1.getValue()){
			Dialogs.create()
					.owner(this.primaryStage)
					.title("Erreur")
					.masthead(null)
					.message("Le nombre de monades demandé est erroné")
					.showInformation();
		}
		if (result == this.Slider1.getValue()){
			Dialogs.create()
			.owner(this.primaryStage)
			.title("truc")
			.masthead(null)
			.message("C'est OK")
			.showInformation();
		}
		

	}
}
