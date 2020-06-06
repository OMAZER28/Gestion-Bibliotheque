package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.document.ExemplaireDAO;
import gestionBibliotheque.dao.document.LivreDAO;
import gestionBibliotheque.dao.document.RevueDAO;
import gestionBibliotheque.model.documents.Document;
import gestionBibliotheque.model.documents.Exemplaire;
import gestionBibliotheque.model.documents.Livre;
import gestionBibliotheque.model.documents.Revue;


public class DocumentController {
	private String op;
	private Document doc;
	private Exemplaire exemp;
	
	public DocumentController(String op, Document doc) {
		this.op = op;
		this.doc = doc;
		this.executeOp(op, doc);
	}

	public DocumentController(String op, Exemplaire exemp) {
		this.op = op;
		this.exemp = exemp;
		this.executeOp(op, exemp);
	}
	
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	public Exemplaire getExemp() {
		return exemp;
	}

	public void setExemp(Exemplaire exemp) {
		this.exemp = exemp;
	}
	
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
