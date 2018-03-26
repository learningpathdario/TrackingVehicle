package it.alfasoft.dao;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.model.Movimento;
import it.alfasoft.model.Veicolo;
import it.alfasoft.model.Yard;

public interface IDaoTracking extends Serializable {
	
	public List<Yard> getListaYards();
	public List<ModelloVeicolo> getListaModelloVeicoli();
	public boolean salvaMovimento(Veicolo veicoli);
	public List<Movimento> getListaMovimenti();

}
