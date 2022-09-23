package py.com.cvs2.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orden_compra_detalle")
public class OrdenCompraDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_presupueto_compra_detalle", referencedColumnName = "id")
    private PresupuestoCompraDetalle presupuestoCompraDetalle;

    public OrdenCompraDetalle() {
    }

    public OrdenCompraDetalle(int id, String estado, Long monto, PresupuestoCompraDetalle presupuestoCompraDetalle) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.presupuestoCompraDetalle = presupuestoCompraDetalle;
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

    public PresupuestoCompraDetalle getPresupuestoCompraDetalle() {return presupuestoCompraDetalle;
    }

    public void setPresupuestoCompraDetalle(PresupuestoCompraDetalle presupuestoCompraDetalle) {this.presupuestoCompraDetalle = presupuestoCompraDetalle;
    }

    @Override
    public String toString() {
        return "OrdenCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                '}';
    }
}




