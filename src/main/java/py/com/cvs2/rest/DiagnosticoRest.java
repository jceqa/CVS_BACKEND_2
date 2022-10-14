package py.com.cvs2.rest;
import py.com.cvs2.controller.RecepcionController;
import py.com.cvs2.controller.DiagnosticoController;
import py.com.cvs2.model.Recepcion;
import py.com.cvs2.model.Diagnostico;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/diagnostico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DiagnosticoRest {

    @GET
    public Response listDiagnostico(@QueryParam("all") Boolean all){
        DiagnosticoController dc = new DiagnosticoController();
        List<Diagnostico> diagnosticoList = dc.listDiagnostico(all);

        return Response.ok(diagnosticoList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/sucursal/{idSucursal}")
    public Response listDiagnosticoBySucursal(@PathParam("idSucursal") Integer idSucursal){
        DiagnosticoController dc = new DiagnosticoController();
        List<Diagnostico> diagnosticoList = dc.listDiagnosticoBySucursal(idSucursal);

        return Response.ok(diagnosticoList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes")
    public Response listDiagnosticoPendientes(){
        DiagnosticoController dc = new DiagnosticoController();
        List<Diagnostico> diagnosticoList = dc.listDiagnosticoPendientes();

        return Response.ok(diagnosticoList, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/pendientes/{idSucursal}")
    public Response listDiagnosticoPendientesByProveedorBySucursal(@PathParam("idSucursal") Integer idSucursal){
        DiagnosticoController dc = new DiagnosticoController();
        List<Diagnostico> diagnosticoList = dc.listDiagnosticoPendientesBySucursal(idSucursal);

        return Response.ok(diagnosticoList, MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response saveDiagnostico(Diagnostico diagnostico) {
        DiagnosticoController dc = new DiagnosticoController();
        try {
            diagnostico = dc.saveDiagnostico(diagnostico);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }
        return Response.ok(diagnostico, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/anular")
    public Response cancelDiagnostico(Diagnostico diagnostico) {
        DiagnosticoController pcc = new DiagnosticoController();

        try {
            pcc.cancelDiagnostico(diagnostico);
        } catch (Exception e) {
            Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
            rb.entity(e.getMessage());
            //throw new RuntimeException(e);
            return rb.build();
        }

        return Response.ok().build();
    }
}