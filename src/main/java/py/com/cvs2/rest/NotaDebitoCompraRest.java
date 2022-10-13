package py.com.cvs2.rest;

import py.com.cvs2.controller.NotaDebitoCompraController;
import py.com.cvs2.model.NotaDebitoCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notadebitocompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotaDebitoCompraRest {

    @GET
    public Response listNotasDebitoCompra(@QueryParam("all") Boolean all){
        NotaDebitoCompraController nrc = new NotaDebitoCompraController();
        List<NotaDebitoCompra> notaDebitoCompraList = nrc.listNotasDebitoCompra(all);

        return Response.ok(notaDebitoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listNotasDebitoCompraPendientes(){
        NotaDebitoCompraController nrc = new NotaDebitoCompraController();
        List<NotaDebitoCompra> notaDebitoCompraList = nrc.listNotasDebitoCompraPendientes();

        return Response.ok(notaDebitoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/procesar")
    public Response processNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) {
        NotaDebitoCompraController nrc = new NotaDebitoCompraController();
        try {
            notaDebitoCompra = nrc.processNotaDebitoCompra(notaDebitoCompra);
        }  catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            return rb.build();
        }
        return Response.ok(notaDebitoCompra, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) {
        NotaDebitoCompraController nrc = new NotaDebitoCompraController();
        try {
            notaDebitoCompra = nrc.saveNotaDebitoCompra(notaDebitoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(notaDebitoCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelNotaDebitoCompra(NotaDebitoCompra notaDebitoCompra) {
        NotaDebitoCompraController nrc = new NotaDebitoCompraController();

        try {
            nrc.cancelNotaDebitoCompra(notaDebitoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
