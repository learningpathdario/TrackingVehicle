package it.alfasoft.resources;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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

import it.alfasoft.controller.ControllerYard;
import it.alfasoft.dao.DaoTracking;
import it.alfasoft.manager.IManagerServizi;
import it.alfasoft.manager.ManagerServizi;
import it.alfasoft.model.Yard;
import it.alfasoft.utils.ParserUtility;

@Path("yards")
public class YardsResource {

	private static final Logger LOGGER = Logger.getLogger(YardsResource.class.getName());
	
	/*
	 * Recupero la lista di yards da manager.
	 */
	@GET
	public Response pippo() {
		IManagerServizi manager = new ManagerServizi();
		return Response.ok(Arrays.toString(manager.getYards().stream().toArray())).build();
	}	
	
	@GET
	@Path("getYards")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYards() throws JsonProcessingException {
		LOGGER.info("getYards start");
		ControllerYard controllerYard = new ControllerYard();
		List<Yard> listaYards = controllerYard.getlistaYards();
		LOGGER.info("getYards end");
		return  Response.ok().entity(ParserUtility.parseListObject(listaYards))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYard(@PathParam("id") String id) throws JsonProcessingException {
		LOGGER.info("getYard start");
		LOGGER.info("getYard id: "+id);
		ControllerYard controllerYard = new ControllerYard();
		Yard yards = controllerYard.getYard(id);
		LOGGER.info("getYard end");
		return  Response.ok().entity(ParserUtility.parseObject(yards))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) throws JsonProcessingException {
		LOGGER.info("delete start");
		LOGGER.info("delete id: "+id);
		ControllerYard controllerYard = new ControllerYard();
		boolean resultDelete = controllerYard.delete(id);
		LOGGER.info("delete end");
		if(resultDelete) {
		return  Response.status(200).entity("piazzale "+id+" cancellato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante la delete del piazzale "+id).build();
	}
	@PUT
//	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String yardStr) throws JsonProcessingException {
		LOGGER.info("update start");
		LOGGER.info("update yardStr: "+yardStr);
		ControllerYard controllerYard = new ControllerYard();
		Yard yard = null;
		try {
			yard = ParserUtility.parseString(yardStr, Yard.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultDelete = controllerYard.update(yard);
		LOGGER.info("update end");
		if(resultDelete) {
		return  Response.ok().entity("piazzale "+yard.getCodiceYard()+" aggiornato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante aggiornamento del piazzale "+yard.getCodiceYard()).build();
	}
	@POST
//	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String yardStr) throws JsonProcessingException {
		LOGGER.info("create start");
		LOGGER.info("create yardStr: "+yardStr);
		ControllerYard controllerYard = new ControllerYard();
		Yard yard = null;
		try {
			yard = ParserUtility.parseString(yardStr, Yard.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultDelete = controllerYard.create(yard);
		LOGGER.info("create end");
		if(resultDelete) {
		return   Response.ok().entity("piazzale "+yard.getCodiceYard()+" creato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
//		return Response.status(200).entity("piazzale 1 creato").build();
		}else 
		 return Response.status(400).entity("Errore durante la create del piazzale 1").build();
		
	}
	
}
