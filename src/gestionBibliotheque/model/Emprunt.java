package gestionBibliotheque.model;

public class Emprunt {
	private int numLecteur;
	private int cote;
	private String dateDebut;
	private String dateFin;
	private int idBibliothecaire;
	
	public Emprunt(int numLecteur, int cote, String dateDebut, String dateFin, int idBibliothecaire) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idBibliothecaire = idBibliothecaire;
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

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdBibliothecaire() {
		return idBibliothecaire;
	}

	public void setIdBibliothecaire(int idBibliothecaire) {
		this.idBibliothecaire = idBibliothecaire;
	}

	@Override
	public String toString() {
		return "";
	}
	
	

	
}
