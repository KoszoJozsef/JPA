package com.airline.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.airline.models.Flight;
import com.airline.service.FlightService;


@Path("/flight")
@Transactional
public class FlightsWebService {

	@PersistenceContext(unitName="user")
	EntityManager em;
	
	@EJB
	FlightService fs;
	
	public FlightsWebService(){
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getFlights(){
		
		List<Flight> fList = fs.getFlights();
		
		return fList;
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{flight_id}")
	public Flight getFlight(@PathParam("flight_id") int flightId ){
		
		Flight f = fs.getFlight(flightId);
		
		if(f == null){
			throw new NotFoundException("The flight with an id of "+ flightId + "was not found!");
		}
		
		return f;
	}
	
	
	@DELETE
	@Path("{flight_id}")
	public Response deleteFlight(@PathParam("flight_id") int flightId){
		
		Flight fRemove = em.find(Flight.class, flightId);
		
		if(fRemove == null){	
			throw new NotFoundException("The flight with an id of " + flightId + "was not found!");
		}
		
		em.remove(fRemove);
		
		return Response.noContent().build();
	}
	
}
