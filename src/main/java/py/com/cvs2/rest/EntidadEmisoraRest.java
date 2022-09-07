/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;


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

import py.com.cvs2.controller.EntidadEmisoraController;
import py.com.cvs2.model.EntidadEmisora;

@Path("/entidademisora")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntidadEmisoraRest {

	@GET
	public Response listEntidadEmisoras() {
		EntidadEmisoraController ec = new EntidadEmisoraController();
		List<EntidadEmisora> entidademisoras = ec.listEntidadEmisoras();

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
		entidademisora = ec.saveEntidadEmisora(entidademisora);

		return Response.ok(entidademisora, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEntidadEmisora(EntidadEmisora entidademisora) {
		EntidadEmisoraController ec = new EntidadEmisoraController();
		entidademisora = ec.updateEntidadEmisora(entidademisora);

		return Response.ok(entidademisora, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEntidadEmisora(@PathParam("id") Integer id) {
		EntidadEmisoraController ec = new EntidadEmisoraController();

		ec.deleteEntidadEmisora(id);

		return Response.ok().build();
	}

}
