package gestionBibliotheque.dao.utilisateurs;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Etudiant;

public class EtudiantDAO {
	
	private Connection connection;
	
	public EtudiantDAO() throws DAOException {
		
		Properties dbprops = new Properties();
		try {
			
			dbprops.load(new FileInputStream("dbprops.properties"));
		} catch(IOException e) {
			throw new DAOException("problème de chargement des informations de la base de donnée...", e);
		}
		String user, password, dburl;
		user = dbprops.getProperty("user");
		password = dbprops.getProperty("password");
		dburl = dbprops.getProperty("dburl");
		
		
		try {
			connection = DriverManager.getConnection(dburl, user, password);
		} catch(SQLException e) {
			throw new DAOException("problème de connexion au base de donnée " + dburl + "...", e);
		}
	}
	
	public void addEtudiant(Etudiant etudiant) throws DAOException{
		PreparedStatement req1;
		String sql1;
		try {
			sql1 = "INSERT INTO adherant(numLecteur, login, mdp, nbMax, nom) VALUES (null, ?, ?, ?, ?)";
			req1 = connection.prepareStatement(sql1);
			req1.setString(1, etudiant.getLogin());
			req1.setString(2, etudiant.getMdp());
			req1.setInt(3, 100);
			req1.setString(4, etudiant.getNom());
			req1.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout de l'étudiant " + etudiant.getNom(), e);
		}
	}
}

