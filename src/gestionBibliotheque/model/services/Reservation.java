package gestionBibliotheque.model.services;

public class Reservation {
	private int numLecteur;
	private int cote;
	private String date;
	
	public Reservation(int numLecteur, int cote, String date) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.date = date;
	}
	public Reservation(int numLecteur, int cote) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.date = "";
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
	
}
