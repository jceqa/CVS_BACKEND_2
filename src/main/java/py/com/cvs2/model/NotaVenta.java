package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nota_venta")

public class NotaVenta implements Serializable {
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
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoNotaVenta;

    @OneToOne
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura factura;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_nota_venta", referencedColumnName = "id")
    private List<NotaVentaDetalle> notaVentaDetalle;

    @OneToOne
    @JoinColumn(name = "id_tipo_nota", referencedColumnName = "id")
    private TipoNota tipoNota;

    public NotaVenta() {
    }

    public NotaVenta(int id, String observacion, String estado, Long monto, Date fecha, Cliente cliente, Estado estadoNotaVenta, FacturaCompra facturaCompra,TipoNota tipoNota, List<NotaVentaDetalle> notaVentaDetalle) {
        this.id = id;
        this.observacion = observacion;
        this.estado = estado;
        this.monto = monto;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estadoNotaVenta = estadoNotaVenta;
        this.factura = factura;
        this.notaVentaDetalle = notaVentaDetalle;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstadoNotaVenta() {
        return estadoNotaVenta;
    }

    public void setEstadoNotaVenta(Estado estadoNotaVenta) {
        this.estadoNotaVenta = estadoNotaVenta;
    }

    public TipoNota getTipoNota() {return tipoNota;
    }

    public void setTipoNota(TipoNota tipoNota) {this.tipoNota = tipoNota;
    }
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<NotaVentaDetalle> getNotaVentaDetalle() {
        return notaVentaDetalle;
    }

    public void setNotaCreditoCompraDetalle(List<NotaVentaDetalle> notaVentaDetalle) {
        this.notaVentaDetalle = notaVentaDetalle;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "NotaCreditoCompra{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", estadoNotaVenta=" + estadoNotaVenta +
                ", factura=" + factura +
                ", notaVentaDetalle=" + notaVentaDetalle +
                ", tipoNota=" + tipoNota +
                '}';
    }
}

