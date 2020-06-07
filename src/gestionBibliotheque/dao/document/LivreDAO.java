package gestionBibliotheque.dao.document;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.documents.Livre;
import gestionBibliotheque.model.utilisateurs.Etudiant;


public class LivreDAO {
	
	private Connection connection;
	
	public LivreDAO() throws DAOException {
		
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
	
	public void addLivre(Livre l) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "INSERT INTO livre (id, titre, nomEditeur, auteur) VALUES (0, ?, ?, ?) ";
			req = connection.prepareStatement(sql);
			req.setString(1, l.getTitre());
			req.setString(2, l.getNomEditeur());
			req.setString(3, l.getAuteur());
			req.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout d'un livre " + l.getTitre(), e);
		}finally {
			close(req);
		}
	}
	
	public void deleteLivre(Livre l) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "DELETE FROM livre WHERE titre=? and nomEditeur=? and auteur=?";
			req = connection.prepareStatement(sql);
			req.setString(1, l.getTitre());
			req.setString(2, l.getNomEditeur());
			req.setString(3, l.getAuteur());
			req.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("problème de suppression d'un livre " + l.getTitre(), e);
		}finally {
			close(req);
		}
	}
	
	public int getIdByTitre(String titre) throws DAOException{
		PreparedStatement req = null;
		ResultSet rs = null;
		int id=0;
		String sql;
		try {
			
			sql = "SELECT id FROM livre WHERE titre = ? ";
			req = connection.prepareStatement(sql);
			req.setString(1, titre);
			rs = req.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
			
			return id;
		} catch(SQLException e) {
			throw new DAOException("problème de recherche d'un id de livre ", e);
		}finally {
			close(req);
		}
	}
	
	public static String[] add(int n, String arr[], String x) 
    { 
        int i; 
        String newarr[] = new String[n + 1]; 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
        newarr[n] = x; 
        return newarr; 
    } 
	
	public String[] getAllTitre() throws DAOException {
		Statement req = null;
		ResultSet rs = null;
		String sql;
		String[] tab= {};
		String titre = "";
		int i = 0;
		try {
			req = connection.createStatement();
			sql = "SELECT DISTINCT titre FROM livre ";
			rs = req.executeQuery(sql);
			
			while (rs.next()) {
				titre = rs.getString("titre");
				tab=add(i,tab,titre);
				i++;
			}

			return tab;
		}catch(SQLException e) {
			throw new DAOException("problème d'obtention d'un titre de livre " , e);
		}finally {
			close(req);
		}
	}
	
	
	public List<Livre> getAllLivre() throws DAOException {
		List<Livre> list = new ArrayList<Livre>();
		
		Statement req = null;
		ResultSet rs = null;
		String sql;
		
		try {
			req = connection.createStatement();
			sql = "SELECT * FROM livre ";
			rs = req.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String nomEditeur = rs.getString("nomEditeur");
				String auteur = rs.getString("auteur");
				
				Livre l = new Livre(id,titre,nomEditeur,auteur);
				list.add(l);
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("problème d'affichage de la liste des livres ", e);
		}finally {
			close(req, rs);
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

