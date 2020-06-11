package gestionBibliotheque.dao.document;

import java.util.*;
import java.sql.*;
import java.io.*;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.model.documents.Revue;

/** Class qui permet la manipulation des donn�es des revue
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class RevueDAO {
	/** Connection permet de l'acc�e au base de donn�es */
	private Connection connection;
	
	/** Un constructeur qui r�alize une connexion
	 * @throws DAOException Exception
	 */
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
	
	/** M�thode addRevue permet d'ajouter un Revue
	 * @param r un Revue
	 * @throws DAOException une Exception
	 */
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
	
	/** M�thode permettant de supprimer un Revue
	 * @param r Rveue
	 * @throws DAOException une Exception
	 */
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
	
	/** M�thode permettant de renvoyer tous les revues
	 * @return list des revues
	 * @throws DAOException une Exception
	 */
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
	
	/** M�thode permettant de rechercher un revue
	 * @param mot une cha�ne de caract�res
	 * @return list des revues
	 * @throws DAOException une Exception
	 */
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

