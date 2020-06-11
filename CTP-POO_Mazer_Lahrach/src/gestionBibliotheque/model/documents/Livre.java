package gestionBibliotheque.model.documents;

/** Class qui repr�sente un livre et qui h�rite de la classe document
@author 	lahrach omar, mazer omar
@version 	juin 2020
@see 		Document
*/

public class Livre extends Document {
	/** Nom de l'�diteur d'un livre */
	private String nomEditeur;
	
	/** Auteur d'un livre */
	private String auteur;
	
	/** Un constructeur qui prend quatre param�tres pour retourner un objet livre
	@param		id un entier
	@param		titre une cha�ne de caract�res
	@param		nomEditeur une cha�ne de caract�res
	@param		auteur une cha�ne de caract�res
	*/
	public Livre(int id, String titre, String nomEditeur, String auteur) {
		super(id, titre);
		this.nomEditeur = nomEditeur;
		this.auteur = auteur;
	}
	
	/** Getter de nom de l'�diteur du livre
	@return		la valeur de nom de l'�diteur du livre nomEditeur
    */
	public String getNomEditeur() {
		return nomEditeur;
	}
	
	/** Setter de nom de l'�diteur du livre
	@param		nomEditeur une cha�ne de caract�res
    */
	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}
	
	/** Getter de l'auteur du livre
	@return		la valeur de l'auteur du livre auteur
    */
	public String getAuteur() {
		return auteur;
	}
	
	/** Setter de l'auteur du livre
	@param		auteur une cha�ne de caract�res
    */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet livre qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet livre
	@see		Document#toString()
    */
	@Override
	public String toString() {
		return super.toString() + ", Nom de l'�diteur : " + nomEditeur + ", Auteur : " + auteur;
	}
	
	
	
}
