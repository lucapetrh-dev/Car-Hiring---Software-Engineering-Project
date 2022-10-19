package Control;
import java.sql.Date;

import java.time.DateTimeException;
import java.util.*;

import DB.*;
import Entity.Auto;

//pattern singleton: restituisce solo un'istanza, non può costruire oggetti.

public class GestoreNoleggio {
	private static GestoreNoleggio instance = null;
	//costruttore privato// 
	private GestoreNoleggio() {}
	
	public static GestoreNoleggio getInstance() {
		if (instance == null) {
			instance = new GestoreNoleggio();
		}
			return instance;
	}
	public static void RegistraUtente(String Nome, String Cognome, String Data_nascita, String Email, String Num_patente, int Anno_patente, int Scad_patente, String Utente,String Password) {
		try {
			 DBUtente.RegistraUtente(Nome,Cognome,Data_nascita,Email,Num_patente,Anno_patente,Scad_patente,Utente,Password);	
			} catch (Exception e) {}
		}
	public static void EliminaNoleggio(String targa) {
		try {
		DBNoleggio.EliminaNoleggio(targa);
		}
		catch(Exception e) {}
	}
/*	public static ArrayList<Auto> RicercaAuto(int Capienza, int Potenza, String Alimentazione, String Segmento) {
		try {
			return DBAuto.ricercaVeicolo(Capienza, Potenza, Alimentazione, Segmento);	
			} catch (Exception e) {}
		return null;
		}
*/	public static Object [][] RicercaPerModifica() {
		try {
			return DBAuto.ricercaPerModifica();	
			} catch (Exception e) {}
		return null;
		}
	public static void AggiornaVeicolo(String targa, Date dataInizio, Date dataFine){
		try{DBNoleggio.AggiornaVeicolo(targa,  dataInizio,  dataFine);}
		catch(Exception e) {}
	}
	
public static Object [][] RicercaTarga(){
		try {

			return DBAuto.query_ricercatarga();	
			} catch (Exception e) {}
		return null;
		}
	
public static boolean InserisciAuto (String Modello, float prezzo , String targa, int capienza, int potenza,String alimentazione, String segmento, boolean StatoVeicolo) {
	    try {
	        if(!DBAuto.query_targa(targa)) {
	            DBAuto.create(Modello, prezzo,targa, capienza,potenza,alimentazione, segmento, StatoVeicolo);

				DBManager.closeConnection();
	            return true;
	        }

	    } catch (Exception e) {

	    }
	    return false;
	}
	
	public static boolean ModificaAuto ( String targa,boolean StatoVeicolo) {
		try {
			 {
				DBAuto.query_modifica(targa,StatoVeicolo);
				
				DBManager.closeConnection();
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	
public static boolean VerificaUtente(String utente, String password) {
	    try {
	        if(DBUtente.query_login(utente,password)) {
				DBManager.closeConnection();
	            return true;
	        }

	    } catch (Exception e) {		
	}
	    //System.out.print("Username o password errati\n");
		return false;
}

public static boolean VerificaOperatore(String utente, String password) {
    try {
        if(DBOperatore.query_login(utente,password)) {
			DBManager.closeConnection();
            return true;
        }

    } catch (Exception e) {		
}
    System.out.print("Username o password errati\n");
	return false;
}
	

public static String Noleggia(String utente,String targa, Date dataInizio, Date dataFinale, float PrezzoTotale,Object [] vect,int dim,String assic,String autista){
	String esito=null;
	if((dataFinale.getTime() - dataInizio.getTime())<0)return "La data di inizio e' minore della data finale, reinserisci !";
	if(DBAuto.query_targa(targa))
			esito=DBNoleggio.createNoleggio(utente, targa, dataInizio, dataFinale, PrezzoTotale,vect, dim,assic,autista);
			return esito;
		
}

	public static ArrayList<Auto> RicercaAutoPerDate(Date Inizio, Date Fine,String segm){
		try {
			return DBAuto.RicercaAutoPerData( Inizio, Fine, segm);	
			} catch (Exception e) {}
		return null;
		}
	
}