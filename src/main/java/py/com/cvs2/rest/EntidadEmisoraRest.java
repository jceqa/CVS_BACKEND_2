/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;


import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.EntidadEmisoraController;
import py.com.cvs2.model.EntidadEmisora;

@Path("/entidademisora")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntidadEmisoraRest {

	@GET
	public Response listEntidadEmisoras(@QueryParam("all") Boolean all) {
		EntidadEmisoraController ec = new EntidadEmisoraController();
		List<EntidadEmisora> entidademisoras = ec.listEntidadEmisoras(all);

		return Response.ok(entidademisoras, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getEntidadEmisoraById(@PathParam("id") Integer id) {
		EntidadEmisoraController ec = new EntidadEmisoraController();
		EntidadEmisora entidademisora = ec.getEntidadEmisoraById(id);

		return Response.ok(entidademisora, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveEntidadEmisora(EntidadEmisora entidademisora) {
		EntidadEmisoraController ec = new EntidadEmisoraController();
		try{
			entidademisora = ec.saveEntidadEmisora(entidademisora);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(entidademisora, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEntidadEmisora(EntidadEmisora entidademisora) {
		EntidadEmisoraController ec = new EntidadEmisoraController();
		try{
			entidademisora = ec.updateEntidadEmisora(entidademisora);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(entidademisora, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEntidadEmisora(@PathParam("id") Integer id) {
		EntidadEmisoraController ec = new EntidadEmisoraController();

		try {
			ec.deleteEntidadEmisora(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}
