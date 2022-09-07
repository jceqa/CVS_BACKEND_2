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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.com.cvs2.controller.ImpuestoController;
import py.com.cvs2.model.Impuesto;

@Path("/impuesto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImpuestoRest {

	@GET
	public Response listMarcas() {
		ImpuestoController mc = new ImpuestoController();
		List<Impuesto> impuestos = mc.listImpuestos();

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
		impuesto = ic.saveImpuesto(impuesto);

		return Response.ok(impuesto, MediaType.APPLICATION_JSON).build();
	}

	@PUT
	public Response updateImpuesto(Impuesto impuesto) {
		ImpuestoController ic = new ImpuestoController();
		impuesto = ic.updateImpuesto(impuesto);

		return Response.ok(impuesto, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteImpuesto(@PathParam("id") Integer id) {
		ImpuestoController ic = new ImpuestoController();

		ic.deleteImpuesto(id);

		return Response.ok().build();
	}

}