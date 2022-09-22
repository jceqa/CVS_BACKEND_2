package py.com.cvs2.rest;

import py.com.cvs2.controller.MarcaController;
import py.com.cvs2.controller.PedidoCompraController;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Marca;
import py.com.cvs2.model.PedidoCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pedidocompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoCompraRest {

    @GET
    public Response listPedidosCompra(@QueryParam("all") Boolean all){
        PedidoCompraController pcc = new PedidoCompraController();
        List<PedidoCompra> pedidoCompraList = pcc.listPedidosCompra(all);

        return Response.ok(pedidoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response savePedidoCompra(PedidoCompra pedidoCompra) {
        PedidoCompraController pcc = new PedidoCompraController();
        try {
            pedidoCompra = pcc.savePedidoCompra(pedidoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(pedidoCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelPedidoCompra(PedidoCompra pedidoCompra) {
        PedidoCompraController pcc = new PedidoCompraController();

        try {
            pcc.cancelPedidoCompra(pedidoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
