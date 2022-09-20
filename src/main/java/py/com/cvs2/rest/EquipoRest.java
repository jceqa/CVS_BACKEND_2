package py.com.cvs2.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.EquipoController;
import py.com.cvs2.model.Equipo;

@Path("/equipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipoRest {

	@GET
	public Response listEquipos(@QueryParam("all") Boolean all) {
		EquipoController ec = new EquipoController();
		List<Equipo> equipos = ec.listEquipos(all);

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
		try{
			equipo = ec.saveEquipo(equipo);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEquipo(Equipo equipo) {
		EquipoController ec = new EquipoController();
		try{
			equipo = ec.updateEquipo(equipo);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEquipo(@PathParam("id") Integer id) {
		EquipoController ec = new EquipoController();

		try{
			ec.deleteEquipo(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}
