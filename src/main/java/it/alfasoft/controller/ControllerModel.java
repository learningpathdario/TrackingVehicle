package it.alfasoft.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import it.alfasoft.dao.DaoModels;
import it.alfasoft.model.ModelloVeicolo;

public class ControllerModel {

	@Inject
	DaoModels daoModelsCdi;
	
	public ControllerModel() {
	}
	public List<ModelloVeicolo> getlistaModels() throws SQLException, Exception {
//		DaoModels daoModels = new DaoModels();
		List<ModelloVeicolo> listaModelloVeicolo = daoModelsCdi.getListaModelliVeicolo();
//		List<ModelloVeicolo> listaModelloVeicolo = daoModels.getListaModelliVeicolo();
		return  listaModelloVeicolo;
	}
	
	public ModelloVeicolo getModelloVeicolo(String id) throws SQLException, Exception {
		DaoModels daoModels = new DaoModels();
		ModelloVeicolo modelloVeicolo = daoModels.getModelloVeicolo(id);
		return  modelloVeicolo;
	}
	
	public boolean delete(String id) throws SQLException, Exception {
		DaoModels daoModels = new DaoModels();
		boolean resultDelete = false;
		resultDelete = daoModels.deleteModelloVeicolo(id);
		return  resultDelete;
	}
	
	public boolean update(ModelloVeicolo modelloVeicolo) throws SQLException, Exception {
		DaoModels daoModels = new DaoModels();
		boolean resultUpdate = daoModels.updateModelloVeicolo(modelloVeicolo);
		return  resultUpdate;
	}
	
	public boolean create(ModelloVeicolo modelloVeicolo) throws SQLException, Exception {
		DaoModels daoModels = new DaoModels();
		boolean resultInsert = daoModels.insertModelloVeicolo(modelloVeicolo);
		return  resultInsert;
	}
}
