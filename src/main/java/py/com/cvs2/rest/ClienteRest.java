package py.com.cvs2.rest;

import py.com.cvs2.controller.ClienteController;
import py.com.cvs2.model.Cliente;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRest {

    @GET
    public Response listClientes(@QueryParam("all") Boolean all) {
        ClienteController cc = new ClienteController();
        List<Cliente> clientes = cc.listClientes(all);

        return Response.ok(clientes, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getProveedorById(@PathParam("id") Integer id) {
        ClienteController cc = new ClienteController();
        Cliente cliente = cc.getClienteById(id);

        return Response.ok(cliente, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveCliente(Cliente cliente) {
        ClienteController cc = new ClienteController();
        try{
            cliente = cc.saveCliente(cliente);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(cliente, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateCliente(Cliente cliente) {
        ClienteController cc = new ClienteController();
        try{
            cliente = cc.updateCliente(cliente);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(cliente, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") Integer id) {
        ClienteController cc = new ClienteController();

        try {
            cc.deleteCliente(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}