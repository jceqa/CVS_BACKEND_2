package py.com.cvs2.controller;

import py.com.cvs2.dao.PermisoDao;
import py.com.cvs2.dao.RolDao;
import py.com.cvs2.dto.RolPermisoDto;
import py.com.cvs2.model.Formulario;
import py.com.cvs2.model.Permiso;
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

    public RolPermisoDto saveRol(RolPermisoDto rolPermiso) throws Exception {
        RolDao rolDao = new RolDao();
        PermisoDao permisoDao = new PermisoDao();

        Rol rol = rolPermiso.getRol();
        rol.setEstado("ACTIVO");
        rol = rolDao.save(rol);

        for(Formulario formulario: rolPermiso.getFormularios()){
            Permiso permiso = new Permiso(rol, formulario);
            permisoDao.save(permiso);
        }

        return rolPermiso;
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
