package py.com.cvs2.rest;

import py.com.cvs2.controller.MarcaController;
import py.com.cvs2.controller.RecepcionController;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Marca;
import py.com.cvs2.model.Recepcion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/recepcion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecepcionRest {

    @GET
    public Response listRecepcion(@QueryParam("all") Boolean all){
        RecepcionController rc = new RecepcionController();
        List<Recepcion> recepcionList = rc.listRecepcion(all);

        return Response.ok(recepcionList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listRecepcionPendientes(){
        RecepcionController rc = new RecepcionController();
        List<Recepcion> recepcionList = rc.listRecepcionPendientes();

        return Response.ok(recepcionList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveRecepcion(Recepcion recepcion) {
        RecepcionController rc = new RecepcionController();
        try {
            recepcion = rc.saveRecepcion(recepcion);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(recepcion, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelRecepcion(Recepcion recepcion) {
        RecepcionController rc = new RecepcionController();

        try {
            rc.cancelRecepcion(recepcion);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
