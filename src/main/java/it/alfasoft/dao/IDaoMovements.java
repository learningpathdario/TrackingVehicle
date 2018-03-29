package it.alfasoft.dao;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.Movimento;

public interface IDaoMovements extends Serializable {
	
	public List<Movimento> getListaMovimenti();
	public Movimento getMovimentoByVin(String vin);
	public boolean deleteMovimentoById(String id);
	public boolean updateMovimento(Movimento movimento);
	public boolean insertMovimento(Movimento movimento);
	public Movimento getMovimentoById(String id);
	public boolean deleteMovimentoByVin(String vin);

}
