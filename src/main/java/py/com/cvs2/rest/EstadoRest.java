/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;



import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.EstadoController;
import py.com.cvs2.model.Estado;

@Path("/estado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoRest {

	@GET
	public Response listEstados(@QueryParam("all") Boolean all) {
		EstadoController ec = new EstadoController();
		List<Estado> estados = ec.listEstados(all);

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
	public Response saveEstado(Estado estado) {
		EstadoController ec = new EstadoController();
		try{
			estado = ec.saveEstado(estado);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(estado, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEstado(Estado estado) {
		EstadoController ec = new EstadoController();
		try{
			estado = ec.updateEstado(estado);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(estado, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEstado(@PathParam("id") Integer id) {
		EstadoController ec = new EstadoController();

		try{
			ec.deleteEstado(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}
