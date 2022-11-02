package py.com.cvs2.dao;

import py.com.cvs2.converters.UsuarioRolDtoConverter;
import py.com.cvs2.dto.UsuarioRolDto;
import py.com.cvs2.model.Permiso;
import py.com.cvs2.model.UsuarioRol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UsuarioRolDao extends GenericDao<UsuarioRol>{

    public List<UsuarioRolDto> findByIdUsuario(Integer idUsuario) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CVS_PU");
        EntityManager em = emf.createEntityManager();

        List<UsuarioRol> usuarioRolList;
        List<UsuarioRolDto> usuarioRolDtoList;
        UsuarioRolDtoConverter converter = new UsuarioRolDtoConverter();

        List<Permiso> permisos;

        Query q = em.createQuery("SELECT ur FROM UsuarioRol ur "
                + " WHERE ur.usuario.id = :idUsuario "
                + " AND ur.estado = 'ACTIVO' "
                + " AND ur.rol.estado = 'ACTIVO' "
                + " ORDER BY ur.id ");

        q.setParameter("idUsuario", idUsuario);

        usuarioRolList = q.getResultList();

        usuarioRolDtoList = converter.converter(usuarioRolList);

        for( UsuarioRolDto ur : usuarioRolDtoList){
            Query q2 = em.createQuery("SELECT p FROM Permiso p "
                    + " WHERE p.rol.id=:idRol "
                    + " AND p.estado = 'ACTIVO' "
                    + " AND p.formulario.estado = 'ACTIVO' "
                    + " AND p.rol.estado = 'ACTIVO' "
                    + " ORDER BY p.formulario.sistema.id, "
                    + " p.formulario.subMenu.id, "
                    + " p.formulario.id");

            q2.setParameter("idRol", ur.getRol().getId());

            permisos = q2.getResultList();

            ur.setPermisos(permisos);
        }

        return usuarioRolDtoList;
    }
}