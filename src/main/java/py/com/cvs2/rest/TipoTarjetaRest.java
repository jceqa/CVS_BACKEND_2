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

import py.com.cvs2.controller.TipoTarjetaController;
import py.com.cvs2.model.TipoTarjeta;

@Path("/tipotarjeta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoTarjetaRest {

	@GET
	public Response listTipoTarjetas() {
		TipoTarjetaController tc = new TipoTarjetaController();
		List<TipoTarjeta> tipotarjetas = tc.listTipoTarjetas();

		return Response.ok(tipotarjetas, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getTipoTarjetaById(@PathParam("id") Integer id) {
		TipoTarjetaController tc = new TipoTarjetaController();
		TipoTarjeta tipotarjeta = tc.getTipoTarjetaById(id);

		return Response.ok(tipotarjeta, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveTipoTarjeta(TipoTarjeta tipotarjeta) {
		TipoTarjetaController tc = new TipoTarjetaController();
		try {
			tipotarjeta = tc.saveTipoTarjeta(tipotarjeta);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(tipotarjeta, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateTipoTarjeta(TipoTarjeta tipotarjeta) {
		TipoTarjetaController tc = new TipoTarjetaController();
		try {
			tipotarjeta = tc.updateTipoTarjeta(tipotarjeta);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(tipotarjeta, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTipoTarjeta(@PathParam("id") Integer id) {
		TipoTarjetaController tc = new TipoTarjetaController();

		try {
			tc.deleteTipoTarjeta(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}
