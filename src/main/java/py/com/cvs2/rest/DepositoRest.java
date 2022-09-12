package py.com.cvs2.rest;


import py.com.cvs2.controller.DepositoController;
import py.com.cvs2.model.Deposito;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/deposito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepositoRest {

    @GET
    public Response listDepositos() {
        DepositoController dc = new DepositoController();
        List<Deposito> depositos = dc.listDepositos();

        return Response.ok(depositos, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getDepositoById(@PathParam("id") Integer id) {
        DepositoController dc = new DepositoController();
        Deposito deposito = dc.getDepositoById(id);

        return Response.ok(deposito, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveDeposito(Deposito deposito) {
        DepositoController dc = new DepositoController();
        deposito = dc.saveDeposito(deposito);

        return Response.ok(deposito, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateDeposito(Deposito deposito) {
        DepositoController dc = new DepositoController();
        deposito = dc.updateDeposito(deposito);

        return Response.ok(deposito, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDeposito(@PathParam("id") Integer id) {
        DepositoController dc = new DepositoController();

        dc.deleteDeposito(id);

        return Response.ok().build();
    }
}