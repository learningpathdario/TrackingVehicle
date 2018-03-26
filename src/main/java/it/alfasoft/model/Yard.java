package it.alfasoft.model;

import java.io.Serializable;

public class Yard implements Serializable {

	private static final long serialVersionUID = 1L;

	public Yard() {
		// TODO Auto-generated constructor stub
	}
	
	private String codiceYard = "";
	private String descrYard = "";

	public String getCodiceYard() {
		return codiceYard;
	}
	public void setCodiceYard(String codiceYard) {
		this.codiceYard = codiceYard;
	}
	public String getDescrYard() {
		return descrYard;
	}
	public void setDescrYard(String descrYard) {
		this.descrYard = descrYard;
	}
}