package py.com.cvs2.rest;

import py.com.cvs2.controller.PedidoCompraController;
import py.com.cvs2.controller.PresupuestoCompraController;
import py.com.cvs2.model.PedidoCompra;
import py.com.cvs2.model.PresupuestoCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reclamo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReclamoRest {

    @GET
    public Response listPresupuestosCompra(@QueryParam("all") Boolean all){
        PresupuestoCompraController pcc = new PresupuestoCompraController();
        List<PresupuestoCompra> presupuestoCompraList = pcc.listPresupuestosCompra(all);

        return Response.ok(presupuestoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/sucursal/{idSucursal}")
    public Response listPresupuestoCompraBySucursal(@PathParam("idSucursal") Integer idSucursal){
        PresupuestoCompraController pcc = new PresupuestoCompraController();
        List<PresupuestoCompra> presupuestoCompraList = pcc.listPresupuestosCompraBySucursal(idSucursal);

        return Response.ok(presupuestoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listPresupuestoCompraPendientes(){
        PresupuestoCompraController pcc = new PresupuestoCompraController();
        List<PresupuestoCompra> presupuestoCompraList = pcc.listPresupuestoCompraPendientes();

        return Response.ok(presupuestoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/{idProveedor}")
    public Response listPresupuestoCompraPendientesByProveedor(@PathParam("idProveedor") Integer idProveedor){
        PresupuestoCompraController pcc = new PresupuestoCompraController();
        List<PresupuestoCompra> presupuestoCompraList = pcc.listPresupuestoCompraPendientesByProveedor(idProveedor);

        return Response.ok(presupuestoCompraList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response savePresupuestoCompra(PresupuestoCompra presupuestoCompra) {
        PresupuestoCompraController pcc = new PresupuestoCompraController();
        try {
            presupuestoCompra = pcc.savePresupuestoCompra(presupuestoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(presupuestoCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelPresupuestoCompra(PresupuestoCompra presupuestoCompra) {
        PresupuestoCompraController pcc = new PresupuestoCompraController();

        try {
            pcc.cancelPresupuestoCompra(presupuestoCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}