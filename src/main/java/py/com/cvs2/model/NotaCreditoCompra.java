package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nota_credito_compra")
public class NotaCreditoCompra implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "fecha")
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoNotaCreditoCompra;

    @OneToOne
    @JoinColumn(name = "id_factura_compra", referencedColumnName = "id")
    private FacturaCompra facturaCompra;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_nota_credito_compra", referencedColumnName = "id")
    private List<NotaCreditoCompraDetalle> notaCreditoCompraDetalle;

    public NotaCreditoCompra() {
    }

    public NotaCreditoCompra(int id, String observacion, String estado, Long monto, Date fecha, Proveedor proveedor, Estado estadoNotaCreditoCompra, FacturaCompra facturaCompra, List<NotaCreditoCompraDetalle> notaCreditoCompraDetalle) {
        this.id = id;
        this.observacion = observacion;
        this.estado = estado;
        this.monto = monto;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.estadoNotaCreditoCompra = estadoNotaCreditoCompra;
        this.facturaCompra = facturaCompra;
        this.notaCreditoCompraDetalle = notaCreditoCompraDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Estado getEstadoNotaCreditoCompra() {
        return estadoNotaCreditoCompra;
    }

    public void setEstadoNotaCreditoCompra(Estado estadoNotaCreditoCompra) {
        this.estadoNotaCreditoCompra = estadoNotaCreditoCompra;
    }

    public FacturaCompra getFacturaCompra() {
        return facturaCompra;
    }

    public void setFacturaCompra(FacturaCompra facturaCompra) {
        this.facturaCompra = facturaCompra;
    }

    public List<NotaCreditoCompraDetalle> getNotaCreditoCompraDetalle() {
        return notaCreditoCompraDetalle;
    }

    public void setNotaCreditoCompraDetalle(List<NotaCreditoCompraDetalle> notaCreditoCompraDetalle) {
        this.notaCreditoCompraDetalle = notaCreditoCompraDetalle;
    }

    @Override
    public String toString() {
        return "NotaCreditoCompra{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", proveedor=" + proveedor +
                ", estadoNotaCreditoCompra=" + estadoNotaCreditoCompra +
                ", facturaCompra=" + facturaCompra +
                ", notaCreditoCompraDetalle=" + notaCreditoCompraDetalle +
                '}';
    }
}
