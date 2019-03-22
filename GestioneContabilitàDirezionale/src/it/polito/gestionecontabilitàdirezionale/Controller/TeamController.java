package it.polito.gestionecontabilitàdirezionale.Controller;

/**
 * Sample Skeleton for 'Team.fxml' Controller Class
 */



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import it.polito.contabilitàdirezionale.model.ModelMain;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeamController {
    ModelMain model;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="anchorpane"
    private AnchorPane anchorpane; // Value injected by FXMLLoader

    @FXML // fx:id="buttontecnici"
    private JFXButton buttontecnici; // Value injected by FXMLLoader

    @FXML // fx:id="buttonteam"
    private JFXButton buttonteam; // Value injected by FXMLLoader

    @FXML // fx:id="buttonreport"
    private JFXButton buttonreport; // Value injected by FXMLLoader

    @FXML // fx:id="tabpane"
    private TabPane tabpane; // Value injected by FXMLLoader

    @FXML // fx:id="fatturato"
    private Tab fatturato; // Value injected by FXMLLoader

    @FXML // fx:id="table1"
    private TableView<?> table1; // Value injected by FXMLLoader

    @FXML // fx:id="tecnicoa1"
    private TableColumn<?, ?> tecnicoa1; // Value injected by FXMLLoader

    @FXML // fx:id="tecnicob1"
    private TableColumn<?, ?> tecnicob1; // Value injected by FXMLLoader

    @FXML // fx:id="enter2"
    private JFXTextField enter2; // Value injected by FXMLLoader

    @FXML // fx:id="Incidenza_ritorni"
    private Tab Incidenza_ritorni; // Value injected by FXMLLoader

    @FXML // fx:id="table2"
    private TableView<?> table2; // Value injected by FXMLLoader

    @FXML // fx:id="tecnicoa2"
    private TableColumn<?, ?> tecnicoa2; // Value injected by FXMLLoader

    @FXML // fx:id="tecnicob2"
    private TableColumn<?, ?> tecnicob2; // Value injected by FXMLLoader

    @FXML // fx:id="enter"
    private JFXTextField enter; // Value injected by FXMLLoader

    @FXML
    void doReport(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Report.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		
		
		ModelMain model= new ModelMain();
		ReportController controller= loader.getController();
		controller.setModelMain(model);
		
		root.setMaxSize(1200,1200);
		
		anchorpane.getChildren().setAll(root);
    }

    @FXML
    void doTeam(ActionEvent event) {

    }

    @FXML
    void doTecnici(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("GestioneContabilitàDirezionale.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		ModelMain model= new ModelMain();
		GestioneContabilitàDirezionaleController controller= loader.getController();
		controller.setModelMain(model);
		anchorpane.getChildren().setAll(root);
    }

    @FXML
    void entername(KeyEvent event) {

    }

    @FXML
    void entername2(KeyEvent event) {

    }

    @FXML
    void legenda(ActionEvent event) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("legenda.fxml"));
  	   
 	    SplitPane root = (SplitPane) loader.load();
     Scene scene = new Scene(root);
    
     	Stage stage = new Stage();
     	    
     	stage.setScene(scene);
     stage.show();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert anchorpane != null : "fx:id=\"anchorpane\" was not injected: check your FXML file 'Team.fxml'.";
        assert buttontecnici != null : "fx:id=\"buttontecnici\" was not injected: check your FXML file 'Team.fxml'.";
        assert buttonteam != null : "fx:id=\"buttonteam\" was not injected: check your FXML file 'Team.fxml'.";
        assert buttonreport != null : "fx:id=\"buttonreport\" was not injected: check your FXML file 'Team.fxml'.";
        assert tabpane != null : "fx:id=\"tabpane\" was not injected: check your FXML file 'Team.fxml'.";
        assert fatturato != null : "fx:id=\"fatturato\" was not injected: check your FXML file 'Team.fxml'.";
        assert table1 != null : "fx:id=\"table1\" was not injected: check your FXML file 'Team.fxml'.";
        assert tecnicoa1 != null : "fx:id=\"tecnicoa1\" was not injected: check your FXML file 'Team.fxml'.";
        assert tecnicob1 != null : "fx:id=\"tecnicob1\" was not injected: check your FXML file 'Team.fxml'.";
        assert enter2 != null : "fx:id=\"enter2\" was not injected: check your FXML file 'Team.fxml'.";
        assert Incidenza_ritorni != null : "fx:id=\"Incidenza_ritorni\" was not injected: check your FXML file 'Team.fxml'.";
        assert table2 != null : "fx:id=\"table2\" was not injected: check your FXML file 'Team.fxml'.";
        assert tecnicoa2 != null : "fx:id=\"tecnicoa2\" was not injected: check your FXML file 'Team.fxml'.";
        assert tecnicob2 != null : "fx:id=\"tecnicob2\" was not injected: check your FXML file 'Team.fxml'.";
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'Team.fxml'.";
        

    }
    public void setModelMain(ModelMain model) {
    	this.model=model;
}
}

