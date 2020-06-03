package gestionBibliotheque.model.utilisateurs;

public class Enseignant extends Adherant {
	private String departement;

	public Enseignant(String login, String mdp, String nom, int numLecteur, String departement) {
		super(login, mdp, nom, numLecteur, 4);
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
