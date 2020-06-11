package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.utilisateurs.EtudiantDAO;
import gestionBibliotheque.dao.utilisateurs.EnseignantDAO;
import gestionBibliotheque.dao.utilisateurs.AdherantDAO;
import gestionBibliotheque.dao.utilisateurs.BibliothecaireDAO;
import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;
import gestionBibliotheque.model.utilisateurs.Etudiant;
import gestionBibliotheque.model.utilisateurs.Enseignant;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

/** Class qui repr�sente un controlleur des utilisateurs
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class UtilisateurController {
	/** L'op�ration voulu du controlleur (ex: ajouter un utilisateur)*/
	private String op;
	/** L'utilisateur � controller*/
	private Utilisateur user;
	
	/** Un constructeur qui prend deux param�tres pour retourner un objet utilisateur controller
	 *  et qui va ex�cuter l'op�ration op sur l'utilisateur user
	@param		op une cha�ne de caract�res
	@param		user un Utilisateur
	*/
	public UtilisateurController(String op, Utilisateur user) {
		this.op = op;
		this.user = user;
		this.executeOp(op, user);
	}
	
	/** Getter de l'op�ration
	@return		la valeur de l'op�ration op
    */
	public String getOp() {
		return op;
	}
	
	/** Setter de l'op�ration
	@param		op une cha�ne de caract�re
    */
	public void setOp(String op) {
		this.op = op;
	}
	
	/** Getter de l'utilisateur
	@return		le r�f�rence de l'objet utilisateur user
    */
	public Utilisateur getUser() {
		return user;
	}
	
	/** Setter de l'utilisateur
	@param		user un Utilisateur
    */
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	/** M�thode executeOp qui va ex�cuter l'op�ration op sur l'utilisateur user
	@param		op une cha�ne de caract�res
	@param		user un Utilisateur
    */
	public void executeOp(String op, Utilisateur user) {
		if(this.getOp()=="add") {
			if(user instanceof Bibliothecaire ) {
				try {
					BibliothecaireDAO bibDAO= new BibliothecaireDAO();
					bibDAO.addBibliothecaire((Bibliothecaire) user);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
			else if(user instanceof Etudiant ) {
				try {
					EtudiantDAO etDAO= new EtudiantDAO();
					etDAO.addEtudiant((Etudiant) user);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
			else if(user instanceof Enseignant) {
				try {
					EnseignantDAO enDAO= new EnseignantDAO();
					enDAO.addEnseignant((Enseignant) user);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
			
		}
		else if(this.getOp()=="delete") {
			try{
				AdherantDAO adDAO = new AdherantDAO();
				adDAO.deleteAdherant((Adherant)user);
			} catch(DAOException ex) {
				System.out.println(ex);
			}
		}
	}
	
}
