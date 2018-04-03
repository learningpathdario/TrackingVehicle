package it.alfasoft.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import it.alfasoft.resources.ModelsResource;

public class DateFormatUtility implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DateFormatUtility.class.getName());

	public DateFormatUtility() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCurrentTimeStamp() {

		Date curDate = new Date();

//		SimpleDateFormat format = new SimpleDateFormat();
//		String dateToStr = format.format(curDate.getTime());
//		System.out.println("Default pattern: " + dateToStr);

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dateToStr = format.format(curDate);
		LOGGER.info("dateToStr: "+dateToStr);
		
		return dateToStr;

	}


}
