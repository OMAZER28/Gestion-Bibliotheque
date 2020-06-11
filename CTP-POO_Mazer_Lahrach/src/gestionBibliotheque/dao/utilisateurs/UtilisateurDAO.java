package gestionBibliotheque.dao.utilisateurs;

/** Class qui permet la r�cup�ration des donn�es des utilisateurs
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

public class UtilisateurDAO {
	/** Connection permet de l'acc�e au base de donn�es */
	private Connection connection;
	
	/** Un constructeur qui r�alize une connexion
	 * @throws DAOException Exception
	 */
	public UtilisateurDAO() throws DAOException {
		
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
	
	/** M�thode qui permet d'authentifier un utilisateur user
	 * @param 		user un Utilisateur
	 * @return		le type de l'utilisateur (adh�rant/bibliothecaire ou introuvable)
	 * @throws 		DAOException des exception de connection
	 */
	public String signin(Utilisateur user) throws DAOException{
		PreparedStatement req1 = null;
		PreparedStatement req2 = null;
		String sql1,sql2;
		int n=0;
		int m=0;
		try {
			sql1 = "SELECT COUNT(*) as nb FROM adherant WHERE login= ? and mdp =? and isVerified=1";
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
				m= m+rs2.getInt("nb");
			}
			
			if(n==0 && m==0) {
				return "introuvable";
			}else if(n==0 && m==1) {
				return "bibliothecaire";
			}else{
				return "adherant";
			}
		} catch(SQLException e) {
			throw new DAOException("probl�me d'acces au compte utlisateur " + user.getLogin(), e);
		}finally {
			close(req1);
			close(req2);
		}
	}
	
	/** M�thode qui permet la fermeture des r�sultats des requ�tes, la requ�te et la connexion
	 * @param 		myConn une Connection
	 * @param 		myStmt Statement
	 * @param 		myRs ResultSet
	 * @throws 		DAOException Exception
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
	
	/** M�thode qui permet la fermeture des r�sultats des requ�tes et aussi la requ�te
	 * @param myStmt Statement
	 * @param myRs ResultSet
	 * @throws DAOException Exception
	 */
	@SuppressWarnings("unused")
	private void close(Statement myStmt, ResultSet myRs) throws DAOException {
		close(null, myStmt, myRs);		
	}
	
	/** M�thode qui permet la fermeture des requ�tes
	 * @param myStmt Statement
	 * @throws DAOException Exception
	 */
	private void close(Statement myStmt) throws DAOException {
		close(null, myStmt, null);		
	}

}

