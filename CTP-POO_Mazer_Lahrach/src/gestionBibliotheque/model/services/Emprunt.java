package gestionBibliotheque.model.services;

/** Class qui repr�sente un emprunt
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class Emprunt {
	/** Num�ro de lecteur d'un adh�rant pour un emprunt */
	private int numLecteur;
	
	/** Cote de l'exemplaire � emprunter */
	private int cote;
	
	/** Date de d�but d'un emprunt */
	private String dateDebut;
	
	/** Date de fin d'un emprunt */
	private String dateFin;
	
	/** Identifiant du bibliothecaire qui va r�aliser un emprunt */
	private int idBibliothecaire;
	
	/** Un constructeur qui prend cinq param�tres pour retourner un objet emprunt
	@param		numLecteur un entier
	@param		cote un entier
	@param		dateDebut une cha�ne de caract�res
	@param		dateFin une cha�ne de caract�res
	@param		idBibliothecaire un entier
	*/
	public Emprunt(int numLecteur, int cote, String dateDebut, String dateFin, int idBibliothecaire) {
		this.numLecteur = numLecteur;
		this.cote = cote;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idBibliothecaire = idBibliothecaire;
	}
	
	/** Getter de num�ro de lecteur pour l'emprunt
	@return		la valeur de num�ro de lecteur pour l'emprunt numLecteur
    */
	public int getNumLecteur() {
		return numLecteur;
	}
	
	/** Setter de num�ro de lecteur pour l'emprunt
	@param		numLecteur un entier
    */
	public void setNumLecteur(int numLecteur) {
		this.numLecteur = numLecteur;
	}
	
	/** Getter de la cote de l'exemplaire emprunt�
	@return		la valeur de la cote de l'exemplaire emprunt� cote
    */
	public int getCote() {
		return cote;
	}
	
	/** Setter de la cote de l'exemplaire � emprunter
	@param		cote un entier
    */
	public void setCote(int cote) {
		this.cote = cote;
	}
	
	/** Getter de la date de d�but de l'emprunt
	@return		la valeur de la date de d�but de l'emprunt dateDebut
    */
	public String getDateDebut() {
		return dateDebut;
	}
	
	/** Setter de la date de d�but de l'emprunt
	@param		dateDebut une cha�ne de caract�res
    */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	/** Getter de la date de d�but de l'emprunt
	@return		la valeur de la date de d�but de l'emprunt dateFin
    */
	public String getDateFin() {
		return dateFin;
	}
	
	/** Setter de la date de d�but de l'emprunt
	@param		dateFin une cha�ne de caract�res
    */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	/** Getter de l'id de bibliothecaire qui a r�aliser l'emprunt
	@return		la valeur de l'id de bibliothecaire qui a r�aliser l'emprunt idBibliothecaire
    */
	public int getIdBibliothecaire() {
		return idBibliothecaire;
	}
	
	/** Setter de l'id de bibliothecaire qui a r�aliser l'emprunt
	@param		idBibliothecaire un entier
    */
	public void setIdBibliothecaire(int idBibliothecaire) {
		this.idBibliothecaire = idBibliothecaire;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet emprunt qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet emprunt
    */
	@Override
	public String toString() {
		return "Num�ro de lecteur : " +  numLecteur + ", Cote : " + cote + ", Date de d�but : " + dateDebut + ", Date fin : " + dateFin + "Id bibliothecaire : " + idBibliothecaire;
	}
		
}
