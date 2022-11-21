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
    public Response listArticulos(@QueryParam("all") Boolean all) {
        ArticuloController ac = new ArticuloController();
        List<Articulo> articulos = ac.listArticulos(all);

        return Response.ok(articulos, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("tipoarticulo/{idTipoArticulo}")
    public Response listArticulosByTipoArticulo(@PathParam("idTipoArticulo") Integer idTipoArticulo) {
        ArticuloController ac = new ArticuloController();
        List<Articulo> articulos = ac.listArticulosByTipoArticulo(idTipoArticulo);

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
        try {
            articulo = ac.saveArticulo(articulo);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(articulo, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateArticulo(Articulo articulo) {
        ArticuloController ac = new ArticuloController();
        try {
            articulo = ac.updateArticulo(articulo);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(articulo, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteArticulo(@PathParam("id") Integer id) {
        ArticuloController ac = new ArticuloController();

        try {
            ac.deleteArticulo(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }


        return Response.ok().build();
    }
}
