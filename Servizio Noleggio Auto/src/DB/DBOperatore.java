package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBOperatore {
	public static boolean query_login (String utente,String password) {


	    try {
	        Connection conn = DBManager.getConnection();

	        String query = "SELECT * FROM OPERATORE WHERE USERNAME=? AND PASSWORD=?";

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
}
