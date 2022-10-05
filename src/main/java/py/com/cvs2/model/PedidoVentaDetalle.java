package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedido_venta_detalle")
public class PedidoVentaDetalle implements Serializable {

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
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    private Articulo articulo;

    public PedidoVentaDetalle() {
    }

    public PedidoVentaDetalle(int id, Integer cantidad, String estado, Articulo articulo) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.articulo = articulo;
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

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "PedidoVentaDetalle{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", articulo=" + articulo +
                '}';
    }
}