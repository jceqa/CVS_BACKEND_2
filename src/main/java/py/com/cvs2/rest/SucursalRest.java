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
    public Response saveSucursal(Sucursal sucursal) throws Exception {
        SucursalController sc = new SucursalController();
        sucursal = sc.saveSucursal(sucursal);

        return Response.ok(sucursal, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateSucursal(Sucursal sucursal) {
        SucursalController sc = new SucursalController();
        sucursal = sc.updateSucursal(sucursal);

        return Response.ok(sucursal, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSucursal(@PathParam("id") Integer id) {
        SucursalController sc = new SucursalController();

        sc.deleteSucursal(id);

        return Response.ok().build();
    }
}