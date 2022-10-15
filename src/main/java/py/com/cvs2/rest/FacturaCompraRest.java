package py.com.cvs2.rest;

import py.com.cvs2.controller.FacturaCompraController;
import py.com.cvs2.model.FacturaCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/facturacompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaCompraRest {

    @GET
    public Response listFacturasCompra(@QueryParam("all") Boolean all){
        FacturaCompraController pcc = new FacturaCompraController();
        List<FacturaCompra> facturaCompraList = pcc.listFacturasCompra(all);

        return Response.ok(facturaCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/procesadas")
    public Response listFacturasCompraProcesadas(){
        FacturaCompraController fcc = new FacturaCompraController();
        List<FacturaCompra> facturaCompraList = fcc.listFacturasCompraProcesadas();

        return Response.ok(facturaCompraList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveFacturaCompra(FacturaCompra facturaCompra) {
        FacturaCompraController pcc = new FacturaCompraController();
        try {
            facturaCompra = pcc.saveFacturaCompra(facturaCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(facturaCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelFacturaCompra(FacturaCompra facturaCompra) {
        FacturaCompraController pcc = new FacturaCompraController();

        try {
            pcc.cancelFacturaCompra(facturaCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
