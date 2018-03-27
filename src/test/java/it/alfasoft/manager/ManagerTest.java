package it.alfasoft.manager;

import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import junit.framework.TestCase;

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
 * test del metodo getVehicleModels che ha il compito di recuperare tutti i modelli dall'anagrafica
 * @throws UnirestException
 */
@Test
public void testSaveMovement() throws UnirestException {
	HttpResponse<String> response = Unirest.post("http://localhost:8080/TrackingVehicle/api/service/saveMovement")
			  .header("Content-Type", "application/json")
			  .header("Cache-Control", "no-cache")
			  .header("Postman-Token", "8d4eff72-9117-41fa-8de8-29f4610e5f34")
			  .body("{\r\n\t\"vin\":\"QWE1234567890OIUY\",\r\n\t\"modello\":\"630\",\r\n\t\"telaio\":\"12345678\",\r\n\t\"stato\":\"01\",\r\n\t\"piazzale\":\"00001\"\r\n}\r\n\r\n    ")
			  .asString();
}
}