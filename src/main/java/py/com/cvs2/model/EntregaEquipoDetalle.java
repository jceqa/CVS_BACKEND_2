package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entrega_equipo_detalle")
public class EntregaEquipoDetalle implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_factura_detalle", referencedColumnName = "id")
    private FacturaDetalle facturaDetalle;

    public EntregaEquipoDetalle() {
    }

    public EntregaEquipoDetalle(int id, String estado, FacturaDetalle facturaDetalle) {
        this.id = id;
        this.estado = estado;
        this.facturaDetalle = new FacturaDetalle();
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

    public FacturaDetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

    @Override
    public String toString() {
        return "FacturaCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", facturaDetalle=" + facturaDetalle +
                '}';
    }
}