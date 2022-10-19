package Entity;

import java.util.Date;

public class Utente {
    int ID;
    String Nome;
    String Cognome;
    String Data_nascita;
    String Email;
    int Num_patente;
    int Anno_patente;
    int Scad_patente;
    String Username;
    String Password;

    public Utente (int ID, String Nome, String Cognome, String Data_nascita, String Email, int Num_patente, int Anno_patente, int Scad_patente, String Username, String Password) {
        this.ID=ID;
    	this.Nome=Nome;
        this.Cognome=Cognome;
        this.Data_nascita=Data_nascita;
        this.Email=Email;
        this.Num_patente=Num_patente;
        this.Anno_patente=Anno_patente;
        this.Scad_patente=Scad_patente;
        this.Username=Username;
        this.Password=Password;
    }
    public String toString() {
        return ("\nID: "+this.ID+
        		"\nNome: "+this.Nome+
        		"\nCognome: "+this.Cognome+
        		"\nData_nascita: "+this.Data_nascita+
        		"\nEmail: "+this.Email+
        		"\nNumero Patente: "+this.Num_patente+
        		"\nAnno Patente: "+this.Anno_patente+
        		"\nScadenza Patente: "+this.Scad_patente+
        		"\nUsername: "+this.Username);
    }
}