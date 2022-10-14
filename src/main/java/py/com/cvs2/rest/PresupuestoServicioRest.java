package py.com.cvs2.rest;

import py.com.cvs2.controller.RecepcionController;
import py.com.cvs2.controller.PresupuestoServicioController;
import py.com.cvs2.model.Recepcion;
import py.com.cvs2.model.PresupuestoServicio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/presupuestoservicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresupuestoServicioRest {

    @GET
    public Response listPresupuestosServicio(@QueryParam("all") Boolean all){
        PresupuestoServicioController pcc = new PresupuestoServicioController();
        List<PresupuestoServicio> presupuestoServicioList = pcc.listPresupuestosServicio(all);

        return Response.ok(presupuestoServicioList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/sucursal/{idSucursal}")
    public Response listPresupuestoServicioBySucursal(@PathParam("idSucursal") Integer idSucursal){
        PresupuestoServicioController pcc = new PresupuestoServicioController();
        List<PresupuestoServicio> presupuestoServicioList = pcc.listPresupuestosServicioBySucursal(idSucursal);

        return Response.ok(presupuestoServicioList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listPresupuestoServicioPendientes(){
        PresupuestoServicioController pcc = new PresupuestoServicioController();
        List<PresupuestoServicio> presupuestoServicioList = pcc.listPresupuestoServicioPendientes();

        return Response.ok(presupuestoServicioList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/{idSucursal}")
    public Response listPresupuestoCompraPendientesBySucursal(@PathParam("idSucursal") Integer idSucursal){
        PresupuestoServicioController pcc = new PresupuestoServicioController();
        List<PresupuestoServicio> presupuestoServicioList = pcc.listPresupuestoServicioPendientesBySucursal(idSucursal);

        return Response.ok(presupuestoServicioList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response savePresupuestoServicio(PresupuestoServicio presupuestoServicio) {
        PresupuestoServicioController pcc = new PresupuestoServicioController();
        try {
            presupuestoServicio = pcc.savePresupuestoServicio(presupuestoServicio);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(presupuestoServicio, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelPresupuestoServicio(PresupuestoServicio presupuestoServicio) {
        PresupuestoServicioController pcc = new PresupuestoServicioController();

        try {
            pcc.cancelPresupuestoServicio(presupuestoServicio);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}