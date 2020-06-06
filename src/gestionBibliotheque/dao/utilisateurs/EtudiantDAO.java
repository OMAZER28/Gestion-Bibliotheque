package gestionBibliotheque.dao.utilisateurs;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Adherant;
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
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public void addEtudiant(Etudiant etudiant) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		PreparedStatement req3 = null;
		String sql1,sql2,sql3;
		try {
			sql1 = "INSERT INTO adherant(numLecteur, login, mdp, nbMax, nom,isVerified) VALUES (0, ?, ?, ?, ?,0)";
			req1 = connection.prepareStatement(sql1);
			req1.setString(1, etudiant.getLogin());
			req1.setString(2, etudiant.getMdp());
			req1.setInt(3, 2);
			req1.setString(4, etudiant.getNom());
			req1.executeUpdate();
			
			sql2 = "SELECT numLecteur FROM Adherant WHERE login = ? and nom =? and isVerified=0";
			req2 = connection.prepareStatement(sql2);
			req2.setString(1, etudiant.getLogin());
			req2.setString(2, etudiant.getNom());
			ResultSet rs= req2.executeQuery();
			int id=0;
			while (rs.next()) {
				id= rs.getInt("numLecteur");
			}
			sql3 = "INSERT INTO etudiant(numLecteur, cne, adresse, filliere) VALUES (?, ?, ?, ?)";
			req3 = connection.prepareStatement(sql3);
			req3.setInt(1, id);
			req3.setString(2, etudiant.getCne());
			req3.setString(3, etudiant.getAdresse());
			req3.setString(4, etudiant.getFilliere());
			req3.executeUpdate();
			
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout de l'étudiant " + etudiant.getNom(), e);
		}finally {
			close(req1);
			close(req2);
			close(req3);
		}
	}
	
	public void modifyEtudiant(Etudiant et,String login,String mdp,String nom,String cne,String adresse,String fil) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		PreparedStatement req3 = null;
		String sql1,sql2,sql3;
		try {
			sql1 = "UPDATE adherant SET login = ?, mdp = ?, nom = ? WHERE login=? and mdp=? and nom=?";
			req1 = connection.prepareStatement(sql1);
			req1.setString(1, login);
			req1.setString(2, mdp);
			req1.setString(3, nom);
			req1.setString(4, et.getLogin());
			req1.setString(5, et.getMdp());
			req1.setString(6, et.getNom());
			req1.executeUpdate();
			
			sql2 = "SELECT numLecteur FROM Adherant WHERE login = ? and nom =?";
			req2 = connection.prepareStatement(sql2);
			req2.setString(1, login);
			req2.setString(2, nom);
			ResultSet rs= req2.executeQuery();
			int id=0;
			while (rs.next()) {
				id= rs.getInt("numLecteur");
			}
			sql3 = "UPDATE etudiant SET cne = ?, adresse = ?, fillere = ? WHERE numLecteur=?";
			req3 = connection.prepareStatement(sql3);
			req3.setString(1, cne);
			req3.setString(2, adresse);
			req3.setString(3, fil);
			req3.setInt(4, id);
			req3.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème de modification d'un etudiant " + et.getNom(), e);
		}finally {
			close(req1);
			close(req2);
			close(req3);
		}
	}
	
	public List<Etudiant> getAllEtudiant() throws DAOException {
		List<Etudiant> list = new ArrayList<Etudiant>();
		
		Statement req = null;
		ResultSet rs = null;
		String sql;
		
		try {
			req = connection.createStatement();
			sql = "SELECT adherant.*,etudiant.cne as cne, etudiant.adresse as adresse ,etudiant.filliere as filliere FROM adherant INNER JOIN etudiant on adherant.numLecteur=etudiant.numLecteur where adherant.isVerified=1";
			rs = req.executeQuery(sql);
			
			while (rs.next()) {
				int numLecteur = rs.getInt("numLecteur");
				String login = rs.getString("login");
				String mdp = rs.getString("mdp");
				String nom = rs.getString("nom");
				String cne = rs.getString("cne");
				String adr = rs.getString("adresse");
				String fil = rs.getString("filliere");
				Etudiant et = new Etudiant(login,mdp,nom,numLecteur,cne,adr,fil);
				list.add(et);
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("problème d'affichage de la liste des etudiants ", e);
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

