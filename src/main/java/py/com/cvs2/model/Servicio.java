package py.com.cvs2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "estado")
    String estado;

    public Servicio() {
    }

    public Servicio(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto= monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getMonto() { return monto;
    }

    public void setMonto(Long monto) { this.monto = monto;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Servicio [id=" + id +
                ", descripcion=" + descripcion +
                ", monto=" + monto +
                '}';
    }

}