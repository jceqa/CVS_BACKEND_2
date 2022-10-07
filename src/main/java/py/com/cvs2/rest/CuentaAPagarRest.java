package py.com.cvs2.rest;

import py.com.cvs2.controller.CuentaAPagarController;
import py.com.cvs2.model.CuentaAPagar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cuentaapagar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CuentaAPagarRest {

    @GET
    public Response listCuentasAPagar(@QueryParam("all") Boolean all){
        CuentaAPagarController cpc = new CuentaAPagarController();
        List<CuentaAPagar> cuentaAPagarList = cpc.listCuentasAPagar(all);

        return Response.ok(cuentaAPagarList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveCuentaAPagar(CuentaAPagar cuentaAPagar) {
        CuentaAPagarController cpc = new CuentaAPagarController();
        try {
            cuentaAPagar = cpc.saveCuentaAPagar(cuentaAPagar);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(cuentaAPagar, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelCuentaAPagar(CuentaAPagar cuentaAPagar) {
        CuentaAPagarController cpc = new CuentaAPagarController();

        try {
            cpc.cancelCuentaAPagar(cuentaAPagar);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
