/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.rest;

/**
 *
 * @author PC-DTIC
 */
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.ImpuestoController;
import py.com.cvs2.model.Impuesto;

@Path("/impuesto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImpuestoRest {

	@GET
	public Response listMarcas(@QueryParam("all") Boolean all) {
		ImpuestoController mc = new ImpuestoController();
		List<Impuesto> impuestos = mc.listImpuestos(all);

		return Response.ok(impuestos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/{id}")
	public Response getImpuestoById(@PathParam("id") Integer id) {
		ImpuestoController ic = new ImpuestoController();
		Impuesto impuesto = ic.getImpuestoById(id);

		return Response.ok(impuesto, MediaType.APPLICATION_JSON).build();
	}

	@POST
	public Response saveImpuesto(Impuesto impuesto) {
		ImpuestoController ic = new ImpuestoController();
		try{
			impuesto = ic.saveImpuesto(impuesto);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(impuesto, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateImpuesto(Impuesto impuesto) {
		ImpuestoController ic = new ImpuestoController();
		try{
			impuesto = ic.updateImpuesto(impuesto);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok(impuesto, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteImpuesto(@PathParam("id") Integer id) {
		ImpuestoController ic = new ImpuestoController();

		try{
			ic.deleteImpuesto(id);
		} catch (Exception e) {
			Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
			rb.entity(e.getMessage());
			//throw new RuntimeException(e);
			return rb.build();
		}

		return Response.ok().build();
	}

}