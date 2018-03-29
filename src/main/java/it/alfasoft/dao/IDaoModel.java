package it.alfasoft.dao;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.Movimento;
import it.alfasoft.model.Veicolo;
import it.alfasoft.model.Yard;

public interface IDaoModel extends Serializable {
	
	public List<Yard> getListaYards();
	public Yard getYard(String id);
	public boolean deleteYard(String id);
	public boolean updateYard(Yard yard);
//	public boolean salvaMovimento(Veicolo veicoli);
//	public List<Movimento> getListaMovimenti();
	boolean insertYard(Yard yard);
}