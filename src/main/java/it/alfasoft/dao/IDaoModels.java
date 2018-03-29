package it.alfasoft.dao;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.ModelloVeicolo;

public interface IDaoModels extends Serializable {

	public List<ModelloVeicolo> getListaModelliVeicolo();
	public ModelloVeicolo getModelloVeicolo(String id);
	public boolean deleteModelloVeicolo(String id);
	public boolean updateModelloVeicolo(ModelloVeicolo modelloVeicolo);
	public boolean insertModelloVeicolo(ModelloVeicolo modelloVeicolo);
}