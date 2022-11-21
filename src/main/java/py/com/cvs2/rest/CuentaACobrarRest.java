package py.com.cvs2.rest;

import py.com.cvs2.controller.CuentaACobrarController;
import py.com.cvs2.model.CuentaACobrar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cuentaacobrar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CuentaACobrarRest {

    @GET
    public Response listCuentasACobrar(@QueryParam("all") Boolean all){
        CuentaACobrarController cpc = new CuentaACobrarController();
        List<CuentaACobrar> cuentaACobrarList = cpc.listCuentasACobrar(all);

        return Response.ok(cuentaACobrarList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listCuentasACobrarPendientes(){
        CuentaACobrarController nrc = new CuentaACobrarController();
        List<CuentaACobrar> cuentaACobrarList = nrc.listCuentasACobrarPendientes();

        return Response.ok(cuentaACobrarList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveCuentaACobrar(CuentaACobrar cuentaACobrar) {
        CuentaACobrarController cpc = new CuentaACobrarController();
        try {
            cuentaACobrar = cpc.saveCuentaACobrar(cuentaACobrar);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(cuentaACobrar, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelCuentaACobrar(CuentaACobrar cuentaACobrar) {
        CuentaACobrarController cpc = new CuentaACobrarController();

        try {
            cpc.cancelCuentaACobrar(cuentaACobrar);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }

    @PUT
    @Path("/procesar")
    public Response processCuentaACobrar(CuentaACobrar cuentaACobrar) {
        CuentaACobrarController ccc = new CuentaACobrarController();
        try {
            cuentaACobrar = ccc.processCuentaACobrar(cuentaACobrar);
        }  catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            return rb.build();
        }
        return Response.ok(cuentaACobrar, MediaType.APPLICATION_JSON).build();
    }

}


