package DB;

import java.sql.*;
import java.util.concurrent.TimeUnit;
import Entity.Auto;
import Entity.Noleggio;


public class DBNoleggio {

public static boolean verificaNoleggio (String utente,String targa) {
    try {

        Connection conn = DBManager.getConnection();

        String query = "SELECT * FROM NOLEGGIO WHERE GUIDATORE=? AND TARGA=?";

        PreparedStatement pstmt = conn.prepareStatement(query);

        pstmt.setString(1, utente);
        pstmt.setString(2, targa);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {

			DBManager.closeConnection();
            return true; 
        }
    } catch (Exception e) {

    }

	DBManager.closeConnection();
    return false;
    }

public static void EliminaNoleggio(String targa) {
	 try {

		 Connection conn = DBManager.getConnection();
			
			String sqlquery = "DELETE FROM NOLEGGIO WHERE TARGA=?;";
		
			PreparedStatement stmt = conn.prepareStatement(sqlquery);
			stmt.setString(1, targa);
			
			stmt.executeUpdate();
				DBManager.closeConnection();
	    } catch (Exception e) {

	    }

		DBManager.closeConnection();
}
public static void AggiornaVeicolo(String targa, Date dataInizio, Date dataFine) {
	try {
		//'"+dataInizio.toString()+"',datafine='"+dataFine.toString()+"' where targa='"+targa+"'";
		Connection conn = DBManager.getConnection();
		
		String sqlquery = "update noleggio set datainizio= '"+dataInizio.toString()+"',datafine='"+dataFine.toString()+"' where targa='"+targa+"'";
		PreparedStatement stmt = conn.prepareStatement(sqlquery);
		System.out.println(sqlquery);
		stmt.executeUpdate();
		
		DBManager.closeConnection();
    } catch (Exception e) {

    }

	DBManager.closeConnection();
    }

public static String createNoleggio(String utente,String targa, Date dataInizio, Date dataFinale, float prezzoFinale,Object [] vect, int  dim,String assicurazione,String autista) {

    try {
        Connection conn = DBManager.getConnection();
        Noleggio m = new Noleggio(utente, targa, dataInizio, dataFinale, prezzoFinale);
        java.sql.Date sqlDate1 = new java.sql.Date(m.getDataInizio().getTime());
        java.sql.Date sqlDate2 = new java.sql.Date(m.getDataFine().getTime());
        long diff = dataFinale.getTime() - dataInizio.getTime();
        float price=m.getPrezzoTotale()*(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        String query;
        PreparedStatement pstmt;
        for(int i=0;i<dim;i++) {
        	query = "Select prezzo from accessorio where descrizione = '"+vect[i]+"'";// (?,?,?,?,?)";	
        	pstmt = conn.prepareStatement(query);
        	pstmt.executeQuery();

        	ResultSet rs = pstmt.executeQuery();

        	price=price+rs.getFloat("Prezzo");
        }
        for(int i=0;i<dim;i++) {
            query = "INSERT INTO NOLEGGIO VALUES (?,?,'"+sqlDate1.toString()+"','"+sqlDate2.toString()+"',"+(price)+",'"+vect[i]+"','"+assicurazione+"','"+autista+"')";// (?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getTarga());
            pstmt.setString(2, m.getGuidatore());
System.out.println(query);
            pstmt.executeUpdate();
        }
        
            return "Prezzo del noleggio registrato con successo dal: "+dataInizio+" al: "+dataFinale+" e' di :"+price;
    } catch (SQLException e) {
    }

    return "ok";
}

}
