package it.alfasoft.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.model.Movimento;
import it.alfasoft.model.Veicolo;
import it.alfasoft.model.Yard;

public class DaoTracking implements IDaoTracking {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoTracking.class.getName());


	public DaoTracking() {
		
	}

	public List<Yard> getListaYards(){
		LOGGER.info("getListaYards start");
		Yard yard1 = new Yard();
		Yard yard2 = new Yard();
		
		yard1.setCodiceYard("00001");
		yard1.setDescrYard("MIRAFIORI");
		
		yard2.setCodiceYard("00002");
		yard2.setDescrYard("RIVALTA");
		
		List<Yard> listaYards = new ArrayList<>();
		listaYards.add(yard1);
		listaYards.add(yard2);
		LOGGER.info("getListaYards end");
		return listaYards;
	}

	@Override
	public List<ModelloVeicolo> getListaModelloVeicoli() {
		LOGGER.info("getListaModelloVeicoli start");
		ModelloVeicolo modello1 = new ModelloVeicolo();
		ModelloVeicolo modello2 = new ModelloVeicolo();
		
		modello1.setCodiceModello("100");
		modello1.setDescrizioneModello("punto");
		
		modello2.setCodiceModello("200");
		modello2.setDescrizioneModello("giulia");
		
		List<ModelloVeicolo> listaModelli = new ArrayList<>();
		
		listaModelli.add(modello1);
		listaModelli.add(modello2);
		LOGGER.info("getListaModelloVeicoli end");
		return listaModelli;
	}

	@Override
	public boolean salvaMovimento(Veicolo veicolo) {
		LOGGER.info("salvaMovimento start");
		LOGGER.info("VIN: "+veicolo.getVin());
		LOGGER.info("MODELLO: "+veicolo.getModello());
		LOGGER.info("TELAIO: "+veicolo.getTelaio());
		LOGGER.info("PIAZZALE: "+veicolo.getPiazzale());
		LOGGER.info("STATO: "+veicolo.getStato());
//		LOGGER.info("DATA INSERIMENTO: "+veicolo.getDataInserimento());
		LOGGER.info("salvaMovimento end");
		return true;
	}

	@Override
	public List<Movimento> getListaMovimenti() {
		// TODO Auto-generated method stub
		return null;
	}
}