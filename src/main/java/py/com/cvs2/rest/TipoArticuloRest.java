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

import py.com.cvs2.controller.TipoArticuloController;
import py.com.cvs2.model.TipoArticulo;

@Path("/tipoarticulo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoArticuloRest {

	@GET
	public Response listTipoArticulos() {
		TipoArticuloController tac = new TipoArticuloController();
		List<TipoArticulo> tipoarticulos = tac.listTipoArticulos();

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
		tipoarticulo = tac.saveTipoArticulo(tipoarticulo);

		return Response.ok(tipoarticulo, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateTipoArticulo(TipoArticulo tipoarticulo) {
		TipoArticuloController tac = new TipoArticuloController();
		tipoarticulo = tac.updateTipoArticulo(tipoarticulo);

		return Response.ok(tipoarticulo, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTipoArticulo(@PathParam("id") Integer id) {
		TipoArticuloController tac = new TipoArticuloController();

		tac.deleteTipoArticulo(id);

		return Response.ok().build();
	}

}