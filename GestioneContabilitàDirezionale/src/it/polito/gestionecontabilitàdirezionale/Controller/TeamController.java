package it.polito.gestionecontabilitàdirezionale.Controller;

/**
 * Sample Skeleton for 'Team.fxml' Controller Class
 */



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;


import it.polito.contabilitàdirezionale.model.ContabilitàAgente;
import it.polito.contabilitàdirezionale.model.ModelMain;
import it.polito.contabilitàdirezionale.model.ReportValoriTecnici;
import it.polito.contabilitàdirezionale.model.TecnicoTeam;
import it.polito.contabilitàdirezionale.model.TecnicoTeamRitorni;


import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import java.util.function.Predicate;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
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

	@FXML
	private JFXComboBox<ReportValoriTecnici> combobox;

	@FXML 
	private JFXTextArea setArea;
	@FXML 
	private PieChart pie;

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
	private TableView<TecnicoTeam> table1; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<TecnicoTeam, Integer> ida1; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<TecnicoTeam, Integer> idb1; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<TecnicoTeam, Double> fatturato1; // Value injected by FXMLLoader

	@FXML // fx:id="tecnicoa1"
	private TableColumn<TecnicoTeam,String> tecnicoa1; // Value injected by FXMLLoader

	@FXML // fx:id="tecnicob1"
	private TableColumn<TecnicoTeam, String> tecnicob1; // Value injected by FXMLLoader

	@FXML // fx:id="enter2"
	private JFXTextField enter2; // Value injected by FXMLLoader

	@FXML // fx:id="enter2"
	private JFXTextField enterf; // Value injected by FXMLLoader

	@FXML // fx:id="enter2"
	private JFXTextField enterr; // Value injected by FXMLLoader

	@FXML // fx:id="Incidenza_ritorni"
	private Tab Incidenza_ritorni; // Value injected by FXMLLoader

	@FXML // fx:id="table2"
	private TableView<TecnicoTeamRitorni> table2; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<TecnicoTeamRitorni, Integer> ida2; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<TecnicoTeamRitorni, Integer> idb2; // Value injected by FXMLLoader

	@FXML // fx:id="tecnicoa2"
	private TableColumn<TecnicoTeamRitorni, String> tecnicoa2; // Value injected by FXMLLoader

	@FXML // fx:id="tecnicob2"
	private TableColumn<TecnicoTeamRitorni, String> tecnicob2; // Value injected by FXMLLoader

	@FXML // fx:id="tecnico"
	private TableColumn<TecnicoTeamRitorni, Double> ritorni; // Value injected by FXMLLoader

	@FXML // fx:id="enter"
	private JFXTextField enter; // Value injected by FXMLLoader
	@FXML // fx:id="sp"
	private ScrollPane sp; // Value injected by FXMLLoader

	ObservableList<TecnicoTeam> obs= FXCollections.observableArrayList();
	FilteredList<TecnicoTeam> flist = new FilteredList<TecnicoTeam>(obs, e->true);


	ObservableList<TecnicoTeamRitorni> obs2= FXCollections.observableArrayList();
	FilteredList<TecnicoTeamRitorni> flist2 = new FilteredList<TecnicoTeamRitorni>(obs2, e->true);
	@FXML
	void doReport(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Report.fxml"));
		AnchorPane root = (AnchorPane) loader.load();


		ModelMain model= new ModelMain();
		ReportController controller= loader.getController();
		controller.setModelMain(model);

		//root.setMaxSize(1200,1200);

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
		enter.textProperty().addListener((observable,oldvalue,newValue) -> {
			flist2.setPredicate((Predicate<? super TecnicoTeamRitorni >) (TecnicoTeamRitorni t)->{
				if(newValue.isEmpty() || newValue==null) {
					return true;
				} else if (t.getNome1().contains(newValue.toUpperCase()) || t.getNome2().contains(newValue.toUpperCase())) {
					return true;
				}

				return false;
			});
		});
		SortedList<TecnicoTeamRitorni> sort= new SortedList<TecnicoTeamRitorni>(flist2);
		sort.comparatorProperty().bind(table2.comparatorProperty());
		table2.setItems(sort);
	}


	@FXML
	void enterrit(KeyEvent event) {
		enterr.textProperty().addListener((observable,oldvalue,newValue) -> {
			flist2.setPredicate((Predicate<? super TecnicoTeamRitorni >) (TecnicoTeamRitorni t)->{
				if(newValue.isEmpty() || newValue==null) {
					return true;
				} 
				else if (t.getRitorni()<=Integer.parseInt(newValue))  {
					return true;
				} 

				return false;
			});
		});
		SortedList<TecnicoTeamRitorni> sort= new SortedList<TecnicoTeamRitorni>(flist2);
		sort.comparatorProperty().bind(table2.comparatorProperty());
		table2.setItems(sort);
	}

	@FXML
	void entername2(KeyEvent event) {
		enter2.textProperty().addListener((observable,oldvalue,newValue) -> {
			flist.setPredicate((Predicate<? super TecnicoTeam >) (TecnicoTeam t)->{
				if(newValue.isEmpty() || newValue==null) {
					return true;
				} else if (t.getNome1().contains(newValue.toUpperCase()) || t.getNome2().contains(newValue.toUpperCase())) {
					return true;
				} 

				return false;
			});
		});
		SortedList<TecnicoTeam> sort= new SortedList<TecnicoTeam>(flist);
		sort.comparatorProperty().bind(table1.comparatorProperty());
		table1.setItems(sort);

	}

	@FXML
	void enterfat(KeyEvent event) {
		enterf.textProperty().addListener((observable,oldvalue,newValue) -> {
			flist.setPredicate((Predicate<? super TecnicoTeam >) (TecnicoTeam t)->{
				if(newValue.isEmpty() || newValue==null) {
					return true;
				} else if (t.getFatturato()>=Integer.parseInt(newValue)) {
					return true;
				} 

				return false;
			});
		});
		SortedList<TecnicoTeam> sort= new SortedList<TecnicoTeam>(flist);
		sort.comparatorProperty().bind(table1.comparatorProperty());
		table1.setItems(sort);

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

	@FXML
	void combo(ActionEvent event) {

		ContabilitàAgente ca=null;

		ReportValoriTecnici rvt= combobox.getValue();

		String resultSpace="\n";
		String result2="";
		pie.getData().clear();
		pie.setTitle("Fatturato: "+rvt.getNome());
		pie.getData().addAll(ModelMain.initPieArea(rvt));

		String result=ModelMain.getTeamProposto(rvt);

		for(ContabilitàAgente c : GestioneContabilitàDirezionaleController.getTecnici().values())  {
			if(c.getId()==rvt.getId()) {
				ca=c;
			}
		}

		for(ReportValoriTecnici t5 :Graphs.neighborListOf(ModelMain.getGrafo(), rvt)) {
			result2+="Tecnico A: "+t5.getNome()+" \nTecnico B: "+rvt.getNome()+resultSpace+"\n";
		}






		if(rvt.getIncidenza_ritorni()>=.25 && rvt.getRic_str_vs_app()<0 ) {
			if(ca.getTot_costomanodopera()>ca.getTot_manodopera()) {
				setArea.setText("Costo Manodopera("+ca.getTot_costomanodopera()+")>Ricavi("+ca.getTot_manodopera()+")\nIndice che non vengono "
						+ "richiesti i corrispettivi manodopera al cliente in misura corretta.\nTroppe ricevute a 0 verso quelle valorizzate.\n"
						+ "Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è negativo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria. "
						+ "Il risultato è da leggere quindi positivamente.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è negativo(deve essere minore di 0.25)+\" \\u20ac\""
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "-Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti.\n"
						+ "-Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi. "
						+ "ove è difficile richiedere il corrispettivo\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n "
						+ "PROPOSTA TEAM:\n"
						+ "\n"
						+result+"\n "
						+ "\n"
						+ result2+"\n "
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			} else {
				setArea.setText("Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è negativo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria. "
						+ "Il risultato è da leggere quindi positivamente.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è negativo(deve essere minore di 0.25)."
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti.\n"
						+ "Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ ""
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			}
		}
		if(rvt.getIncidenza_ritorni()<=.25 && rvt.getRic_str_vs_app()>0  ) {
			if(ca.getTot_costomanodopera()>ca.getTot_manodopera()) {
				setArea.setText("Costo Manodopera("+ca.getTot_costomanodopera()+")>Ricavi("+ca.getTot_manodopera()+")\nIndice che non vengono " 
						+ "richiesti i corrispettivi manodopera al cliente in misura corretta.\nTroppe ricevute a 0 verso quelle valorizzate.\n"
						+ "Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è postivo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria."
						+ "Il risultato è da leggere quindi negativamente\n"
						+ "E' AMMESSA la non ammissione della ricevuta fiscale solo nei casi\n"
						+ "di esecuzione contestuale della manutenzione ordinaria con straordinaria\n"
						+ "purchè non sia stato prelevato un cambio dal magazzino.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è positivo(deve essere minore di 0.25)"
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "-Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti\n"
						+ "-Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso"
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ ""
						+ "\n"
						+result+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			}else {
				setArea.setText("Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è positivo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria."
						+ "Il risultato è da leggere quindi negativamente.\n"
						+ "E' AMMESSA la non ammissione della ricevuta fiscale solo nei casi\n"
						+ "di esecuzione contestuale della manutenzione ordinaria con straordinaria\n"
						+ "purchè non sia stato prelevato un cambio dal magazzino.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è positivo(deve essere minore di 0.25)\n"
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti\n"
						+ "Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso"
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ "\n"
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			}
		}
		if(rvt.getIncidenza_ritorni()>=.25 && rvt.getRic_str_vs_app()>0  ) {
			if(ca.getTot_costomanodopera()>ca.getTot_manodopera()) {
				setArea.setText("Costo Manodopera("+ca.getTot_costomanodopera()+")>Ricavi("+ca.getTot_manodopera()+")\nIndice che non vengono " 
						+ "richiesti i corrispettivi manodopera al cliente in misura corretta.\nTroppe ricevute a 0 verso quelle valorizzate.\n"
						+ "Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è positivo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria."
						+ "Il risultato è da leggere quindi negativamente.\n"
						+ "E' AMMESSA la non ammissione della ricevuta fiscale solo nei casi\n"
						+ "di esecuzione contestuale della manutenzione ordinaria con straordinaria\n"
						+ "purchè non sia stato prelevato un cambio dal magazzino.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è negativo(deve essere minore di 0.25)\n"
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti.\n"
						+ "Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac \n "
						+ "\n"
						+ "TECNICO DA RICOLLOCARE");
			} else {
				setArea.setText("Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è positivo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria."
						+ "Il risultato è da leggere quindi negativamente.\n"
						+ "E' AMMESSA la non ammissione della ricevuta fiscale solo nei casi\n"
						+ "di esecuzione contestuale della manutenzione ordinaria con straordinaria\n"
						+ "purchè non sia stato prelevato un cambio dal magazzino.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è negativo(deve essere minore di 0.25).\n"
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti.\n"
						+ "Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ "\n"
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac \n"
						+ "\n"
						+ "TECNICO DA RICOLLOCARE");
			}

		}
		if(rvt.getIncidenza_ritorni()<=.25 && rvt.getRic_str_vs_app()<0 ) {
			if(ca.getTot_costomanodopera()>ca.getTot_manodopera()) {

				setArea.setText("Costo Manodopera("+ca.getTot_costomanodopera()+")>Ricavi("+ca.getTot_manodopera()+")\nIndice che non vengono "  
						+"richiesti i corrispettivi manodopera al cliente in misura corretta.\nTroppe ricevute a 0 verso quelle valorizzate.\n"
						+ "Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è negativo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria. "
						+ "Il risultato è da leggere quindi positivamente.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è positivo(deve essere minore di 0.25)\n"
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti\n"
						+ "Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ ""
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			}else {
				setArea.setText("Ricevute straordinarie vs appuntamenti: "+rvt.getRic_str_vs_app()+"\n"
						+ "Il dato in statistica è negativo, significa che il numero delle ricevute "
						+ "risulta essere maggiore degli appuntamenti in straordinaria: questo accade perchè la statistica\n"
						+ "considera validi anche gli appuntamenti in straordinaria con ordinaria. "
						+ "Il risultato è da leggere quindi positivamente.\n"
						+ "Incidenza ritorni: "+rvt.getIncidenza_ritorni()+"\n"
						+ "Il dato obiettivo è positivo(deve essere minore di 0.25)\n"
						+ "\n"
						+ "OBIETTIVI:\n"
						+ "\n"
						+ "Riduzione dei ritorni: Garantire a bordo vettura ricambi ricorrenti.\n"
						+ "Incrementare le ricevute fiscali con richiesta di corrispettivo al cliente, anche nei casi "
						+ "ove è difficile richiedere il corrispettivo.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ ""
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			}
		}
		else if(rvt.getIncidenza_ritorni()==.0 && rvt.getRic_str_vs_app()==0 ) {
			if(ca.getTot_costomanodopera()>ca.getTot_manodopera()) {
				setArea.setText("Costo Manodopera("+ca.getCostomanodopera()+")>Ricavi("+ca.getTot_manodopera()+")\nIndice che non vengono" 
						+ "richiesti i corrispettivi manodopera al cliente in misura corretta.\nTroppe ricevute a 0 verso quelle valorizzate.\n"
						+ "Valori insufficenti: assunzione temporanea per installazioni\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ "\n"
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n "
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			} else {
				setArea.setText("Valori insufficenti: assunzione temporanea per installazioni.\n"
						+ "Proposizione vendita di accessori sia durante le manutenzioni straordinarie che le manutenzioni ordinarie: cronotermostati, decalcificatori, cartucce di ricambio per decalcificatori. \n"
						+ "I dispositivi venduti devono essere installati contestualmente all’intervento in corso."
						+ "\n"
						+ "PROPOSTA TEAM:\n"
						+ "\n"
						+ "\n"
						+result+"\n"
						+ "\n"
						+ result2+"\n"
						+ "PREMIO INSTALLAZIONI: "+ca.getInstallazioni()*25+" \u20ac");
			}

		}

	} 

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		for(TecnicoTeam t : ModelMain.getTeam()) {

			obs.add(t);
		}
		for(TecnicoTeamRitorni t2 : ModelMain.getTeamRitorni()) {
			obs2.add(t2);
		}	

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
		assert ida1 != null : "fx:id=\"ida1\" was not injected: check your FXML file 'Team.fxml'.";
		assert idb1 != null : "fx:id=\"tecnicoa2\" was not injected: check your FXML file 'Team.fxml'.";
		assert fatturato1 != null : "fx:id=\"tecnicob2\" was not injected: check your FXML file 'Team.fxml'.";
		assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'Team.fxml'.";
		assert combobox != null : "fx:id=\"enter\" was not injected: check your FXML file 'Team.fxml'.";
		assert pie != null : "fx:id=\"enter\" was not injected: check your FXML file 'Team.fxml'.";
		ida1.setCellValueFactory(new PropertyValueFactory<>("id1"));
		idb1.setCellValueFactory(new PropertyValueFactory<>("id2"));
		fatturato1.setCellValueFactory(new PropertyValueFactory<>("fatturato"));
		tecnicoa1.setCellValueFactory(new PropertyValueFactory<>("nome1"));
		tecnicob1.setCellValueFactory(new PropertyValueFactory<>("nome2"));
		table1.setItems(obs);
		sp.setFitToHeight(true);
		sp.setFitToWidth(true);
		ida2.setCellValueFactory(new PropertyValueFactory<>("id1"));
		idb2.setCellValueFactory(new PropertyValueFactory<>("id2"));
		ritorni.setCellValueFactory(new PropertyValueFactory<>("ritorni"));
		tecnicoa2.setCellValueFactory(new PropertyValueFactory<>("nome1"));
		tecnicob2.setCellValueFactory(new PropertyValueFactory<>("nome2"));
		table2.setItems(obs2);
		sp.setFitToHeight(true);
		sp.setFitToWidth(true);
		combobox.getItems().addAll(GestioneContabilitàDirezionaleController.getValori());




	}
	public void setModelMain(ModelMain model) {
		this.model=model;
	}
}

