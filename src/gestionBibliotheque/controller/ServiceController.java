package gestionBibliotheque.controller;

import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.services.EmpruntDAO;
import gestionBibliotheque.dao.services.ReservationDAO;
import gestionBibliotheque.model.services.Emprunt;
import gestionBibliotheque.model.services.Reservation;


public class ServiceController {
	private String op;
	private Emprunt emp;
	private Reservation res;
	
	public ServiceController(String op, Emprunt emp) {
		this.op = op;
		this.emp = emp;
		this.executeOp(op, emp);
	}
	
	public ServiceController(String op, Reservation res) {
		this.op = op;
		this.res = res;
		this.executeOp(op, res);
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Emprunt getUser() {
		return emp;
	}

	public void setEmp(Emprunt emp) {
		this.emp = emp;
	}
	
	public Reservation getRes() {
		return res;
	}

	public void setRes(Reservation res) {
		this.res = res;
	}
	
	public void executeOp(String op, Emprunt emp) {
		if(this.getOp()=="delete") {
			try {
				EmpruntDAO empDAO= new EmpruntDAO();
				empDAO.deleteEmprunt(emp);
				} catch(DAOException ex) {
					System.out.println(ex);
				}
			}
		}
	
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
