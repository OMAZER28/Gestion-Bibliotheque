package gestionBibliotheque.model;

public class Bibliothecaire extends Utilisateur {
	private int id;
	private String dateNaissance;
	
	public Bibliothecaire(String login, String mdp, String nom, int id, String dateNaissance) {
		super(login, mdp, nom);
		this.id = id;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
}
