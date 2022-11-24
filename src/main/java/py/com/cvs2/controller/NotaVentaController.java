package py.com.cvs2.controller;
import py.com.cvs2.dao.*;
import py.com.cvs2.model.*;

import java.util.List;
public class NotaVentaController {
    public NotaVenta saveNotaVenta(NotaVenta notaVenta) throws Exception {
        NotaVentaDao notaVentaDao = new NotaVentaDao();
        FacturaDao facturaDao = new FacturaDao();
        StockDao stockDao = new StockDao();
        StockController stockController = new StockController();

        for(NotaVentaDetalle notaVentaDetalle: notaVenta.getNotaVentaDetalle()){
            Stock stock = stockDao.getByArticuloAndDeposito(notaVentaDetalle.getArticulo().getId(), 1);
            if(stock.getExistencia() < notaVentaDetalle.getCantidad()){
                throw new Exception("La existencia en el Depósito Central es menor a lo indicado en la Nota de Crédito");
            }
        }

        /*List<NotaRemision> notaRemisionList = notaVenta.getFactura().getNotaRemisionList();*/

        for(NotaVentaDetalle notaVentaDetalle : notaVenta.getNotaVentaDetalle()){
            stockController.updateStock(1, notaVentaDetalle.getArticulo(), notaVentaDetalle.getCantidad(), "DESCUENTO");
        }

        Factura factura = notaVenta.getFactura();
        factura.setEstadoFactura(new Estado(7, "PRCESADO_NOTA_VENTA"));
        facturaDao.update(factura);

        return notaVentaDao.save(notaVenta);
    }

    public List<NotaVenta> listNotasVenta(Boolean all) {
        NotaVentaDao notaVentaDao = new NotaVentaDao();
        return notaVentaDao.list(all);
    }

    public List<NotaVenta> listNotasVentaPendientes() {
        NotaVentaDao notaVentaDao = new NotaVentaDao();
        return notaVentaDao.listPendientes();
    }

    public List<NotaVenta> listNotaVentaPendientesByCliente(Integer idCliente) {
        NotaVentaDao pedidoVentaDao = new NotaVentaDao();
        return pedidoVentaDao.listPendientesByCliente(idCliente);
    }

    public NotaVenta cancelNotaVenta(NotaVenta notaVenta) throws Exception {
        NotaVentaDao notaVentaDao = new NotaVentaDao();
        Estado estado = new Estado(2, "ANULADO");
        StockController stockController = new StockController();
        FacturaDao facturaDao = new FacturaDao();



        for(NotaVentaDetalle notaVentaDetalle : notaVenta.getNotaVentaDetalle()){
            stockController.updateStock(1, notaVentaDetalle.getArticulo(), notaVentaDetalle.getCantidad(), "AUMENTO");
        }

        Factura factura = notaVenta.getFactura();
        factura.setEstadoFactura(new Estado(4, "PROCESADO"));
        facturaDao.update(factura);


        notaVenta.setEstadoNotaVenta(estado);
        return notaVentaDao.update(notaVenta);
    }
}