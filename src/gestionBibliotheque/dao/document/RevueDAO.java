package gestionBibliotheque.dao.document;

import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.documents.Livre;
import gestionBibliotheque.model.documents.Revue;


public class RevueDAO {
	
	private Connection connection;
	
	public RevueDAO() throws DAOException {
		
		Properties dbprops = new Properties();
		try {
			dbprops.load(new FileInputStream("dbprops.properties"));
		} catch(IOException e) {
			throw new DAOException("probl�me de chargement des informations de la base de donn�e...", e);
		}
		String user, password, dburl;
		user = dbprops.getProperty("user");
		password = dbprops.getProperty("password");
		dburl = dbprops.getProperty("dburl");
		
		
		try {
			connection = DriverManager.getConnection(dburl, user, password);
		} catch(SQLException e) {
			throw new DAOException("probl�me de connexion au base de donn�e " + dburl + "...", e);
		}
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public void addRevue(Revue r) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "INSERT INTO revue (id, titre, periodicite, dateParution) VALUES (0, ?, ?, ?) ";
			req = connection.prepareStatement(sql);
			req.setString(1, r.getTitre());
			req.setString(2, r.getPeriodicite());
			req.setString(3, r.getDateParution());
			req.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("probl�me d'ajout d'une revue " + r.getTitre(), e);
		}finally {
			close(req);
		}
	}
	
	public void deleteRevue(Revue r) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "DELETE FROM revue WHERE titre=? and periodicite=? and dateParution=?";
			req = connection.prepareStatement(sql);
			req.setString(1, r.getTitre());
			req.setString(2, r.getPeriodicite());
			req.setString(3, r.getDateParution());
			req.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("probl�me de suppression d'une revue " + r.getTitre(), e);
		}finally {
			close(req);
		}
	}
	
	public List<Revue> getAllRevue() throws DAOException {
		List<Revue> list = new ArrayList<Revue>();
		
		Statement req = null;
		ResultSet rs = null;
		String sql;
		
		try {
			req = connection.createStatement();
			sql = "SELECT * FROM revue ";
			rs = req.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String periodicite = rs.getString("periodicite");
				String dateParution = rs.getString("dateParution");
				
				Revue r = new Revue(id,titre,periodicite,dateParution);
				list.add(r);
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("probl�me d'affichage de la liste des revues ", e);
		}finally {
			close(req, rs);
		}
	}
	
	public List<Revue> searchRevue(String mot) throws DAOException {
		List<Revue> list = new ArrayList<Revue>();
		
		PreparedStatement req = null;
		String sql;
		
		try {
			sql = "SELECT * FROM revue where titre LIKE ? ";
			req = connection.prepareStatement(sql);
			req.setString(1,"%"+mot+"%");
			ResultSet rs= req.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String periodicite = rs.getString("periodicite");
				String dateParution = rs.getString("dateParution");

				Revue r = new Revue(id,titre,periodicite,dateParution);
				list.add(r);
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("probl�me de recherche de la liste des revues ", e);
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

