package py.com.cvs2.rest;

import py.com.cvs2.controller.PersonaController;
import py.com.cvs2.model.Persona;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/persona")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaRest {

    @GET
    public Response listPersonas(@QueryParam("all") Boolean all) {
        PersonaController pc = new PersonaController();
        List<Persona> personas = pc.listPersonas(all);

        return Response.ok(personas, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getPersonaById(@PathParam("id") Integer id) {
        PersonaController pc = new PersonaController();
        Persona persona = pc.getPersonaById(id);

        return Response.ok(persona, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response savePersona(Persona persona) {
        PersonaController pc = new PersonaController();
        try{
            persona = pc.savePersona(persona);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(persona, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updatePersona(Persona persona) {
        PersonaController pc = new PersonaController();
        try{
            persona = pc.updatePersona(persona);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(persona, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePersona(@PathParam("id") Integer id) {
        PersonaController pc = new PersonaController();

        try {
            pc.deletePersona(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
