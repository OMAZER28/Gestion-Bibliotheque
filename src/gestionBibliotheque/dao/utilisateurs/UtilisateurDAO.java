package gestionBibliotheque.dao.utilisateurs;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

public class UtilisateurDAO {
	
	private Connection connection;
	
	public UtilisateurDAO() throws DAOException {
		
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
	
	public boolean signin(Utilisateur user) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		String sql1,sql2;
		int n=0;
		try {
			sql1 = "SELECT COUNT(*) as nb FROM adherant WHERE login= ? and mdp =?";
			req1 = connection.prepareStatement(sql1);
			req1.setString(1, user.getLogin());
			req1.setString(2, user.getMdp());
			ResultSet rs1= req1.executeQuery();
			while (rs1.next()) {
				n= n+rs1.getInt("nb");
			}
			

			sql2 = "SELECT COUNT(*) as nb FROM bibliothecaire WHERE login= ? and mdp =?";
			req2 = connection.prepareStatement(sql2);
			req2.setString(1, user.getLogin());
			req2.setString(2, user.getMdp());
			ResultSet rs2= req2.executeQuery();
			while (rs2.next()) {
				n= n+rs2.getInt("nb");
			}
			
			if(n==0) {
				return false;
			}else {
				return true;
			}
		} catch(SQLException e) {
			throw new DAOException("problème d'acces au compte utlisateur " + user.getLogin(), e);
		}finally {
			close(req1);
			close(req2);
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

