package py.com.cvs2.controller;

import py.com.cvs2.dao.FormularioDao;
import py.com.cvs2.dao.PermisoDao;
import py.com.cvs2.dao.RolDao;
import py.com.cvs2.dto.RolPermisoDto;
import py.com.cvs2.model.Estado;
import py.com.cvs2.model.Formulario;
import py.com.cvs2.model.Permiso;
import py.com.cvs2.model.Rol;

import java.util.ArrayList;
import java.util.List;

public class RolController {

    public List<RolPermisoDto> listRoles(Boolean all) {
        RolDao rolDAO = new RolDao();
        PermisoDao permisoDao = new PermisoDao();

        List<RolPermisoDto> rolPermisoDtoList = new ArrayList<RolPermisoDto>();
        List<Rol> rolList = rolDAO.list(all);

        for(Rol rol: rolList){
            RolPermisoDto rolPermisoDto = new RolPermisoDto();
            rolPermisoDto.setRol(rol);
            rolPermisoDto.setFormularios(new ArrayList<Formulario>());
            List<Permiso> permisos = permisoDao.findByRolId(rol.getId());
            for(Permiso permiso: permisos){
                rolPermisoDto.getFormularios().add(permiso.getFormulario());
            }
            rolPermisoDtoList.add(rolPermisoDto);
        }

        return rolPermisoDtoList;
    }

    public RolPermisoDto getRolById(Integer id) {
        RolDao rolDAO = new RolDao();
        PermisoDao permisoDao = new PermisoDao();

        Rol rol = rolDAO.findById(id);
        RolPermisoDto rolPermisoDto = new RolPermisoDto();
        rolPermisoDto.setRol(rol);
        rolPermisoDto.setFormularios(new ArrayList<Formulario>());
        List<Permiso> permisos = permisoDao.findByRolId(rol.getId());
        for(Permiso permiso: permisos){
            rolPermisoDto.getFormularios().add(permiso.getFormulario());
        }

        return rolPermisoDto;
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

    public RolPermisoDto updateRol(RolPermisoDto rolPermisoDto) throws Exception {
        RolDao rolDao = new RolDao();
        PermisoDao permisoDao = new PermisoDao();

        Rol rol = rolPermisoDto.getRol();
        rolDao.update(rol);

        List<Permiso> permisosViejos = permisoDao.findByRolId(rol.getId());
        for(Permiso permiso: permisosViejos){
            permiso.setEstado("INACTIVO");
            permisoDao.update(permiso);
        }

        for(Formulario formulario : rolPermisoDto.getFormularios()) {
            Permiso permiso = permisoDao.getPermisoByRolAndFormulario(rol.getId(), formulario.getId());
            if(permiso != null){
                permiso.setEstado("ACTIVO");
                permisoDao.update(permiso);
            } else {
                permiso = new Permiso(rol, formulario);
                permisoDao.save(permiso);
            }
        }

        return rolPermisoDto;
    }

    public void deleteRol(Integer id) throws Exception {
        RolDao rolDao = new RolDao();
        PermisoDao permisoDao = new PermisoDao();

        Rol rol = rolDao.findById(id);
        rol.setEstado("INACTIVO");
        rolDao.update(rol);

        List<Permiso> permisos = permisoDao.findByRolId(rol.getId());
        for(Permiso permiso: permisos){
            permiso.setEstado("INACTIVO");
            permisoDao.save(permiso);
        }
        //rolDao.delete(id);
    }
}
