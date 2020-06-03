package gestionBibliotheque.model.utilisateurs;

public class Utilisateur {
	protected String login;
	protected String mdp;
	protected String nom;
	
	public Utilisateur(String login, String mdp, String nom) {
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "";
	}	
}
