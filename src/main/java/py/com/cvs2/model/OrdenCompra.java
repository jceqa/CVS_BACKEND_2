package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_compra")
public class OrdenCompra implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "intervalo")
    private Integer intervalo;

    @Column(name = "cantidad_cuota")
    private Integer cantidadCuota;

    @Column(name = "monto_cuota")
    private Long montoCuota;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoOrdenCompra;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_condicion_pago", referencedColumnName = "id")
    private CondicionPago condicionPago;

    @OneToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;

    @OneToMany
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id")
    private List<PresupuestoCompra> presupuestosCompra;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id")
    private List<OrdenCompraDetalle> ordenCompraDetalle;

    public OrdenCompra() {
    }

    public OrdenCompra(int id, Date fecha, String observacion, String estado, Integer intervalo, Integer cantidadCuota, Long montoCuota, Long monto, Estado estadoOrdenCompra, Usuario usuario, CondicionPago condicionPago, Proveedor proveedor, List<PresupuestoCompra> presupuestosCompra, List<OrdenCompraDetalle> ordenCompraDetalle) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
        this.estado = estado;
        this.intervalo = intervalo;
        this.cantidadCuota = cantidadCuota;
        this.montoCuota = montoCuota;
        this.monto = monto;
        this.estadoOrdenCompra = estadoOrdenCompra;
        this.usuario = usuario;
        this.condicionPago = condicionPago;
        this.proveedor = proveedor;
        this.presupuestosCompra = presupuestosCompra;
        this.ordenCompraDetalle = ordenCompraDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Integer getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Integer intervalo) {
        this.intervalo = intervalo;
    }

    public Integer getCantidadCuota() {
        return cantidadCuota;
    }

    public void setCantidadCuota(Integer cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }

    public Long getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(Long montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Estado getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(Estado estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CondicionPago getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(CondicionPago condicionPago) {
        this.condicionPago = condicionPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<PresupuestoCompra> getPresupuestosCompra() {
        return presupuestosCompra;
    }

    public void setPresupuestosCompra(List<PresupuestoCompra> presupuestosCompra) {
        this.presupuestosCompra = presupuestosCompra;
    }

    public List<OrdenCompraDetalle> getOrdenCompraDetalle() {
        return ordenCompraDetalle;
    }

    public void setOrdenCompraDetalle(List<OrdenCompraDetalle> ordenCompraDetalle) {
        this.ordenCompraDetalle = ordenCompraDetalle;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", intervalo=" + intervalo +
                ", cantidadCuota=" + cantidadCuota +
                ", montoCuota=" + montoCuota +
                ", monto=" + monto +
                ", estadoOrdenCompra=" + estadoOrdenCompra +
                ", usuario=" + usuario +
                ", condicionPago=" + condicionPago +
                ", proveedor=" + proveedor +
                ", presupuestosCompra=" + presupuestosCompra +
                ", ordenCompraDetalle=" + ordenCompraDetalle +
                '}';
    }
}