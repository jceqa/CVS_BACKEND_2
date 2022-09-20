/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.TipoArticuloController;
import py.com.cvs2.model.TipoArticulo;

@Path("/tipoarticulo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoArticuloRest {

	@GET
	public Response listTipoArticulos(@QueryParam("all") Boolean all) {
		TipoArticuloController tac = new TipoArticuloController();
		List<TipoArticulo> tipoarticulos = tac.listTipoArticulos(all);

		return Response.ok(tipoarticulos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getTipoArticuloById(@PathParam("id") Integer id) {
		TipoArticuloController tac = new TipoArticuloController();
		TipoArticulo tipoarticulo = tac.getTipoArticuloById(id);

		return Response.ok(tipoarticulo, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveTipoArticulo(TipoArticulo tipoarticulo) {
		TipoArticuloController tac = new TipoArticuloController();
		try{
			tipoarticulo = tac.saveTipoArticulo(tipoarticulo);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(tipoarticulo, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateTipoArticulo(TipoArticulo tipoarticulo) {
		TipoArticuloController tac = new TipoArticuloController();
		try{
			tipoarticulo = tac.updateTipoArticulo(tipoarticulo);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(tipoarticulo, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTipoArticulo(@PathParam("id") Integer id) {
		TipoArticuloController tac = new TipoArticuloController();

		try {
			tac.deleteTipoArticulo(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}