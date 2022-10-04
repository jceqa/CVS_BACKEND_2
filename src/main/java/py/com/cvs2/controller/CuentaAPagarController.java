package py.com.cvs2.controller;

import py.com.cvs2.dao.CuentaAPagarDao;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.CuentaAPagar;

import java.util.List;

public class CuentaAPagarController {
    public CuentaAPagar saveCuentaAPagar(CuentaAPagar cuentaAPagar) throws Exception {
        CuentaAPagarDao cuentaAPagarDao = new CuentaAPagarDao();
        cuentaAPagar = cuentaAPagarDao.save(cuentaAPagar);

        return cuentaAPagar;
    }

    public List<CuentaAPagar> listCuentasAPagar(Boolean all) {
        CuentaAPagarDao cuentaAPagarDao = new CuentaAPagarDao();
        return cuentaAPagarDao.list(all);
    }

    public CuentaAPagar cancelCuentaAPagar(CuentaAPagar cuentaAPagar) throws Exception {
        CuentaAPagarDao cuentaAPagarDao = new CuentaAPagarDao();
        Estado estado = new Estado(2, "ANULADO");
        cuentaAPagar.setEstadoCuentaAPagar(estado);

        return cuentaAPagarDao.update(cuentaAPagar);
    }
}
