package gestionBibliotheque.dao.utilisateurs;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Etudiant;

public class AdherantDAO {
	
	private Connection connection;
	
	public AdherantDAO() throws DAOException {
		
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
	
	public Adherant getAdherant(String Login,String Mdp) throws DAOException{
		PreparedStatement req = null;
		ResultSet rs = null;
		String sql;
		Adherant ad = null;
		try {
			sql = "SELECT * FROM adherant WHERE login=? and mdp=?";
			req = connection.prepareStatement(sql);
			req.setString(1, Login);
			req.setString(2, Mdp);
			rs=req.executeQuery();
			
			while(rs.next()) {
				int numLecteur = rs.getInt("numLecteur");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				String nom = rs.getString("nom");
				int nbMax = rs.getInt("nbmax");
				ad = new Adherant(login,mdp,nom,numLecteur,nbMax);
			}
			return ad;
			
		} catch(SQLException e) {
			throw new DAOException("problème de verification d'un adherant " + ad.getNom(), e);
		}finally {
			close(req);
		}
	}
	
	public void verifyAdherant(Adherant ad) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "UPDATE adherant SET isVerified = 1 WHERE login=? and nom=? and isVerified=0 ";
			req = connection.prepareStatement(sql);
			req.setString(1, ad.getLogin());
			req.setString(2, ad.getNom());
			req.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème de verification d'un adherant " + ad.getNom(), e);
		}finally {
			close(req);
		}
	}
	
	public void deleteAdherant(Adherant ad) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "DELETE FROM adherant WHERE login=? and nom=? and mdp=? ";
			req = connection.prepareStatement(sql);
			req.setString(1, ad.getLogin());
			req.setString(2, ad.getNom());
			req.setString(3, ad.getMdp());
			req.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème de suppression d'un adherant " + ad.getNom(), e);
		}finally {
			close(req);
		}
	}
	
	public List<Adherant> getNotVerifiedAdherant() throws DAOException {
		List<Adherant> list = new ArrayList<Adherant>();
		
		Statement req = null;
		ResultSet rs = null;
		String sql;
		
		try {
			req = connection.createStatement();
			sql = "SELECT * FROM adherant WHERE isVerified = 0 ";
			rs = req.executeQuery(sql);
			
			while (rs.next()) {
				int numLecteur = rs.getInt("numLecteur");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				String nom = rs.getString("nom");
				int nbMax = rs.getInt("nbmax");
				Adherant ad = new Adherant(login,mdp,nom,numLecteur,nbMax);
				list.add(ad);
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("problème d'affichage de la liste des adherants ", e);
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

