package py.com.cvs2.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orden_servicio_detalle")
public class OrdenServicioDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    private Articulo articulo;

    @OneToOne
    @JoinColumn(name = "id_presupueto_servicio_detalle", referencedColumnName = "id")
    private PresupuestoServicioDetalle presupuestoServicioDetalle;

    public OrdenServicioDetalle() {
    }

    public OrdenServicioDetalle(int id, String estado, Long monto, PresupuestoServicioDetalle presupuestoServicioDetalle,
                              Articulo articulo) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.monto = monto;
        this.articulo= articulo;
        this.presupuestoServicioDetalle = presupuestoServicioDetalle;
    }

    public int getId() {return id;
    }

    public void setId(int id) {this.id = id;
    }

    public String getEstado() {return estado;
    }

    public void setEstado(String estado) {this.estado = estado;
    }

    public Long getMonto() {return monto;
    }

    public void setMonto(Long monto) {this.monto = monto;
    }

    public Articulo getArticulo() {return articulo;
    }

    public void setArticulo(Articulo articulo) {this.articulo = articulo;
    }
    public PresupuestoServicioDetalle getPresupuestoServicioDetalle() {return presupuestoServicioDetalle;
    }

    public void setPresupuestoServicioDetalle(PresupuestoServicioDetalle presupuestoServicioDetalle) {this.presupuestoServicioDetalle = presupuestoServicioDetalle;
    }

    @Override
    public String toString() {
        return "OrdenServicioDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", cantidad=" + cantidad +
                '}';
    }
}