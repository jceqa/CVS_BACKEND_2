package py.com.cvs2.controller;


import py.com.cvs2.dao.DepositoDao;
import py.com.cvs2.model.Deposito;

import java.util.List;

public class DepositoController {

    public List<Deposito> listDepositos(Boolean all) {
        DepositoDao depositoDAO = new DepositoDao();
        return depositoDAO.list(all);
    }

    public Deposito getDepositoById(Integer id) {
        DepositoDao depositoDAO = new DepositoDao();
        return depositoDAO.findById(id);
    }

    public List<Deposito> listDepositosBySucursal(Integer idSucursal){
        DepositoDao depositoDAO = new DepositoDao();
        return depositoDAO.listDepositosBySucursal(idSucursal);
    }

    public Deposito saveDeposito(Deposito deposito) throws Exception {
        DepositoDao depositoDao = new DepositoDao();
        deposito.setEstado("ACTIVO");
        return depositoDao.save(deposito);
    }

    public Deposito updateDeposito(Deposito deposito) throws Exception {
        DepositoDao depositoDao = new DepositoDao();
        return depositoDao.update(deposito);
    }

    public void deleteDeposito(Integer id) throws Exception {
        DepositoDao depositoDao = new DepositoDao();
        Deposito deposito = depositoDao.findById(id);
        deposito.setEstado("INACTIVO");
        depositoDao.update(deposito);

        //depositoDao.delete(id);
    }
}