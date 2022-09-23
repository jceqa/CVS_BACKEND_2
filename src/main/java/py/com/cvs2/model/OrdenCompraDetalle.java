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

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_orden_compra_detalle", referencedColumnName = "id")
    private OrdenCompraDetalle ordenCompraDetalle;

    @OneToOne
    @JoinColumn(name = "id_presupueto_compra_detalle", referencedColumnName = "id")
    private PresupuestoCompraDetalle presupuestoCompraDetalle;

    @OneToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    private Articulo articulo;

    @OneToOne
    @JoinColumn(name = "id_impuesto", referencedColumnName = "id")
    private Impuesto impuesto;


    public OrdenCompraDetalle() {
    }
    public OrdenCompraDetalle(int id, Integer cantidad, String estado, Long monto, PresupuestoCompraDetalle presupuestoCompraDetalle,
                              OrdenCompraDetalle ordenCompraDetalle, Articulo articulo, Impuesto impuesto) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.presupuestoCompraDetalle = presupuestoCompraDetalle;
        this.ordenCompraDetalle= ordenCompraDetalle;
        this.articulo = articulo;
        this.impuesto = impuesto;
    }

    public int getId() {return id;
    }

    public void setId(int id) {this.id = id;
    }

    public String getEstado() {return estado;
    }

    public void setEstado(String estado) {this.estado = estado;
    }

    public Integer getCantidad() {return cantidad;
    }

    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;
    }

    public Long getMonto() {return monto;
    }

    public void setMonto(Long monto) {this.monto = monto;
    }

    public OrdenCompraDetalle getOrdenCompraDetalle() {return ordenCompraDetalle;
    }

    public void setOrdenCompraDetalle(OrdenCompraDetalle ordenCompraDetalle) {this.ordenCompraDetalle = ordenCompraDetalle;
    }

    public PresupuestoCompraDetalle getPresupuestoCompraDetalle() {return presupuestoCompraDetalle;
    }

    public void setPresupuestoCompraDetalle(PresupuestoCompraDetalle presupuestoCompraDetalle) {this.presupuestoCompraDetalle = presupuestoCompraDetalle;
    }

    public Articulo getArticulo() {return articulo;
    }

    public void setArticulo(Articulo articulo) {this.articulo = articulo;
    }

    public Impuesto getImpuesto() {return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "OrdenCompraDetalle{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", ordenCompraDetalle=" + ordenCompraDetalle +
                ", articulo=" + articulo+
                ", impuesto=" + impuesto +
                '}';
    }
}




