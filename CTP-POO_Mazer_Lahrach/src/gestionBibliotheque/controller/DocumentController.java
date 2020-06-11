package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.document.ExemplaireDAO;
import gestionBibliotheque.dao.document.LivreDAO;
import gestionBibliotheque.dao.document.RevueDAO;
import gestionBibliotheque.model.documents.Document;
import gestionBibliotheque.model.documents.Exemplaire;
import gestionBibliotheque.model.documents.Livre;
import gestionBibliotheque.model.documents.Revue;

/** Class qui repr�sente un controlleur des documents
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class DocumentController {
	/** L'op�ration voulu du controlleur (ex: ajouter un document)*/
	private String op;
	/** Le document (livre/revue) controll�*/
	private Document doc;
	/** L'exemplaire controll� */
	private Exemplaire exemp;
	
	/** Un premier constructeur qui prend deux param�tres pour retourner un objet document controller
	 *  et qui va ex�cuter l'op�ration op sur le document doc
	@param		op une cha�ne de caract�res
	@param		doc un Document
	*/
	public DocumentController(String op, Document doc) {
		this.op = op;
		this.doc = doc;
		this.executeOp(op, doc);
	}
	
	/** Un deuxi�me constructeur qui prend deux param�tres pour retourner un objet document controller
	 *  et qui va ex�cuter l'op�ration op sur l'exemplaire doc
	@param		op une cha�ne de caract�res
	@param		exemp un Exemplaire
	*/
	public DocumentController(String op, Exemplaire exemp) {
		this.op = op;
		this.exemp = exemp;
		this.executeOp(op, exemp);
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
	
	/** Getter du document (livre/revue)
	@return		le r�f�rence de l'objet document doc
    */
	public Document getDoc() {
		return doc;
	}
	
	/** Setter du document � controller
	@param		doc un Document
    */
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	/** Getter de l'exemplaire
	@return		le r�f�rence de l'objet exemplaire exemp
    */
	public Exemplaire getExemp() {
		return exemp;
	}
	
	/** Setter de l'exemplaire � controller
	@param		exemp un Exemplaire
    */
	public void setExemp(Exemplaire exemp) {
		this.exemp = exemp;
	}
	
	/** M�thode executeOp qui va ex�cuter l'op�ration op sur le document doc
	@param		op une cha�ne de caract�res
	@param		doc un Document
    */
	public void executeOp(String op, Document doc) {
		if(this.getOp()=="add") {
			if(doc instanceof Livre ) {
				try {
					LivreDAO livreDAO= new LivreDAO();
					livreDAO.addLivre((Livre) doc);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
			else if(doc instanceof Revue ) {
				try {
					RevueDAO revueDAO= new RevueDAO();
					revueDAO.addRevue((Revue) doc);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
		}
		else if(this.getOp()=="delete") {
			if(doc instanceof Livre ) {
				try {
					LivreDAO livreDAO= new LivreDAO();
					livreDAO.deleteLivre((Livre) doc);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
			else if(doc instanceof Revue ) {
				try {
					RevueDAO revueDAO= new RevueDAO();
					revueDAO.deleteRevue((Revue) doc);
					} catch(DAOException ex) {
						System.out.println(ex);
					}
			}
		}
	}
	
	/** M�thode executeOp qui va ex�cuter l'op�ration op sur l'exemplaire exemp
	@param		op une cha�ne de caract�res
	@param		exemp un Exemplaire
    */
	public void executeOp(String op, Exemplaire exemp) {
		if(this.getOp()=="add") {
			try {
				ExemplaireDAO exempDAO= new ExemplaireDAO();
				exempDAO.addExemplaire(exemp);
				} catch(DAOException ex) {
					System.out.println(ex);
				}
			}
		else if(this.getOp()=="delete") {
			try {
				ExemplaireDAO exempDAO= new ExemplaireDAO();
				exempDAO.deleteExemplaire(exemp);
				} catch(DAOException ex) {
					System.out.println(ex);
				}
			}
	}
	
}
