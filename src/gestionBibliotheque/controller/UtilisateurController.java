package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.utilisateurs.EtudiantDAO;
import gestionBibliotheque.model.utilisateurs.Etudiant;

public class UtilisateurController {
	//input fields
	private String userNameInput;
	private String emailInput;
	private String motDePasseInput;
	private String cneInput;
	private String adresseInput;
	private String dateNaissanceInput;
	private String filliereList;
	private String departementList;
	//user
	private String user;
	//dao
	private EtudiantDAO etudiantDAO;
	//modal
	private Etudiant etudiant;
	
	public UtilisateurController(String user,
								 String userNameInput,
								 String emailInput, 
								 String motDePasseInput, 
								 String cneInput, 
								 String adresseInput, 
								 String filliereList, 
								 String departementList, 
								 String dateNaissanceInput) {
		try {
			etudiantDAO = new EtudiantDAO();
		} catch(DAOException e) {
			System.out.println(e.getMessage());
		}
		this.user = user;
		this.userNameInput = userNameInput;
		this.emailInput = emailInput;
		this.motDePasseInput = motDePasseInput;
		this.cneInput = cneInput;
		this.adresseInput = adresseInput;
		this.filliereList = filliereList;
		this.departementList = departementList;
		this.dateNaissanceInput = dateNaissanceInput;
	}
	
	public void inscription() {
		if(user == "etudiant") {
			etudiant = new Etudiant(emailInput,  motDePasseInput,  userNameInput, 1, 20,  cneInput,  adresseInput, filliereList);
			try {
				etudiantDAO.addEtudiant(etudiant);
			} catch(DAOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
