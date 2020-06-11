package gestionBibliotheque.model.services;

/** Class qui repr�sente une r�servation
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class Reservation {
	/** Num�ro de lecteur de l'adh�rent qui a r�server */
	private int numLecteur;
	
	/** Cote de l'exemplaire r�serv� */
	private int cote;
	
	/** Date d'une r�servation */
	private String date;
		
	/** Un premier constructeur qui prend deux param�tres pour retourner un objet r�servation
	@param		numLecteur un entier
	@param		cote un entier
	*/
	public Reservation(int numLecteur, int cote) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.date = "";
	}
	
	/** Un deuxi�me constructeur qui prend trois param�tres pour retourner un objet r�servation
	@param		numLecteur un entier
	@param		cote un entier
	@param		date une cha�ne de caract�res
	*/
	public Reservation(int numLecteur, int cote, String date) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.date = date;
	}
	
	/** Getter du num�ro de lecteur de l'adh�rant qui va r�server
	@return		la valeur du num�ro de lecteur de l'adh�rant qui va r�server numLecteur
    */
	public int getNumLecteur() {
		return numLecteur;
	}
	
	/** Setter du num�ro de lecteur de l'adh�rant qui va r�server
	@param		numLecteur un entier
    */
	public void setNumLecteur(int numLecteur) {
		this.numLecteur = numLecteur;
	}
	
	/** Getter de la cote de l'exemplaire r�serv�
	@return		la valeur de la cote de l'exemplaire r�serv� cote
    */
	public int getCote() {
		return cote;
	}
	
	/** Setter de la cote de l'exemplaire r�serv�
	@param		cote un entier
    */
	public void setCote(int cote) {
		this.cote = cote;
	}
	
	/** Getter de la date de r�servation
	@return		la valeur de la date de r�servation date
    */
	public String getDate() {
		return date;
	}
	
	/** Setter de la date de r�servation
	@param		date une cha�ne de caract�res
    */
	public void setDate(String date) {
		this.date = date;
	}

	/** M�thode qui retourne une repr�sentation d'un objet r�servation qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet r�servation
    */
	@Override
	public String toString() {
		return "Num�ro de lecteur : " +  numLecteur + ", Cote : " + cote + ", Date de r�servation : " + date;
	}
}
