package fr.daguerretech.webdemo.rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employees/{firstname}.{lastname}@{domain}.com")
public class EmpResource {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String getEmployeelastname(@PathParam("lastname") String lastName) {
		return lastName;
	}
}