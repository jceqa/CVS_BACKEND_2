/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;

/**
 *
 * @author PC-DTIC
 */
import java.util.List;
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

import py.com.cvs2.controller.CiudadController;
import py.com.cvs2.model.Ciudad;

@Path("/ciudad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CiudadRest {

	@GET
	public Response listCiudades() {
		CiudadController cc = new CiudadController();
		List<Ciudad> ciudades = cc.listCiudades();

		return Response.ok(ciudades, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getCiudadById(@PathParam("id") Integer id) {
		CiudadController cc = new CiudadController();
		Ciudad ciudad = cc.getCiudadById(id);

		return Response.ok(ciudad, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveCiudad(Ciudad ciudad) {
		CiudadController cc = new CiudadController();
		try{
			ciudad = cc.saveCiudad(ciudad);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(ciudad, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateMarca(Ciudad ciudad) {
		CiudadController cc = new CiudadController();
		try{
			ciudad = cc.updateCiudad(ciudad);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(ciudad, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCiudad(@PathParam("id") Integer id) {
		CiudadController cc = new CiudadController();

		try {
			cc.deleteCiudad(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}