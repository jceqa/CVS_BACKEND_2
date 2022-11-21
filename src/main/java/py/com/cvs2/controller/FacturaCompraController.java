package py.com.cvs2.controller;

import py.com.cvs2.dao.*;
import py.com.cvs2.model.*;

import java.util.List;

public class FacturaCompraController {

    public FacturaCompra saveFacturaCompra(FacturaCompra facturaCompra) throws Exception {
        StockController stockController = new StockController();

        FacturaCompraDao facturaCompraDao = new FacturaCompraDao();
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();

        ArticuloDao articuloDao = new ArticuloDao();
        LibroCompraDetalleDao libroCompraDetalleDao = new LibroCompraDetalleDao();
        NotaDebitoCompraDetalleDao notaDebitoCompraDetalleDao = new NotaDebitoCompraDetalleDao();

        OrdenCompra ordenCompra = facturaCompra.getOrdenCompra();
        ordenCompra.setEstadoOrdenCompra(new Estado(4, "PROCESADO"));

        for(PresupuestoCompra pc : ordenCompra.getPresupuestosCompra()){
            for(PresupuestoCompraDetalle pcD : pc.getPresupuestoCompraDetalles()){
                stockController.updateStock(1, pcD.getPedidoCompraDetalle().getArticulo(), pcD.getPedidoCompraDetalle().getCantidad(), "AUMENTO");

                Articulo articulo = pcD.getPedidoCompraDetalle().getArticulo();
                articulo.setPrecioCompraAnterior(articulo.getPrecioCompra());
                articulo.setPrecioCompra(pcD.getMonto());
                articulo.setPrecioVentaAnterior(articulo.getPrecioVenta());
                articulo.setPrecioVenta((long) (pcD.getMonto() * 1.30));
                articuloDao.update(articulo);
            }
        }

        facturaCompra = facturaCompraDao.save(facturaCompra);

        List<LibroCompraDetalle> libroCompraDetalleList = facturaCompra.getLibroCompra().getLibroCompraDetalles();
        List<FacturaCompraDetalle> facturaCompraDetalleList = facturaCompra.getFacturaCompraDetalle();
        List<NotaDebitoCompra> notaDebitoCompraList = facturaCompra.getNotaDebitoCompraList();

        for(int i = 0; i < facturaCompraDetalleList.size(); i++){
            libroCompraDetalleList.get(i).setFacturaCompraDetalle(facturaCompraDetalleList.get(i));
            libroCompraDetalleDao.update(libroCompraDetalleList.get(i));
        }

        for(NotaDebitoCompra notaDebitoCompra : notaDebitoCompraList){
            for(int j = 0; j < facturaCompraDetalleList.size(); j++){
                notaDebitoCompra.getNotaDebitoCompraDetalle().get(j).setFacturaCompraDetalle(facturaCompraDetalleList.get(j));
                notaDebitoCompraDetalleDao.update(notaDebitoCompra.getNotaDebitoCompraDetalle().get(j));
            }
        }

        ordenCompraDao.update(ordenCompra);

        return facturaCompra;
    }

    public List<FacturaCompra> listFacturasCompra(Boolean all) {
        FacturaCompraDao facturaCompraDao = new FacturaCompraDao();
        return facturaCompraDao.list(all);
    }

    public List<FacturaCompra> listFacturasCompraProcesadas(){
        FacturaCompraDao facturaCompraDao = new FacturaCompraDao();
        return facturaCompraDao.listProcesadas();
    }

    public FacturaCompra cancelFacturaCompra(FacturaCompra facturaCompra) throws Exception {
        FacturaCompraDao facturaCompraDao = new FacturaCompraDao();
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        LibroCompraDao libroCompraDao = new LibroCompraDao();
        LibroCompraDetalleDao libroCompraDetalleDao = new LibroCompraDetalleDao();
        NotaRemisionDao notaRemisionDao = new NotaRemisionDao();
        ArticuloDao articuloDao = new ArticuloDao();
        StockDao stockDao = new StockDao();
        NotaDebitoCompraDao notaDebitoCompraDao = new NotaDebitoCompraDao();
        CuentaAPagarDao cuentaAPagarDao = new CuentaAPagarDao();
        NotaCreditoCompraDao notaCreditoCompraDao = new NotaCreditoCompraDao();

        OrdenCompra ordenCompra = facturaCompra.getOrdenCompra();
        ordenCompra.setEstadoOrdenCompra(new Estado(1, "PENDIENTE"));

        facturaCompra.setEstadoFacturaCompra(new Estado(2, "ANULADO"));

        LibroCompra libroCompra = facturaCompra.getLibroCompra();
        for(LibroCompraDetalle lCD: libroCompra.getLibroCompraDetalles()){
            lCD.setEstado("INACTIVO");
            libroCompraDetalleDao.update(lCD);
        }
        libroCompra.setEstado("INACTIVO");
        libroCompraDao.update(libroCompra);

        List<NotaRemision> notaRemisionList = facturaCompra.getNotaRemisionList();
        for(NotaRemision notaRemision : notaRemisionList){
            for(PedidoCompraDetalle pedidoCompraDetalle : notaRemision.getPedidoCompra().getDetallePedidoCompras()) {
                Articulo articulo = pedidoCompraDetalle.getArticulo();
                articulo.setPrecioCompra(articulo.getPrecioCompraAnterior());
                articulo.setPrecioVenta(articulo.getPrecioVentaAnterior());
                articuloDao.update(articulo);

                Stock stock;
                if (notaRemision.getEstadoNotaRemision().getId() == 4 || notaRemision.getEstadoNotaRemision().getId() == 3) {
                    stock = stockDao.getByArticuloAndDeposito(articulo.getId(), notaRemision.getPedidoCompra().getDeposito().getId());
                } else {
                    stock = stockDao.getByArticuloAndDeposito(articulo.getId(), 1);
                }
                stock.setExistencia(stock.getExistencia() - pedidoCompraDetalle.getCantidad());
                stockDao.update(stock);
            }
            notaRemision.setEstadoNotaRemision(new Estado(2, "ANULADO"));
            notaRemisionDao.update(notaRemision);
        }

        for(NotaDebitoCompra notaDebitoCompra : facturaCompra.getNotaDebitoCompraList()){
            CuentaAPagar cuentaAPagar = notaDebitoCompra.getCuentaAPagar();
            cuentaAPagar.setEstadoCuentaAPagar(new Estado(2, "ANULADO"));
            cuentaAPagarDao.update(cuentaAPagar);

            notaDebitoCompra.setEstadoNotaDebitoCompra(new Estado(2, "ANULADO"));
            notaDebitoCompraDao.update(notaDebitoCompra);
        }

        for(NotaCreditoCompra notaCreditoCompra : facturaCompra.getOrdenCompra().getNotaCreditoComprasCancelacion()){
            notaCreditoCompra.setEstadoNotaCreditoCompra(new Estado(1, "PENDIENTE"));
            notaCreditoCompraDao.update(notaCreditoCompra);
        }

        ordenCompraDao.update(ordenCompra);

        return facturaCompraDao.update(facturaCompra);
    }
}
