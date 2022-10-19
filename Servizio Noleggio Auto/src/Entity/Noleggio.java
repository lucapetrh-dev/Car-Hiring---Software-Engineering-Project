package Entity;

import java.sql.Date;

public class Noleggio {
    String Guidatore;
    String Targa;
    Date DataInizio;
    Date DataFine;
    float PrezzoTotale;
    //String Accessorio;
    
    public Noleggio(String Guidatore, String Targa, Date DataInizio, Date DataFine, float PrezzoTotale) {
        
        this.Guidatore=Guidatore;
        this.Targa=Targa;
        this.DataInizio=DataInizio;
        this.DataFine=DataFine;
        this.PrezzoTotale=PrezzoTotale;
        //this.Accessorio=Accessorio;
        
    }
    public String toString() {
        return (
        		" \nGuidatore: "+this.Guidatore+
        		" Targa: "+this.Targa+
        		" DataInizio: "+this.DataInizio+
        		" DataFine: "+this.DataFine+
        		" Prezzo: "+this.PrezzoTotale);
        		//" Accessorio: "+this.Accessorio);
    }
    
    public String getGuidatore() {
    	return Guidatore;
    }
    public float getPrezzoTotale() {
    	return PrezzoTotale;
    }
    public String getTarga() {
    	return Targa;
    }
    public Date getDataInizio() {
    	return DataInizio;
    }
    public Date getDataFine() {
        return DataFine;
    } 
    /*public String Accessorio() {
    	return Accessorio;
    }*/
}