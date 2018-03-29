package it.alfasoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "vin", "modello", "telaio", "stato", "piazzale", "dataInserimento"})
@XmlRootElement(name = "pippo")
public class Veicolo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Veicolo() {
	}
	
	
	String vin = "";
	String modello = "";
	String telaio = "";
	String stato = "";
	String piazzale = "";
	Date dataInserimento = null;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getTelaio() {
		return telaio;
	}
	public void setTelaio(String telaio) {
		this.telaio = telaio;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getPiazzale() {
		return piazzale;
	}
	public void setPiazzale(String piazzale) {
		this.piazzale = piazzale;
	}
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	@Override
	public String toString() {
		return "Veicolo [vin=" + vin + ", modello=" + modello + ", telaio=" + telaio + ", stato=" + stato
				+ ", piazzale=" + piazzale + ", dataInserimento=" + dataInserimento + "]";
	}

}