package py.com.cvs2.dto;

import py.com.cvs2.model.Formulario;
import py.com.cvs2.model.Rol;

import java.io.Serializable;
import java.util.List;

public class RolPermisoDto implements Serializable {

    private Rol rol;

    private List<Formulario> formularios;

    public RolPermisoDto() {
    }

    public RolPermisoDto(Rol rol, List<Formulario> formularios) {
        this.rol = rol;
        this.formularios = formularios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }

    @Override
    public String toString() {
        return "RolPermisoDto{" +
                "rol=" + rol +
                ", formularios=" + formularios +
                '}';
    }
}
