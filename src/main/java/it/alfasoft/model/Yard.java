package it.alfasoft.model;

import java.io.Serializable;

public class Yard implements Serializable {

	private static final long serialVersionUID = 1L;

	public Yard() {
		// TODO Auto-generated constructor stub
	}
	private String id = "";
	private String codiceYard = "";
	private String descrYard = "";

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodiceYard() {
		return codiceYard;
	}
	public void setCodiceYard(String codiceYard) {
		this.codiceYard = codiceYard;
	}
	public String getDescrYard() {
		return descrYard;
	}
	
	@Override
	public String toString() {
		return "Yard [codiceYard=" + codiceYard + ", descrYard=" + descrYard + "]";
	}
	public void setDescrYard(String descrYard) {
		this.descrYard = descrYard;
	}
	
}