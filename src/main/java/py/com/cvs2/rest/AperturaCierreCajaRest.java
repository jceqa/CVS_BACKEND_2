package py.com.cvs2.rest;

import py.com.cvs2.controller.AperturaCierreCajaController;
import py.com.cvs2.model.AperturaCierreCaja;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/aperturacierrecaja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AperturaCierreCajaRest {

    @GET
    public Response listAperturaCierreCajas(@QueryParam("all") Boolean all) {
        AperturaCierreCajaController mc = new AperturaCierreCajaController();
        List<AperturaCierreCaja> aperturaCierreCajas = mc.listAperturaCierreCajas(all);

        return Response.ok(aperturaCierreCajas, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getAperturaCierreCajaById(@PathParam("id") Integer id) {
        AperturaCierreCajaController mc = new AperturaCierreCajaController();
        AperturaCierreCaja aperturaCierreCaja = mc.getAperturaCierreCajaById(id);

        return Response.ok(aperturaCierreCaja, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/abiertos/{idSucursal}")
    public Response getAperturaCierreCajaAbiertaBySucursal(@PathParam("idSucursal") Integer idSucursal) {
        AperturaCierreCajaController mc = new AperturaCierreCajaController();
        List<AperturaCierreCaja> aperturaCierreCajas = mc.getAperturaCierreCajaAbiertaBySucursal(idSucursal);

        return Response.ok(aperturaCierreCajas, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveAperturaCierreCaja(AperturaCierreCaja aperturaCierreCaja) {
        AperturaCierreCajaController mc = new AperturaCierreCajaController();
        try {
            aperturaCierreCaja = mc.saveAperturaCierreCaja(aperturaCierreCaja);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(aperturaCierreCaja, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateAperturaCierreCaja(AperturaCierreCaja aperturaCierreCaja) {
        AperturaCierreCajaController mc = new AperturaCierreCajaController();
        try {
            aperturaCierreCaja = mc.updateAperturaCierreCaja(aperturaCierreCaja);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(aperturaCierreCaja, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAperturaCierreCaja(@PathParam("id") Integer id) {
        AperturaCierreCajaController mc = new AperturaCierreCajaController();

        try {
            mc.deleteAperturaCierreCaja(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
