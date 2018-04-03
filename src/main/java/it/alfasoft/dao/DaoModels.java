package it.alfasoft.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;

import it.alfasoft.databse.ConnectionJDBC;
import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.utils.DateFormatUtility;
@RequestScoped
public class DaoModels implements IDaoModels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoModels.class.getName());
	public DaoModels() {
		
	}

	@Override
	public List<ModelloVeicolo> getListaModelliVeicolo() throws Exception {
		LOGGER.info("getListaModelliVeicolo start");
		
		List<ModelloVeicolo> listaModelliVeicolo = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;
		ConnectionJDBC c = new ConnectionJDBC();
		
		try {
		
			dbConnection =c.getORASqlConnection();
			String query = "select ID, CODICE_MODELLO, DESCRIZIONE_MODELLO  from anagrafica_modelli";
			statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
            	ModelloVeicolo modelloVeicolo = new ModelloVeicolo();
            	modelloVeicolo.setId(resultSet.getInt("ID"));
            	modelloVeicolo.setCodiceModello(resultSet.getString("CODICE_MODELLO"));
            	modelloVeicolo.setDescrizioneModello(resultSet.getString("DESCRIZIONE_MODELLO"));
            	listaModelliVeicolo.add(modelloVeicolo);
            }
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
			return null;
		}  
	finally {
		if (statement != null) {
			statement.close();
			
		}

		if (dbConnection != null) {
			dbConnection.close();
		}
	}
		LOGGER.info("getListaModelliVeicolo end");
		return listaModelliVeicolo;
	}

	@Override
	public ModelloVeicolo getModelloVeicolo(String id) throws Exception {
		LOGGER.info("getModelloVeicolo start");
		Connection dbConnection = null;
		Statement statement = null;
		ConnectionJDBC c = new ConnectionJDBC();
		ModelloVeicolo modelloVeicolo = new ModelloVeicolo();
		try {
		
			dbConnection =c.getORASqlConnection();
			String query = "select ID, CODICE_MODELLO, DESCRIZIONE_MODELLO  from anagrafica_modelli where id = "+id;
			statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
   
            
            modelloVeicolo.setId(resultSet.getInt("ID"));
            modelloVeicolo.setCodiceModello(resultSet.getString("CODICE_MODELLO"));
            modelloVeicolo.setDescrizioneModello(resultSet.getString("DESCRIZIONE_MODELLO"));
            			
			} catch (SQLException e) {
			 
				e.printStackTrace();
				return null;
			}  
		finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		LOGGER.info("getListaModelliVeicolo end");
		return modelloVeicolo;
	}

	@Override
	public boolean deleteModelloVeicolo(String id) throws Exception {
		LOGGER.info("deleteModelloVeicolo start");
		LOGGER.info("cancello il modello con id: "+id);
		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();

		
		String query = "UPDATE ANAGRAFICA_MODELLI SET"
				+" DATA_DELETE = to_date('"+dataCorrente + "', 'dd/mm/yyyy HH24:mi:ss')) "
				+ "where id="+id;
		Connection dbConnection = null;
		Statement statement = null;
		try {
		ConnectionJDBC connessioneJDBC = new ConnectionJDBC();
		
		dbConnection = connessioneJDBC.getORASqlConnection();
		statement = dbConnection.createStatement();
		statement.executeUpdate(query);
		dbConnection.commit();
		LOGGER.info("updateModelloVeicolo end");
		} catch (SQLException e) {

			return false;

		}
		finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return true;
	}

	@Override
	public boolean updateModelloVeicolo(ModelloVeicolo modelloVeicolo) throws Exception {
		LOGGER.info("updateModelloVeicolo start");
		LOGGER.info("ID: "+modelloVeicolo.getId());
		LOGGER.info("codice modello: "+modelloVeicolo.getCodiceModello());
		LOGGER.info("Descr modello: "+modelloVeicolo.getDescrizioneModello());
		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();

		
		String query = "UPDATE ANAGRAFICA_MODELLI SET"
				+ "ID="+modelloVeicolo.getId()+", CODICE_MODELLO ="+modelloVeicolo.getCodiceModello()+", DESCRIZIONE_MODELLO="+modelloVeicolo.getDescrizioneModello()
				+", DATA_AGGIORNAMENTO =to_date('"+ dataCorrente + "', 'dd/mm/yyyy HH24:mi:ss'))";
		Connection dbConnection = null;
		Statement statement = null;
		try {
		ConnectionJDBC connessioneJDBC = new ConnectionJDBC();
		
		dbConnection = connessioneJDBC.getORASqlConnection();
		statement = dbConnection.createStatement();
		statement.executeUpdate(query);
		dbConnection.commit();
		LOGGER.info("updateModelloVeicolo end");
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
			return false;
		}
		finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return true;
	}

	@Override
	public boolean insertModelloVeicolo(ModelloVeicolo modelloVeicolo) throws Exception {
		LOGGER.info("insertModelloVeicolo start");
		LOGGER.info("codice modello: "+modelloVeicolo.getCodiceModello());
		LOGGER.info("Descr modello: "+modelloVeicolo.getDescrizioneModello());
		
		ConnectionJDBC connessioneJDBC = new ConnectionJDBC();
		Connection dbConnection = null;
		Statement statement = null;
		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();
		String query = "INSERT INTO ANAGRAFICA_MODELLI"
				+ "(ID, CODICE_MODELLO, DESCRIZIONE_MODELLO, DATA_INSERIMENTO) " + "VALUES"
				+ "("+modelloVeicolo.getId()+",'"+modelloVeicolo.getCodiceModello()+"','"+modelloVeicolo.getDescrizioneModello()+ "'," 
				+ "to_date('"
				+ dataCorrente + "', 'dd/mm/yyyy HH24:mi:ss'))";
		LOGGER.info("query: "+query);
		
		try {
			dbConnection = connessioneJDBC.getORASqlConnection();
			statement = dbConnection.createStatement();
			statement.executeUpdate(query);
			dbConnection.commit();
			LOGGER.info("Record inserito");
			LOGGER.info("insertModelloVeicolo end");
			return true;
		} catch (SQLException e) {

			LOGGER.info(e.getMessage());
			return false;

		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return false;
		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
}
