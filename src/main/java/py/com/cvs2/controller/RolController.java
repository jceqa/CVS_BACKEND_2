package py.com.cvs2.controller;

import py.com.cvs2.dao.RolDao;
import py.com.cvs2.model.Rol;

import java.util.List;

public class RolController {

    public List<Rol> listRoles(Boolean all) {
        RolDao rolDAO = new RolDao();
        return rolDAO.list(all);
    }

    public Rol getRolById(Integer id) {
        RolDao rolDAO = new RolDao();
        return rolDAO.findById(id);
    }

    public Rol saveRol(Rol rol) throws Exception {
        RolDao rolDao = new RolDao();
        rol.setEstado("ACTIVO");
        return rolDao.save(rol);
    }

    public Rol updateRol(Rol rol) throws Exception {
        RolDao rolDao = new RolDao();
        return rolDao.update(rol);
    }

    public void deleteRol(Integer id) throws Exception {
        RolDao rolDao = new RolDao();
        Rol rol = rolDao.findById(id);
        rol.setEstado("INACTIVO");
        rolDao.update(rol);
        //rolDao.delete(id);
    }
}
