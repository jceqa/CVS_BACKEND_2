package py.com.cvs2.controller;

import py.com.cvs2.dao.DiagnosticoDao;
import py.com.cvs2.dao.PresupuestoServicioDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Recepcion;
import py.com.cvs2.dao.RecepcionDao;
import py.com.cvs2.model.Diagnostico;



import java.util.List;

public class DiagnosticoController {

    public Diagnostico saveDiagnostico(Diagnostico diagnostico) throws Exception {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        RecepcionDao recepcionDao = new RecepcionDao();

        Recepcion recepcion = diagnostico.getRecepcion();
        recepcion.setEstadoRecepcion(new Estado(4, "PROCESADO"));
        recepcionDao.update(recepcion);

        diagnostico = diagnosticoDao.save(diagnostico);

        return diagnostico;
    }

    public List<Diagnostico> listDiagnostico(Boolean all) {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        return diagnosticoDao.list(all);
    }

    public List<Diagnostico> listDiagnosticoBySucursal(Integer idSucursal) {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        return diagnosticoDao.listBySucursal(idSucursal);
    }

    public List<Diagnostico> listDiagnosticoPendientes() {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        return diagnosticoDao.listPendientes();
    }

    public List<Diagnostico> listDiagnosticoPendientesBySucursal(Integer idSucursal) {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        return diagnosticoDao.listPendientesBySucursal(idSucursal);
    }


    public Diagnostico cancelDiagnostico(Diagnostico diagnostico) throws Exception {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        RecepcionDao recepcionDao = new RecepcionDao();

        Recepcion recepcion = diagnostico.getRecepcion();
        recepcion.setEstadoRecepcion(new Estado(1, "PENDIENTE"));
        recepcionDao.update(recepcion);

        diagnostico.setEstadoDiagnostico(new Estado(2, "ANULADO"));

        return diagnosticoDao.update(diagnostico);
    }
}