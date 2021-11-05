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
import py.com.cvs2.dao.MarcaDao;
import py.com.cvs2.model.Marca;

@Path("/marca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaRestController {

	@GET
	public Response getMarcas() {
		MarcaDao marcaDAO = new MarcaDao();
		List<Marca> marcas = marcaDAO.list();

		return Response.ok(marcas, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getMarcaById(@PathParam("id") Integer id) {
		MarcaDao marcaDAO = new MarcaDao();
		Marca marca = marcaDAO.findById(id);

		return Response.ok(marca, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response setMarca(Marca marca) {
		MarcaDao marcaDao = new MarcaDao();
		marca = marcaDao.save(marca);

		return Response.ok(marca, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateMarca(Marca marca) {
		MarcaDao marcaDao = new MarcaDao();
		marca = marcaDao.update(marca);

		return Response.ok(marca, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteMarca(@PathParam("id") Integer id) {
		MarcaDao marcaDao = new MarcaDao();

		marcaDao.delete(id);

		return Response.ok().build();
	}

}
