package py.com.cvs2.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.UsuarioRolController;
import py.com.cvs2.dto.UsuarioRolDto;
import py.com.cvs2.model.UsuarioRol;

import java.util.List;

@Path("/usuariorol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRolRest {

	@GET
	@Path("/{idusuario}")
	public Response getUsuarioRolByIdUsuario(@PathParam("idusuario") Integer idUsuario) {
		UsuarioRolController urc = new UsuarioRolController();
		List<UsuarioRolDto> ur = urc.getByIdUsuario(idUsuario);

		return Response.ok(ur, MediaType.APPLICATION_JSON).build();
	}

	@GET
	public Response listUsuariosRol(@QueryParam("all") Boolean all) {
		UsuarioRolController urc = new UsuarioRolController();
		List<UsuarioRol> usuariosRol = urc.listUsuariosRol(all);

		return Response.ok(usuariosRol, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getUsuarioRolById(@PathParam("id") Integer id) {
		UsuarioRolController urc = new UsuarioRolController();
		UsuarioRol usuarioRol = urc.getUsuarioRolById(id);

		return Response.ok(usuarioRol, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveUsuarioRol(UsuarioRol usuarioRol) {
		UsuarioRolController urc = new UsuarioRolController();
		try {
			usuarioRol = urc.saveUsuarioRol(usuarioRol);

		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}
		return Response.ok(usuarioRol, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateUsuarioRol(UsuarioRol usuarioRol) {
		UsuarioRolController urc = new UsuarioRolController();
		try {
			usuarioRol = urc.updateUsuarioRol(usuarioRol);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(usuarioRol, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUsuarioRol(@PathParam("id") Integer id) {
		UsuarioRolController urc = new UsuarioRolController();

		try {
			urc.deleteUsuarioRol(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}
}
