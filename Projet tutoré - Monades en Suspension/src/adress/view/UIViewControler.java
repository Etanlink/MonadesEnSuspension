package adress.view;

import adress.MainMonadesEnSuspension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;


public class UIViewControler {

	
	@FXML
	private Button BoutonAnimation;

	
	private MainMonadesEnSuspension mainApp;
	
	
	
    public void setMainApp(MainMonadesEnSuspension mainApp) {
        this.mainApp = mainApp;

    }
    
    public UIViewControler(){
    }

    @FXML
    private void initialize() {
    }
    
    @FXML
    private void handlerAnimerCercle(){
    }
}
