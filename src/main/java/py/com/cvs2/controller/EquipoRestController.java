package py.com.cvs2.controller;

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

import py.com.cvs2.dao.EquipoDao;
import py.com.cvs2.model.Equipo;

@Path("/equipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipoRestController {

	@GET
	public Response getEquipos() {
		EquipoDao equipoDao = new EquipoDao();
		List<Equipo> equipos = equipoDao.list();

		return Response.ok(equipos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getEquipoById(@PathParam("id") Integer id) {
		EquipoDao equipoDao = new EquipoDao();
		Equipo equipo = equipoDao.findById(id);

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response setEquipo(Equipo equipo) {
		EquipoDao equipoDao = new EquipoDao();
		equipo = equipoDao.save(equipo);

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateEquipo(Equipo equipo) {
		EquipoDao equipoDao = new EquipoDao();
		equipo = equipoDao.update(equipo);

		return Response.ok(equipo, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEquipo(@PathParam("id") Integer id) {
		EquipoDao equipoDao = new EquipoDao();

		equipoDao.delete(id);

		return Response.ok().build();
	}

}
