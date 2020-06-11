package gestionBibliotheque.model.utilisateurs;

/** Class qui repr�sente un utilisateur
@author		lahrach omar, mazer omar
@version	juin 2020
*/

public class Utilisateur {
	/** Login d'un utilisateur */
	protected String login;
	
	/** Mot de passe d'un utilisateur */
	protected String mdp;
	
	/** Nom d'un utilisateur */
	protected String nom;
	
	/** Un premier constructeur qui prend deux param�tres pour retourner un objet utilisateur
	@param		login une cha�ne de caract�res
	@param		mdp une cha�ne de caract�res
	*/
	public Utilisateur(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}
	
	/** Un deuxi�me constructeur qui prend trois param�tres pour returner un objet utilisateur
	@param		login une cha�ne de caract�res
	@param		mdp une cha�ne de caract�res
	@param		nom une cha�ne de caract�res	
	*/
	public Utilisateur(String login, String mdp, String nom) {
		this(login, mdp);
		this.nom = nom;
	}
	
	/** Getter du login de l'utilisateur
	@return		la valeur du login login
    */
	public String getLogin() {
		return login;
	}
	
	/** Setter du login de l'utilisateur 
	@param      login une cha�ne de caract�res 
	*/
	public void setLogin(String login) {
		this.login = login;
	}
	
	/** Getter du mot de passe de l'utilisateur
	@return		la valeur du mot de passe mdp
    */
	public String getMdp() {
		return mdp;
	}
	
	/** Setter du mot de passe de l'utilisateur 
	@param      mdp une cha�ne de caract�res
	*/
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	/** Getter du nom de l'utilisateur
	@return 	la valeur du nom nom
    */
	public String getNom() {
		return nom;
	}
	
	/** Setter du nom de l'utilisateur
	@param      nom une cha�ne de caract�res
	*/
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/** M�thode qui retourne une repr�sentation d'un objet utilisateur qui est facile � lire pour une personne.
	@return 	la repr�sentation d'un objet utilisateur
    */
	@Override
	public String toString() {
		return "Login : " + login + ", Mot de passe : " + mdp + ", Nom : " + nom;
	}	
}
