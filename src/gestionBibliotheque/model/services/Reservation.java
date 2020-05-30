package gestionBibliotheque.model.services;

public class Reservation {
	private int numLecteur;
	private int cote;
	private int date;
	
	public Reservation(int numLecteur, int cote, int date) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.date = date;
	}

	public int getNumLecteur() {
		return numLecteur;
	}

	public void setNumLecteur(int numLecteur) {
		this.numLecteur = numLecteur;
	}

	public int getCote() {
		return cote;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
	
}
