package Entity;

public class Auto {
	int ID;
    String Modello;
    float Prezzo;
    String Targa;
    int Capienza;
    int Potenza;
    String Alimentazione;
    String Segmento;
    boolean StatoVeicolo;
    
    public Auto(int ID, String Modello,float Prezzo, String Targa, int Capienza, int Potenza, String Alimentazione, String Segmento, boolean StatoVeicolo) {
        this.ID=ID;
    	this.Modello=Modello;
        this.Prezzo=Prezzo;
        this.Targa=Targa;
        this.Capienza=Capienza;
        this.Potenza=Potenza;
        this.Alimentazione=Alimentazione;
        this.Segmento=Segmento;
        this.StatoVeicolo=StatoVeicolo;
    }
    public String toString() {
        return ("\nID: "+this.ID+
        		" Modello: "+this.Modello+
        		" Prezzo: "+this.Prezzo+
        		" Targa: "+this.Targa+
        		" Capienza: "+this.Capienza+
        		" Potenza: "+this.Potenza+
        		" Alimentazione: "+this.Alimentazione+
        		" Segmento: "+this.Segmento+
        		" Stato Veicolo: "+this.StatoVeicolo);
    }
    
    public int getID() {
    	return ID;
    }
    public String getModello() {
    	return Modello;
    }
    public float getPrezzo() {
    	return Prezzo;
    }
    public String getTarga() {
    	return Targa;
    }
    public int getCapienza() {
    	return Capienza;
    }
    public int getPotenza() {
    	return Potenza;
    }
    public String getAlimentazione() {
    	return Alimentazione;
    }
    public String getSegmento() {
        return Segmento;
    } 
    public boolean getStato() {
    	return StatoVeicolo;
    }
}