package it.alfasoft.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import it.alfasoft.dao.DaoYard;
import it.alfasoft.model.Yard;

public class ControllerYard implements Serializable {

	private static final long serialVersionUID = 1L;

	public ControllerYard() {
		
	}
	
	public List<Yard> getlistaYards() throws SQLException, Exception{
		DaoYard daoYard = new DaoYard();
		List<Yard> listaYards = daoYard.getListaYards();
		return  listaYards;
	}
	
	public Yard getYard(String id)  throws SQLException, Exception{
		DaoYard daoYard = new DaoYard();
		Yard yard = daoYard.getYard(id);
		return  yard;
	}
	
	public boolean delete(String id) throws SQLException, Exception{
		DaoYard daoYard = new DaoYard();
		boolean resultDelete = daoYard.deleteYard(id);
		return  resultDelete;
	}
	
	public boolean update(Yard yard) throws SQLException, Exception{
		DaoYard daoYard = new DaoYard();
		boolean resultUpdate = daoYard.updateYard(yard);
		return  resultUpdate;
	}
	
	public boolean create(Yard yard) throws SQLException, Exception{
		DaoYard daoYard = new DaoYard();
		boolean resultInsert = daoYard.insertYard(yard);
		return  resultInsert;
	}
}