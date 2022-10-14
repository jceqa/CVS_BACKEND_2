package py.com.cvs2.rest;

import py.com.cvs2.controller.PagoController;
import py.com.cvs2.model.Pago;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pago")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagoRest {

    @GET
    public Response listPagos(@QueryParam("all") Boolean all) {
        PagoController mc = new PagoController();
        List<Pago> pagos = mc.listPagos(all);

        return Response.ok(pagos, MediaType.APPLICATION_JSON).build();
    }
}
