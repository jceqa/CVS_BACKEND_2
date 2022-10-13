package py.com.cvs2.rest;
import py.com.cvs2.controller.ServicioController;
import py.com.cvs2.model.Servicio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/servicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioRest {

    @GET
    public Response listServicios(@QueryParam("all") Boolean all) {
        ServicioController sc = new ServicioController();
        List<Servicio> servicios = sc.listServicios(all);

        return Response.ok(servicios, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getServicioById(@PathParam("id") Integer id) {
        ServicioController sc = new ServicioController();
        Servicio servicio = sc.getServicioById(id);

        return Response.ok(servicio, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveServicio(Servicio servicio) {
        ServicioController sc = new ServicioController();
        try {
            servicio = sc.saveServicio(servicio);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(servicio, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateServicio(Servicio servicio) {
        ServicioController sc = new ServicioController();
        try {
            servicio = sc.updateServicio(servicio);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(servicio, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteServicio(@PathParam("id") Integer id) {
        ServicioController sc = new ServicioController();

        try {
            sc.deleteServicio(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }


        return Response.ok().build();
    }
}