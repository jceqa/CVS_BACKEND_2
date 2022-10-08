package py.com.cvs2.rest;


import py.com.cvs2.controller.OrdenCompraController;
import py.com.cvs2.controller.PresupuestoCompraController;
import py.com.cvs2.model.OrdenCompra;
import py.com.cvs2.model.PresupuestoCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ordencompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdenCompraRest {

    @GET
    public Response listOrdenCompra(@QueryParam("all") Boolean all){
        OrdenCompraController occ = new OrdenCompraController();
        List<OrdenCompra> ordenCompraList = occ.listOrdenCompra(all);

        return Response.ok(ordenCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listOrdenCompraPendientes(){
        OrdenCompraController occ = new OrdenCompraController();
        List<OrdenCompra> ordenCompraList = occ.listOrdenCompraPendientes();

        return Response.ok(ordenCompraList, MediaType.APPLICATION_JSON).build();
    }

    /*@GET
    @Path("/sucursal/{idSucursal}")
    public Response listOrdenCompraBySucursal(@PathParam("idSucursal") Integer idSucursal){
        OrdenCompraController pcc = new OrdenCompraController();
        List<OrdenCompra> ordenCompraList = pcc.listOrdenCompraBySucursal(idSucursal);

        return Response.ok(ordenCompraList, MediaType.APPLICATION_JSON).build();
    }*/

    @POST
    public Response saveOrdenCompra(OrdenCompra ordenCompra) {
        OrdenCompraController occ = new OrdenCompraController();
        try {
            ordenCompra = occ.saveOrdenCompra(ordenCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(ordenCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelOrdenCompra(OrdenCompra ordenCompra) {
        OrdenCompraController occ = new OrdenCompraController();

        try {
            occ.cancelOrdenCompra(ordenCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}