package py.com.cvs2.dto;

import py.com.cvs2.model.Permiso;
import py.com.cvs2.model.Rol;
import py.com.cvs2.model.Usuario;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

public class UsuarioRolDto implements Serializable {

    private int id;

    private Usuario usuario;

    private Rol rol;

    private String estado;

    private List<Permiso> permisos;

    public UsuarioRolDto() {
    }

    public UsuarioRolDto(int id, Usuario usuario, Rol rol, String estado, List<Permiso> permisos) {
        this.id = id;
        this.usuario = usuario;
        this.rol = rol;
        this.estado = estado;
        this.permisos = permisos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "UsuarioRolDto{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", rol=" + rol +
                ", estado='" + estado + '\'' +
                ", permisos=" + permisos +
                '}';
    }
}
