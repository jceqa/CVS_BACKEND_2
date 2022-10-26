package py.com.cvs2.rest;

import py.com.cvs2.controller.PedidoVentaController;
import py.com.cvs2.controller.RecepcionController;
import py.com.cvs2.controller.PresupuestoServicioController;
import py.com.cvs2.model.PedidoVenta;
import py.com.cvs2.model.Recepcion;
import py.com.cvs2.model.Servicio;
import py.com.cvs2.controller.OrdenServicioController;
import py.com.cvs2.model.OrdenServicio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ordenservicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdenServicioRest {

    @GET
    public Response listOrdenServicios(@QueryParam("all") Boolean all){
        OrdenServicioController pcc = new OrdenServicioController();
        List<OrdenServicio> ordenServicioList = pcc.listOrdenServicio(all);

        return Response.ok(ordenServicioList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listOrdenServicioPendientes(){
        OrdenServicioController pcc = new OrdenServicioController();
        List<OrdenServicio> ordenServicioList = pcc.listOrdenServicioPendientes();

        return Response.ok(ordenServicioList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/cliente/{idCliente}")
    public Response listOrdenServicioPendientesByCliente(@PathParam("idCliente") Integer idCliente){
        OrdenServicioController pcc = new OrdenServicioController();
        List<OrdenServicio> ordenServicioList = pcc.listOrdenServicioPendientesByCliente(idCliente);

        return Response.ok(ordenServicioList, MediaType.APPLICATION_JSON).build();
    }


    @POST
    public Response saveOrdenServicio(OrdenServicio ordenServicio) {
        OrdenServicioController pcc = new OrdenServicioController();
        try {
            ordenServicio = pcc.saveOrdenServicio(ordenServicio);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(ordenServicio, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelOrdenServicio(OrdenServicio ordenServicio) {
        OrdenServicioController pcc = new OrdenServicioController();

        try {
            pcc.cancelOrdenServicio(ordenServicio);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
