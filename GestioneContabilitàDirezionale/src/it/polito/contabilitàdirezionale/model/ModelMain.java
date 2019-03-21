package it.polito.contabilitàdirezionale.model;

import java.util.Map;

import it.polito.gestionecontabilitàdirezionale.db.GestioneContabilitàDAO;

public class ModelMain {

	public void getValori(Map<Integer, ContabilitàAgente> tecnici) {
		// TODO Auto-generated method stub
		GestioneContabilitàDAO dao = new GestioneContabilitàDAO();
		dao.getvalori(tecnici);
	}

}
