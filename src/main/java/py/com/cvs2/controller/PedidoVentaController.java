package py.com.cvs2.controller;

import py.com.cvs2.dao.MarcaDao;
import py.com.cvs2.dao.PedidoVentaDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Marca;
import py.com.cvs2.model.PedidoVenta;

import java.util.List;

public class PedidoVentaController {

    public PedidoVenta savePedidoVenta(PedidoVenta pedidoVenta) throws Exception {
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();
        pedidoVenta = pedidoVentaDao.save(pedidoVenta);

        return pedidoVenta;
    }

    public List<PedidoVenta> listPedidosVenta(Boolean all) {
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();
        return pedidoVentaDao.list(all);
    }

    public List<PedidoVenta> listPedidosVentaPendientes() {
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();
        return pedidoVentaDao.listPendientes();
    }

    public PedidoVenta cancelPedidoVenta(PedidoVenta pedidoVenta) throws Exception {
        PedidoVentaDao pedidoVentaDao = new PedidoVentaDao();
        Estado estado = new Estado(2, "ANULADO");
        pedidoVenta.setEstadoPedidoVenta(estado);

        return pedidoVentaDao.update(pedidoVenta);
    }
}