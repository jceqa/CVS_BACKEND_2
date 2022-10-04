package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "presupuesto_compra")
public class PresupuestoCompra implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "total")
    private Long total;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoPresupuestoCompra;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_pedido_compra", referencedColumnName = "id")
    private PedidoCompra pedidoCompra;

    @OneToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_presuesto_compra", referencedColumnName = "id")
    private List<PresupuestoCompraDetalle> presupuestoCompraDetalles;

    public PresupuestoCompra() {
    }

    public PresupuestoCompra(int id, Date fecha, String estado, String observacion, Long total, Estado estadoPresupuestoCompra, Usuario usuario, PedidoCompra pedidoCompra, Proveedor proveedor, List<PresupuestoCompraDetalle> presupuestoCompraDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
        this.total = total;
        this.estadoPresupuestoCompra = estadoPresupuestoCompra;
        this.usuario = usuario;
        this.pedidoCompra = pedidoCompra;
        this.proveedor = proveedor;
        this.presupuestoCompraDetalles = presupuestoCompraDetalles;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Estado getEstadoPresupuestoCompra() {
        return estadoPresupuestoCompra;
    }

    public void setEstadoPresupuestoCompra(Estado estadoPresupuestoCompra) {
        this.estadoPresupuestoCompra = estadoPresupuestoCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PedidoCompra getPedidoCompra() {
        return pedidoCompra;
    }

    public void setPedidoCompra(PedidoCompra pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<PresupuestoCompraDetalle> getPresupuestoCompraDetalles() {
        return presupuestoCompraDetalles;
    }

    public void setPresupuestoCompraDetalles(List<PresupuestoCompraDetalle> presupuestoCompraDetalles) {
        this.presupuestoCompraDetalles = presupuestoCompraDetalles;
    }

    @Override
    public String toString() {
        return "PresupuestoCompra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                ", total=" + total +
                ", estadoPresupuestoCompra=" + estadoPresupuestoCompra +
                ", usuario=" + usuario +
                ", pedidoCompra=" + pedidoCompra +
                ", proveedor=" + proveedor +
                ", presupuestoCompraDetalles=" + presupuestoCompraDetalles +
                '}';
    }
}
