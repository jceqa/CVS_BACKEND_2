package py.com.cvs2.controller;

import py.com.cvs2.dao.CuentaACobrarDao;
import py.com.cvs2.dao.CuentaAPagarDao;
import py.com.cvs2.dao.NotaDebitoCompraDao;
import py.com.cvs2.model.CuentaACobrar;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.NotaDebitoCompra;

import java.util.List;

public class CuentaACobrarController {

    public CuentaACobrar saveCuentaACobrar(CuentaACobrar cuentaACobrar) throws Exception {
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();
        cuentaACobrar = cuentaACobrarDao.save(cuentaACobrar);

        return cuentaACobrar;
    }

    public List<CuentaACobrar> listCuentasACobrar(Boolean all) {
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();
        return cuentaACobrarDao.list(all);
    }

    public List<CuentaACobrar> listCuentasACobrarPendientes() {
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();
        return cuentaACobrarDao.listPendientes();
    }

    public CuentaACobrar cancelCuentaACobrar(CuentaACobrar cuentaACobrar) throws Exception {
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();
        Estado estado = new Estado(2, "ANULADO");
        cuentaACobrar.setEstadoCuentaACobrar(estado);

        return cuentaACobrarDao.update(cuentaACobrar);
    }

    public CuentaACobrar processCuentaACobrar(CuentaACobrar cuentaACobrar) throws Exception {
        CuentaACobrarDao cuentaACobrarDao = new CuentaACobrarDao();

        cuentaACobrar.setEstadoCuentaACobrar(new Estado(4, "PROCESADO"));

        return  cuentaACobrarDao.update(cuentaACobrar);
    }
}
