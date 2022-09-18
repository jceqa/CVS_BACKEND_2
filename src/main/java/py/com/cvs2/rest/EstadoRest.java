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

import py.com.cvs2.controller.EstadoController;
import py.com.cvs2.model.Estado;

@Path("/estado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoRest {

	@GET
	public Response listEstados() {
		EstadoController ec = new EstadoController();
		List<Estado> estados = ec.listEstados();

		return Response.ok(estados, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getEstadoById(@PathParam("id") Integer id) {
		EstadoController ec = new EstadoController();
		Estado estado = ec.getEstadoById(id);

		return Response.ok(estado, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveEstado(Estado estado) throws Exception {
		EstadoController ec = new EstadoController();
		estado = ec.saveEstado(estado);

		return Response.ok(estado, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEstado(Estado estado) {
		EstadoController ec = new EstadoController();
		estado = ec.updateEstado(estado);

		return Response.ok(estado, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEstado(@PathParam("id") Integer id) {
		EstadoController ec = new EstadoController();

		ec.deleteEstado(id);

		return Response.ok().build();
	}

}
