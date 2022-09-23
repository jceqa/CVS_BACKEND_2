package py.com.cvs2.controller;


import py.com.cvs2.dao.OrdenCompraDao;
import py.com.cvs2.dao.PresupuestoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.OrdenCompra;
import py.com.cvs2.model.PedidoCompra;
import py.com.cvs2.model.PresupuestoCompra;

import java.util.List;

public class OrdenCompraController {

    public OrdenCompra saveOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();

        PresupuestoCompra presupuestoCompra = ordenCompra.getPresupuestoCompra();
        presupuestoCompra.setEstadoPresupuesto(new Estado(4, "PROCESADO"));
        presupuestoCompraDao.update(presupuestoCompra);

        ordenCompra = ordenCompraDao.save(ordenCompra);

        return ordenCompra;
    }

    public List<OrdenCompra> listOrdenCompra(Boolean all) {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        return ordenCompraDao.list(all);
    }

    public OrdenCompra cancelOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();

        PresupuestoCompra presupuestoCompra = ordenCompra.getPresupuestoCompra();
        presupuestoCompra.setEstadoPresupuesto(new Estado(1, "PENDIENTE"));
        presupuestoCompraDao.update(presupuestoCompra);

        ordenCompra.setEstadoOrdenCompra(new Estado(2, "ANULADO"));

        return ordenCompraDao.update(ordenCompra);
    }
}