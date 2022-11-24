package py.com.cvs2.rest;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.TipoNotaController;
import py.com.cvs2.model.TipoNota;

@Path("/tiponota")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoNotaRest {

    @GET
    public Response listTipoNotas(@QueryParam("all") Boolean all) {
        TipoNotaController cc = new TipoNotaController();
        List<TipoNota> tipoNotas = cc.listTipoNotas(all);

        return Response.ok(tipoNotas, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getTipoNotaById(@PathParam("id") Integer id) {
        TipoNotaController cc = new TipoNotaController();
        TipoNota tipoNota = cc.getTipoNotaById(id);

        return Response.ok(tipoNota, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveTipoNota(TipoNota tipoNota) {
        TipoNotaController cc = new TipoNotaController();
        try{
            tipoNota = cc.saveTipoNota(tipoNota);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(tipoNota, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateMarca(TipoNota tipoNota) {
        TipoNotaController cc = new TipoNotaController();
        try{
            tipoNota = cc.updateTipoNota(tipoNota);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(tipoNota, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTipoNota(@PathParam("id") Integer id) {
        TipoNotaController cc = new TipoNotaController();

        try {
            cc.deleteTipoNota(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}

