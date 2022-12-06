package py.com.cvs2.rest;

import py.com.cvs2.controller.FacturaController;
import py.com.cvs2.model.Factura;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/factura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaRest {

    @GET
    @Path("/numeroactual")
    public Response getNumeroActual() {
        FacturaController fc = new FacturaController();
        Integer numeroActual = fc.getNumeroActual();

        return Response.ok(numeroActual, MediaType.APPLICATION_JSON).build();
    }

    @GET
    public Response listFacturas(@QueryParam("all") Boolean all){
        FacturaController pcc = new FacturaController();
        List<Factura> facturaList = pcc.listFacturas(all);

        return Response.ok(facturaList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/procesadas")
    public Response listFacturasProcesadas(){
        FacturaController fcc = new FacturaController();
        List<Factura> facturaList = fcc.listFacturasProcesadas();

        return Response.ok(facturaList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/caja/{idCaja}")
    public Response listFacturasByCaja(@PathParam("idCaja") Integer idCaja){
        FacturaController fcc = new FacturaController();
        List<Factura> facturaList = fcc.listFacturasByCaja(idCaja);

        return Response.ok(facturaList, MediaType.APPLICATION_JSON).build();
    }


    @POST
    public Response saveFactura(Factura factura) {
        FacturaController pcc = new FacturaController();
        try {
            factura = pcc.saveFactura(factura);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(factura, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelFactura(Factura factura) {
        FacturaController pcc = new FacturaController();

        try {
            pcc.cancelFactura(factura);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
