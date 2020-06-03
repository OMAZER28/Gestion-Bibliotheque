package gestionBibliotheque.model.documents;

public class Exemplaire {
	private int cote;
	private String etat;
	private int idLivre;
	
	public Exemplaire(int cote, String etat, int idLivre) {
		this.cote = cote;
		this.etat = etat;
		this.idLivre = idLivre;
	}

	public int getCote() {
		return cote;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	

}
