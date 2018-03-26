package it.alfasoft.manager;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import it.alfasoft.dao.DaoTracking;
import it.alfasoft.model.ModelloVeicolo;
import it.alfasoft.model.Veicolo;
import it.alfasoft.model.Yard;
import it.alfasoft.utils.ParserUtility;

@Path("service")
public class VehicleTracking implements IVehicleTracking {

	
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(VehicleTracking.class.getName());

	public VehicleTracking() {
		// TODO Auto-generated constructor stub
	}

	
	@GET
	@Path("/getYards")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getYards() throws JsonProcessingException {
		DaoTracking daoTracking = new DaoTracking();
		List<Yard> listaYards = daoTracking.getListaYards();
//		return Response.ok().entity(res).build();
		return  Response.ok().entity(ParserUtility.parseListObject(listaYards))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	
	@GET
	@Path("/vehicleModels")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getVehicleModels() throws JsonProcessingException{
		DaoTracking daoTracking = new DaoTracking();
		List<ModelloVeicolo> listaModelliVeicolo = daoTracking.getListaModelloVeicoli();
		return  Response.ok().entity(ParserUtility.parseListObject(listaModelliVeicolo))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@POST
	@Path("/saveMovement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response saveMovement(Veicolo veicolo) {
		DaoTracking daoTracking = new DaoTracking();
		boolean save = daoTracking.salvaMovimento(veicolo);
//		String result = "veicolo ok : " + veicolo;
		return Response.status(201).entity(veicolo)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}

	@Override
	public List<Veicolo> getMovements() {
		// TODO Auto-generated method stub
		return null;
	}
}