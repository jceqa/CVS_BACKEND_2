package py.com.cvs2.rest;

import py.com.cvs2.controller.TipoCobroController;
import py.com.cvs2.model.TipoCobro;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tipocobro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoCobroRest {

    @GET
    public Response listTipoCobros(@QueryParam("all") Boolean all) {
        TipoCobroController mc = new TipoCobroController();
        List<TipoCobro> tipoCobros = mc.listTipoCobros(all);

        return Response.ok(tipoCobros, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getTipoCobroById(@PathParam("id") Integer id) {
        TipoCobroController mc = new TipoCobroController();
        TipoCobro tipoCobro = mc.getTipoCobroById(id);

        return Response.ok(tipoCobro, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveTipoCobro(TipoCobro tipoCobro) {
        TipoCobroController mc = new TipoCobroController();
        try {
            tipoCobro = mc.saveTipoCobro(tipoCobro);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(tipoCobro, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateTipoCobro(TipoCobro tipoCobro) {
        TipoCobroController mc = new TipoCobroController();
        try {
            tipoCobro = mc.updateTipoCobro(tipoCobro);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(tipoCobro, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTipoCobro(@PathParam("id") Integer id) {
        TipoCobroController mc = new TipoCobroController();

        try {
            mc.deleteTipoCobro(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
