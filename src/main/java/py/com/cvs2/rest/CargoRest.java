/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;


import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.CargoController;
import py.com.cvs2.model.Cargo;

@Path("/cargo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CargoRest {

    @GET
    public Response listCargos(@QueryParam("all") Boolean all) {
        CargoController cc = new CargoController();
        List<Cargo> cargos = cc.listCargos(all);

        return Response.ok(cargos, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getCargoById(@PathParam("id") Integer id) {
        CargoController cc = new CargoController();
        Cargo cargo = cc.getCargoById(id);

        return Response.ok(cargo, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveCargo(Cargo cargo) {
        CargoController cc = new CargoController();
        try {
            cargo = cc.saveCargo(cargo);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(cargo, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateCargo(Cargo cargo) {
        CargoController cc = new CargoController();
        try {
            cargo = cc.updateCargo(cargo);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(cargo, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCargo(@PathParam("id") Integer id) {
        CargoController cc = new CargoController();

        try {
            cc.deleteCargo(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }

}
