package py.com.cvs2.rest;

import py.com.cvs2.controller.NotaCreditoCompraController;
import py.com.cvs2.controller.NotaDebitoCompraController;
import py.com.cvs2.controller.PresupuestoCompraController;
import py.com.cvs2.model.NotaCreditoCompra;
import py.com.cvs2.model.NotaDebitoCompra;
import py.com.cvs2.model.PresupuestoCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notacreditocompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotaCreditoCompraRest {

    @GET
    public Response listNotasCreditoCompra(@QueryParam("all") Boolean all){
        NotaCreditoCompraController ncc = new NotaCreditoCompraController();
        List<NotaCreditoCompra> notaCreditoCompraList = ncc.listNotasCreditoCompra(all);

        return Response.ok(notaCreditoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listNotasCreditoCompraPendientes(){
        NotaCreditoCompraController nrc = new NotaCreditoCompraController();
        List<NotaCreditoCompra> notaCreditoCompraList = nrc.listNotasCreditoCompraPendientes();

        return Response.ok(notaCreditoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/{idProveedor}")
    public Response listNotaCreditoCompraPendientesByProveedor(@PathParam("idProveedor") Integer idProveedor){
        NotaCreditoCompraController pcc = new NotaCreditoCompraController();
        List<NotaCreditoCompra> presupuestoCompraList = pcc.listNotaCreditoCompraPendientesByProveedor(idProveedor);

        return Response.ok(presupuestoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveNotaCreditoCompra(NotaCreditoCompra notaCreditoCompra) {
        NotaCreditoCompraController ncc = new NotaCreditoCompraController();
        try {
            notaCreditoCompra = ncc.saveNotaCreditoCompra(notaCreditoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(notaCreditoCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelNotaCreditoCompra(NotaCreditoCompra notaCreditoCompra) {
        NotaCreditoCompraController ncc = new NotaCreditoCompraController();

        try {
            ncc.cancelNotaCreditoCompra(notaCreditoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
