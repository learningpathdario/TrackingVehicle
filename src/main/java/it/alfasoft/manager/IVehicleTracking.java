package it.alfasoft.manager;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import it.alfasoft.model.Veicolo;

public interface IVehicleTracking extends  Serializable {
	public Response getYards() throws JsonProcessingException, Exception;
	public Response getVehicleModels() throws JsonProcessingException;
	public Response saveMovement(Veicolo veicolo);
	public List<Veicolo> getMovements();
}