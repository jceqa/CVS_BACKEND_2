package py.com.cvs2.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.dao.GenericDao;

public class GenericRestController<T, K extends GenericDao<T>> {

	private Class<T> type;

	public GenericRestController() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@GET
	public Response getAll() {
		//K k = new K();
		//List<T> tL = k.list();

		return Response.ok(/*tL*/ MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		GenericDao<T> dao = new GenericDao<T>();
		T t = dao.findById(id);

		return Response.ok(t, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response set(T t) {
		GenericDao<T> dao = new GenericDao<T>();
		t = dao.save(t);

		return Response.ok(t, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response update(T t) {
		GenericDao<T> dao = new GenericDao<T>();
		t = dao.update(t);

		return Response.ok(t, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		GenericDao<T> dao = new GenericDao<T>();

		dao.delete(id);

		return Response.ok().build();
	}

}
