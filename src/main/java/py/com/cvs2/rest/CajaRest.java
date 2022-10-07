package py.com.cvs2.rest;

import py.com.cvs2.controller.CajaController;
import py.com.cvs2.model.Caja;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/caja")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CajaRest {

    @GET
    public Response listCajas(@QueryParam("all") Boolean all) {
        CajaController mc = new CajaController();
        List<Caja> cajas = mc.listCajas(all);

        return Response.ok(cajas, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/sucursal/")
    public Response listCajasBySucursal(@QueryParam("id") List<Integer> id){
        CajaController cc = new CajaController();
        List<Caja> cajas = cc.listCajasBySucursal(id);

        return Response.ok(cajas, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getCajaById(@PathParam("id") Integer id) {
        CajaController mc = new CajaController();
        Caja caja = mc.getCajaById(id);

        return Response.ok(caja, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveCaja(Caja caja) {
        CajaController mc = new CajaController();
        try {
            caja = mc.saveCaja(caja);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(caja, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateCaja(Caja caja) {
        CajaController mc = new CajaController();
        try {
            caja = mc.updateCaja(caja);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(caja, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCaja(@PathParam("id") Integer id) {
        CajaController mc = new CajaController();

        try {
            mc.deleteCaja(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
