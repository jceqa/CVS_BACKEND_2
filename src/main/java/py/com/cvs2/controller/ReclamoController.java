package py.com.cvs2.controller;

import py.com.cvs2.dao.EntregaEquipoDao;
import py.com.cvs2.dao.ReclamoDao;
import py.com.cvs2.model.EntregaEquipo;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Reclamo;
import py.com.cvs2.model.EntregaEquipo;

import java.util.List;

public class ReclamoController {

    public Reclamo saveReclamo(Reclamo reclamo) throws Exception {
        ReclamoDao reclamoDao = new ReclamoDao();
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();

        EntregaEquipo entregaEquipo = reclamo.getEntregaEquipo();
        entregaEquipo.setEstadoEntregaEquipo(new Estado(4, "PROCESADO"));
        entregaEquipoDao.update(entregaEquipo);

        reclamo = reclamoDao.save(reclamo);

        return reclamo;
    }

    public List<Reclamo> listPresupuestosCompra(Boolean all) {
        ReclamoDao reclamoDao = new ReclamoDao();
        return reclamoDao.list(all);
    }

    public List<Reclamo> listPresupuestosCompraBySucursal(Integer idSucursal) {
        ReclamoDao reclamoDao = new ReclamoDao();
        return reclamoDao.listBySucursal(idSucursal);
    }

    public List<Reclamo> listReclamoPendientes() {
        ReclamoDao reclamoDao = new ReclamoDao();
        return reclamoDao.listPendientes();
    }

    public Reclamo cancelReclamo(Reclamo reclamo) throws Exception {
        ReclamoDao reclamoDao = new ReclamoDao();
        EntregaEquipoDao entregaEquipoDao = new EntregaEquipoDao();

        EntregaEquipo entregaEquipo = reclamo.getEntregaEquipo();
        entregaEquipo.setEstadoEntregaEquipo(new Estado(1, "PENDIENTE"));
        entregaEquipoDao.update(entregaEquipo);

        reclamo.setEstadoReclamo(new Estado(2, "ANULADO"));

        return reclamoDao.update(reclamo);
    }
}