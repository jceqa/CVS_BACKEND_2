package py.com.cvs2.rest;

import py.com.cvs2.controller.PromoDescuentoController;
import py.com.cvs2.model.PromoDescuento;
import py.com.cvs2.dao.PromoDescuentoDao;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/promodescuento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PromoDescuentoRest {

    @GET
    public Response listPromoDescuentos(@QueryParam("all") Boolean all) {
        PromoDescuentoController sc = new PromoDescuentoController();
        List<PromoDescuento> promoDescuentos = sc.listPromoDescuentos(all);

        return Response.ok(promoDescuentos, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getPromoDescuentoById(@PathParam("id") Integer id) {
        PromoDescuentoController sc = new PromoDescuentoController();
        PromoDescuento promoDescuento = sc.getPromoDescuentoById(id);

        return Response.ok(promoDescuento, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response savePromoDescuento(PromoDescuento promoDescuento) {
        PromoDescuentoController sc = new PromoDescuentoController();
        try {
            promoDescuento = sc.savePromoDescuento(promoDescuento);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(promoDescuento, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updatePromoDescuento(PromoDescuento promoDescuento) {
        PromoDescuentoController sc = new PromoDescuentoController();
        try {
            promoDescuento = sc.updatePromoDescuento(promoDescuento);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(promoDescuento, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePromoDescuento(@PathParam("id") Integer id) {
        PromoDescuentoController sc = new PromoDescuentoController();

        try {
            sc.deletePromoDescuento(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }


        return Response.ok().build();
    }
}