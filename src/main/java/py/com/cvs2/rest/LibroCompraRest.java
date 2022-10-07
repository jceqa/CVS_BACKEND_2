package py.com.cvs2.rest;

import py.com.cvs2.controller.LibroCompraController;
import py.com.cvs2.model.LibroCompra;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/librocompra")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibroCompraRest {

    @GET
    public Response listLibrosCompra(@QueryParam("all") Boolean all){
        LibroCompraController lcc = new LibroCompraController();
        List<LibroCompra> libroCompraList = lcc.listLibrosCompra(all);

        return Response.ok(libroCompraList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveLibroCompra(LibroCompra libroCompra) {
        LibroCompraController lcc = new LibroCompraController();
        try {
            libroCompra = lcc.saveLibroCompra(libroCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(libroCompra, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelLibroCompra(LibroCompra libroCompra) {
        LibroCompraController lcc = new LibroCompraController();

        try {
            lcc.cancelLibroCompra(libroCompra);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
