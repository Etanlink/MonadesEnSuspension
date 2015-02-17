package ch.makery.address.view;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import ch.makery.address.MainApp;



public class PersonOverwiewControl {
	
	@FXML
	private Button BoutonBouger;
	@FXML
	public Circle cercle2;
	
	@FXML
	private Button BoutonGenerer ;
	
	@FXML
	public ArrayList<Circle> ListeDeCercle = new ArrayList();
	
	public MainApp mainApp;
	
	
	
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
    
    
    public PersonOverwiewControl(){
    }

    @FXML
    private void initialize() {
    }
    
    @FXML
    private void handleBougerCercle(){
    	int i = 0;
    	while(ListeDeCercle.get(i).getId()!="2"){
    	i++;
    	}
    	this.ListeDeCercle.get(i).setRadius(20);
    }
    
    @FXML
    private void genererCercle(){
    	/*Circle monCercle = new Circle();
    	ListeDeCercle.add(monCercle);
    	int i = 0;
    	while(i<ListeDeCercle.size()){
    		i++;
    	}
    	monCercle.setId("Cercle"+i);
    	ListeDeCercle.get(i).setCenterX(300);//réglage de la position, de la taille et de la couleur du cercle
    	ListeDeCercle.get(i).setCenterY(200);
    	ListeDeCercle.get(i).setRadius(100);
    	ListeDeCercle.get(i).setFill(Color.YELLOW);
    	ListeDeCercle.get(i).setStroke(Color.ORANGE);//réglage de la couleur de la bordure et de son épaisseur
    	ListeDeCercle.get(i).setStrokeWidth(5);*/
    	Circle cercle = new Circle();
        cercle.setCenterX(300);//réglage de la position, de la taille et de la couleur du cercle
        cercle.setCenterY(200);
        cercle.setRadius(100);
        cercle.setFill(Color.YELLOW);
        cercle.setStroke(Color.ORANGE);//réglage de la couleur de la bordure et de son épaisseur
        cercle.setStrokeWidth(5);
        Circle cercle2 = new Circle();
        cercle2.setCenterX(81);//réglage de la position, de la taille et de la couleur du cercle
        cercle2.setCenterY(82);
        cercle2.setRadius(54);
        cercle2.setFill(Color.BLUE);
        ListeDeCercle.add(cercle);
        ListeDeCercle.add(cercle2);
        cercle.setId("1");
        cercle2.setId("2");
    	this.mainApp.Root.getChildren().add(cercle);
    	this.mainApp.Root.getChildren().add(cercle2);
    }
}

