package py.com.cvs2.rest;


import py.com.cvs2.controller.SucursalController;
import py.com.cvs2.model.Sucursal;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sucursal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SucursalRest {

    @GET
    public Response listSucursales() {
        SucursalController sc = new SucursalController();
        List<Sucursal> sucursales = sc.listSucursales();

        return Response.ok(sucursales, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getSucursalById(@PathParam("id") Integer id) {
        SucursalController sc = new SucursalController();
        Sucursal sucursal = sc.getSucursalById(id);

        return Response.ok(sucursal, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveSucursal(Sucursal sucursal) {
        SucursalController sc = new SucursalController();
        try{
            sucursal = sc.saveSucursal(sucursal);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(sucursal, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateSucursal(Sucursal sucursal) {
        SucursalController sc = new SucursalController();
        try{
            sucursal = sc.updateSucursal(sucursal);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(sucursal, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSucursal(@PathParam("id") Integer id) {
        SucursalController sc = new SucursalController();

        try {
            sc.deleteSucursal(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}