package py.com.cvs2.controller;

import py.com.cvs2.dao.*;
import py.com.cvs2.model.*;

import java.util.List;

public class FacturaController {

    public Integer getNumeroActual(){
        FacturaDao facturaDao = new FacturaDao();
        return facturaDao.getNumeroActual();
    }

    public Factura saveFactura(Factura factura) throws Exception {
        StockController stockController = new StockController();

        FacturaDao facturaDao = new FacturaDao();
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        LibroVentaDetalleDao libroVentaDetalleDao = new LibroVentaDetalleDao();

        if (factura.getPedidoVenta() != null) {
            PedidoVenta pedidoVenta = factura.getPedidoVenta();
            pedidoVenta.setEstadoPedidoVenta(new Estado(4, "PROCESADO"));

            for (PedidoVentaDetalle pVD : pedidoVenta.getPedidoVentaDetalles()) {
                stockController.updateStock(pedidoVenta.getDeposito().getId(), pVD.getArticulo(), pVD.getCantidad(), "DESCUENTO");
            }
            pedidoVentaDao.update(pedidoVenta);
        }

        factura = facturaDao.save(factura);

        if (factura.getOrdenServiciosList() != null && factura.getOrdenServiciosList().size() != 0) {
            for (OrdenServicio ordenServicio : factura.getOrdenServiciosList()) {
                ordenServicio.setEstadoOrdenServicio(new Estado(4, "PROCESADO"));
                ordenServicioDao.update(ordenServicio);
            }
        }

        List<LibroVentaDetalle> libroVentaDetalleList = factura.getLibroVenta().getLibroVentaDetalles();
        List<FacturaDetalle> facturaDetalleList = factura.getFacturaDetalles();

        for (int i = 0; i < facturaDetalleList.size(); i++) {
            libroVentaDetalleList.get(i).setFacturaDetalle(facturaDetalleList.get(i));
            libroVentaDetalleDao.update(libroVentaDetalleList.get(i));
        }

        return factura;
    }

    public List<Factura> listFacturas(Boolean all) {
        FacturaDao facturaDao = new FacturaDao();
        return facturaDao.list(all);
    }

    public List<Factura> listFacturasProcesadas(){
        FacturaDao facturaDao = new FacturaDao();
        return facturaDao.listProcesadas();
    }

    public Factura cancelFactura(Factura factura) throws Exception {
        FacturaDao facturaDao = new FacturaDao();
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();
        LibroVentaDao libroVentaDao = new LibroVentaDao();
        LibroVentaDetalleDao libroVentaDetalleDao = new LibroVentaDetalleDao();
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();

        StockController stockController = new StockController();

        if (factura.getPedidoVenta() != null) {
            PedidoVenta pedidoVenta = factura.getPedidoVenta();
            pedidoVenta.setEstadoPedidoVenta(new Estado(1, "PENDIENTE"));

            for (PedidoVentaDetalle pVD : pedidoVenta.getPedidoVentaDetalles()) {
                stockController.updateStock(pedidoVenta.getDeposito().getId(), pVD.getArticulo(), pVD.getCantidad(), "DESCUENTO");
            }
            pedidoVentaDao.update(pedidoVenta);
        }

        factura.setEstadoFactura(new Estado(2, "ANULADO"));

        LibroVenta libroVenta = factura.getLibroVenta();
        for (LibroVentaDetalle lVD : libroVenta.getLibroVentaDetalles()) {
            lVD.setEstado("INACTIVO");
            libroVentaDetalleDao.update(lVD);
        }
        libroVenta.setEstado("INACTIVO");
        libroVentaDao.update(libroVenta);

        for (CuentaACobrar cuentaACobrar : factura.getCuentaACobrarList()) {
            cuentaACobrar.setEstadoCuentaACobrar(new Estado(2, "ANULADO"));
            cuentaACobrarDao.update(cuentaACobrar);

        }

        for (OrdenServicio ordenServicio : factura.getOrdenServiciosList()){
            ordenServicio.setEstadoOrdenServicio(new Estado(1, "PENDIENTE"));
            ordenServicioDao.update(ordenServicio);
        }
        
        return facturaDao.update(factura);
    }
}
