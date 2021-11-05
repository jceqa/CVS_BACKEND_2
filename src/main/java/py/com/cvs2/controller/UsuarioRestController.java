package py.com.cvs2.controller;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.digest.DigestUtils;

import py.com.cvs2.dao.UsuarioDao;
import py.com.cvs2.model.Usuario;
import py.com.cvs2.util.Configuracion;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestController {

	@POST
	@Path("validar")
	public Response validarUsuario(Usuario usuario) {

		usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));

		UsuarioDao usuariosDAO = new UsuarioDao();
		HashMap datos = usuariosDAO.validarAcceso(usuario);

		return Response.ok(datos, MediaType.APPLICATION_JSON).build();

	}

	@GET
	public Response getUserByToken(@QueryParam("token") String token) {

		Usuario usuario = Configuracion.getUsuarioJWT(token);

		return Response.ok(usuario, MediaType.APPLICATION_JSON).build();

	}
}
