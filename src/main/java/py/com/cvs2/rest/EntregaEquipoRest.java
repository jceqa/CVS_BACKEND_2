package py.com.cvs2.rest;

import py.com.cvs2.controller.FacturaController;
import py.com.cvs2.controller.EntregaEquipoController;
import py.com.cvs2.model.Factura;
import py.com.cvs2.model.EntregaEquipo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/entregaequipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntregaEquipoRest {

    @GET
    public Response listEntregaEquipos(@QueryParam("all") Boolean all){
        EntregaEquipoController pcc = new EntregaEquipoController();
        List<EntregaEquipo> entregaEquipoList = pcc.listEntregaEquipos(all);

        return Response.ok(entregaEquipoList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/sucursal/{idSucursal}")
    public Response listEntregaEquipoBySucursal(@PathParam("idSucursal") Integer idSucursal){
        EntregaEquipoController pcc = new EntregaEquipoController();
        List<EntregaEquipo> entregaEquipoList = pcc.listEntregaEquiposBySucursal(idSucursal);

        return Response.ok(entregaEquipoList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listEntregaEquiposPendientes(){
        EntregaEquipoController pcc = new EntregaEquipoController();
        List<EntregaEquipo> entregaEquipoList = pcc.listEntregaEquipoPendientes();

        return Response.ok(entregaEquipoList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/{idProveedor}")
    public Response listEntregaEquipoPendientesByProveedor(@PathParam("idProveedor") Integer idProveedor){
        EntregaEquipoController pcc = new EntregaEquipoController();
        List<EntregaEquipo> entregaEquipoList = pcc.listEntregaEquipoPendientesByProveedor(idProveedor);

        return Response.ok(entregaEquipoList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveEntregaEquipo(EntregaEquipo entregaEquipo) {
        EntregaEquipoController pcc = new EntregaEquipoController();
        try {
            entregaEquipo = pcc.saveEntregaEquipo(entregaEquipo);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(entregaEquipo, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelEntregaEquipo(EntregaEquipo entregaEquipo) {
        EntregaEquipoController pcc = new EntregaEquipoController();

        try {
            pcc.cancelEntregaEquipo(entregaEquipo);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}