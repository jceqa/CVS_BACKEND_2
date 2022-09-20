package py.com.cvs2.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.UsuarioRolController;
import py.com.cvs2.dto.UsuarioRolDto;

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
}
