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

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoOrdenCompra;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_presupuesto_compra", referencedColumnName = "id")
    private PresupuestoCompra presupuestoCompra;

    @OneToOne
    @JoinColumn(name = "id_condicion_pago", referencedColumnName = "id")
    private CondicionPago condicionPago;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_orden_compra_detalle", referencedColumnName = "id")
    private List<OrdenCompraDetalle> ordenCompraDetalle;

    public OrdenCompra() {
    }

    public OrdenCompra(int id, Date fecha, String estado, Integer intervalo, Integer cantidadCuota,  Long montoCuota, Estado estadoOrdenCompra, Usuario usuario, PresupuestoCompra presupuestoCompra, List<OrdenCompraDetalle> ordenCompraDetalle) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.intervalo = intervalo;
        this.cantidadCuota = cantidadCuota;
        this.montoCuota = montoCuota;
        this.estadoOrdenCompra=estadoOrdenCompra;
        this.usuario = usuario;
        this.presupuestoCompra = presupuestoCompra;
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

    public Integer getCantidadCuota() { return cantidadCuota;
    }

    public void setCantidadCuota(Integer cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }

    public Long getMontoCuota() {return montoCuota;
    }

    public void setMontoCuota(Long montoCuota) {this.montoCuota = montoCuota;
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

    public PresupuestoCompra getPresupuestoCompra() {
        return presupuestoCompra;
    }

    public void setPresupuestoCompra(PresupuestoCompra presupuestoCompra) {
        this.presupuestoCompra = presupuestoCompra;
    }

    public List<OrdenCompraDetalle> getOrdenCompraDetallesCompraDetalle() {
        return ordenCompraDetalle;
    }

    public void setOrdenCompraDetalles(List<OrdenCompraDetalle> ordenCompraDetalles) {
        this.ordenCompraDetalle = ordenCompraDetalles;
    }

    public CondicionPago getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(CondicionPago condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
                ", estado='" + estado + '\'' +
                ", intervalo='" + intervalo + '\'' +
                ", cantidadCuota='" + cantidadCuota + '\'' +
                ", montoCuota=" + montoCuota +
                ", estadoOrdenCompra=" + estadoOrdenCompra +
                ", usuario=" + usuario +
                ", PresupuestoCompra=" + presupuestoCompra +
                ", ordenCompraDetalle=" + ordenCompraDetalle +
                '}';
    }
}