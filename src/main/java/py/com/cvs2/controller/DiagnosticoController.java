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
        DiagnosticoDao diagnosticoCompraDao = new DiagnosticoDao();
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();

        Recepcion recepcion = recepcion.getRecepcion();
        recepcion.setEstadoDiagnostico(new Estado(4, "PROCESADO"));
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


    public Diagnostico cancelDiagnostico(Diagnostico diagnostico) throws Exception {
        DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
        recepcionDao recepcionDao = new RecepcionDao();

        Recepcion recepcion = recepcion.getRecepcion();
        recepcion.setEstadoDiagnostico(new Estado(1, "PENDIENTE"));
        recepcionDao.update(recepcion);

        diagnostico.setEstadoDiagnostico(new Estado(2, "ANULADO"));

        return diagnosticoDao.update(diagnostico);
    }
}