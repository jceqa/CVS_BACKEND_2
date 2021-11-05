package py.com.cvs2.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.model.Permiso;
import py.com.cvs2.dao.PermisoDao;

@Path("/permiso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PermisoRestController {

	@GET
	@Path("rol/{idRol}")
	public Response getByRol(@PathParam("idRol") Integer idRol) {

		PermisoDao permisoDAO = new PermisoDao();
		List<Permiso> permisos = permisoDAO.findById(idRol);

		return Response.ok(permisos).build();
	}

}
