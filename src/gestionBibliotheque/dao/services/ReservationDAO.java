package gestionBibliotheque.dao.services;

import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.services.Reservation;
import gestionBibliotheque.model.utilisateurs.Adherant;


public class ReservationDAO {
	
	private Connection connection;
	
	public ReservationDAO() throws DAOException {
		
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
	
	public boolean addReservation(Reservation res) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		PreparedStatement req3 = null;
		String sql1,sql2,sql3;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String date=dateFormat.format(cal.getTime());
		try {
			sql1 = "SELECT nbMax FROM adherant where numLecteur = ?";
			req1 = connection.prepareStatement(sql1);
			req1.setInt(1, res.getNumLecteur());

			ResultSet rs= req1.executeQuery();
			int nbMax=0;
			while (rs.next()) {
				nbMax= rs.getInt("nbMax");
			}
			
			sql2 = "SELECT COUNT(*) as nbRes FROM reservation WHERE numLecteur=?";
			req2 = connection.prepareStatement(sql2);
			req2.setInt(1, res.getNumLecteur());

			ResultSet rs1= req2.executeQuery();
			int nbRes=0;
			while (rs1.next()) {
				nbRes= rs1.getInt("nbRes");
			}
			if(nbRes<nbMax) {
				sql3 = "INSERT INTO reservation(numLecteur, cote, date) VALUES (?, ?, ?)";
				req3 = connection.prepareStatement(sql3);
				req3.setInt(1, res.getNumLecteur());
				req3.setInt(2, res.getCote());
				req3.setString(3, date);
				req3.executeUpdate();
				return true;
			}
			else {
				return false;
			}
			
		} catch(SQLException e) {
			throw new DAOException("problème d'ajout de la  reservation ", e);
		}finally {
			close(req1);
			close(req2);
			close(req3);
		}
	}
	
	public void deleteReservation(Reservation res) throws DAOException{
		PreparedStatement req = null;
		String sql;
		try {
			sql = "DELETE FROM reservation WHERE numLecteur=? and cote=? ";
			req = connection.prepareStatement(sql);
			req.setInt(1, res.getNumLecteur());
			req.setInt(2, res.getCote());
			req.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("problème de suppression d'une réservation ", e);
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

