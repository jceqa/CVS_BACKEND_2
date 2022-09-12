package py.com.cvs2.controller;


import py.com.cvs2.dao.DepositoDao;
import py.com.cvs2.model.Deposito;

import java.util.List;

public class DepositoController {

    public List<Deposito> listDepositos() {
        DepositoDao depositoDAO = new DepositoDao();
        return depositoDAO.list();
    }

    public Deposito getDepositoById(Integer id) {
        DepositoDao depositoDAO = new DepositoDao();
        return depositoDAO.findById(id);
    }

    public Deposito saveDeposito(Deposito deposito) {
        DepositoDao depositoDao = new DepositoDao();
        return depositoDao.save(deposito);
    }

    public Deposito updateDeposito(Deposito deposito) {
        DepositoDao depositoDao = new DepositoDao();
        return depositoDao.update(deposito);
    }

    public void deleteDeposito(Integer id) {
        DepositoDao depositoDao = new DepositoDao();
        depositoDao.delete(id);
    }
}