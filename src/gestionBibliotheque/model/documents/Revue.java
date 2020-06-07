package gestionBibliotheque.model.documents;

public class Revue extends Document {
	private String periodicite;
	private String dateParution;

	public Revue(int id, String titre, String periodicite,String dateParution) {
		super(id, titre);
		this.periodicite = periodicite;
		this.dateParution = dateParution;
	}

	public String getDateParution() {
		return dateParution;
	}

	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
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
