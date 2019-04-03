package it.polito.contabilitàdirezionale.model;


import java.util.LinkedList;
import java.util.Map;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.gestionecontabilitàdirezionale.Controller.GestioneContabilitàDirezionaleController;
import it.polito.gestionecontabilitàdirezionale.db.GestioneContabilitàDAO;
import javafx.collections.ObservableList;

import javafx.scene.chart.PieChart.Data;


public class ModelMain {
	static SimpleWeightedGraph<ReportValoriTecnici, DefaultWeightedEdge> grafo=new SimpleWeightedGraph<ReportValoriTecnici, DefaultWeightedEdge>(DefaultWeightedEdge.class);

	static double peso=0.0;
	static LinkedList<TecnicoTeam> team= new LinkedList<TecnicoTeam>();
	static LinkedList<TecnicoTeamRitorni> teamritorni= new LinkedList<TecnicoTeamRitorni>();
	static SimpleWeightedGraph<ReportValoriTecnici, DefaultWeightedEdge> grafo2=new SimpleWeightedGraph<ReportValoriTecnici, DefaultWeightedEdge>(DefaultWeightedEdge.class);
	public void getValori(Map<Integer, ContabilitàAgente> tecnici) {
		// TODO Auto-generated method stub
		GestioneContabilitàDAO dao = new GestioneContabilitàDAO();
		dao.getvalori(tecnici);
	}

	public static void creaGrafo() {
		// TODO Auto-generated method stub


		

		Map<Integer, ReportValoriTecnici> map1=GestioneContabilitàDirezionaleController.getValori2();
		Map<Integer, ReportValoriTecnici> map2=GestioneContabilitàDirezionaleController.getValori2();
		
		for(ReportValoriTecnici tecnico1: map1.values()) {
         

			for(ReportValoriTecnici tecnico2: map2.values()) {
                
				peso=tecnico1.getTot_fat()-tecnico2.getTot_fat();
				if(peso>0) {
				
					if(!grafo.containsVertex(tecnico1))
						grafo.addVertex(tecnico1);
					if(!grafo.containsVertex(tecnico2))
						grafo.addVertex(tecnico2);
					if(!grafo.containsEdge(tecnico1, tecnico2) && !grafo.containsEdge(tecnico2, tecnico1)) {
						DefaultWeightedEdge edge= new DefaultWeightedEdge();
						edge = grafo.addEdge(tecnico1, tecnico2);
						grafo.setEdgeWeight(edge, peso);
						peso= Math.floor(peso*100)/100;
						TecnicoTeam t= new TecnicoTeam(tecnico1.getId(), tecnico1.getNome(), tecnico2.getId(), tecnico2.getNome(),peso);
						team.add(t);
                         

					}

				}
			}

		}



	}

	public static SimpleWeightedGraph<ReportValoriTecnici, DefaultWeightedEdge> getGrafo() {
		return grafo2;
	}

	public static LinkedList<TecnicoTeam> getTeam() {
		return team;
	}

	public static void creaGrafoRitorni() {
		// TODO Auto-generated method stub
		int peso=0;

		Map<Integer, ReportValoriTecnici> map1=GestioneContabilitàDirezionaleController.getValori2();
		Map<Integer, ReportValoriTecnici> map2=GestioneContabilitàDirezionaleController.getValori2();
		for(ReportValoriTecnici tecnico1: map1.values()) {


			for(ReportValoriTecnici tecnico2: map2.values()) {
				peso=(int) (tecnico1.getRic_str_vs_app()+tecnico2.getRic_str_vs_app());
				//peso=(int) (tecnico1.getRic_str_vs_app()-tecnico2.getRic_str_vs_app());
				if(tecnico1.getRic_str_vs_app()<=15 && tecnico2.getRic_str_vs_app()>15 && peso<=45) {
				
					if(!grafo2.containsVertex(tecnico1))
						grafo2.addVertex(tecnico1);
					if(!grafo2.containsVertex(tecnico2))
						grafo2.addVertex(tecnico2);
					if(!grafo2.containsEdge(tecnico1, tecnico2) && !grafo2.containsEdge(tecnico2, tecnico1)) {
						DefaultWeightedEdge edge= new DefaultWeightedEdge();
						edge = grafo2.addEdge(tecnico1, tecnico2);
						grafo2.setEdgeWeight(edge, peso);

						TecnicoTeamRitorni t= new TecnicoTeamRitorni(tecnico1.getId(), tecnico1.getNome(), tecnico2.getId(), tecnico2.getNome(),peso);
						teamritorni.add(t);


					}

				}
			}

		}


	}
	public static LinkedList<TecnicoTeamRitorni> getTeamRitorni() {
		return teamritorni;
	}

	public static LinkedList<TecnicoTeam> getTeamNome() {
		return team;
	}

	public static ObservableList<Data> initPieArea(ReportValoriTecnici rvt) {
		// TODO Auto-generated method stub
		GestioneContabilitàDAO dao = new GestioneContabilitàDAO();
		dao.getData(rvt);
		return dao.getData(rvt);
		
	}

	public static String getTeamProposto(ReportValoriTecnici rvt) {
		// TODO Auto-generated method stub
		GestioneContabilitàDAO dao = new GestioneContabilitàDAO();
		return dao.TeamProposto(rvt);
	}

	
	
	

}
