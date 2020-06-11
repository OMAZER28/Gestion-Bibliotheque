package gestionBibliotheque.model.utilisateurs;

/** Class qui repr�sente un etudiant et qui h�rite de la classe Adherant
@author 	lahrach omar, mazer omar
@version 	juin 2020
@see 		Adherant
*/

public class Etudiant extends Adherant {
	/** Code national d'un �tudiant */
	private String cne;
	
	/** Adresse d'un �tudiant */
	private String adresse;
	
	/** Filliere d'un �tudiant */
	private String filliere;
	
	/** Un constructeur qui prend sept param�tres pour retourner un objet �tudiant
	@param		login une cha�ne de caract�res
	@param		mdp une cha�ne de caract�res
	@param		nom une cha�ne de caract�res
	@param		numLecteur un entier
	@param		cne une cha�ne de caract�res
	@param		adresse une cha�ne de caract�res
	@param		filliere une cha�ne de caract�res	
	*/
	public Etudiant(String login, String mdp, String nom, int numLecteur,  String cne, String adresse,
			String filliere) {
		super(login, mdp, nom, numLecteur, 2);
		this.cne = cne;
		this.adresse = adresse;
		this.filliere = filliere;
	}

	/** Getter du code national de l'�tudiant
	@return		la valeur du code national cne
    */
	public String getCne() {
		return cne;
	}

	/** Setter du code national de l'�tudiant
	@param		cne une cha�ne de caract�res 
    */
	public void setCne(String cne) {
		this.cne = cne;
	}

	/** Getter de l'adresse de l'enseignant
	@return		la valeur de l'adresse adresse
    */
	public String getAdresse() {
		return adresse;
	}

	/** Setter de l'adresse de l'enseignant
	@param	adresse une cha�ne de caract�res
    */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/** Getter de la filliere de l'�tudiant
	@return		la valeur de la filliere filliere
    */
	public String getFilliere() {
		return filliere;
	}

	/** Setter de la filliere de l'�tudiant
	@param	filliere une cha�ne de caract�res
    */
	public void setFilliere(String filliere) {
		this.filliere = filliere;
	}

	/** M�thode qui retourne une repr�sentation d'un objet �tudiant qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet �tudiant
	@see		Adherant#toString()
    */
	@Override
	public String toString() {
		return super.toString() + ", CNE : " + cne + ", Adresse : " + adresse + ", Filli�re : " + filliere;
	}
	
	
	
	
}
