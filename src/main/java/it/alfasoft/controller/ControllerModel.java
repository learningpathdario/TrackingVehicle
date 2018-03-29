package it.alfasoft.controller;

import java.util.List;

import it.alfasoft.dao.DaoModels;
import it.alfasoft.model.ModelloVeicolo;

public class ControllerModel {

	public ControllerModel() {
	}
	public List<ModelloVeicolo> getlistaModels() {
		DaoModels daoModels = new DaoModels();
		List<ModelloVeicolo> listaModelloVeicolo = daoModels.getListaModelliVeicolo();
		return  listaModelloVeicolo;
	}
	
	public ModelloVeicolo getModelloVeicolo(String id)  {
		DaoModels daoModels = new DaoModels();
		ModelloVeicolo modelloVeicolo = daoModels.getModelloVeicolo(id);
		return  modelloVeicolo;
	}
	
	public boolean delete(String id) {
		DaoModels daoModels = new DaoModels();
		boolean resultDelete = daoModels.deleteModelloVeicolo(id);
		return  resultDelete;
	}
	
	public boolean update(ModelloVeicolo modelloVeicolo) {
		DaoModels daoModels = new DaoModels();
		boolean resultUpdate = daoModels.updateModelloVeicolo(modelloVeicolo);
		return  resultUpdate;
	}
	
	public boolean create(ModelloVeicolo modelloVeicolo) {
		DaoModels daoModels = new DaoModels();
		boolean resultInsert = daoModels.insertModelloVeicolo(modelloVeicolo);
		return  resultInsert;
	}
}
