package it.alfasoft.servizi.rest;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import it.alfasoft.manager.ManagerServizi;
import it.alfasoft.model.Veicolo;
import it.alfasoft.utils.ParserUtility;

@Path("tracking")
public class ServiziTracking {

	public ServiziTracking() {
		// TODO Auto-generated constructor stub
	}
	private static final Logger LOGGER = Logger.getLogger(ServiziTracking.class.getName());
	@GET
	@Path("/cercaveicolo/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVeicolo(@PathParam("vin") String vin) throws JsonProcessingException {
		LOGGER.info("getVeicolo vin"+vin);
		ManagerServizi ms = new ManagerServizi();
		Veicolo veicoloSearch = new Veicolo();
		veicoloSearch.setVin(vin);
		Veicolo veicolo = ms.searchVeicolo(veicoloSearch);

		return Response.ok().entity(ParserUtility.parseObject(veicolo))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
