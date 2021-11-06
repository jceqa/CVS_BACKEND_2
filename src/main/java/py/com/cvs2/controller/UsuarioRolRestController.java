package py.com.cvs2.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.dao.UsuarioRolDao;
import py.com.cvs2.model.UsuarioRol;

@Path("/usuariorol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRolRestController {

	@GET
	@Path("/{id}")
	public Response getUsuarioRolById(@PathParam("id") Integer id) {
		UsuarioRolDao urDAO = new UsuarioRolDao();
		UsuarioRol ur = urDAO.findById(id);

		return Response.ok(ur, MediaType.APPLICATION_JSON).build();
	}

}
