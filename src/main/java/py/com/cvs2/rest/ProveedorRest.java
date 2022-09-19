package py.com.cvs2.rest;
import py.com.cvs2.controller.ProveedorController;
import py.com.cvs2.model.Proveedor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


    @Path("/proveedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class ProveedorRest {

        @GET
        public Response listProveedores() {
            ProveedorController pc = new ProveedorController();
            List<Proveedor> proveedores = pc.listProveedores();

            return Response.ok(proveedores, MediaType.APPLICATION_JSON).build();
        }

        @GET
        @Path("/{id}")
        public Response getProveedorById(@PathParam("id") Integer id) {
            ProveedorController pc = new ProveedorController();
            Proveedor proveedor = pc.getProveedorById(id);

            return Response.ok(proveedor, MediaType.APPLICATION_JSON).build();
        }

        @POST
        public Response saveProveedor(Proveedor proveedor) {
            ProveedorController pc = new ProveedorController();
            try{
                proveedor = pc.saveProveedor(proveedor);
            } catch (Exception e) {
                Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
                rb.entity(e.getMessage());
                //throw new RuntimeException(e);
                return rb.build();
            }

            return Response.ok(proveedor, MediaType.APPLICATION_JSON).build();
        }

        @PUT
        public Response updateProveedor(Proveedor proveedor) {
            ProveedorController pc = new ProveedorController();
            try{
                proveedor = pc.updateProveedor(proveedor);
            } catch (Exception e) {
                Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
                rb.entity(e.getMessage());
                //throw new RuntimeException(e);
                return rb.build();
            }

            return Response.ok(proveedor, MediaType.APPLICATION_JSON).build();
        }

        @DELETE
        @Path("/{id}")
        public Response deleteProveedor(@PathParam("id") Integer id) {
            ProveedorController pc = new ProveedorController();

            try {
                pc.deleteProveedor(id);
            } catch (Exception e) {
                Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
                rb.entity(e.getMessage());
                //throw new RuntimeException(e);
                return rb.build();
            }

            return Response.ok().build();
        }
    }


