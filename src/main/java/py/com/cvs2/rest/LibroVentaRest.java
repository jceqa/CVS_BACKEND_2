package py.com.cvs2.rest;

import py.com.cvs2.controller.LibroVentaController;
import py.com.cvs2.model.LibroVenta;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/libroventa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibroVentaRest {

    @GET
    public Response listLibrosVenta(@QueryParam("all") Boolean all){
        LibroVentaController lcc = new LibroVentaController();
        List<LibroVenta> libroVentaList = lcc.listLibrosVenta(all);

        return Response.ok(libroVentaList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveLibroVenta(LibroVenta libroVenta) {
        LibroVentaController lcc = new LibroVentaController();
        try {
            libroVenta = lcc.saveLibroVenta(libroVenta);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(libroVenta, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelLibroVenta(LibroVenta libroVenta) {
        LibroVentaController lcc = new LibroVentaController();

        try {
            lcc.cancelLibroVenta(libroVenta);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
