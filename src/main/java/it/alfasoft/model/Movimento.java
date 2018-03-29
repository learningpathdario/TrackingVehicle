package it.alfasoft.model;

import java.io.Serializable;
import java.util.Date;

public class Movimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Movimento() {
		// TODO Auto-generated constructor stub
	}
	
	private String id;
	private String tipoMovimento;
	private String codPiazzale;
	private String tipoTrasporto;
//	private Date dataMovimento;
	private String vin;
	private String codModello;
	private String codTelaio;
	private String versione;
	private String serie;
	private String parkingSpot;
	private String numberPlate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	public String getCodPiazzale() {
		return codPiazzale;
	}
	public void setCodPiazzale(String codPiazzale) {
		this.codPiazzale = codPiazzale;
	}
	public String getTipoTrasporto() {
		return tipoTrasporto;
	}
	public void setTipoTrasporto(String tipoTrasporto) {
		this.tipoTrasporto = tipoTrasporto;
	}
//	public Date getDataMovimento() {
//		return dataMovimento;
//	}
//	public void setDataMovimento(Date dataMovimento) {
//		this.dataMovimento = dataMovimento;
//	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getCodModello() {
		return codModello;
	}
	public void setCodModello(String codModello) {
		this.codModello = codModello;
	}

	public String getCodTelaio() {
		return codTelaio;
	}
	public void setCodTelaio(String codTelaio) {
		this.codTelaio = codTelaio;
	}
	public String getVersione() {
		return versione;
	}
	public void setVersione(String versione) {
		this.versione = versione;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(String parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	@Override
	public String toString() {
		return "Movimento [id=" + id + ", tipoMovimento=" + tipoMovimento + ", codPiazzale=" + codPiazzale
				+ ", tipoTrasporto=" + tipoTrasporto //+ ", dataMovimento=" + dataMovimento 
				+ ", vin=" + vin
				+ ", codModello=" + codModello + ", codTelaio=" + codTelaio + ", versione=" + versione + ", serie="
				+ serie + ", parkingSpot=" + parkingSpot + ", numberPlate=" + numberPlate + "]";
	}
	
}
