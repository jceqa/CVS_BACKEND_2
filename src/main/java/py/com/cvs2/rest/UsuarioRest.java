package py.com.cvs2.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.UsuarioController;
import py.com.cvs2.dto.TokenDto;
import py.com.cvs2.model.Usuario;

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
}
