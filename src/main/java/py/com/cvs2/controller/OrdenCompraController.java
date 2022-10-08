package py.com.cvs2.controller;


import py.com.cvs2.dao.OrdenCompraDao;
import py.com.cvs2.dao.PresupuestoCompraDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.OrdenCompra;
import py.com.cvs2.model.PresupuestoCompra;

import java.util.List;

public class OrdenCompraController {

    public OrdenCompra saveOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();

        for(PresupuestoCompra presupuestoCompra : ordenCompra.getPresupuestosCompra()){
            presupuestoCompra.setEstadoPresupuestoCompra(new Estado(4, "PROCESADO"));
            presupuestoCompraDao.update(presupuestoCompra);
        }

        ordenCompra = ordenCompraDao.save(ordenCompra);

        return ordenCompra;
    }

    public List<OrdenCompra> listOrdenCompraPendientes() {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        return ordenCompraDao.listPendientes();
    }

    /*public List<OrdenCompra> listOrdenCompraBySucursal(Integer idSucursal) {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        return ordenCompraDao.listBySucursal(idSucursal);
    }*/

    public List<OrdenCompra> listOrdenCompra(Boolean all) {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        return ordenCompraDao.list(all);
    }

    public OrdenCompra cancelOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        OrdenCompraDao ordenCompraDao = new OrdenCompraDao();
        PresupuestoCompraDao presupuestoCompraDao = new PresupuestoCompraDao();

        for(PresupuestoCompra presupuestoCompra : ordenCompra.getPresupuestosCompra()){
            presupuestoCompra.setEstadoPresupuestoCompra(new Estado(1, "PENDIENTE"));
            presupuestoCompraDao.update(presupuestoCompra);
        }

        ordenCompra.setEstadoOrdenCompra(new Estado(2, "ANULADO"));

        return ordenCompraDao.update(ordenCompra);
    }
}