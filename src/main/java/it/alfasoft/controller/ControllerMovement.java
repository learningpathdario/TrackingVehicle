package it.alfasoft.controller;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.dao.DaoModels;
import it.alfasoft.dao.DaoMovements;
import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.model.Movimento;

public class ControllerMovement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerMovement() {
		
	}
	
	public List<Movimento> getMovements() {
		DaoMovements daoMovements = new DaoMovements();
		List<Movimento> listaMovimento = daoMovements.getListaMovimenti();
		return  listaMovimento;
	}
	
	public Movimento getMovementById(String id) {
		DaoMovements daoMovements = new DaoMovements();
		Movimento movimento = daoMovements.getMovimentoById(id);
		return  movimento;
	}
	
	public Movimento getMovementByVin(String vin) {
		DaoMovements daoMovements = new DaoMovements();
		Movimento movimento = daoMovements.getMovimentoById(vin);
		return  movimento;
	}
	
	public boolean deleteById(String id) {
		DaoMovements daoMovements = new DaoMovements();
		boolean resultDelete = daoMovements.deleteMovimentoById(id);
		return  resultDelete;
	}
	
	public boolean deleteByVin(String vin) {
		DaoMovements daoMovements = new DaoMovements();
		boolean resultDelete = daoMovements.deleteMovimentoByVin(vin);
		return  resultDelete;
	}
	
	public boolean update(Movimento movimento) {
		DaoMovements daoMovements = new DaoMovements();
		boolean resultUpdate = daoMovements.updateMovimento(movimento);
		return  resultUpdate;
	}
	
	public boolean create(Movimento movimento) {
		DaoMovements daoMovements = new DaoMovements();
		boolean resultInsert = daoMovements.insertMovimento(movimento);
		return  resultInsert;
	}



}
