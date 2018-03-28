package it.alfasoft.resources;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import it.alfasoft.manager.IManagerServizi;
import it.alfasoft.manager.ManagerServizi;

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
}
