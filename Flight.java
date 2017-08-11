package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */

@NamedQuery(name="Flight.findById", query="SELECT f FROM Flight f WHERE f.id = :id")
@Entity
public class Flight implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightOrigin;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightDestination;
	
	private int price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date flightTime;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="airplane_fk")
	private Airplane airplaneDetail;
	
	@OneToMany(mappedBy = "flightforPilot")
	private List<Pilot> pilots;
	
	@ManyToMany
	@JoinTable(name="f_p_join", joinColumns = @JoinColumn(name="flight_fk"), inverseJoinColumns = @JoinColumn(name="passenger_fk"))
	private List<Passenger> passengers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FlightDestinations getFlightOrigin() {
		return flightOrigin;
	}

	public void setFlightOrigin(FlightDestinations flightOrigin) {
		this.flightOrigin = flightOrigin;
	}

	public FlightDestinations getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(FlightDestinations flightDestination) {
		this.flightDestination = flightDestination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}
	
	public Airplane getAirplaneDetail() {
		return airplaneDetail;
	}

	public void setAirplaneDetails(Airplane airplaneDetail) {
		this.airplaneDetail = airplaneDetail;
	}

	
	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public void setAirplaneDetail(Airplane airplaneDetail) {
		this.airplaneDetail = airplaneDetail;
	}
	
	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightOrigin=" + flightOrigin
				+ ", flightDestination=" + flightDestination + ", price="
				+ price + ", flightTime=" + flightTime + ", airplaneDetail="
				+ airplaneDetail + ", pilots=" + pilots + "]";
	}


}
