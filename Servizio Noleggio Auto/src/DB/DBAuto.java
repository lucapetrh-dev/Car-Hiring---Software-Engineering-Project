package DB;


import java.sql.*;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import Entity.*;
import java.util.*;

import Control.GestoreNoleggio;

public class DBAuto {
	public static int dim=0;
	
/*	public ArrayList<Auto> estrai(){
		ArrayList<Auto> ArrayAuto = new ArrayList<Auto>();
		Connection conn = DBManager.getConnection();
		String query = "SELECT * FROM VEICOLO";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ArrayAuto.add(new Auto(rs.getInt("ID"),rs.getString("Modello"), rs.getFloat("Prezzo"), rs.getString("Targa"), rs.getInt("Capienza"), rs.getInt("Potenza"), rs.getString("Alimentazione"), rs.getString("Segmento"), rs.getBoolean("StatoVeicolo")));
			}
		}
		catch(Exception e) {}
		
		ArrayList<Auto> prova=ArrayAuto;
		for(Auto i:prova) {
			System.out.println(i);
		}
			return ArrayAuto;
	}
*/
	
	public static boolean query_targa (String targa) {


        try {
            Connection conn = DBManager.getConnection();

            String query = "SELECT * FROM VEICOLO WHERE TARGA=?";

            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, targa);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

				DBManager.closeConnection();
                return true;} 

        } catch (Exception e) {

        }

		DBManager.closeConnection();
        return false;
        }
	
public static Object[][] query_ricercatarga () {


        try {
            Connection conn = DBManager.getConnection();
            String query= "select  count(targa) from (select distinct targa  from noleggio  group by targa)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            dim=rs.getInt("count(targa)");
            Object [] []vect=new Object[dim][3];
            
             query = "select distinct targa,DataInizio,DataFine  from noleggio  group by targa";

             pstmt = conn.prepareStatement(query);
             rs = pstmt.executeQuery();
             
             int i=0;
            while(rs.next()) {
            	vect [i][0]=rs.getString("Targa");
            	vect [i][1]=rs.getString("DataInizio");
            	vect [i][2]=rs.getString("DataFine");
            	i++;
            }

				DBManager.closeConnection();
                return vect;

        } catch (Exception e) {

        }

		DBManager.closeConnection();
        return null;
        }

public static void create(String Modello,float Prezzo, String Targa, int Capienza, int Potenza, String Alimentazione, String Segmento, boolean StatoVeicolo) {

    try {
        Connection conn = DBManager.getConnection();

        String query = "SELECT MAX(ID) FROM VEICOLO ";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        Auto m = new Auto(rs.getInt("MAX(ID)")+1,Modello, Prezzo,Targa, Capienza,Potenza,Alimentazione, Segmento, StatoVeicolo);
        System.out.println(m);
            query = "INSERT INTO VEICOLO VALUES (?,?,?,?,?,?,?,?,'TRUE')";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,m.getID());
            pstmt.setString(2, m.getModello());
            pstmt.setFloat(3, m.getPrezzo());
            pstmt.setString(4, m.getTarga());
            pstmt.setInt(5, m.getCapienza());
            pstmt.setInt(6, m.getPotenza());
            pstmt.setString(7, m.getAlimentazione());
            pstmt.setString(8, m.getSegmento());
            //"+m.getID()+", '"+m.getModello()+"',"+m.getPrezzo()+",'"+m.getTarga()+"',"+m.getCapienza()+","+m.getPotenza()+",'"+m.getAlimentazione()+"','"+m.getSegmento()+"'
            //
            pstmt.executeUpdate();
    } catch (SQLException e) {
    }


}
	
