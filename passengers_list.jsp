<%@page import="java.util.List"%>
<%@page import="com.airline.models.Passenger"%>
<%@page import="com.airline.models.Pilot"%>
<%@page import="com.airline.models.Flight"%>
<!DOCTYPE html>
<html>
<head>

<title>Passengers List</title>
</head>
<body>

	<h1>List of passengers</h1>
	
	<table>
		<tr>
			<th>Id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Date of birth</th>
			<th>Gender</th>
		</tr>
		
		<%
			
			List<Passenger> pList = (List<Passenger>) request.getAttribute("passengers_list");
			
			for(int i = 0; i < pList.size(); i++){
				
			
		%>
		
		<tr>
			<td><%= pList.get(i).getId() %></td>
			<td><%= pList.get(i).getFirstName() %></td>
			<td><%= pList.get(i).getLastName() %></td>
			<td><%= pList.get(i).getDob() %></td>
			<td><%= pList.get(i).getGender() %></td>
			
		</tr>
		
		<tr>
			<th>Tickets:</th>
			<td colspan="4">
				
				<%
					if(pList.get(i).getFlights().size() > 0){
						
						List<Flight> fList = pList.get(i).getFlights();
						
						for(int j = 0; j < fList.size(); j++){
				%>
					<%= j+1 %>) <%= fList.get(j).getFlightOrigin() %> to <%= fList.get(j).getFlightDestination() %> @ <%= fList.get(j).getFlightTime() %> <br />
				<%
						}
					} else {
				%>
					No flight tickets yet.
				<%
					}
				%>

			</td>
		
		</tr>
		
		
		<%
			}
		%>
	</table>

</body>
</html>