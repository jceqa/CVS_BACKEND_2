package py.com.cvs2.rest;
import py.com.cvs2.controller.NotaVentaController;
import py.com.cvs2.model.NotaVenta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notacreditocompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotaVentaRest {

    @GET
    public Response listNotasVenta(@QueryParam("all") Boolean all){
        NotaVentaController ncc = new NotaVentaController();
        List<NotaVenta> notaVentaList = ncc.listNotasVenta(all);

        return Response.ok(notaVentaList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listNotasVentaPendientes(){
        NotaVentaController nrc = new NotaVentaController();
        List<NotaVenta> notaVentaList = nrc.listNotasVentaPendientes();

        return Response.ok(notaVentaList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/{idCliente}")
    public Response listNotaVentaPendientesByProveedor(@PathParam("idCliente") Integer idCliente){
        NotaVentaController pcc = new NotaVentaController();
        List<NotaVenta> pedidoVentaList = pcc.listNotaVentaPendientesByCliente(idCliente);

        return Response.ok(pedidoVentaList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveNotaVenta(NotaVenta notaVenta) {
        NotaVentaController ncc = new NotaVentaController();
        try {
            notaVenta = ncc.saveNotaVenta(notaVenta);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(notaVenta, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelNotaVenta(NotaVenta notaVenta) {
        NotaVentaController ncc = new NotaVentaController();

        try {
            ncc.cancelNotaVenta(notaVenta);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
