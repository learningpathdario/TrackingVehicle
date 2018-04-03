package it.alfasoft.dao;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.ModelloVeicolo;

public interface IDaoModels extends Serializable {

	public List<ModelloVeicolo> getListaModelliVeicolo() throws Exception;
	public ModelloVeicolo getModelloVeicolo(String id) throws Exception;
	public boolean deleteModelloVeicolo(String id) throws Exception;
	public boolean updateModelloVeicolo(ModelloVeicolo modelloVeicolo) throws Exception;
	public boolean insertModelloVeicolo(ModelloVeicolo modelloVeicolo) throws Exception;
}