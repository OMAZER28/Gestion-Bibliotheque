package gestionBibliotheque.model.utilisateurs;

public class Enseignant extends Adherant {
	private String departement;

	public Enseignant(String login, String mdp, String nom, int numLecteur, int nbMax, String departement) {
		super(login, mdp, nom, numLecteur, nbMax);
		this.departement = departement;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
}
