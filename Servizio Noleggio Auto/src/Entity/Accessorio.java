package Entity;

public class Accessorio {
	int ID;
	String descrizione;
	float prezzo;
	String tipo;
	
	
	public Accessorio(int ID, String descrizione, float prezzo) {
		this.ID=ID;
		this.descrizione=descrizione;
		this.prezzo=prezzo;
		this.tipo = tipo;
	}
	
	public String toString() {
        return ("\nID: "+this.ID+
        		" Descrizione: "+this.descrizione+
        		" Prezzo: "+this.prezzo);
    }
    
    public int getID() {
    	return ID;
    }
    public String getModello() {
    	return descrizione;
    }
    public float getPrezzo() {
    	return prezzo;
    }
    public String getTipo() {
    	return tipo;
    }
}
