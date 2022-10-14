package py.com.cvs2.controller;

import py.com.cvs2.dao.OrdenServicioDao;
import py.com.cvs2.dao.PresupuestoServicioDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.OrdenServicio;
import py.com.cvs2.model.PresupuestoServicio;

import java.util.List;

public class OrdenServicioController {

    public OrdenServicio saveOrdenServicio(OrdenServicio ordenServicio) throws Exception {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();

        PresupuestoServicio presupuestoServicio = ordenServicio.getPresupuestoServicio();
        presupuestoServicio.setEstadoPresupuestoServicio(new Estado(4, "PROCESADO"));
        presupuestoServicioDao.update(presupuestoServicio);

        ordenServicio = ordenServicioDao.save(ordenServicio);

        return ordenServicio;
    }

    public List<OrdenServicio> listOrdenServicioPendientes() {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.listPendientes();
    }

    public List<OrdenServicio> listOrdenServicioBySucursal(Integer idSucursal) {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.listBySucursal(idSucursal);
    }

    public List<OrdenServicio> listOrdenServicioPendientesBySucursal(Integer idSucursal) {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.listByPendientesSucursal(idSucursal);
    }

    public List<OrdenServicio> listOrdenServicio(Boolean all) {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        return ordenServicioDao.list(all);
    }

    public OrdenServicio cancelOrdenServicio(OrdenServicio ordenServicio) throws Exception {
        OrdenServicioDao ordenServicioDao = new OrdenServicioDao();
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();

        PresupuestoServicio presupuestoServicio = ordenServicio.getPresupuestoServicio();
        presupuestoServicio.setEstadoPresupuestoServicio(new Estado(1, "PENDIENTE"));
        presupuestoServicioDao.update(presupuestoServicio);

        ordenServicio.setEstadoOrdenServicio(new Estado(2, "ANULADO"));

        return ordenServicioDao.update(ordenServicio);
    }
}