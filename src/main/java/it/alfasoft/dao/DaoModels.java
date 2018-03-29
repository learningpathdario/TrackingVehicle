package it.alfasoft.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import it.alfasoft.model.ModelloVeicolo;

public class DaoModels implements IDaoModels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoModels.class.getName());
	public DaoModels() {
		
	}

	@Override
	public List<ModelloVeicolo> getListaModelliVeicolo() {
		LOGGER.info("getListaModelliVeicolo start");
		ModelloVeicolo modelloVeicolo1 = new ModelloVeicolo();
		ModelloVeicolo modelloVeicolo2 = new ModelloVeicolo();
		
		modelloVeicolo1.setCodiceModello("199");
		modelloVeicolo1.setDescrizioneModello("PUNTO");
		
		modelloVeicolo2.setCodiceModello("630");
		modelloVeicolo2.setDescrizioneModello("GIULIA");
		
		List<ModelloVeicolo> listaModelliVeicolo = new ArrayList<>();
		listaModelliVeicolo.add(modelloVeicolo1);
		listaModelliVeicolo.add(modelloVeicolo2);
		LOGGER.info("getListaModelliVeicolo end");
		return listaModelliVeicolo;
	}

	@Override
	public ModelloVeicolo getModelloVeicolo(String id) {
		LOGGER.info("getModelloVeicolo start");
		ModelloVeicolo modelloVeicolo1 = new ModelloVeicolo();
		
		modelloVeicolo1.setCodiceModello("199");
		modelloVeicolo1.setDescrizioneModello("PUNTO");


		LOGGER.info("getModelloVeicolo end");
		return modelloVeicolo1;
	}

	@Override
	public boolean deleteModelloVeicolo(String id) {
		LOGGER.info("deleteModelloVeicolo start");
		LOGGER.info("cancello il modello con id: "+id);
		LOGGER.info("deleteModelloVeicolo end");
		return true;
	}

	@Override
	public boolean updateModelloVeicolo(ModelloVeicolo modelloVeicolo) {
		LOGGER.info("updateModelloVeicolo start");
		LOGGER.info("codice modello: "+modelloVeicolo.getCodiceModello());
		LOGGER.info("Descr modello: "+modelloVeicolo.getDescrizioneModello());
		LOGGER.info("updateModelloVeicolo end");
		return true;
	}

	@Override
	public boolean insertModelloVeicolo(ModelloVeicolo modelloVeicolo) {
		LOGGER.info("salvaModelloVeicolo start");
		LOGGER.info("codice modello: "+modelloVeicolo.getCodiceModello());
		LOGGER.info("Descr modello: "+modelloVeicolo.getDescrizioneModello());
		LOGGER.info("salvaModelloVeicolo end");
		return true;
	}

}
