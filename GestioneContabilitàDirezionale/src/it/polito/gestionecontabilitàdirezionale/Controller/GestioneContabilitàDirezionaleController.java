/**
 * Sample Skeleton for 'GestioneContabilitàDirezionale.fxml' Controller Class
 */

package it.polito.gestionecontabilitàdirezionale.Controller;

/**
 * Sample Skeleton for 'GestioneContabilitàDirezionale.fxml' Controller Class
 */



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import it.polito.contabilitàdirezionale.model.ContabilitàAgente;
import it.polito.contabilitàdirezionale.model.ModelMain;
import it.polito.gestionecontabilitàdirezionale.db.DBConnect;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class GestioneContabilitàDirezionaleController {
ModelMain model;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="anchorpane"
    private AnchorPane anchorpane; // Value injected by FXMLLoader

    @FXML // fx:id="buttonview"
    private JFXButton buttonview; // Value injected by FXMLLoader

    @FXML // fx:id="buttonteam"
    private JFXButton buttonteam; // Value injected by FXMLLoader

    @FXML // fx:id="buttonreport"
    private JFXButton buttonreport; // Value injected by FXMLLoader

    @FXML // fx:id="buttonteam"
    private JFXButton buttontecnici; // Value injected by FXMLLoader

    @FXML // fx:id="anchorpane2"
    private AnchorPane anchorpane2; // Value injected by FXMLLoader

    @FXML // fx:id="sp"
    private ScrollPane sp; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private TableView<ContabilitàAgente> table; // Value injected by FXMLLoader

    @FXML // fx:id="id"
    private TableColumn<ContabilitàAgente, Integer> id; // Value injected by FXMLLoader

    @FXML // fx:id="members"
    private TableColumn<ContabilitàAgente, String> members; // Value injected by FXMLLoader

    @FXML // fx:id="installazioni"
    private TableColumn<ContabilitàAgente, Integer> installazioni; // Value injected by FXMLLoader

    @FXML // fx:id="inst_tot"
    private TableColumn<ContabilitàAgente, Float> inst_tot; // Value injected by FXMLLoader

    @FXML // fx:id="tot_man_stra"
    private TableColumn<ContabilitàAgente, Integer> tot_man_stra; // Value injected by FXMLLoader

    @FXML // fx:id="tot2"
    private TableColumn<ContabilitàAgente, Float> tot2; // Value injected by FXMLLoader

    @FXML // fx:id="ricambi"
    private TableColumn<ContabilitàAgente, Integer> ricambi; // Value injected by FXMLLoader

    @FXML // fx:id="ricambi_tot"
    private TableColumn<ContabilitàAgente, Float> ricambi_tot; // Value injected by FXMLLoader

    @FXML // fx:id="accessori"
    private TableColumn<ContabilitàAgente, Integer> accessori; // Value injected by FXMLLoader

    @FXML // fx:id="accessori_tot"
    private TableColumn<ContabilitàAgente, Float> accessori_tot; // Value injected by FXMLLoader

    @FXML // fx:id="manod"
    private TableColumn<ContabilitàAgente, Integer> manod; // Value injected by FXMLLoader

    @FXML // fx:id="man_tot"
    private TableColumn<ContabilitàAgente, Float> man_tot; // Value injected by FXMLLoader

    @FXML // fx:id="costo_man"
    private TableColumn<ContabilitàAgente, Integer> costo_man; // Value injected by FXMLLoader

    @FXML // fx:id="costo_man_tot"
    private TableColumn<ContabilitàAgente, Float> costo_man_tot; // Value injected by FXMLLoader

    @FXML // fx:id="lifo"
    private TableColumn<ContabilitàAgente, Integer> lifo; // Value injected by FXMLLoader

    @FXML // fx:id="lifo_tot"
    private TableColumn<ContabilitàAgente, Float> lifo_tot; // Value injected by FXMLLoader

    @FXML // fx:id="man_ord_reali"
    private TableColumn<ContabilitàAgente, Integer> man_ord_reali; // Value injected by FXMLLoader

    @FXML // fx:id="man_ord_tot"
    private TableColumn<ContabilitàAgente, Float> man_ord_tot; // Value injected by FXMLLoader

    @FXML // fx:id="man_ord_pot"
    private TableColumn<ContabilitàAgente, Integer> man_ord_pot; // Value injected by FXMLLoader

    @FXML // fx:id="man_pot_tot"
    private TableColumn<ContabilitàAgente, Float> man_pot_tot; // Value injected by FXMLLoader

    @FXML // fx:id="man_str_tyfo"
    private TableColumn<ContabilitàAgente, Integer> man_str_tyfo; // Value injected by FXMLLoader

    @FXML // fx:id="man_str_ritorni"
    private TableColumn<ContabilitàAgente, Integer> man_str_ritorni; // Value injected by FXMLLoader

    @FXML // fx:id="man_rit_ordninarie"
    private TableColumn<ContabilitàAgente, Integer> man_rit_ordninarie; // Value injected by FXMLLoader

    @FXML // fx:id="man_ordin_tyfon"
    private TableColumn<ContabilitàAgente, Integer> man_ordin_tyfon; // Value injected by FXMLLoader

    @FXML // fx:id="enter"
    private JFXTextField enter; // Value injected by FXMLLoader
    
    ObservableList<ContabilitàAgente> obs= FXCollections.observableArrayList();
    FilteredList<ContabilitàAgente> flist = new FilteredList<ContabilitàAgente>(obs, e->true);
    boolean isOpen=false;
    @FXML
    void entername(KeyEvent event) {
     enter.textProperty().addListener((observable,oldvalue,newValue) -> {
    	 flist.setPredicate((Predicate<? super ContabilitàAgente >) (ContabilitàAgente ca)->{
    		 if(newValue.isEmpty() || newValue==null) {
    			 return true;
    		 } else if (ca.getName().contains(newValue.toUpperCase())) {
    			 return true;
    		 } 
    			 
    		 return false;
    	 });
     });
     SortedList<ContabilitàAgente> sort= new SortedList<ContabilitàAgente>(flist);
     sort.comparatorProperty().bind(table.comparatorProperty());
     table.setItems(sort);
    }
   

    @FXML
    void doReport(ActionEvent event) {
    	
    	try {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Report.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		
		
		ModelMain model= new ModelMain();
		ReportController controller= loader.getController();
		controller.setModelMain(model);
		
		root.setMaxSize(1200,1200);
		
		anchorpane.getChildren().setAll(root);
		
		//((Stage) ((Node)(event.getSource())).getScene().getWindow()).close();
	} catch(Exception e) {
		e.printStackTrace();
	}
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
    void legenda(ActionEvent event) throws IOException {
    	
    if(isOpen!=true) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("legenda.fxml"));
   
	SplitPane root = (SplitPane) loader.load();
    Scene scene = new Scene(root);
   
    	Stage stage = new Stage();
    	    
    	stage.setScene(scene);
    stage.show();
    
    isOpen=true;
    } else {
    	
    }
      
    	   
    }
 
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
    	Connection conn = DBConnect.getConnection();
		ResultSet res =conn.createStatement().executeQuery("Select*\n" + 
				"from ProduzioneAgenti");
		while(res.next()) {
			obs.add(new ContabilitàAgente(res.getInt("id"),res.getString("Nome"), res.getInt("1 Installazioni"), res.getFloat("1 Totale"),res.getInt("2 Tot_Man_Str"), res.getFloat("2 Totale"),res.getInt("3 Ricambi"), res.getFloat("3 Totale"),res.getInt("4 Accessori"), res.getFloat("4 Totale"),res.getInt("5 Manodopera"), res.getFloat("5 Totale"),res.getInt("6 CostoManodopera"), res.getFloat("6 Totale"),res.getInt("7 LIFO"), res.getFloat("7 Totale"),res.getInt("8 Man_Ord_Reali"), res.getFloat("8 Totale"),res.getInt("9 Man_Ord_Pot"), res.getFloat("9 Totale"),res.getInt("10 Man_Str_TYFON"),res.getInt("11 Man_Str_Ritorni"),res.getInt("12 Man_Rit_suOrdinarie"),res.getInt("13 Man_Ordinarie_TYFON")));
		}
        assert anchorpane != null : "fx:id=\"anchorpane\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert buttonview != null : "fx:id=\"buttonview\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert buttonteam != null : "fx:id=\"buttonteam\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert buttonreport != null : "fx:id=\"buttonreport\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert anchorpane2 != null : "fx:id=\"anchorpane2\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert sp != null : "fx:id=\"sp\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert members != null : "fx:id=\"members\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert installazioni != null : "fx:id=\"installazioni\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert inst_tot != null : "fx:id=\"inst_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert tot_man_stra != null : "fx:id=\"tot_man_stra\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert tot2 != null : "fx:id=\"tot2\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert ricambi != null : "fx:id=\"ricambi\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert ricambi_tot != null : "fx:id=\"ricambi_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert accessori != null : "fx:id=\"accessori\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert accessori_tot != null : "fx:id=\"accessori_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert manod != null : "fx:id=\"manod\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_tot != null : "fx:id=\"man_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert costo_man != null : "fx:id=\"costo_man\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert costo_man_tot != null : "fx:id=\"costo_man_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert lifo != null : "fx:id=\"lifo\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert lifo_tot != null : "fx:id=\"lifo_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_ord_reali != null : "fx:id=\"man_ord_reali\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_ord_tot != null : "fx:id=\"man_ord_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_ord_pot != null : "fx:id=\"man_ord_pot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_pot_tot != null : "fx:id=\"man_pot_tot\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_str_tyfo != null : "fx:id=\"man_str_tyfo\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_str_ritorni != null : "fx:id=\"man_str_ritorni\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_rit_ordninarie != null : "fx:id=\"man_rit_ordninarie\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert man_ordin_tyfon != null : "fx:id=\"man_ordin_tyfon\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'GestioneContabilitàDirezionale.fxml'.";
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        members.setCellValueFactory(new PropertyValueFactory<>("name"));
        installazioni.setCellValueFactory(new PropertyValueFactory<>("installazioni"));
        inst_tot.setCellValueFactory(new PropertyValueFactory<>("tot_inst"));
        tot_man_stra.setCellValueFactory(new PropertyValueFactory<>("tot_man_str"));
        tot2.setCellValueFactory(new PropertyValueFactory<>("totale"));
        ricambi.setCellValueFactory(new PropertyValueFactory<>("ricambi"));
        ricambi_tot.setCellValueFactory(new PropertyValueFactory<>("tot_ricambi"));
        accessori.setCellValueFactory(new PropertyValueFactory<>("accessori"));
        accessori_tot.setCellValueFactory(new PropertyValueFactory<>("tot_accessori"));
        manod.setCellValueFactory(new PropertyValueFactory<>("manodopera"));
        man_tot.setCellValueFactory(new PropertyValueFactory<>("tot_manodopera"));
        costo_man.setCellValueFactory(new PropertyValueFactory<>("costomanodopera"));
        costo_man_tot.setCellValueFactory(new PropertyValueFactory<>("tot_costomanodopera"));
        lifo.setCellValueFactory(new PropertyValueFactory<>("lifo"));
        lifo_tot.setCellValueFactory(new PropertyValueFactory<>("tot_lifo"));
        man_ord_reali.setCellValueFactory(new PropertyValueFactory<>("man_ord_reale"));
        man_ord_tot.setCellValueFactory(new PropertyValueFactory<>("tot_man_ord_reale"));
        man_ord_pot.setCellValueFactory(new PropertyValueFactory<>("man_ord_pot"));
        man_pot_tot.setCellValueFactory(new PropertyValueFactory<>("tot_man_ord_pot"));
        man_str_tyfo.setCellValueFactory(new PropertyValueFactory<>("man_str_Tyfon"));
        man_str_ritorni.setCellValueFactory(new PropertyValueFactory<>("man_straordinaria_ritorni"));
        man_rit_ordninarie.setCellValueFactory(new PropertyValueFactory<>("man_ritorni_ordninaria"));
        man_ordin_tyfon.setCellValueFactory(new PropertyValueFactory<>("man_ordn_tyfon"));
        table.setItems(obs);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        
    }

public void setModelMain(ModelMain model) {
	    	this.model=model;
    }
}




