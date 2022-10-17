package py.com.cvs2.controller;

import py.com.cvs2.dao.*;
import py.com.cvs2.model.*;

import java.util.List;

public class NotaCreditoCompraController {
    public NotaCreditoCompra saveNotaCreditoCompra(NotaCreditoCompra notaCreditoCompra) throws Exception {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        FacturaCompraDao facturaCompraDao = new FacturaCompraDao();
        StockDao stockDao = new StockDao();
        StockController stockController = new StockController();

        for(NotaCreditoCompraDetalle notaCreditoCompraDetalle: notaCreditoCompra.getNotaCreditoCompraDetalle()){
            Stock stock = stockDao.getByArticuloAndDeposito(notaCreditoCompraDetalle.getArticulo().getId(), 1);
            if(stock.getExistencia() < notaCreditoCompraDetalle.getCantidad()){
                throw new Exception("La existencia en el Depósito Central es menor a lo indicado en la Nota de Crédito");
            }
        }

        List<NotaRemision> notaRemisionList = notaCreditoCompra.getFacturaCompra().getNotaRemisionList();

        for(NotaCreditoCompraDetalle notaCreditoCompraDetalle : notaCreditoCompra.getNotaCreditoCompraDetalle()){
            stockController.updateStock(1, notaCreditoCompraDetalle.getArticulo(), notaCreditoCompraDetalle.getCantidad(), "DESCUENTO");
        }

        FacturaCompra facturaCompra = notaCreditoCompra.getFacturaCompra();
        facturaCompra.setEstadoFacturaCompra(new Estado(7, "PRCESADO_NOTA_CREDITO"));
        facturaCompraDao.update(facturaCompra);

        return notaCreditoCompraDao.save(notaCreditoCompra);
    }

    public List<NotaCreditoCompra> listNotasCreditoCompra(Boolean all) {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        return notaCreditoCompraDao.list(all);
    }

    public List<NotaCreditoCompra> listNotasCreditoCompraPendientes() {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        return notaCreditoCompraDao.listPendientes();
    }

    public List<NotaCreditoCompra> listNotaCreditoCompraPendientesByProveedor(Integer idProveedor) {
        NotaCreditoCompraDao presupuestoCompraDao = new NotaCreditoCompraDao();
        return presupuestoCompraDao.listPendientesByProveedor(idProveedor);
    }

    public NotaCreditoCompra cancelNotaCreditoCompra(NotaCreditoCompra notaCreditoCompra) throws Exception {
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();
        Estado estado = new Estado(2, "ANULADO");
        StockController stockController = new StockController();
        FacturaCompraDao facturaCompraDao = new FacturaCompraDao();



        for(NotaCreditoCompraDetalle notaCreditoCompraDetalle : notaCreditoCompra.getNotaCreditoCompraDetalle()){
            stockController.updateStock(1, notaCreditoCompraDetalle.getArticulo(), notaCreditoCompraDetalle.getCantidad(), "AUMENTO");
        }

        FacturaCompra facturaCompra = notaCreditoCompra.getFacturaCompra();
        facturaCompra.setEstadoFacturaCompra(new Estado(4, "PROCESADO"));
        facturaCompraDao.update(facturaCompra);


        notaCreditoCompra.setEstadoNotaCreditoCompra(estado);
        return notaCreditoCompraDao.update(notaCreditoCompra);
    }
}
