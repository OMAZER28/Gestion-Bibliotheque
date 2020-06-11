package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.services.EmpruntDAO;
import gestionBibliotheque.dao.services.ReservationDAO;
import gestionBibliotheque.model.services.Emprunt;
import gestionBibliotheque.model.services.Reservation;

/** Class qui repr�sente un controlleur des services d'emprunt et de r�servation
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class ServiceController {
	/** L'op�ration voulu du controlleur (ex: ajouter un emprunt)*/
	private String op;
	/** L'emprunt � controlleur*/
	private Emprunt emp;
	/** R�servation � controlleur*/
	private Reservation res;
	
	/** Un premier constructeur qui prend deux param�tres pour retourner un objet service controller
	 *  et qui va ex�cuter l'op�ration op sur l'emprunt emp
	@param		op une cha�ne de caract�res
	@param		emp un Emprunt
	*/
	public ServiceController(String op, Emprunt emp) {
		this.op = op;
		this.emp = emp;
		this.executeOp(op, emp);
	}
	
	/** Un deux�me constructeur qui prend deux param�tres pour retourner un objet service controller
	 *  et qui va ex�cuter l'op�ration op sur la r�servation res
	@param		op une cha�ne de caract�res
	@param		res un Reservation
	*/
	public ServiceController(String op, Reservation res) {
		this.op = op;
		this.res = res;
		this.executeOp(op, res);
	}
	
	/** Getter de l'op�ration
	@return		la valeur de l'op�ration op
    */
	public String getOp() {
		return op;
	}
	
	/** Setter de l'op�ration
	@param		op une cha�ne de caract�re
    */
	public void setOp(String op) {
		this.op = op;
	}

	/** Getter du r�aliseur de l'emprunt
	@return		le r�f�rence de l'objet utilisateur r�aliseur de l'emprunt emp
    */
	public Emprunt getUser() {
		return emp;
	}
	
	/** Setter de l'emprunt 
	@param		emp un Emprunt
	*/
	public void setEmp(Emprunt emp) {
		this.emp = emp;
	}
	
	/** Getter de la r�servation 
	@return		le r�f�rence de l'objet r�servation res
	*/
	public Reservation getRes() {
		return res;
	}
	
	/** Setter de la r�servation
	@param		res une Reservation
	*/
	public void setRes(Reservation res) {
		this.res = res;
	}
	
	/** M�thode executeOp qui va ex�cuter l'op�ration op sur l'emprunt emp
	@param		op une cha�ne de caract�res
	@param		emp un Emprunt
    */
	public void executeOp(String op, Emprunt emp) {
		if(this.getOp()=="delete") {
			try {
				EmpruntDAO empDAO= new EmpruntDAO();
				empDAO.deleteEmprunt(emp);
				} catch(DAOException ex) {
					System.out.println(ex);
				}
		}
		else if(this.getOp() == "add") {
			try {
				EmpruntDAO empDAO= new EmpruntDAO();
				empDAO.addEmprunt(emp);
				} catch(DAOException ex) {
					System.out.println(ex);
				}
		}
	}
	
	/** M�thode executeOp qui va ex�cuter l'op�ration op sur la r�servation res
	@param		op une cha�ne de caract�res
	@param		res une Reservation
    */
	public void executeOp(String op, Reservation res) {
		if(this.getOp()=="delete") {
			try {
				ReservationDAO resDAO= new ReservationDAO();
				resDAO.deleteReservation(res);
				} catch(DAOException ex) {
					System.out.println(ex);
				}
			}
		}
}
