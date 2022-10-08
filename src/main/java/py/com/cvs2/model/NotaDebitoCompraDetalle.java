package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nota_debito_compra_detalle")
public class NotaDebitoCompraDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_factura_compra_detalle", referencedColumnName = "id")
    private FacturaCompraDetalle facturaCompraDetalle;

    public NotaDebitoCompraDetalle() {
    }

    public NotaDebitoCompraDetalle(int id, String estado, FacturaCompraDetalle facturaCompraDetalle) {
        this.id = id;
        this.estado = estado;
        this.facturaCompraDetalle = facturaCompraDetalle;
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

    public FacturaCompraDetalle getFacturaCompraDetalle() {
        return facturaCompraDetalle;
    }

    public void setFacturaCompraDetalle(FacturaCompraDetalle facturaCompraDetalle) {
        this.facturaCompraDetalle = facturaCompraDetalle;
    }

    @Override
    public String toString() {
        return "NotaDebitoCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", facturaCompraDetalle=" + facturaCompraDetalle +
                '}';
    }
}
