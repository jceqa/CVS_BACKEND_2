package py.com.cvs2.rest;

import java.util.List;

import javax.ws.rs.*;
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

	@GET
	public Response listPermisos(@QueryParam("all") Boolean all) {
		PermisoController mc = new PermisoController();
		List<Permiso> permisos = mc.listPermisos(all);

		return Response.ok(permisos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getPermisoById(@PathParam("id") Integer id) {
		PermisoController mc = new PermisoController();
		Permiso permiso = mc.getPermisoById(id);

		return Response.ok(permiso, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response savePermiso(Permiso permiso) {
		PermisoController mc = new PermisoController();
		try {
			permiso = mc.savePermiso(permiso);

		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}
		return Response.ok(permiso, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updatePermiso(Permiso permiso) {
		PermisoController mc = new PermisoController();
		try {
			permiso = mc.updatePermiso(permiso);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(permiso, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deletePermiso(@PathParam("id") Integer id) {
		PermisoController mc = new PermisoController();

		try {
			mc.deletePermiso(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}
