package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factura_compra_detalle")
public class FacturaCompraDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_orden_compra_detalle", referencedColumnName = "id")
    private OrdenCompraDetalle ordenCompraDetalle;

    public FacturaCompraDetalle() {
    }

    public FacturaCompraDetalle(int id, String estado, OrdenCompraDetalle ordenCompraDetalle) {
        this.id = id;
        this.estado = estado;
        this.ordenCompraDetalle = ordenCompraDetalle;
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

    public OrdenCompraDetalle getOrdenCompraDetalle() {
        return ordenCompraDetalle;
    }

    public void setOrdenCompraDetalle(OrdenCompraDetalle ordenCompraDetalle) {
        this.ordenCompraDetalle = ordenCompraDetalle;
    }

    @Override
    public String toString() {
        return "FacturaCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", ordenCompraDetalle=" + ordenCompraDetalle +
                '}';
    }
}
