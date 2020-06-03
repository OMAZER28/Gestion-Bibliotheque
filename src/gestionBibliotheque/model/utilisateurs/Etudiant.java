package gestionBibliotheque.model.utilisateurs;

public class Etudiant extends Adherant {
	private String cne;
	private String adresse;
	private String filliere;
	
	public Etudiant(String login, String mdp, String nom, int numLecteur,  String cne, String adresse,
			String filliere) {
		super(login, mdp, nom, numLecteur, 2);
		this.cne = cne;
		this.adresse = adresse;
		this.filliere = filliere;
	}


	public String getCne() {
		return cne;
	}


	public void setCne(String cne) {
		this.cne = cne;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getFilliere() {
		return filliere;
	}


	public void setFilliere(String filliere) {
		this.filliere = filliere;
	}


	@Override
	public String toString() {
		return "";
	}
	
	
	
	
}
