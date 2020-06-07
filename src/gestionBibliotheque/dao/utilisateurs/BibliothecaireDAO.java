package gestionBibliotheque.dao.utilisateurs;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;

public class BibliothecaireDAO {
	
	private Connection connection;
	
	public BibliothecaireDAO() throws DAOException {
		
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
	
	public Bibliothecaire getBibliothecaire(String Login,String Mdp) throws DAOException{
		PreparedStatement req = null;
		ResultSet rs = null;
		String sql;
		Bibliothecaire bib = null;
		try {
			sql = "SELECT * FROM bibliothecaire WHERE login=? and mdp=?";
			req = connection.prepareStatement(sql);
			req.setString(1, Login);
			req.setString(2, Mdp);
			rs=req.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				String nom = rs.getString("nom");
				String dateNaissance = rs.getString("datenaissance");
				bib = new Bibliothecaire(id,login,mdp,nom,dateNaissance);
			}
			return bib;
			
		} catch(SQLException e) {
			throw new DAOException("problème de verification d'un adherant ", e);
		}finally {
			close(req);
		}
	}
	
	public void addBibliothecaire(Bibliothecaire bib) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "INSERT INTO bibliothecaire(id,login, mdp,nom,dateNaissance) VALUES (0, ?, ?, ?, ?)";
			req = connection.prepareStatement(sql);
			req.setString(1, bib.getLogin());
			req.setString(2, bib.getMdp());
			req.setString(3, bib.getNom());
			req.setString(4, bib.getDateNaissance());
			req.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout d'un bibliothecaire " + bib.getNom(), e);
		}finally {
			close(req);
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

