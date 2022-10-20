package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura_compra")
public class FacturaCompra implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoFacturaCompra;

    @OneToOne
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id")
    private OrdenCompra ordenCompra;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_factura_compra", referencedColumnName = "id")
    private List<FacturaCompraDetalle> facturaCompraDetalle;

    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_libro_compra", referencedColumnName = "id")
    private LibroCompra libroCompra;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_factura_compra", referencedColumnName = "id")
    private List<NotaRemision> notaRemisionList;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_factura_compra", referencedColumnName = "id")
    private List<NotaDebitoCompra> notaDebitoCompraList;

    public FacturaCompra() {
    }

    public FacturaCompra(int id, String estado, Date fecha, Long monto, String numeroFactura, Usuario usuario, Estado estadoFacturaCompra, OrdenCompra ordenCompra, List<FacturaCompraDetalle> facturaCompraDetalle) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.monto = monto;
        this.numeroFactura = numeroFactura;
        this.usuario = usuario;
        this.estadoFacturaCompra = estadoFacturaCompra;
        this.ordenCompra = ordenCompra;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstadoFacturaCompra() {
        return estadoFacturaCompra;
    }

    public void setEstadoFacturaCompra(Estado estadoFacturaCompra) {
        this.estadoFacturaCompra = estadoFacturaCompra;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public List<FacturaCompraDetalle> getFacturaCompraDetalle() {
        return facturaCompraDetalle;
    }

    public void setFacturaCompraDetalle(List<FacturaCompraDetalle> facturaCompraDetalle) {
        this.facturaCompraDetalle = facturaCompraDetalle;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LibroCompra getLibroCompra() {
        return libroCompra;
    }

    public void setLibroCompra(LibroCompra libroCompra) {
        this.libroCompra = libroCompra;
    }

    public List<NotaRemision> getNotaRemisionList() {
        return notaRemisionList;
    }

    public void setNotaRemisionList(List<NotaRemision> notaRemisionList) {
        this.notaRemisionList = notaRemisionList;
    }

    public List<NotaDebitoCompra> getNotaDebitoCompraList() {
        return notaDebitoCompraList;
    }

    public void setNotaDebitoCompraList(List<NotaDebitoCompra> notaDebitoCompraList) {
        this.notaDebitoCompraList = notaDebitoCompraList;
    }

    @Override
    public String toString() {
        return "FacturaCompra{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", numeroFactura='" + numeroFactura + '\'' +
                ", usuario=" + usuario +
                ", estadoFacturaCompra=" + estadoFacturaCompra +
                ", ordenCompra=" + ordenCompra +
                ", facturaCompraDetalle=" + facturaCompraDetalle +
                '}';
    }
}
