package DB;

import java.sql.*;
import java.util.ArrayList;

import Entity.Utente;

public class DBUtente {

	/*public ArrayList<Utente> estrai(){
		ArrayList<Utente> ArrayUtente = new ArrayList<Utente>();
		Connection conn = DBManager.getConnection();
		String query = "SELECT * FROM UTENTE";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ArrayUtente.add(new Utente(rs.getInt("ID"), rs.getString("NOME"), rs.getString("COGNOME"), rs.getString("DATA_NASCITA"), rs.getString("EMAIL"), rs.getInt("NUM_PATENTE"), rs.getInt("ANNO_PATENTE"), rs.getInt("SCAD_PATENTE"), rs.getString("USERNAME"), rs.getString("PASSWORD")));
			}
		}
		catch(Exception e) {}
		
		ArrayList<Utente> prova=ArrayUtente;
		for(Utente i:prova) {
			System.out.println(i);
		}
			return ArrayUtente;
	}*/
	
public static boolean query_login (String utente,String password) {


    try {
        Connection conn = DBManager.getConnection();

        String query = "SELECT * FROM UTENTE WHERE USERNAME=? AND PASSWORD=?";

        PreparedStatement pstmt = conn.prepareStatement(query);

        pstmt.setString(1, utente);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next())
            return true; 

    } catch (Exception e) {

    }
    return false;
    }

public static void RegistraUtente(String Nome, String Cognome, String Data_nascita, String Email, String Num_patente, int Anno_patente, int Scad_patente, String Utente,String Password) {
	try {
		
		Connection conn = DBManager.getConnection();
        String query = "SELECT MAX(ID) FROM UTENTE";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        query = "Insert into Utente values(?,?,?,?,?,?,?,?,?,?)";

        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, rs.getInt("MAX(ID)")+1);
        pstmt.setString(2, Nome);
        pstmt.setString(3, Cognome);
        pstmt.setString(4, Data_nascita);
        pstmt.setString(5, Email);
        pstmt.setString(6, Num_patente);
        pstmt.setInt(7, Anno_patente);
        pstmt.setInt(8, Scad_patente);
        pstmt.setString(9, Utente);
        pstmt.setString(10, Password);

        pstmt.executeUpdate();


    } catch (Exception e) {}
}
}