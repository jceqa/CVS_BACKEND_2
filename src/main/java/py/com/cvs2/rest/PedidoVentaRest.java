package py.com.cvs2.rest;

import py.com.cvs2.controller.MarcaController;
import py.com.cvs2.controller.PedidoVentaController;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Marca;
import py.com.cvs2.model.PedidoVenta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pedidoventa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoVentaRest {

    @GET
    public Response listPedidosVenta(@QueryParam("all") Boolean all){
        PedidoVentaController pcc = new PedidoVentaController();
        List<PedidoVenta> pedidoVentaList = pcc.listPedidosVenta(all);

        return Response.ok(pedidoVentaList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listPedidosVentaPendientes(){
        PedidoVentaController pcc = new PedidoVentaController();
        List<PedidoVenta> pedidoVentaList = pcc.listPedidosVentaPendientes();

        return Response.ok(pedidoVentaList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response savePedidoVenta(PedidoVenta pedidoVenta) {
        PedidoVentaController pcc = new PedidoVentaController();
        try {
            pedidoVenta = pcc.savePedidoVenta(pedidoVenta);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(pedidoVenta, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelPedidoVenta(PedidoVenta pedidoVenta) {
        PedidoVentaController pcc = new PedidoVentaController();

        try {
            pcc.cancelPedidoVenta(pedidoVenta);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
