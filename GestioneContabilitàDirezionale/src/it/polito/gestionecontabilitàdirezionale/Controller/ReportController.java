package it.polito.gestionecontabilitàdirezionale.Controller;

/**
 * Sample Skeleton for 'Report.fxml' Controller Class
 */



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


import it.polito.contabilitàdirezionale.model.ModelMain;
import it.polito.contabilitàdirezionale.model.ReportValoriTecnici;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ReportController {
    ModelMain model;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="anchorpane"
    private AnchorPane anchorpane; // Value injected by FXMLLoader

    @FXML // fx:id="buttonteam"
    private JFXButton buttonteam; // Value injected by FXMLLoader
    @FXML // fx:id="buttonteam"
    private JFXButton buttontecnici; // Value injected by FXMLLoader

    @FXML // fx:id="buttonreport"
    private JFXButton buttonreport; // Value injected by FXMLLoader

    @FXML // fx:id="anchorpane2"
    private AnchorPane anchorpane2; // Value injected by FXMLLoader

    @FXML // fx:id="enter"
    private JFXTextField enter; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private TableView<ReportValoriTecnici> table; // Value injected by FXMLLoader

    @FXML // fx:id="tecnico1"
    private TableColumn<?, ?> tecnico1; // Value injected by FXMLLoader

    @FXML // fx:id="tecnico"
    private TableColumn<?, ?> tecnico; // Value injected by FXMLLoader

    @FXML // fx:id="tot_fatt"
    private TableColumn<?, ?> tot_fatt; // Value injected by FXMLLoader

    @FXML // fx:id="ric_str"
    private TableColumn<?, ?> ric_str; // Value injected by FXMLLoader

    @FXML // fx:id="ma_str"
    private TableColumn<?, ?> ma_str; // Value injected by FXMLLoader

    @FXML // fx:id="margine"
    private TableColumn<?, ?> margine; // Value injected by FXMLLoader

    @FXML // fx:id="aspett_1"
    private TableColumn<?, ?> aspett_1; // Value injected by FXMLLoader

    @FXML // fx:id="Asp_2"
    private TableColumn<?, ?> Asp_2; // Value injected by FXMLLoader

    @FXML // fx:id="incidenza"
    private TableColumn<?, ?> incidenza; // Value injected by FXMLLoader
    
    
    ObservableList<ReportValoriTecnici> obs= FXCollections.observableArrayList();
    FilteredList<ReportValoriTecnici> flist = new FilteredList<ReportValoriTecnici>(obs, e->true);
    
    @FXML
    void doReport(ActionEvent event) {

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
    void doTeam(ActionEvent event) {

    }

    @FXML
    void entername(KeyEvent event) {
    	enter.textProperty().addListener((observable,oldvalue,newValue) -> {
       	 flist.setPredicate((Predicate<? super ReportValoriTecnici >) (ReportValoriTecnici rvt)->{
       		 if(newValue.isEmpty() || newValue==null) {
       			 return true;
       		 } else if (rvt.getNome().contains(newValue.toUpperCase())) {
       			 return true;
       		 } 
       			 
       		 return false;
       	 });
        });
        SortedList<ReportValoriTecnici> sort= new SortedList<ReportValoriTecnici>(flist);
        sort.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sort);
    }

    @FXML
    void legenda(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("legendaReport.fxml"));
    	   
    	SplitPane root = (SplitPane) loader.load();
        Scene scene = new Scene(root);
       
        	Stage stage = new Stage();
        	    
        	stage.setScene(scene);
        stage.show();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	    //model.setValori();
        assert anchorpane != null : "fx:id=\"anchorpane\" was not injected: check your FXML file 'Report.fxml'.";
        assert buttonteam != null : "fx:id=\"buttonteam\" was not injected: check your FXML file 'Report.fxml'.";
        assert buttonreport != null : "fx:id=\"buttonreport\" was not injected: check your FXML file 'Report.fxml'.";
        assert anchorpane2 != null : "fx:id=\"anchorpane2\" was not injected: check your FXML file 'Report.fxml'.";
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'Report.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'Report.fxml'.";
        assert tecnico1 != null : "fx:id=\"tecnico1\" was not injected: check your FXML file 'Report.fxml'.";
        assert tecnico != null : "fx:id=\"tecnico\" was not injected: check your FXML file 'Report.fxml'.";
        assert tot_fatt != null : "fx:id=\"tot_fatt\" was not injected: check your FXML file 'Report.fxml'.";
        assert ric_str != null : "fx:id=\"ric_str\" was not injected: check your FXML file 'Report.fxml'.";
        assert ma_str != null : "fx:id=\"ma_str\" was not injected: check your FXML file 'Report.fxml'.";
        assert margine != null : "fx:id=\"margine\" was not injected: check your FXML file 'Report.fxml'.";
        assert aspett_1 != null : "fx:id=\"aspett_1\" was not injected: check your FXML file 'Report.fxml'.";
        assert Asp_2 != null : "fx:id=\"Asp_2\" was not injected: check your FXML file 'Report.fxml'.";
        assert incidenza != null : "fx:id=\"incidenza\" was not injected: check your FXML file 'Report.fxml'.";

    }
    
    public void setModelMain(ModelMain model) {
    	this.model=model;
}
}

