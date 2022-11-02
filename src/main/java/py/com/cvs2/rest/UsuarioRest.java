package py.com.cvs2.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.UsuarioController;
import py.com.cvs2.dto.TokenDto;
import py.com.cvs2.model.Usuario;

import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest {

	@POST
	@Path("validar")
	public Response validar(Usuario usuario) {
		UsuarioController uc = new UsuarioController();
		TokenDto datos = uc.validar(usuario);
		return Response.ok(datos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	public Response getByToken(@QueryParam("token") String token) {
		UsuarioController uc = new UsuarioController();
		Usuario usuario = uc.getByToken(token);
		return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
	}


	@GET
	public Response listUsuarios(@QueryParam("all") Boolean all) {
		UsuarioController uc = new UsuarioController();
		List<Usuario> usuarios = uc.listUsuarios(all);

		return Response.ok(usuarios, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getUsuarioById(@PathParam("id") Integer id) {
		UsuarioController uc = new UsuarioController();
		Usuario usuario = uc.getUsuarioById(id);

		return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveUsuario(Usuario usuario) {
		UsuarioController uc = new UsuarioController();
		try {
			usuario = uc.saveUsuario(usuario);

		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}
		return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateUsuario(Usuario usuario) {
		UsuarioController uc = new UsuarioController();
		try {
			usuario = uc.updateUsuario(usuario);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUsuario(@PathParam("id") Integer id) {
		UsuarioController uc = new UsuarioController();

		try {
			uc.deleteUsuario(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}
}
