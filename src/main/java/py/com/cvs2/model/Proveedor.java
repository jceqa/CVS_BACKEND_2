package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Proveedor implements Serializable{

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razon")
    private String razon;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

    public Proveedor() {
    }

    public Proveedor(int id, String ruc, String razon, String direccion, String correo, String telefono, Ciudad ciudad) {
        this.id = id;
        this.ruc = ruc;
        this.razon = razon;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", razon='" + razon + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", ciudad=" + ciudad +
                '}';
    }

}
