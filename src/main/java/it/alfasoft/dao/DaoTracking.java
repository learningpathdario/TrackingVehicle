package it.alfasoft.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import it.alfasoft.model.Movimento;
import it.alfasoft.model.Veicolo;
import it.alfasoft.model.Yard;

public class DaoTracking implements IDaoModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoTracking.class.getName());


	public DaoTracking() {
		
	}
	@Override
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
	public Yard getYard(String id){
		LOGGER.info("getYard start");
		Yard yard1 = new Yard();
		
		yard1.setCodiceYard("00001");
		yard1.setDescrYard("MIRAFIORI");


		LOGGER.info("getYard end");
		return yard1;
	}
	@Override
	public boolean deleteYard(String id){
		LOGGER.info("deleteYard start");
		LOGGER.info("cancello il piazzale con id: "+id);

		LOGGER.info("deleteYard end");
		return true;
	}

//
//	@Override
//	public boolean salvaMovimento(Veicolo veicolo) {
//		LOGGER.info("salvaMovimento start");
//		LOGGER.info("VIN: "+veicolo.getVin());
//		LOGGER.info("MODELLO: "+veicolo.getModello());
//		LOGGER.info("TELAIO: "+veicolo.getTelaio());
//		LOGGER.info("PIAZZALE: "+veicolo.getPiazzale());
//		LOGGER.info("STATO: "+veicolo.getStato());
////		LOGGER.info("DATA INSERIMENTO: "+veicolo.getDataInserimento());
//		LOGGER.info("salvaMovimento end");
//		return true;
//	}

//	@Override
//	public List<Movimento> getListaMovimenti() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public boolean updateYard(Yard yard) {
		LOGGER.info("updateYard start");
		LOGGER.info("codice yard: "+yard.getCodiceYard());
		LOGGER.info("Descr yard: "+yard.getDescrYard());
//		LOGGER.info("DATA INSERIMENTO: "+veicolo.getDataInserimento());
		LOGGER.info("updateYard end");
		return true;
	}
	@Override
	public boolean insertYard(Yard yard) {
		LOGGER.info("insertYard start");
		LOGGER.info("codice yard: "+yard.getCodiceYard());
		LOGGER.info("Descr yard: "+yard.getDescrYard());
//		LOGGER.info("DATA INSERIMENTO: "+veicolo.getDataInserimento());
		LOGGER.info("insertYard end");
		return true;
	}

}