package py.com.cvs2.controller;

import py.com.cvs2.dao.MarcaDao;
import py.com.cvs2.dao.PedidoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Marca;
import py.com.cvs2.model.PedidoCompra;

import java.util.List;

public class PedidoCompraController {

    public PedidoCompra savePedidoCompra(PedidoCompra pedidoCompra) throws Exception {
        PedidoCompraDao pedidoCompraDao = new PedidoCompraDao();
        pedidoCompra = pedidoCompraDao.save(pedidoCompra);

        return pedidoCompra;
    }

    public List<PedidoCompra> listPedidosCompra(Boolean all) {
        PedidoCompraDao pedidoCompraDao = new PedidoCompraDao();
        return pedidoCompraDao.list(all);
    }

    public List<PedidoCompra> listPedidosCompraPendientes() {
        PedidoCompraDao pedidoCompraDao = new PedidoCompraDao();
        return pedidoCompraDao.listPendientes();
    }

    public PedidoCompra cancelPedidoCompra(PedidoCompra pedidoCompra) throws Exception {
        PedidoCompraDao pedidoCompraDao = new PedidoCompraDao();
        Estado estado = new Estado(2, "ANULADO");
        pedidoCompra.setEstadoPedido(estado);

        return pedidoCompraDao.update(pedidoCompra);
    }
}
