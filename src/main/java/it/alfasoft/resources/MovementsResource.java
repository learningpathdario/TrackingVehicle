package it.alfasoft.resources;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import it.alfasoft.controller.ControllerMovement;
import it.alfasoft.manager.ManagerServizi;
import it.alfasoft.model.Movimento;
import it.alfasoft.model.Veicolo;
import it.alfasoft.utils.ParserUtility;

@Path("movements")
public class MovementsResource {

	private static final Logger LOGGER = Logger.getLogger(MovementsResource.class.getName());
	
	@GET
	public Response hello() {
		return Response.ok("ciao").build();
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovimentoById(@PathParam("id") String id) throws JsonProcessingException {
		LOGGER.info("getMovimento id"+id);
		ManagerServizi ms = new ManagerServizi();
		Veicolo veicoloSearch = new Veicolo();
		veicoloSearch.setVin(id);
		Veicolo veicolo = ms.searchVeicolo(veicoloSearch);

		return Response.ok().entity(ParserUtility.parseObject(veicolo))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Path("/vin/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovimentoByVin(@PathParam("vin") String vin) throws JsonProcessingException {
		LOGGER.info("getMovimento id"+vin);
		ControllerMovement controllerMovement = new ControllerMovement();
		Movimento movimento = controllerMovement.getMovementByVin(vin);

		return Response.ok().entity(ParserUtility.parseObject(movimento))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@DELETE
	@Path("vin/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteByVin(@PathParam("vin") String vin) throws JsonProcessingException {
		LOGGER.info("getMovimento vin"+vin);
		ControllerMovement controllerMovement = new ControllerMovement();
		boolean resultDelete = controllerMovement.deleteByVin(vin);
		LOGGER.info("delete end");
		if(resultDelete) {
		return  Response.status(200).entity("movimento "+vin+" cancellato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante la delete del piazzale "+vin).build();
	}
	@DELETE
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("id") String id) throws JsonProcessingException {
		LOGGER.info("getMovimento id"+id);
		ControllerMovement controllerMovement = new ControllerMovement();
		boolean resultDelete = controllerMovement.deleteById(id);
		LOGGER.info("delete end");
		if(resultDelete) {
		return  Response.status(200).entity("movimento "+id+" cancellato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante la delete del piazzale "+id).build();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String movimentoStr) throws JsonProcessingException {
		LOGGER.info("update start");
		LOGGER.info("update movimentoStr: "+movimentoStr);
		ControllerMovement controllerMovement = new ControllerMovement();
		Movimento movimento = null;
		try {
			movimento = ParserUtility.parseString(movimentoStr, Movimento.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultUpdate = controllerMovement.update(movimento);
		LOGGER.info("update end");
		if(resultUpdate) {
		return  Response.ok().entity("movimento "+movimento.getVin()+" aggiornato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante aggiornamento del piazzale "+movimento.getVin()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String movimentoStr) throws JsonProcessingException {
		LOGGER.info("create start");
		LOGGER.info("create movimentoStr: "+movimentoStr);
		ControllerMovement controllerMovement = new ControllerMovement();
		Movimento movimento = null;
		try {
			movimento = ParserUtility.parseString(movimentoStr, Movimento.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultCreate = controllerMovement.create(movimento);
		LOGGER.info("create end");
		if(resultCreate) {
		return   Response.ok().entity("movimento "+movimento.getVin()+" creato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
//		return Response.status(200).entity("piazzale 1 creato").build();
		}else 
		 return Response.status(400).entity("Errore durante la create del movimento 1").build();
		
	}
}
