package gestionBibliotheque.dao.services;

import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.services.Emprunt;
import gestionBibliotheque.model.utilisateurs.Etudiant;



public class EmpruntDAO {
	
	private Connection connection;
	
	public EmpruntDAO() throws DAOException {
		
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
	
	
	public List<Object> getAllEmprunt(String numLecteur) throws DAOException {
		List<Object> list = new ArrayList<Object>();
		
		PreparedStatement req = null;
		String sql;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String date=dateFormat.format(cal.getTime());
		
		try {
			
			sql = "SELECT *,DATEDIFF(dateFin, ?) AS delai FROM emprunt WHERE numLecteur=?";
			req = connection.prepareStatement(sql);
			req.setString(1, date);
			req.setString(2, numLecteur);
			ResultSet rs= req.executeQuery();
			
			while (rs.next()) {
				int cote = rs.getInt("cote");
				String dateDebut = rs.getString("dateDebut");
				String dateFin = rs.getString("dateFin");
				String delai = rs.getString("delai");
				
				list.add(new Object[] {cote,dateDebut,dateFin,delai});
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("problème d'affichage de la liste des emprunts ", e);
		}finally {
			close(req);
		}
	}
	
	public List<Object> getAllEmprunt() throws DAOException {
		List<Object> list = new ArrayList<Object>();
		
		PreparedStatement req = null;
		String sql;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String date=dateFormat.format(cal.getTime());
		try {
			
			sql = "SELECT *,DATEDIFF(dateFin, ?) AS delai FROM emprunt group by numLecteur";
			req = connection.prepareStatement(sql);
			req.setString(1, date);
			ResultSet rs= req.executeQuery();
			
			while (rs.next()) {
				int numLecteur = rs.getInt("numLecteur");
				int cote = rs.getInt("cote");
				String dateDebut = rs.getString("dateDebut");
				String dateFin = rs.getString("dateFin");
				String delai = rs.getString("delai");
				
				list.add(new Object[] {numLecteur,cote,dateDebut,dateFin,delai});
			}

			return list;		
		}catch (SQLException e) {
			throw new DAOException("problème d'affichage de la liste des emprunts ", e);
		}finally {
			close(req);
		}
	}
	
	public boolean addEmprunt(Emprunt emp) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		PreparedStatement req3 = null;
		String sql1,sql2,sql3;
		int nbEmp = 0;
		int n = 0;
		try {
			sql1 = "SELECT COUNT(*) as nbEmp FROM emprunt WHERE numLecteur = ?";
			req1 = connection.prepareStatement(sql1);
			req1.setInt(1, emp.getNumLecteur());
			ResultSet rs1= req1.executeQuery();
			while (rs1.next()) {
				nbEmp= rs1.getInt("nbEmp");
			}
			
			sql2 = "SELECT COUNT(*) as n FROM reservation WHERE cote=?";
			req2 = connection.prepareStatement(sql2);
			req2.setInt(1, emp.getCote());
			ResultSet rs2= req2.executeQuery();
			while (rs2.next()) {
				n= rs2.getInt("n");
			}
			if(nbEmp<5 && n==0) {
				sql3 = "INSERT INTO emprunt(numLecteur, cote, dateDebut, dateFin,idBibliothecaire) VALUES (?, ?, ?, ?, ?)";
				req3 = connection.prepareStatement(sql3);
				req3.setInt(1, emp.getNumLecteur());
				req3.setInt(2, emp.getCote());
				req3.setString(3, emp.getDateDebut());
				req3.setString(4, emp.getDateFin());
				req3.setInt(5, emp.getIdBibliothecaire());
				req3.executeUpdate();
				return true;
			}
			else {
				return false;
			}
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout d'un emprunt ", e);
		}finally {
			close(req1);
			close(req2);
			close(req3);
		}
	}
	
	
	public void deleteEmprunt(Emprunt emp) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {

			sql = "DELETE FROM emprunt WHERE numLecteur = ? and cote = ?";
			req = connection.prepareStatement(sql);
			req.setInt(1, emp.getNumLecteur());
			req.setInt(2, emp.getCote());
			req.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème de suppression d'un emprunt ", e);
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

