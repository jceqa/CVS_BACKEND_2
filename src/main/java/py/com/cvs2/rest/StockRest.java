package py.com.cvs2.rest;

import py.com.cvs2.controller.StockController;
import py.com.cvs2.model.Stock;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockRest {

    @GET
    public Response listStocks(@QueryParam("all") Boolean all) {
        StockController sc = new StockController();
        List<Stock> sucursales = sc.listStocks(all);

        return Response.ok(sucursales, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/deposito/{id}")
    public Response listStockByDeposito(@PathParam("id") Integer idDeposito) {
        StockController sc = new StockController();
        List<Stock> stock = sc.listStockByDeposito(idDeposito);

        return Response.ok(stock, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/articulo/{id}")
    public Response listStockByArticulo(@PathParam("id") Integer idArticulo) {
        StockController sc = new StockController();
        List<Stock> stock = sc.listStockByArticulo(idArticulo);

        return Response.ok(stock, MediaType.APPLICATION_JSON).build();
    }
}
