package gestionBibliotheque.model;

public class Revue extends Document {
	private String periodicite;

	public Revue(int id, String titre, String periodicite) {
		super(id, titre);
		this.periodicite = periodicite;
	}

	public String getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
}
