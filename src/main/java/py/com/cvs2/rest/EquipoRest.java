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

import py.com.cvs2.controller.EquipoController;
import py.com.cvs2.model.Equipo;

@Path("/equipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipoRest {

	@GET
	public Response listEquipos() {
		EquipoController ec = new EquipoController();
		List<Equipo> equipos = ec.listEquipos();

		return Response.ok(equipos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getEquipoById(@PathParam("id") Integer id) {
		EquipoController ec = new EquipoController();
		Equipo equipo = ec.getEquipoById(id);

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveEquipo(Equipo equipo) {
		EquipoController ec = new EquipoController();
		equipo = ec.saveEquipo(equipo);

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEquipo(Equipo equipo) {
		EquipoController ec = new EquipoController();
		equipo = ec.updateEquipo(equipo);

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEquipo(@PathParam("id") Integer id) {
		EquipoController ec = new EquipoController();
		ec.deleteEquipo(id);

		return Response.ok().build();
	}

}
