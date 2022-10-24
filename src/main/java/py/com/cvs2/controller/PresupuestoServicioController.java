package py.com.cvs2.controller;

import py.com.cvs2.dao.RecepcionDao;
import py.com.cvs2.dao.DiagnosticoDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Recepcion;
import py.com.cvs2.model.Diagnostico;
import py.com.cvs2.model.PresupuestoServicio;
import py.com.cvs2.dao.PresupuestoServicioDao;

import java.util.List;

public class PresupuestoServicioController {

    public PresupuestoServicio savePresupuestoServicio(PresupuestoServicio presupuestoServicio) throws Exception {
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();

        Diagnostico diagnostico = presupuestoServicio.getDiagnostico();
        diagnostico.setEstadoDiagnostico(new Estado(4, "PROCESADO"));
        diagnosticoDao.update(diagnostico);

        presupuestoServicio.setEstadoPresupuestoServicio(new Estado(1, "PENDIENTE"));

        presupuestoServicio = presupuestoServicioDao.save(presupuestoServicio);

        return presupuestoServicio;
    }

    public List<PresupuestoServicio> listPresupuestosServicio(Boolean all) {
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        return presupuestoServicioDao.list(all);
    }

    public List<PresupuestoServicio> listPresupuestosServicioBySucursal(Integer idSucursal) {
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        return presupuestoServicioDao.listBySucursal(idSucursal);
    }

    public List<PresupuestoServicio> listPresupuestoServicioPendientes() {
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        return presupuestoServicioDao.listPendientes();
    }

    public List<PresupuestoServicio> listPresupuestoServicioPendientesBySucursal(Integer idSucursal) {
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        return presupuestoServicioDao.listPendientesBySucursal(idSucursal);
    }

    public PresupuestoServicio cancelPresupuestoServicio(PresupuestoServicio presupuestoServicio) throws Exception {
        PresupuestoServicioDao presupuestoServicioDao = new PresupuestoServicioDao();
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();

        Diagnostico diagnostico = presupuestoServicio.getDiagnostico();
        diagnostico.setEstadoDiagnostico(new Estado(1, "PENDIENTE"));
        diagnosticoDao.update(diagnostico);

        presupuestoServicio.setEstadoPresupuestoServicio(new Estado(2, "ANULADO"));

        return presupuestoServicioDao.update(presupuestoServicio);
    }
}
