package py.com.cvs2.rest;

import py.com.cvs2.controller.CondicionPagoController;
import py.com.cvs2.controller.EntidadEmisoraController;
import py.com.cvs2.model.CondicionPago;
import py.com.cvs2.model.EntidadEmisora;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/condicionpago")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CondicionPagoRest {

    @GET
    public Response listCondicionPagos() {
        CondicionPagoController cpc = new CondicionPagoController();
        List<CondicionPago> condicionPagos = cpc.listCondicionPagos();

        return Response.ok(condicionPagos, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getCondicionPagoById(@PathParam("id") Integer id) {
        CondicionPagoController cpc = new CondicionPagoController();
        CondicionPago condicionPago = cpc.getCondicionPagoById(id);

        return Response.ok(condicionPago, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveCondicionPago(CondicionPago condicionPago) {
        CondicionPagoController cpc = new CondicionPagoController();
        try{
            condicionPago = cpc.saveCondicionPago(condicionPago);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(condicionPago, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateCondicionPago(CondicionPago condicionPago) {
        CondicionPagoController cpc = new CondicionPagoController();
        try{
            condicionPago = cpc.updateCondicionPago(condicionPago);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(condicionPago, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCondicionPago(@PathParam("id") Integer id) {
        CondicionPagoController cpc = new CondicionPagoController();

        try {
            cpc.deleteCondicionPago(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
