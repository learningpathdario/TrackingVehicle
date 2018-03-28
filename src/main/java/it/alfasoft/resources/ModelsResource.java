package it.alfasoft.resources;

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

@Path("models")
public class ModelsResource {

	private static final Logger LOGGER = Logger.getLogger(ModelsResource.class.getName());
	
	@GET
	public Response hello() {
		return Response.ok("ciao").build();
	}
	
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
