package gestionBibliotheque.model;

public class Document {
	protected int id;
	protected String titre;
	
	public Document(int id, String titre) {
		this.id = id;
		this.titre = titre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "";
	}
	
	

}
