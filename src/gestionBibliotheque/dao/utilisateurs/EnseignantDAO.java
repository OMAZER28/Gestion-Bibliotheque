package gestionBibliotheque.dao.utilisateurs;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Enseignant;

public class EnseignantDAO {
	
	private Connection connection;
	
	public EnseignantDAO() throws DAOException {
		
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
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public void addEnseignant(Enseignant enseignant) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		PreparedStatement req3 = null;
		String sql1,sql2,sql3;
		try {
			sql1 = "INSERT INTO adherant(numLecteur, login, mdp, nbMax, nom) VALUES (0, ?, ?, ?, ?)";
			req1 = connection.prepareStatement(sql1);
			req1.setString(1, enseignant.getLogin());
			req1.setString(2, enseignant.getMdp());
			req1.setInt(3, 4);
			req1.setString(4, enseignant.getNom());
			req1.executeUpdate();
			
			sql2 = "SELECT numLecteur FROM Adherant WHERE login = ? and nom =?";
			req2 = connection.prepareStatement(sql2);
			req2.setString(1, enseignant.getLogin());
			req2.setString(2, enseignant.getNom());
			ResultSet rs= req2.executeQuery();
			int id=0;
			while (rs.next()) {
				id= rs.getInt("numLecteur");
			}
			sql3 = "INSERT INTO enseignant(numLecteur,departement) VALUES (?, ?)";
			req3 = connection.prepareStatement(sql3);
			req3.setInt(1, id);
			req3.setString(2, enseignant.getDepartement());
			req3.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout de l'enseignant " + enseignant.getNom(), e);
		}finally {
			close(req1);
			close(req2);
			close(req3);
		}
	}
	
	
	
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws DAOException {

		if (myRs != null) {
			try {
				myRs.close();
			} catch (SQLException e) {
				throw new DAOException("Error closing the ResultSet ... ", e);
			}
		}

		if (myStmt != null) {
			try {
				myStmt.close();
			} catch (SQLException e) {
				throw new DAOException("Error closing the Statement ... ", e);
			}
		}
		
		if (myConn != null) {
			try {
				myConn.close();
			} catch (SQLException e) {
				throw new DAOException("Error closing the Connection ... ", e);
			}
		}
	}
	
	private void close(Statement myStmt, ResultSet myRs) throws DAOException {
		close(null, myStmt, myRs);		
	}

	private void close(Statement myStmt) throws DAOException {
		close(null, myStmt, null);		
	}

}

