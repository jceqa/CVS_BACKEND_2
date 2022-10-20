package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libro_venta_detalle")
public class LibroVentaDetalle implements Serializable {

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
    @JoinColumn(name = "id_factura_detalle", referencedColumnName = "id")
    private FacturaDetalle facturaDetalle;

    public LibroVentaDetalle() {
    }

    public LibroVentaDetalle(int id, String estado, Long montoNeto, Long montoImpuesto, Impuesto impuesto, FacturaDetalle facturaDetalle) {
        this.id = id;
        this.estado = estado;
        this.montoNeto = montoNeto;
        this.montoImpuesto = montoImpuesto;
        this.impuesto = impuesto;
        this.facturaDetalle = facturaDetalle;
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

    public FacturaDetalle getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(FacturaDetalle facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

    @Override
    public String toString() {
        return "LibroVentaDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", montoNeto=" + montoNeto +
                ", montoImpuesto=" + montoImpuesto +
                ", impuesto=" + impuesto +
                ", facturaDetalle=" + facturaDetalle +
                '}';
    }
}
