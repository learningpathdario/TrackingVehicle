package it.alfasoft.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import it.alfasoft.databse.ConnectionJDBC;
import it.alfasoft.model.Yard;
import it.alfasoft.utils.DateFormatUtility;

public class DaoYard implements IDaoYard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(DaoYard.class.getName());


	public DaoYard() {
		
	}
	@Override
	public List<Yard> getListaYards() throws Exception{
		LOGGER.info("getListaYards start");
		List<Yard> listaYards = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;
		ConnectionJDBC c = new ConnectionJDBC();
		
		try {
		
			dbConnection =c.getORASqlConnection();
			String query = "select ID, CODICE_YARD, DESCRIZIONE_YARD  from anagrafica_yard data_delete is null";
			statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
            	Yard yard = new Yard();
            	yard.setId(resultSet.getInt("ID")+"");
            	yard.setCodiceYard(resultSet.getString("CODICE_YARD"));
            	yard.setDescrYard(resultSet.getString("DESCRIZIONE_YARD"));
            	listaYards.add(yard);
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
		LOGGER.info("getListaYards end");
		return listaYards;
	}
	@Override
	public Yard getYard(String id) throws Exception{
		LOGGER.info("getYard start");
		Connection dbConnection = null;
		Statement statement = null;
		ConnectionJDBC c = new ConnectionJDBC();
		Yard yard = new Yard();
		try {
		
			dbConnection =c.getORASqlConnection();
			String query = "select ID, CODICE_YARD, DESCRIZIONE_YARD  from anagrafica_yard where data_delete is null and id = "+id;
			statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
   
            yard.setId(resultSet.getInt("ID")+"");
            yard.setCodiceYard(resultSet.getString("CODICE_YARD"));
            yard.setDescrYard(resultSet.getString("DESCRIZIONE_YARD"));
           
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

		LOGGER.info("getYard end");
		return yard;
	}
	@Override
	public boolean deleteYard(String id) throws Exception{
		LOGGER.info("deleteYard start");
		LOGGER.info("cancello il piazzale con id: "+id);
		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();

		
		String query = "UPDATE ANAGRAFICA_YARD SET"
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
		LOGGER.info("deleteYard end");
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
	public boolean updateYard(Yard yard) throws Exception {
		LOGGER.info("updateYard start");
		LOGGER.info("codice yard: "+yard.getCodiceYard());
		LOGGER.info("Descr yard: "+yard.getDescrYard());

		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();

		
		String query = "UPDATE ANAGRAFICA_MODELLI SET"
				+ "ID="+yard.getId()+", CODICE_MODELLO ="+yard.getCodiceYard()+", DESCRIZIONE_MODELLO="+yard.getDescrYard()
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
	public boolean insertYard(Yard yard) throws Exception{
		LOGGER.info("insertYard start");
		LOGGER.info("codice yard: "+yard.getCodiceYard());
		LOGGER.info("Descr yard: "+yard.getDescrYard());
//		LOGGER.info("DATA INSERIMENTO: "+veicolo.getDataInserimento());
		ConnectionJDBC connessioneJDBC = new ConnectionJDBC();
		Connection dbConnection = null;
		Statement statement = null;
		DateFormatUtility dfu = new DateFormatUtility();
		String dataCorrente = dfu.getCurrentTimeStamp();
		String query = "INSERT INTO ANAGRAFICA_MODELLI"
				+ "(ID, CODICE_MODELLO, DESCRIZIONE_MODELLO, DATA_INSERIMENTO) " + "VALUES"
				+ "("+yard.getId()+",'"+yard.getCodiceYard()+"','"+yard.getDescrYard()+ "'," 
				+ "to_date('"
				+ dataCorrente + "', 'dd/mm/yyyy HH24:mi:ss'))";
		LOGGER.info("query: "+query);
		
		try {
			dbConnection = connessioneJDBC.getORASqlConnection();
			statement = dbConnection.createStatement();
			statement.executeUpdate(query);
			dbConnection.commit();
			LOGGER.info("Record inserito");
			LOGGER.info("insertYard end");
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