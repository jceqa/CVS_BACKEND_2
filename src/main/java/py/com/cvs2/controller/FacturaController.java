package py.com.cvs2.controller;

import py.com.cvs2.dao.*;
import py.com.cvs2.model.*;

import java.util.List;

public class FacturaController {

    public Factura saveFactura(Factura factura) throws Exception {
        StockController stockController = new StockController();

        FacturaDao facturaDao = new FacturaDao();
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();

        ArticuloDao articuloDao = new ArticuloDao();
        LibroVentaDetalleDao libroDetalleDao = new LibroVentaDetalleDao();
        //NotaDebitoDetalleDao notaDebitoDetalleDao = new NotaDebitoDetalleDao();

        PedidoVenta pedidoVenta = factura.getPedidoVenta();
        pedidoVenta.setEstadoPedidoVenta(new Estado(4, "PROCESADO"));

        for(PedidoVentaDetalle pVD : pedidoVenta.getPedidoVentaDetalles()){
            //for(PresupuestoDetalle pcD : pc.getPresupuestoDetalles()){
                stockController.updateStock(pedidoVenta.getDeposito().getId(), pVD.getArticulo(), pVD.getCantidad(), "DESCUENTO");

                /*Articulo articulo = pcD.getPedidoDetalle().getArticulo();
                articulo.setPrecioAnterior(articulo.getPrecio());
                articulo.setPrecio(pcD.getMonto());
                articuloDao.update(articulo);*/
            //}
        }

        factura = facturaDao.save(factura);

        List<LibroVentaDetalle> libroVentaDetalleList = factura.getLibroVenta().getLibroVentaDetalles();
        List<FacturaDetalle> facturaDetalleList = factura.getFacturaDetalles();
        //List<NotaDebito> notaDebitoList = factura.getNotaDebitoList();

        for(int i = 0; i < facturaDetalleList.size(); i++){
            libroVentaDetalleList.get(i).setFacturaDetalle(facturaDetalleList.get(i));
            libroDetalleDao.update(libroVentaDetalleList.get(i));
        }

        /*for(NotaDebito notaDebito : notaDebitoList){
            for(int j = 0; j < facturaDetalleList.size(); j++){
                notaDebito.getNotaDebitoDetalle().get(j).setFacturaDetalle(facturaDetalleList.get(j));
                notaDebitoDetalleDao.update(notaDebito.getNotaDebitoDetalle().get(j));
            }
        }*/

        pedidoVentaDao.update(pedidoVenta);
        //ordenDao.update(orden);

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
        //NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        ArticuloDao articuloDao = new ArticuloDao();
        StockDao stockDao = new StockDao();
        //NotaDebitoDao notaDebitoDao = new NotaDebitoDao();
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();
        //NotaCreditoDao notaCreditoDao = new NotaCreditoDao();

        PedidoVenta pedidoVenta = factura.getPedidoVenta();
        pedidoVenta.setEstadoPedidoVenta(new Estado(1, "PENDIENTE"));

        factura.setEstadoFactura(new Estado(2, "ANULADO"));

        LibroVenta libroVenta = factura.getLibroVenta();
        for(LibroVentaDetalle lVD: libroVenta.getLibroVentaDetalles()){
            lVD.setEstado("INACTIVO");
            libroVentaDetalleDao.update(lVD);
        }
        libroVenta.setEstado("INACTIVO");
        libroVentaDao.update(libroVenta);

        /*List<NotaRemision> notaRemisionList = factura.getNotaRemisionList();
        for(NotaRemision notaRemision : notaRemisionList){
            for(PedidoDetalle pedidoDetalle : notaRemision.getPedido().getDetallePedidos()) {
                Articulo articulo = pedidoDetalle.getArticulo();
                articulo.setPrecio(articulo.getPrecioAnterior());
                articuloDao.update(articulo);

                Stock stock;
                if (notaRemision.getEstadoNotaRemision().getId() == 4 || notaRemision.getEstadoNotaRemision().getId() == 3) {
                    stock = stockDao.getByArticuloAndDeposito(articulo.getId(), notaRemision.getPedido().getDeposito().getId());
                } else {
                    stock = stockDao.getByArticuloAndDeposito(articulo.getId(), 1);
                }
                stock.setExistencia(stock.getExistencia() - pedidoDetalle.getCantidad());
                stockDao.update(stock);
            }
            notaRemision.setEstadoNotaRemision(new Estado(2, "ANULADO"));
            notaRemisionDao.update(notaRemision);
        }*/

        for(CuentaACobrar cuentaACobrar : factura.getCuentaACobrarList()){
            cuentaACobrar.setEstadoCuentaACobrar(new Estado(2, "ANULADO"));
            cuentaACobrarDao.update(cuentaACobrar);

            //notaDebito.setEstadoNotaDebito(new Estado(2, "ANULADO"));
            //notaDebitoDao.update(notaDebito);
        }

        /*for(NotaCredito notaCredito : factura.getOrden().getNotaCreditosCancelacion()){
            notaCredito.setEstadoNotaCredito(new Estado(1, "PENDIENTE"));
            notaCreditoDao.update(notaCredito);
        }*/

        pedidoVentaDao.update(pedidoVenta);

        return facturaDao.update(factura);
    }
}
