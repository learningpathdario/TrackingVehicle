package it.alfasoft.model;

import java.io.Serializable;

public class ModelloVeicolo implements Serializable {

	private static final long serialVersionUID = 1L;

	public ModelloVeicolo() {
		// TODO Auto-generated constructor stub
	}

	private String codiceModello = "";
	private String descrizioneModello = "";
	
	public String getCodiceModello() {
		return codiceModello;
	}
	public void setCodiceModello(String codiceModello) {
		this.codiceModello = codiceModello;
	}
	public String getDescrizioneModello() {
		return descrizioneModello;
	}
	public void setDescrizioneModello(String descrizioneModello) {
		this.descrizioneModello = descrizioneModello;
	}
	@Override
	public String toString() {
		return "ModelloVeicolo [codiceModello=" + codiceModello + ", descrizioneModello=" + descrizioneModello + "]";
	}
	
}