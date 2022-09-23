package py.com.cvs2.controller;

import py.com.cvs2.dao.PedidoCompraDao;
import py.com.cvs2.dao.PresupuestoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.PedidoCompra;
import py.com.cvs2.model.PresupuestoCompra;

import java.util.List;

public class PresupuestoCompraController {

    public PresupuestoCompra savePresupuestoCompra(PresupuestoCompra presupuestoCompra) throws Exception {
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();
        PedidoCompraDao pedidoCompraDao = new PedidoCompraDao();

        PedidoCompra pedidoCompra = presupuestoCompra.getPedidoCompra();
        pedidoCompra.setEstadoPedido(new Estado(4, "PROCESADO"));
        pedidoCompraDao.update(pedidoCompra);

        presupuestoCompra = presupuestoCompraDao.save(presupuestoCompra);

        return presupuestoCompra;
    }

    public List<PresupuestoCompra> listPresupuestosCompra(Boolean all) {
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();
        return presupuestoCompraDao.list(all);
    }

    public PresupuestoCompra cancelPresupuestoCompra(PresupuestoCompra presupuestoCompra) throws Exception {
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();
        PedidoCompraDao pedidoCompraDao = new PedidoCompraDao();

        PedidoCompra pedidoCompra = presupuestoCompra.getPedidoCompra();
        pedidoCompra.setEstadoPedido(new Estado(1, "PENDIENTE"));
        pedidoCompraDao.update(pedidoCompra);

        presupuestoCompra.setEstadoPresupuesto(new Estado(2, "ANULADO"));

        return presupuestoCompraDao.update(presupuestoCompra);
    }
}
