package it.alfasoft.manager;


import java.util.List;

import it.alfasoft.dao.DaoYard;
import it.alfasoft.dao.IDaoYard;
import it.alfasoft.model.Veicolo;
import it.alfasoft.model.Yard;

public class ManagerServizi implements IManagerServizi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagerServizi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertGateIn(Veicolo veicolo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGateIn(Veicolo veicolo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Veicolo searchVeicolo(Veicolo veicolo) {
		Veicolo veicoloDB = new Veicolo();
		veicoloDB.setVin("QWE12345678909876");
		veicoloDB.setModello("630");
		veicoloDB.setTelaio("09876543");
		return veicoloDB;
	}

	@Override
	public List<Veicolo> searchVeicoli(List<Veicolo> listaVeicoli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Yard> getYards() {
		IDaoYard dao = new DaoYard();
		try {
			return dao.getListaYards();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
