package py.com.cvs2.rest;

import py.com.cvs2.controller.CobroController;
import py.com.cvs2.dto.FiltroDto;
import py.com.cvs2.model.Cobro;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cobro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CobroRest {

    @GET
    public Response listCobros(@QueryParam("all") Boolean all) {
        CobroController mc = new CobroController();
        List<Cobro> cobros = mc.listCobros(all);

        return Response.ok(cobros, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/filter")
    public Response filterCobrosByDate(FiltroDto filtroDto){
        CobroController pc = new CobroController();
        List<Cobro> cobros = pc.filterCobrosByDate(filtroDto);

        return Response.ok(cobros, MediaType.APPLICATION_JSON).build();
    }
}
