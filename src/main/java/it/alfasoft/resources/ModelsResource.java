package it.alfasoft.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
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

import it.alfasoft.controller.ControllerModel;
import it.alfasoft.dao.DaoModels;
import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.utils.ParserUtility;

@RequestScoped
@Path("models")
public class ModelsResource {

	private static final Logger LOGGER = Logger.getLogger(ModelsResource.class.getName());
	
	@GET
	public Response hello() {
		return Response.ok("ciao").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getModels() throws JsonProcessingException {
		DaoModels daoModels = new DaoModels();
		List<ModelloVeicolo> listaModelliVeicolo = null;;
		try {
			listaModelliVeicolo = daoModels.getListaModelliVeicolo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(400).entity("Errorr durante la get dei modelli").build();
		}

		return Response.ok().entity(ParserUtility.parseListObject(listaModelliVeicolo))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYards(@PathParam("id") String id) throws JsonProcessingException {
		DaoModels daoModels = new DaoModels();
		ModelloVeicolo modelloVeicolo = null;
		try {
			modelloVeicolo = daoModels.getModelloVeicolo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(400).entity("Errorr durante la get del modello con id:"+id).build();
		}
		return  Response.ok().entity(ParserUtility.parseObject(modelloVeicolo))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) throws JsonProcessingException {
		ControllerModel controllerModel = new ControllerModel();
		boolean resultDelete;
		try {
			resultDelete = controllerModel.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(400).entity("Errorr durante la delete del modello con ID "+id).build();
		}
//		return Response.ok().entity(res).build();
		if(resultDelete) {
		return  Response.status(200).entity("modello "+id+" cancellato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante la delete del modello "+id).build();
	}
	@PUT
//	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String modelloVeicoloStr) throws JsonProcessingException {
		LOGGER.info("update start");
		ControllerModel controllerModel = new ControllerModel();
		ModelloVeicolo modelloVeicolo = null;
		try {
			modelloVeicolo = ParserUtility.parseString(modelloVeicoloStr, ModelloVeicolo.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean resultUpdate;
		try {
			resultUpdate = controllerModel.update(modelloVeicolo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(400).entity("Errorr durante aggiornamento del modello "+modelloVeicolo.getCodiceModello()).build();
		}
		LOGGER.info("update end");
		if(resultUpdate) {
		return  Response.ok().entity("modello "+modelloVeicolo.getCodiceModello()+" aggiornato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errorr durante aggiornamento del modello "+modelloVeicolo.getCodiceModello()).build();
	}
	@POST
//	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String modelloVeicoloStr) throws JsonProcessingException {
		LOGGER.info("create start");
//		DaoModels daoModels = new DaoModels();
		ControllerModel controllerModel = new ControllerModel();
		ModelloVeicolo modelloVeicolo = null;
		boolean resultCreate = false;
		try {
			modelloVeicolo = ParserUtility.parseString(modelloVeicoloStr, ModelloVeicolo.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			resultCreate = controllerModel.create(modelloVeicolo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(400).entity("Errore durante la create del modello "+modelloVeicolo.getCodiceModello()).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(400).entity("Errore durante la create del modello "+modelloVeicolo.getCodiceModello()).build();
		}
//		return Response.ok().entity(res).build();
		LOGGER.info("create end");
		if(resultCreate) {
		return  Response.ok().entity("modello "+modelloVeicolo.getCodiceModello()+" creato")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
		}else
			
		 return Response.status(400).entity("Errore durante la create del modello "+modelloVeicolo.getCodiceModello()).build();
	}
	
}
