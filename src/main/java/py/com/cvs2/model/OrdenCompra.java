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

    @Column(name = "estado")
    private String estado;

    @Column(name = "intervalo")
    private Integer intervalo;

    @Column(name = "cantidadcuota")
    private Integer cantidadcuota;

    @Column(name = "montocuota")
    private Long montocuota;

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

    public OrdenCompra(int id, Date fecha, String estado, Integer intervalo, Integer cantidadcuota,  Long montocuota, Estado estadoOrdenCompra, Usuario usuario, PresupuestoCompra presupuestoCompra, List<OrdenCompraDetalle> ordenCompraDetalle) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.intervalo = intervalo;
        this.cantidadcuota = cantidadcuota;
        this.montocuota = montocuota;
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

    public Integer getCantidadcuota() { return cantidadcuota;
    }

    public void setCantidadcuota(Integer cantidadcuota) {
        this.cantidadcuota = cantidadcuota;
    }

    public Long getMontocuota() {return montocuota;
    }

    public void setMontocuota(Long montocuota) {this.montocuota = montocuota;
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

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", intervalo='" + intervalo + '\'' +
                ", cantidadcuota='" + cantidadcuota + '\'' +
                ", montocuota=" + montocuota +
                ", estadoOrdenCompra=" + estadoOrdenCompra +
                ", usuario=" + usuario +
                ", PresupuestoCompra=" + presupuestoCompra +
                ", ordenCompraDetalle=" + ordenCompraDetalle +
                '}';
    }
}