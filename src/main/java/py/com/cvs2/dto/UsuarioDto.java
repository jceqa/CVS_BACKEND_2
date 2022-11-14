package py.com.cvs2.dto;

import py.com.cvs2.model.Rol;
import py.com.cvs2.model.Usuario;

import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable {

    private Usuario usuario;

    private List<Rol> roles;

    public UsuarioDto() {
    }

    public UsuarioDto(Usuario usuario, List<Rol> roles) {
        this.usuario = usuario;
        this.roles = roles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "usuario=" + usuario +
                ", roles=" + roles +
                '}';
    }
}
