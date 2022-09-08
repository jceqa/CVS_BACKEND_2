package py.com.cvs2.rest;

import py.com.cvs2.controller.ArticuloController;
import py.com.cvs2.model.Articulo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/articulo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArticuloRest {

    @GET
    public Response listArticulos() {
        ArticuloController ac = new ArticuloController();
        List<Articulo> articulos = ac.listArticulos();

        return Response.ok(articulos, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getArticuloById(@PathParam("id") Integer id) {
        ArticuloController ac = new ArticuloController();
        Articulo articulo = ac.getArticuloById(id);

        return Response.ok(articulo, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveArticulo(Articulo articulo) {
        ArticuloController ac = new ArticuloController();
        articulo = ac.saveArticulo(articulo);

        return Response.ok(articulo, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateArticulo(Articulo articulo) {
        ArticuloController ac = new ArticuloController();
        articulo = ac.updateArticulo(articulo);

        return Response.ok(articulo, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteArticulo(@PathParam("id") Integer id) {
        ArticuloController ac = new ArticuloController();

        ac.deleteArticulo(id);

        return Response.ok().build();
    }
}
