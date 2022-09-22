package py.com.cvs2.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.MarcaController;
import py.com.cvs2.model.Marca;

@Path("/marca")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class
MarcaRest {

    @GET
    public Response listMarcas(@QueryParam("all") Boolean all) {
        MarcaController mc = new MarcaController();
        List<Marca> marcas = mc.listMarcas(all);

        return Response.ok(marcas, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getMarcaById(@PathParam("id") Integer id) {
        MarcaController mc = new MarcaController();
        Marca marca = mc.getMarcaById(id);

        return Response.ok(marca, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveMarca(Marca marca) {
        MarcaController mc = new MarcaController();
        try {
            marca = mc.saveMarca(marca);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(marca, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateMarca(Marca marca) {
        MarcaController mc = new MarcaController();
        try {
            marca = mc.updateMarca(marca);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(marca, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMarca(@PathParam("id") Integer id) {
        MarcaController mc = new MarcaController();

        try {
            mc.deleteMarca(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
