package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.utilisateurs.EtudiantDAO;
import gestionBibliotheque.dao.utilisateurs.EnseignantDAO;
import gestionBibliotheque.dao.utilisateurs.AdherantDAO;
import gestionBibliotheque.dao.utilisateurs.BibliothecaireDAO;
import gestionBibliotheque.dao.utilisateurs.UtilisateurDAO;
import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;
import gestionBibliotheque.model.utilisateurs.Etudiant;
import gestionBibliotheque.model.utilisateurs.Enseignant;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

public class UtilisateurController {
	private String op;
	private Utilisateur user;
	
	public UtilisateurController(String op, Utilisateur user) {
		this.op = op;
		this.user = user;
		this.executeOp(op, user);
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
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
