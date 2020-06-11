package gestionBibliotheque.model.documents;

/** Class qui repr�sente un exemplaire
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class Exemplaire {
	/** Cote d'un exemplaire */
	private int cote;
	
	/** Etat d'un exemplaire (bon �tat/mauvais �tat) */
	private String etat;
	
	/** Identifiant du livre qui a cet exemplaire (foreign key)*/
	private int idLivre;
	
	/** Un constructeur qui prend trois param�tres pour retourner un objet exemplaire
	@param		cote un entier
	@param		etat une cha�ne de caract�res
	@param		idLivre un entier
	*/
	public Exemplaire(int cote, String etat, int idLivre) {
		this.cote = cote;
		this.etat = etat;
		this.idLivre = idLivre;
	}
	
	/** Getter de la cote de l'exemplaire
	@return		la valeur de la cote de l'exemplaire cote
    */
	public int getCote() {
		return cote;
	}
	
	/** Setter de la cote de l'exemplaire
	@param		cote in entier
    */
	public void setCote(int cote) {
		this.cote = cote;
	}
	
	/** Getter de l'etat de l'exemplaire
	@return		la valeur de l'etat de l'exemplaire etat
    */
	public String getEtat() {
		return etat;
	}
	
	/** Setter de l'etat de l'exemplaire
	@param		etat une cha�ne de caract�res
    */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	/** Getter de l'id livre de l'exemplaire
	@return		la valeur l'id livre de l'exemplaire idLivre
    */
	public int getIdLivre() {
		return idLivre;
	}
	
	/** Setter de l'id livre de l'exemplaire
	@param		idLivre un entier
    */
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet exemplaire qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet exemplaire
    */
	@Override
	public String toString() {
		return "Cote : " + cote + ", Etat : " + etat + ", Id livre : " + idLivre;
	}
	
	
	

}
