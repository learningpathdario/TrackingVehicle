package it.alfasoft.manager;

import org.junit.Ignore;
import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import junit.framework.TestCase;

@Ignore
public class ManagerTest extends TestCase {
	/**
	 * Need to start server
	 * @throws UnirestException
	 */
	@Test
	public void testEsempio() throws UnirestException {
		HttpResponse<String> response = Unirest.get("http://localhost:8080/TrackingVehicle/tracking/tracking/cercaveicolo/QWE123456")
				  .header("Cache-Control", "no-cache")
				  .header("Postman-Token", "b0269d33-a6e2-40f3-9c86-99b27e9ecaee")
				  .asString();
	}
	
	
	/**
	 * test del metodo getYard che ha il compito di recuperare tutti i piazzali dall'anagrafica
	 * @throws UnirestException
	 */
	@Test
	public void testGetYards() throws UnirestException {
	HttpResponse<String> response = Unirest.get("http://localhost:8080/TrackingVehicle/api/service/getYards")
			  .header("Cache-Control", "no-cache")
			  .header("Postman-Token", "0e777d04-8184-440d-a59e-1e9df67d7543")
			  .asString();
	}
	/**
	 * test del metodo getVehicleModels che ha il compito di recuperare tutti i modelli dall'anagrafica
	 * @throws UnirestException
	 */
	@Test
	public void testGetVehicleModels() throws UnirestException {
	HttpResponse<String> response = Unirest.get("http://localhost:8080/TrackingVehicle/api/service/vehicleModels")
			  .header("Cache-Control", "no-cache")
			  .header("Postman-Token", "5d15aea4-c5ba-4e67-b979-42bd52ae1ccf")
			  .asString();
}

/**
 * test del metodo testSaveMovement che ha il compito di salvare il movimento su db
 * @throws UnirestException
 */
@Test
public void testSaveMovement() throws UnirestException {
	HttpResponse<String> response = Unirest.post("http://localhost:8080/TrackingVehicle/api/movements")
			.header("Content-Type", "application/json")
			.header("Cache-Control", "no-cache")
			.header("Postman-Token", "00792100-1211-4d0b-bcfc-096823e236bd")
			.body("{\r\n\t\"id\":\"1\",\r\n\t\"tipoMovimento\":\"ING\",\r\n\t\"codPiazzale\":\"00001\",\r\n\t\"tipoTrasporto\":\"STR\",\r\n\t\"vin\":\"1234ERTYUIOP4RTGF\",\r\n\t\"codModello\":\"199\",\r\n\t\"codTelaio\":\"12345678\",\r\n\t\"versione\":\"123\",\r\n\t\"serie\":\"1\",\r\n\t\"parkingSpot\":\"123\",\r\n\t\"numberPlate\":\"345\"\r\n\t}")
			.asString();
}


}