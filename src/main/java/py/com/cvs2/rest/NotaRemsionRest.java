package py.com.cvs2.rest;

import py.com.cvs2.controller.NotaRemisionController;
import py.com.cvs2.model.NotaRemision;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notaremision")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotaRemsionRest {

    @GET
    public Response listNotasRemision(@QueryParam("all") Boolean all){
        NotaRemisionController nrc = new NotaRemisionController();
        List<NotaRemision> notaRemisionList = nrc.listNotasRemision(all);

        return Response.ok(notaRemisionList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listNotasRemisionPendientes(){
        NotaRemisionController nrc = new NotaRemisionController();
        List<NotaRemision> notaRemisionList = nrc.listNotasRemisionPendientes();

        return Response.ok(notaRemisionList, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/procesar")
    public Response processNotaRemision(NotaRemision notaRemision) {
        NotaRemisionController nrc = new NotaRemisionController();
        try {
            notaRemision = nrc.processNotaRemision(notaRemision);
        }  catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            return rb.build();
        }
        return Response.ok(notaRemision, MediaType.APPLICATION_JSON).build();
    }


    @POST
    public Response saveNotaRemision(NotaRemision notaRemision) {
        NotaRemisionController nrc = new NotaRemisionController();
        try {
            notaRemision = nrc.saveNotaRemision(notaRemision);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(notaRemision, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelNotaRemision(NotaRemision notaRemision) {
        NotaRemisionController nrc = new NotaRemisionController();

        try {
            nrc.cancelNotaRemision(notaRemision);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
