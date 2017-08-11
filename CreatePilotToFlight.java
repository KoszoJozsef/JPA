package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

/**
 * Servlet implementation class CreatePilotToFlight
 */
@WebServlet("/CreatePilotToFlight")
public class CreatePilotToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PilotService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePilotToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int license = Integer.parseInt(request.getParameter("license"));
		String rank = request.getParameter("rank");
		
		String flightId = request.getParameter("fid");
		
		Pilot p = new Pilot();
		
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setPilotLicense(license);
		p.setPilotRank(PilotRank.valueOf(rank));
		
		ps.addNewPilotToFlight(p, flightId);
		
		response.sendRedirect("Flights");
	}

}
