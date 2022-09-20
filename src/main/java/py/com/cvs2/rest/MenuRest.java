package py.com.cvs2.rest;

import py.com.cvs2.controller.MenuController;
import py.com.cvs2.dto.MenuDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuRest {

    @GET
    public Response getMenu() {
        MenuController mc = new MenuController();
        MenuDto menu = mc.getMenu();

        return Response.ok(menu, MediaType.APPLICATION_JSON).build();
    }
}
