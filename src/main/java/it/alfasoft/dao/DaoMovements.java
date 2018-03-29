package it.alfasoft.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import it.alfasoft.model.Movimento;

public class DaoMovements implements IDaoMovements {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoMovements.class.getName());

	public DaoMovements() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Movimento> getListaMovimenti() {
		LOGGER.info("getListaMovimenti start");
		Movimento movimento1 = new Movimento();
		Movimento movimento2 = new Movimento();
		
		movimento1.setId("1");
		movimento1.setTipoMovimento("ING");
		
		movimento2.setId("2");
		movimento2.setTipoMovimento("USC");
		
		List<Movimento> listaMovimento = new ArrayList<>();
		listaMovimento.add(movimento1);
		listaMovimento.add(movimento1);
		LOGGER.info("getListaMovimenti end");
		return listaMovimento;
	}

	@Override
	public Movimento getMovimentoById(String id) {
		LOGGER.info("getMovimento start");
		Movimento movimento1 = new Movimento();
		
		movimento1.setId("1");
		movimento1.setTipoMovimento("ING");

		LOGGER.info("getMovimento end");
		return movimento1;
	}
	@Override
	public Movimento getMovimentoByVin(String id) {
		LOGGER.info("getMovimento start");
		Movimento movimento1 = new Movimento();
		
		movimento1.setId("1");
		movimento1.setTipoMovimento("ING");

		LOGGER.info("getMovimento end");
		return movimento1;
	}
	@Override
	public boolean deleteMovimentoById(String id) {
		LOGGER.info("deleteMovimentoById start");
		LOGGER.info("cancello il movimento con id: "+id);
		LOGGER.info("deleteMovimentoById end");
		return true;
	}
	@Override
	public boolean deleteMovimentoByVin(String vin) {
		LOGGER.info("deleteMovimentoByVin start");
		LOGGER.info("vin: "+vin);
		LOGGER.info("deleteMovimentoByVin end");
		return true;
	}
	@Override
	public boolean updateMovimento(Movimento movimento) {
		LOGGER.info("updateMovimento start");
		LOGGER.info("id movimento: "+movimento.getId());
		LOGGER.info("tipo movimento: "+movimento.getTipoMovimento());
		LOGGER.info("updateMovimento end");
		return true;
	}

	@Override
	public boolean insertMovimento(Movimento movimento) {
		LOGGER.info("insertMovimento start");
		LOGGER.info("id movimento: "+movimento.getId());
		LOGGER.info("tipo movimento: "+movimento.getTipoMovimento());
		LOGGER.info("insertMovimento end");
		return true;
	}

}
