package py.com.cvs2.model;

import javax.persistence.*;

@Entity
@Table(name = "presupuesto_compra_detalle")
public class PresupuestoCompraDetalle {

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
    @JoinColumn(name = "id_pedido_compra_detalle", referencedColumnName = "id")
    private PedidoCompraDetalle pedidoCompraDetalle;

    public PresupuestoCompraDetalle() {
    }

    public PresupuestoCompraDetalle(int id, String estado, Long monto, PedidoCompraDetalle pedidoCompraDetalle) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.pedidoCompraDetalle = pedidoCompraDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public PedidoCompraDetalle getPedidoCompraDetalle() {
        return pedidoCompraDetalle;
    }

    public void setPedidoCompraDetalle(PedidoCompraDetalle pedidoCompraDetalle) {
        this.pedidoCompraDetalle = pedidoCompraDetalle;
    }

    @Override
    public String toString() {
        return "PresupuestoCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", pedidoCompraDetalle=" + pedidoCompraDetalle +
                '}';
    }
}
