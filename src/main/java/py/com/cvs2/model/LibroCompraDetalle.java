package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libro_compra_detalle")
public class LibroCompraDetalle implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto_neto")
    private Long montoNeto;

    @Column(name = "monto_impuesto")
    private Long montoImpuesto;

    @OneToOne
    @JoinColumn(name = "id_impuesto", referencedColumnName = "id")
    private Impuesto impuesto;

    @OneToOne
    @JoinColumn(name = "id_factura_compra_detalle", referencedColumnName = "id")
    private FacturaCompraDetalle facturaCompraDetalle;

    public LibroCompraDetalle() {
    }

    public LibroCompraDetalle(int id, Long montoNeto, Long montoImpuesto, Impuesto impuesto, FacturaCompraDetalle facturaCompraDetalle) {
        this.id = id;
        this.montoNeto = montoNeto;
        this.montoImpuesto = montoImpuesto;
        this.impuesto = impuesto;
        this.facturaCompraDetalle = facturaCompraDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMontoNeto() {
        return montoNeto;
    }

    public void setMontoNeto(Long montoNeto) {
        this.montoNeto = montoNeto;
    }

    public Long getMontoImpuesto() {
        return montoImpuesto;
    }

    public void setMontoImpuesto(Long montoImpuesto) {
        this.montoImpuesto = montoImpuesto;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public FacturaCompraDetalle getFacturaCompraDetalle() {
        return facturaCompraDetalle;
    }

    public void setFacturaCompraDetalle(FacturaCompraDetalle facturaCompraDetalle) {
        this.facturaCompraDetalle = facturaCompraDetalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "LibroCompraDetalle{" +
                "id=" + id +
                ", montoNeto=" + montoNeto +
                ", montoImpuesto=" + montoImpuesto +
                ", impuesto=" + impuesto +
                ", facturaCompraDetalle=" + facturaCompraDetalle +
                '}';
    }
}
