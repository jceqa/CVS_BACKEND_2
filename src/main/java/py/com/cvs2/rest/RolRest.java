package py.com.cvs2.rest;

import py.com.cvs2.controller.RolController;
import py.com.cvs2.dto.RolPermisoDto;
import py.com.cvs2.model.Rol;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolRest {

    @GET
    public Response listRoles(@QueryParam("all") Boolean all) {
        RolController mc = new RolController();
        List<RolPermisoDto> roles = mc.listRoles(all);

        return Response.ok(roles, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    public Response getRolById(@PathParam("id") Integer id) {
        RolController mc = new RolController();
        RolPermisoDto rol = mc.getRolById(id);

        return Response.ok(rol, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveRol(RolPermisoDto rolPermisoDto) {
        RolController mc = new RolController();
        try {
            rolPermisoDto = mc.saveRol(rolPermisoDto);

        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(rolPermisoDto, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response updateRol(RolPermisoDto rolPermisoDto) {
        RolController mc = new RolController();
        try {
            rolPermisoDto = mc.updateRol(rolPermisoDto);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok(rolPermisoDto, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRol(@PathParam("id") Integer id) {
        RolController mc = new RolController();

        try {
            mc.deleteRol(id);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}
