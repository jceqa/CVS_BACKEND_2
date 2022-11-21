package py.com.cvs2.rest;

import py.com.cvs2.controller.TimbradoController;
import py.com.cvs2.model.Timbrado;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/timbrado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimbradoRest {

    @GET
    public Response listTimbrados(@QueryParam("all") Boolean all) {
        TimbradoController mc = new TimbradoController();
        List<Timbrado> timbrados = mc.listTimbrados(all);

        return Response.ok(timbrados, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getTimbradoById(@PathParam("id") Integer id) {
        TimbradoController mc = new TimbradoController();
        Timbrado timbrado = mc.getTimbradoById(id);

        return Response.ok(timbrado, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveTimbrado(Timbrado timbrado) {
        TimbradoController mc = new TimbradoController();
        try {
            timbrado = mc.saveTimbrado(timbrado);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(timbrado, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateTimbrado(Timbrado timbrado) {
        TimbradoController mc = new TimbradoController();
        try {
            timbrado = mc.updateTimbrado(timbrado);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(timbrado, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTimbrado(@PathParam("id") Integer id) {
        TimbradoController mc = new TimbradoController();

        try {
            mc.deleteTimbrado(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
