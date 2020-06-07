package gestionBibliotheque.model.utilisateurs;

public class Adherant extends Utilisateur {
	protected int numLecteur;
	protected int nbMax;
	

	public Adherant(String login, String mdp, String nom, int numLecteur, int nbMax) {
		super(login, mdp, nom);
		this.numLecteur = numLecteur;
		this.nbMax = nbMax;
	}
	
	public int getNumLecteur() {
		return numLecteur;
	}
	public void setNumLecteur(int numLecteur) {
		this.numLecteur = numLecteur;
	}
	public int getNbMax() {
		return nbMax;
	}
	public void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}

	@Override
	public String toString() {
		return "Un adherant est connu par son numero de lecteur et le nombre maximal de livre qu'il"
				+ "peut emprunter";
	}

}
