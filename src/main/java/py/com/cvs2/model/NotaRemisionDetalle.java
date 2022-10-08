package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nota_remision_detalle")
public class NotaRemisionDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cantidad")
    private Integer cantidad;

    @OneToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    private Articulo articulo;

    @OneToOne
    @JoinColumn(name = "id_pedido_compra_detalle", referencedColumnName = "id")
    private PedidoCompraDetalle pedidoCompraDetalle;

    public NotaRemisionDetalle() {
    }

    public NotaRemisionDetalle(int id, String estado, Integer cantidad, Articulo articulo, PedidoCompraDetalle pedidoCompraDetalle) {
        this.id = id;
        this.estado = estado;
        this.cantidad = cantidad;
        this.articulo = articulo;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public PedidoCompraDetalle getPedidoCompraDetalle() {
        return pedidoCompraDetalle;
    }

    public void setPedidoCompraDetalle(PedidoCompraDetalle pedidoCompraDetalle) {
        this.pedidoCompraDetalle = pedidoCompraDetalle;
    }

    @Override
    public String toString() {
        return "NotaRemisionDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", cantidad=" + cantidad +
                ", articulo=" + articulo +
                ", pedidoCompraDetalle=" + pedidoCompraDetalle +
                '}';
    }
}
