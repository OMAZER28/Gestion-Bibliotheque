package gestionBibliotheque.model.utilisateurs;

/** Class qui repr�sente un enseignant et qui h�rite de la classe Adherant
@author 	lahrach omar, mazer omar
@version 	juin 2020
@see 		Adherant
*/

public class Enseignant extends Adherant {
	/** D�partement d'un enseignant */
	private String departement;
	
	/** Un constructeur qui prend cinq param�tres pour retourner un objet enseignant
	@param		login une cha�ne de caract�res
	@param		mdp une cha�ne de caract�res
	@param		nom une cha�ne de caract�res
	@param		numLecteur un entier
	@param		departement une cha�ne de caract�res
	*/
	public Enseignant(String login, String mdp, String nom, int numLecteur, String departement) {
		super(login, mdp, nom, numLecteur, 4);
		this.departement = departement;
	}
	
	/** Getter de d�partement de l'enseignant
	@return		la valeur de d�partement departement
    */
	public String getDepartement() {
		return departement;
	}
	
	/** Setter de d�partement de l'enseignant
	@param		departement une cha�ne de caract�re
    */
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet enseignant qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet enseignant
	@see		Adherant#toString()
    */
	@Override
	public String toString() {
		return super.toString() + ", D�partement : " + departement;
	}
	
	
	
}
