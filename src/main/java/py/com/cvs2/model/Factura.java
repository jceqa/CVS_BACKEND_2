package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

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

    @Column(name = "numeroFactura")
    private String numeroFactura;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoFactura;

    @OneToOne
    @JoinColumn(name = " id_timbrado", referencedColumnName = "id")
    private Timbrado timbrado;

    @OneToOne
    @JoinColumn(name = "id_condicion_pago", referencedColumnName = "id")
    private CondicionPago condicionPago;

    @OneToOne
    @JoinColumn(name = "id_pedido_venta", referencedColumnName = "id")
    private PedidoVenta pedidoVenta;

    @OneToMany
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private List<OrdenServicio> ordenServiciosList;

    @OneToOne
    @JoinColumn(name = "id_caja", referencedColumnName = "id")
    private Caja caja;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_libro_venta", referencedColumnName = "id")
    private LibroVenta libroVenta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private List<FacturaDetalle> facturaDetalles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private List<CuentaACobrar> cuentaACobrarList;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    public Factura() {
    }

    public Factura(int id, String observacion, String estado, Date fecha, Long monto, String numeroFactura, Estado estadoFactura, Timbrado timbrado, CondicionPago condicionPago, PedidoVenta pedidoVenta, List<OrdenServicio> ordenServiciosList, Caja caja, LibroVenta libroVenta, List<FacturaDetalle> facturaDetalles, List<CuentaACobrar> cuentaACobrarList) {
        this.id = id;
        this.observacion = observacion;
        this.estado = estado;
        this.fecha = fecha;
        this.monto = monto;
        this.numeroFactura = numeroFactura;
        this.estadoFactura = estadoFactura;
        this.timbrado = timbrado;
        this.condicionPago = condicionPago;
        this.pedidoVenta = pedidoVenta;
        this.ordenServiciosList = ordenServiciosList;
        this.caja = caja;
        this.libroVenta = libroVenta;
        this.facturaDetalles = facturaDetalles;
        this.cuentaACobrarList = cuentaACobrarList;
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

    public Estado getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(Estado estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Timbrado getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Timbrado timbrado) {
        this.timbrado = timbrado;
    }

    public CondicionPago getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(CondicionPago condicionPago) {
        this.condicionPago = condicionPago;
    }

    public PedidoVenta getPedidoVenta() {
        return pedidoVenta;
    }

    public void setPedidoVenta(PedidoVenta pedidoVenta) {
        this.pedidoVenta = pedidoVenta;
    }

    public List<OrdenServicio> getOrdenServiciosList() {
        return ordenServiciosList;
    }

    public void setOrdenServiciosList(List<OrdenServicio> ordenServiciosList) {
        this.ordenServiciosList = ordenServiciosList;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public LibroVenta getLibroVenta() {
        return libroVenta;
    }

    public void setLibroVenta(LibroVenta libroVenta) {
        this.libroVenta = libroVenta;
    }

    public List<FacturaDetalle> getFacturaDetalles() {
        return facturaDetalles;
    }

    public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }

    public List<CuentaACobrar> getCuentaACobrarList() {
        return cuentaACobrarList;
    }

    public void setCuentaACobrarList(List<CuentaACobrar> cuentaACobrarList) {
        this.cuentaACobrarList = cuentaACobrarList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", numeroFactura='" + numeroFactura + '\'' +
                ", estadoFactura=" + estadoFactura +
                ", timbrado=" + timbrado +
                ", condicionPago=" + condicionPago +
                ", pedidoVenta=" + pedidoVenta +
                ", ordenServiciosList=" + ordenServiciosList +
                ", caja=" + caja +
                ", libroVenta=" + libroVenta +
                ", facturaDetalles=" + facturaDetalles +
                ", cuentaACobrarList=" + cuentaACobrarList +
                '}';
    }
}

