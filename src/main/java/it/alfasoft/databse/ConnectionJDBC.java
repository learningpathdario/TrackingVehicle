package it.alfasoft.databse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class ConnectionJDBC {

//	public ConnectionJDBC() {
//		// TODO Auto-generated constructor stub
//	}
	
   
    private Properties dbProperties;
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static final Logger LOGGER = Logger.getLogger(ConnectionJDBC.class.getName());
    
    
	  public Connection getORASqlConnection() throws Exception {
		  LOGGER.info("getORASqlConnection start");
		  LOGGER.info("driver: "+driver);
		  LOGGER.info("url: "+url);
		  LOGGER.info("user: "+user);
		  LOGGER.info("password: "+password);
		    Class.forName(driver);
		    Connection conn = DriverManager.getConnection(url, user, password);
		    LOGGER.info("getORASqlConnection end");
		    return conn;
		  }
	  
	  public Connection close() throws Exception {
		  LOGGER.info("getORASqlConnection start");
		  LOGGER.info("driver: "+driver);
		  LOGGER.info("url: "+url);
		  LOGGER.info("user: "+user);
		  LOGGER.info("password: "+password);
		    Class.forName(driver);
		    Connection conn = DriverManager.getConnection(url, user, password);
		    LOGGER.info("getORASqlConnection end");
		    return conn;
		  }
	  
	    public ConnectionJDBC()  {
	    	LOGGER.info("ConnectionJDBC start");
	        try {
	        	 InputStream dbPropFile = getClass().getResourceAsStream("config.properties");
	             
	            dbProperties = new Properties();
	            dbProperties.load(dbPropFile);
	            
//	            postgresUrl = "jdbc:postgresql://" + dbProperties.getProperty("host") + ":"
//	                    + dbProperties.getProperty("port") + "/" + dbProperties.getProperty("dbName");
	            driver = dbProperties.getProperty("driver");
	            url = dbProperties.getProperty("url");
	            user = dbProperties.getProperty("user");
	            password = dbProperties.getProperty("password");
	 
	             
	        } catch (IOException e) {
	            
	        }
	    }

}
