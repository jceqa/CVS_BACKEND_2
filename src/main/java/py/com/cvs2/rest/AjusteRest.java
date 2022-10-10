package py.com.cvs2.rest;

import py.com.cvs2.controller.AjusteController;
import py.com.cvs2.model.Ajuste;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ajuste")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AjusteRest {

    @GET
    public Response listAjustes(@QueryParam("all") Boolean all) {
        AjusteController mc = new AjusteController();
        List<Ajuste> ajustes = mc.listAjustes(all);

        return Response.ok(ajustes, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getAjusteById(@PathParam("id") Integer id) {
        AjusteController mc = new AjusteController();
        Ajuste ajuste = mc.getAjusteById(id);

        return Response.ok(ajuste, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveAjuste(Ajuste ajuste) {
        AjusteController mc = new AjusteController();
        try {
            ajuste = mc.saveAjuste(ajuste);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(ajuste, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateAjuste(Ajuste ajuste) {
        AjusteController mc = new AjusteController();
        try {
            ajuste = mc.updateAjuste(ajuste);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(ajuste, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAjuste(@PathParam("id") Integer id) {
        AjusteController mc = new AjusteController();

        try {
            mc.deleteAjuste(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
