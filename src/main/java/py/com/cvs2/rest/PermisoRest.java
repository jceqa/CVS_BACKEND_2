package py.com.cvs2.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.model.Permiso;
import py.com.cvs2.controller.PermisoController;

@Path("/permiso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PermisoRest {

	@GET
	@Path("rol/{idRol}")
	public Response listByRol(@PathParam("idRol") Integer idRol) {

		PermisoController pc = new PermisoController();
		List<Permiso> permisos = pc.listByRol(idRol);

		return Response.ok(permisos).build();
	}

}
