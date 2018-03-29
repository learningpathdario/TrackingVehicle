package it.alfasoft.controller;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.dao.DaoTracking;
import it.alfasoft.model.Yard;

public class ControllerYard implements Serializable {

	private static final long serialVersionUID = 1L;

	public ControllerYard() {
		
	}
	
	public List<Yard> getlistaYards() {
		DaoTracking daoTracking = new DaoTracking();
		List<Yard> listaYards = daoTracking.getListaYards();
		return  listaYards;
	}
	
	public Yard getYard(String id)  {
		DaoTracking daoTracking = new DaoTracking();
		Yard yard = daoTracking.getYard(id);
		return  yard;
	}
	
	public boolean delete(String id) {
		DaoTracking daoTracking = new DaoTracking();
		boolean resultDelete = daoTracking.deleteYard(id);
		return  resultDelete;
	}
	
	public boolean update(Yard yard) {
		DaoTracking daoTracking = new DaoTracking();
		boolean resultUpdate = daoTracking.updateYard(yard);
		return  resultUpdate;
	}
	
	public boolean create(Yard yard) {
		DaoTracking daoTracking = new DaoTracking();
		boolean resultInsert = daoTracking.insertYard(yard);
		return  resultInsert;
	}
}