package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recepcion_detalle")
public class RecepcionDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    private Equipo equipo;

    public RecepcionDetalle() {
    }

    public RecepcionDetalle(int id, Integer cantidad, String estado, Equipo equipo) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "RecepcionDetalle{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}