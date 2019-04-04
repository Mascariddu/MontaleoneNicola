package it.polito.gestionecontabilitàdirezionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;


import it.polito.contabilitàdirezionale.model.ContabilitàAgente;
import it.polito.contabilitàdirezionale.model.ReportValoriTecnici;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;


public class GestioneContabilitàDAO {
	static ObservableList<PieChart.Data> obs2;
	public void getvalori(Map<Integer, ContabilitàAgente> tecnici) {
		// TODO Auto-generated method stub
		String sql="Select*\n" + 
				"from ProduzioneAgenti";
		Connection conn = DBConnect.getConnection(); 
		try {

			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res=st.executeQuery();	
			while(res.next()) {
				tecnici.put(res.getInt("id"),new ContabilitàAgente(res.getInt("id"),res.getString("Nome"), res.getInt("1 Installazioni"), res.getFloat("1 Totale"),res.getInt("2 Tot_Man_Str"), res.getFloat("2 Totale"),res.getInt("3 Ricambi"), res.getFloat("3 Totale"),res.getInt("4 Accessori"), res.getFloat("4 Totale"),res.getInt("5 Manodopera"), res.getFloat("5 Totale"),res.getInt("6 CostoManodopera"), res.getFloat("6 Totale"),res.getInt("7 LIFO"), res.getFloat("7 Totale"),res.getInt("8 Man_Ord_Reali"), res.getFloat("2 Totale"),res.getInt("9 Man_Ord_Pot"), res.getFloat("9 Totale"),res.getInt("10 Man_Str_TYFON"),res.getInt("11 Man_Str_Ritorni"),res.getInt("12 Man_Rit_suOrdinarie"),res.getInt("13 Man_Ordinarie_TYFON")));
			}



		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public ObservableList<PieChart.Data> getData(ReportValoriTecnici rvt) {
		// TODO Auto-generated method stub
		obs2=FXCollections.observableArrayList();
		String sql="Select `1 Totale`, `2 Totale`, `8 Totale`\n" + 
				"from ProduzioneAgenti\n" + 
				"where `id`=?";
		Connection conn = DBConnect.getConnection(); 
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1,rvt.getId());
			ResultSet res = preparedStatement.executeQuery();



			while (res.next()) {
				PieChart.Data d1 = new PieChart.Data("installazioni ",res.getFloat("1 Totale"));
				PieChart.Data d2 = new PieChart.Data( "manodopera\nstraordinarie",res.getFloat("2 Totale"));
				PieChart.Data d3 = new PieChart.Data("manutenzioni\n ordinarie", res.getFloat("8 Totale"));
				obs2.add(d1);
				obs2.add(d2);
				obs2.add(d3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obs2;
	}
	public static ObservableList<PieChart.Data> removeList() {
		return obs2;
	}

	public String TeamProposto(ReportValoriTecnici rvt) {
		// TODO Auto-generated method stub
		String nome1="";
		String nome2="";
		String sql="Select p1.`Nome` nome1, p2.`Nome` nome2, max((p2.`1 Totale`-p1.`1 Totale`)) as min1\n" + 
				"from ProduzioneAgenti p1, ProduzioneAgenti p2\n" + 
				"where (p2.`id`=?\n" + 
				"or p1.`id`=?)\n" + 
				"and p1.id!=p2.`id`\n" + 
				"and (p2.`1 Totale`-p1.`1 Totale`)>0";
		Connection conn = DBConnect.getConnection(); 
		try {

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,rvt.getId());
			st.setInt(2,rvt.getId());
			ResultSet res=st.executeQuery();	
			while(res.next()) {
				nome1=res.getString("nome1");
				nome2=res.getString("nome2");
			}



		} catch (SQLException e) {
			e.printStackTrace();

		}
		return "TecnicoA: "+nome1+"\n"
		+ "TecnicoB: "+nome2;
	}

}
