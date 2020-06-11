package gestionBibliotheque.dao.utilisateurs;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;

/** Class qui permet la r�cup�ration des donn�es des bibliothecaires
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class BibliothecaireDAO {
	/** Connection permet de l'acc�e au base de donn�es */
	private Connection connection;
	
	/** Un constructeur qui r�alize une connexion
	 * @throws DAOException Exception
	 */
	public BibliothecaireDAO() throws DAOException {
		
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
	
	/** M�thode permettant de renvoyer un bibliothecaire par mot de passe et login
	 * @param Login une cha�ne de caract�res
	 * @param Mdp une cha�ne de caract�res
	 * @return le r�f�rence d'un objet bibliothecaire
	 * @throws DAOException une Exception
	 */
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
			throw new DAOException("probl�me de verification d'un adherant ", e);
		}finally {
			close(req);
		}
	}
	
	/** M�thode addBibliothecaire permet d'ajouter un Bibliothecaire
	 * @param bib un Bibliothecaire
	 * @throws DAOException une Exception
	 */
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
			throw new DAOException("probl�me d'ajout d'un bibliothecaire " + bib.getNom(), e);
		}finally {
			close(req);
		}
	}
	
	/** M�thode de class permet la fermeture de connexion, statement, requ�te
	 * @param myConn Connection
	 * @param myStmt Statement
	 * @param myRs ResultSet
	 * @throws DAOException Exception
	 */
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
	
	/** M�thode de class permet la fermeture de statement, requ�te
	 * @param myStmt Statement
	 * @param myRs ResultSet
	 * @throws DAOException Exception
	 */
	@SuppressWarnings("unused")
	private void close(Statement myStmt, ResultSet myRs) throws DAOException {
		close(null, myStmt, myRs);		
	}
	
	/** M�thode de class permet la fermeture de statement
	 * @param myStmt Statement
	 * @throws DAOException Exception
	 */
	private void close(Statement myStmt) throws DAOException {
		close(null, myStmt, null);		
	}

}

