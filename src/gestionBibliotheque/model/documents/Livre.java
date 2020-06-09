package gestionBibliotheque.model.documents;

public class Livre extends Document {
	private String nomEditeur;
	private String auteur;
	
	public Livre(int id, String titre, String nomEditeur, String auteur) {
		super(id, titre);
		this.nomEditeur = nomEditeur;
		this.auteur = auteur;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
}
