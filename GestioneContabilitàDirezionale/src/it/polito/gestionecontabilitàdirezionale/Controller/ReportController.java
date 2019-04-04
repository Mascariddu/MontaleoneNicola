package it.polito.gestionecontabilitàdirezionale.Controller;

/**
 * Sample Skeleton for 'Report.fxml' Controller Class
 */



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


import it.polito.contabilitàdirezionale.model.ContabilitàAgente;
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
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	@FXML // fx:id="buttonreport"
	private JFXButton buttonpie; // Value injected by FXMLLoader


	@FXML // fx:id="anchorpane2"
	private AnchorPane anchorpane2; // Value injected by FXMLLoader

	@FXML // fx:id="enter"
	private JFXTextField enter; // Value injected by FXMLLoader
	@FXML // fx:id="sp"
	private ScrollPane sp; // Value injected by FXMLLoader

	@FXML // fx:id="table"
	private TableView<ReportValoriTecnici> table; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico1"
	private TableColumn<ReportValoriTecnici, Integer> tecnico1; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<ReportValoriTecnici, String> tecnico; // Value injected by FXMLLoader

	@FXML // fx:id="tot_fatt"
	private TableColumn<ReportValoriTecnici, Double> tot_fatt; // Value injected by FXMLLoader

	@FXML // fx:id="ric_str"
	private TableColumn<ReportValoriTecnici, Integer> ric_str; // Value injected by FXMLLoader

	@FXML // fx:id="ma_str"
	private TableColumn<ReportValoriTecnici, Float> ma_str; // Value injected by FXMLLoader

	@FXML // fx:id="margine"
	private TableColumn<ReportValoriTecnici, Float> margine; // Value injected by FXMLLoader

	@FXML // fx:id="aspett_1"
	private TableColumn<ReportValoriTecnici, Float> aspett_1; // Value injected by FXMLLoader

	@FXML // fx:id="Asp_2"
	private TableColumn<ReportValoriTecnici, Float> Asp_2; // Value injected by FXMLLoader

	@FXML // fx:id="incidenza"
	private TableColumn<ReportValoriTecnici, Float> incidenza; // Value injected by FXMLLoader


	ObservableList<ReportValoriTecnici> obs= FXCollections.observableArrayList();
	FilteredList<ReportValoriTecnici> flist = new FilteredList<ReportValoriTecnici>(obs, e->true);
	ObservableList<PieChart.Data> obs2= FXCollections.observableArrayList();
	ObservableList<PieChart.Data> obs3= FXCollections.observableArrayList();
	PieChart pieChart=null;
	PieChart pieChart2=null;
	BorderPane root;
	Stage stageP;

	private JFXTextField label;
	@FXML
	void doReport(ActionEvent event) {

	}
	@FXML
	void pie(ActionEvent event) throws IOException {

		float somma1=(float) 0.0;
		float somma2=(float) 0.0;
		float somma3=(float) 0.0;
		int somma4= 0;
		int somma5=0;
		int somma6=0;

		if(pieChart==null) {
			stageP = new Stage();
			for(ContabilitàAgente  ca: GestioneContabilitàDirezionaleController.getTecnici().values()) {
				somma1+=ca.getTotale();
				somma2+=ca.getTot_manodopera();
				somma3+=ca.getTot_inst();
			}
			for(ContabilitàAgente  ca: GestioneContabilitàDirezionaleController.getTecnici().values()) {
				somma4+=ca.getTot_man_str();
				somma5+=ca.getMan_str_Tyfon();
				somma6+=ca.getMan_ritorni_ordninaria();
			}
			somma1= (float) (Math.floor(somma1*100)/100);
			somma2= (float) (Math.floor(somma2*100)/100);
			somma3= (float) (Math.floor(somma3*100)/100);
			obs2.addAll(new PieChart.Data("Totale manutenzioni\n ordinarie", somma1),new PieChart.Data("Totale manodopera\n straordinarie", somma2),new PieChart.Data("Totale installazioni",somma3));
			root = new BorderPane();
			Scene scene = new Scene(root,1000, 1000);
			pieChart= new PieChart();
			pieChart.setData(obs2);
			pieChart.setTitle("Totale fatturato(\u20ac)");
			pieChart.setLegendSide(Side.BOTTOM);
			pieChart.setLegendVisible(true);
			root.setLeft(pieChart);
			label= new JFXTextField();
			label.setEditable(false);

			label.setFont(Font.font("Sanserif", FontWeight.BOLD, 15));
			pieChart.getData().stream().forEach(data->{data.getNode().addEventHandler(MouseEvent.ANY, e->{
				label.setText(data.getName()+" "+(Math.floor(data.getPieValue()*100)/100)+" \u20ac");
			});
			});



			root.setBottom(label);
			stageP.setScene(scene);
			obs3.addAll(new PieChart.Data("Totale manutenzioni\n straordinarie", somma4),new PieChart.Data("Totale straordinarie\n Tyfon", somma5),new PieChart.Data("Totale ritorni\n su ordinaria",somma6));


			pieChart2= new PieChart();
			pieChart2.setData(obs3);
			pieChart2.setTitle("Totale Ricevute e Appuntamenti");
			pieChart2.setLegendSide(Side.BOTTOM);
			pieChart2.setLegendVisible(true);
			root.setRight(pieChart2);
			pieChart2.getData().stream().forEach(data->{data.getNode().addEventHandler(MouseEvent.ANY, e->{
				label.setText(data.getName()+" "+data.getPieValue());
			});
			});
			BorderPane.setMargin(label,new  Insets(0,0,10, 120));








			stageP.setScene(scene);
			stageP.show();

		} else {
			stageP.show();
		}
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
	void doTeam(ActionEvent event) throws IOException {
		ModelMain.creaGrafo();
		ModelMain.creaGrafoRitorni();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Team.fxml"));
		AnchorPane root = (AnchorPane) loader.load();


		ModelMain model= new ModelMain();
		TeamController controller= loader.getController();
		controller.setModelMain(model);

		//root.setMaxSize(1200,1200);

		anchorpane.getChildren().setAll(root);
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

		FXMLLoader loader = new FXMLLoader(getClass().getResource("legenda.fxml"));

		SplitPane root = (SplitPane) loader.load();
		Scene scene = new Scene(root);

		Stage stage = new Stage();

		stage.setScene(scene);
		stage.show();



	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		for(ReportValoriTecnici rp: GestioneContabilitàDirezionaleController.getValori()) {
			obs.add(rp);
		}

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
		tecnico1.setCellValueFactory(new PropertyValueFactory<>("id"));
		tecnico.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tot_fatt.setCellValueFactory(new PropertyValueFactory<>("tot_fat"));
		ric_str.setCellValueFactory(new PropertyValueFactory<>("ric_str_vs_app"));
		ma_str.setCellValueFactory(new PropertyValueFactory<>("man_str_vs_app"));
		margine.setCellValueFactory(new PropertyValueFactory<>("margine"));
		aspett_1.setCellValueFactory(new PropertyValueFactory<>("asp_ricevuta"));
		Asp_2.setCellValueFactory(new PropertyValueFactory<>("asp_ricevuta_vs_app"));
		incidenza.setCellValueFactory(new PropertyValueFactory<>("incidenza_ritorni"));
		incidenza.setCellFactory(column -> new ChangeCell());
		ric_str.setCellFactory(column -> new ChangeCellRicevuteTyfon());

		table.setItems(obs);
		sp.setFitToHeight(true);
		sp.setFitToWidth(true);

	}

	public void setModelMain(ModelMain model) {
		this.model=model;
	}


}

