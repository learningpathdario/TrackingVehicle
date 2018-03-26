package it.alfasoft.manager;

import java.io.Serializable;
import java.util.List;

import it.alfasoft.model.Veicolo;

public interface IManagerServizi extends Serializable {
	public boolean insertGateIn(Veicolo veicolo);
	public boolean deleteGateIn(Veicolo veicolo);
	public Veicolo searchVeicolo(Veicolo veicolo);
	public List<Veicolo> searchVeicoli(List<Veicolo> listaVeicoli);

}
