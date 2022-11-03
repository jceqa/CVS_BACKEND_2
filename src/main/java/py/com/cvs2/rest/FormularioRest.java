package py.com.cvs2.rest;

import py.com.cvs2.controller.FormularioController;
import py.com.cvs2.model.Formulario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/formulario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FormularioRest {

    @GET
    public Response listFormularios(@QueryParam("all") Boolean all) {
        FormularioController mc = new FormularioController();
        List<Formulario> formularios = mc.listFormularios(all);

        return Response.ok(formularios, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getFormularioById(@PathParam("id") Integer id) {
        FormularioController mc = new FormularioController();
        Formulario formulario = mc.getFormularioById(id);

        return Response.ok(formulario, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveFormulario(Formulario formulario) {
        FormularioController mc = new FormularioController();
        try {
            formulario = mc.saveFormulario(formulario);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(formulario, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateFormulario(Formulario formulario) {
        FormularioController mc = new FormularioController();
        try {
            formulario = mc.updateFormulario(formulario);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(formulario, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFormulario(@PathParam("id") Integer id) {
        FormularioController mc = new FormularioController();

        try {
            mc.deleteFormulario(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
