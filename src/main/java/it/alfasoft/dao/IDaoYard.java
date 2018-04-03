package it.alfasoft.dao;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.Yard;

public interface IDaoYard extends Serializable {
	
	public List<Yard> getListaYards()  throws Exception;;
	public Yard getYard(String id)  throws Exception;;
	public boolean deleteYard(String id)  throws Exception;;
	public boolean updateYard(Yard yard)  throws Exception;;
//	public boolean salvaMovimento(Veicolo veicoli);
//	public List<Movimento> getListaMovimenti();
	boolean insertYard(Yard yard)  throws Exception;;
}