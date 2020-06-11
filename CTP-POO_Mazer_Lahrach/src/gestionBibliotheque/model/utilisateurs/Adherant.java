package gestionBibliotheque.model.utilisateurs;

/** Class qui repr�sente un adh�rant et qui h�rite de la classe Utilisateur
@author 	lahrach omar, mazer omar
@version 	juin 2020
@see 		Utilisateur
*/

public class Adherant extends Utilisateur {
	/** Num�ro de lecteur , identifiant d'un adh�rant */
	protected int numLecteur;
	
	/** Nombre max de r�servation possible qu'un adh�rant peut faire(2 pour un �tudiant/4 pour un enseignant) */
	protected int nbMax;
	
	/** Un constructeur qui prend cinq param�tres pour retourner un objet adh�rant
	@param		login une cha�ne de caract�res
	@param		mdp une cha�ne de caract�res
	@param		nom une cha�ne de caract�res
	@param		numLecteur un entier
	@param		nbMax un entier	
	*/
	public Adherant(String login, String mdp, String nom, int numLecteur, int nbMax) {
		super(login, mdp, nom);
		this.numLecteur = numLecteur;
		this.nbMax = nbMax;
	}
	
	/** Getter du num�ro de lecteur de l'adh�rant
	@return		la valeur du num�ro de lecteur numLecteur
    */
	public int getNumLecteur() {
		return numLecteur;
	}
	
	/** Setter du num�ro de lecteur de l'adh�rant
	@param		numLecteur un entier
    */
	public void setNumLecteur(int numLecteur) {
		this.numLecteur = numLecteur;
	}
	
	/** Getter du nombre de max de r�servations de l'adh�rant
	@return		la valeur du nombre max de r�servations nbMax
    */
	public int getNbMax() {
		return nbMax;
	}
	
	/** Setter du nombre de max de r�servations de l'adh�rant 
	@param      nbMax un entier
	*/
	public void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet adh�rant qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet adh�rant
	@see		Utilisateur#toString()
    */
	@Override
	public String toString() {
		return super.toString() + ", Num�ro de lecteur : " + numLecteur + ", Nombre max de r�servation : " + nbMax;
	}

}
