package gestionBibliotheque.model.documents;

/** Class qui repr�sente un revue et qui h�rite de la classe document
@author 	lahrach omar, mazer omar
@version 	juin 2020
@see 		Document
*/

public class Revue extends Document {
	/** P�riodicit� d'un revue (hebdomadaire, quotidienne, mensuel) */
	private String periodicite;
	
	/** Date de parution d'un revue */
	private String dateParution;
	
	/** Un constructeur qui prend quatre param�tres pour retourner un objet revue
	@param		id un entier
	@param		titre une cha�ne de caract�res
	@param		periodicite une cha�ne de caract�res
	@param		dateParution une cha�ne de caract�res
	*/
	public Revue(int id, String titre, String periodicite,String dateParution) {
		super(id, titre);
		this.periodicite = periodicite;
		this.dateParution = dateParution;
	}
	
	/** Getter de la date de parution du revue
	@return		la valeur de la date de parution du livre dateParution
    */
	public String getDateParution() {
		return dateParution;
	}
	
	/** Setter de la date de parution du revue
	@param		dateParution une cha�ne de caract�res
    */
	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}
	
	/** Getter de la p�riodicit� du revue
	@return		la valeur de la p�riodicit� du revue periodicite
    */
	public String getPeriodicite() {
		return periodicite;
	}
	
	/** Setter de la p�riodicit� du revue
	@param		periodicite une cha�ne de caract�res
    */
	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet revue qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet revue
	@see		Document#toString()
    */
	@Override
	public String toString() {
		return super.toString() + ", P�riodicit� : " + periodicite + ", Date de parution : " + dateParution;
	}
	
	
}