public static void query_modifica (String Targa, boolean StatoVeicolo ) {
		try {
			//'"+dataInizio.toString()+"',datafine='"+dataFine.toString()+"' where targa='"+targa+"'";
			Connection conn = DBManager.getConnection();
			String sqlquery;
			if(StatoVeicolo)
				sqlquery = "update veicolo set StatoVeicolo= 'TRUE' where targa='"+Targa+"'";
			else sqlquery = "update veicolo set StatoVeicolo= 'FALSE' where targa='"+Targa+"'";
			
			PreparedStatement stmt = conn.prepareStatement(sqlquery);
			stmt.executeUpdate();
			DBManager.closeConnection();
	    } catch (Exception e) {

	    }

		DBManager.closeConnection();
	    }
	
	
	
/*static public ArrayList<Auto> ricercaVeicolo(int Capienza, int Potenza, String Alimentazione, String Segmento) {
        ArrayList<Auto> ArrayAuto = new ArrayList<Auto>();

        try {
            Connection conn = DBManager.getConnection();
            String query = "SELECT * FROM VEICOLO WHERE 1=1";
            if(Capienza!=0){
                query +=" AND CAPIENZA ="+Capienza;
                }

            if(Potenza != 0 ) {
                    query += " AND POTENZA ="+Potenza;
                }
            if(!Alimentazione.trim().isEmpty() ) {
                query+=" AND ALIMENTAZIONE = '"+Alimentazione+"'";
            }
            if(!Segmento.trim().isEmpty() ) {
                query+=" AND SEGMENTO = '"+Segmento+"'";
                System.out.println(query);
            }

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                ArrayAuto.add(new Auto(rs.getInt("ID"),rs.getString("Modello"), rs.getFloat("Prezzo"), rs.getString("Targa"), rs.getInt("Capienza"), rs.getInt("Potenza"), rs.getString("Alimentazione"), rs.getString("Segmento"), rs.getBoolean("StatoVeicolo")));
            }

        }
        catch(Exception e) {}

        return ArrayAuto;
    }*/

static public ArrayList<Auto>  RicercaAutoPerData(Date Inizio,Date Fine,String segm){
		ArrayList<Auto> ArrayAuto = new ArrayList<Auto>();

        try {
        	java.sql.Date sqlDate1 = new java.sql.Date(Inizio.getTime());
        	java.sql.Date sqlDate2 = new java.sql.Date(Fine.getTime());
            Connection conn = DBManager.getConnection();
            String query ="SELECT MODELLO,PREZZO,veicolo.TARGA,CAPIENZA,POTENZA,ALIMENTAZIONE,SEGMENTO FROM VEICOLO where targa not in (select targa from noleggio where ((DataInizio<='"+sqlDate1.toString()+"' and DataFine>='"+sqlDate1.toString()+"') or (DataInizio<='"+sqlDate2.toString()+"' and DataFine>='"+sqlDate2.toString()+"')) and segmento= '"+segm+"') and segmento='"+segm+"' and StatoVeicolo='TRUE'";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
            	Auto a=new Auto(0,rs.getString("Modello"), rs.getFloat("Prezzo"), rs.getString("Targa"), rs.getInt("Capienza"), rs.getInt("Potenza"), rs.getString("Alimentazione"), rs.getString("Segmento"), true);
                ArrayAuto.add(a);
            }

        }
        catch(Exception e) {}

        return ArrayAuto;}

public static Object[][] ricercaPerModifica () {


        try {
            Connection conn = DBManager.getConnection();
            String query= "select  count(targa) from (select distinct targa  from veicolo  group by targa)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            dim=rs.getInt("count(targa)");
            Object [] []vect=new Object[dim][3];
            
             query = "select distinct targa,Modello,StatoVeicolo  from veicolo  group by targa";

             pstmt = conn.prepareStatement(query);
             rs = pstmt.executeQuery();
             
             int i=0;
            while(rs.next()) {
            	vect [i][0]=rs.getString("Targa");
            	vect [i][1]=rs.getString("Modello");
            	vect [i][2]=rs.getString("StatoVeicolo");
            	i++;
            }

				DBManager.closeConnection();
                return vect;

        } catch (Exception e) {

        }

		DBManager.closeConnection();
        return null;
        }

}
