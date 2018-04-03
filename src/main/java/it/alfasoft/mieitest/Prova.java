package it.alfasoft.mieitest;

import it.alfasoft.utils.DateFormatUtility;

public class Prova {

	public Prova() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();
		System.out.println(dataCorrente);
	}
}