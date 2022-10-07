package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nota_credito_compra_detalle")
public class NotaCreditoCompraDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @OneToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    private Articulo articulo;

    public NotaCreditoCompraDetalle() {
    }

    public NotaCreditoCompraDetalle(int id, String estado, Long monto, Integer cantidad, Articulo articulo) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.cantidad = cantidad;
        this.articulo = articulo;
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

    @Override
    public String toString() {
        return "NotaCreditoCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", cantidad=" + cantidad +
                ", articulo=" + articulo +
                '}';
    }
}
