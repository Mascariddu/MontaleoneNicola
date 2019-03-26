package it.polito.gestionecontabilitàdirezionale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


import it.polito.contabilitàdirezionale.model.ContabilitàAgente;

public class GestioneContabilitàDAO {

	public void getvalori(Map<Integer, ContabilitàAgente> tecnici) {
		// TODO Auto-generated method stub
		String sql="Select*\n" + 
				"from ProduzioneAgenti";
		Connection conn = DBConnect.getConnection(); 
		try {

			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res=st.executeQuery();	
			while(res.next()) {
				tecnici.put(res.getInt("id"),new ContabilitàAgente(res.getInt("id"),res.getString("Nome"), res.getInt("1 Installazioni"), res.getFloat("1 Totale"),res.getInt("2 Tot_Man_Str"), res.getFloat("2 Totale"),res.getInt("3 Ricambi"), res.getFloat("3 Totale"),res.getInt("4 Accessori"), res.getFloat("4 Totale"),res.getInt("5 Manodopera"), res.getFloat("5 Totale"),res.getInt("6 CostoManodopera"), res.getFloat("6 Totale"),res.getInt("7 LIFO"), res.getFloat("7 Totale"),res.getInt("8 Man_Ord_Reali"), res.getFloat("8 Totale"),res.getInt("9 Man_Ord_Pot"), res.getFloat("9 Totale"),res.getInt("10 Man_Str_TYFON"),res.getInt("11 Man_Str_Ritorni"),res.getInt("12 Man_Rit_suOrdinarie"),res.getInt("13 Man_Ordinarie_TYFON")));
			}



		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

}
