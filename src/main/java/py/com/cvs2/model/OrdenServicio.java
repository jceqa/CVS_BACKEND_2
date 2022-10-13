package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orden_servicio")
public class OrdenServicio implements Serializable {

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

    @Column(name = "fechaentrega")
    private Date fechaentrega;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoOrdenServicio;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_deposito", referencedColumnName = "id")
    private Deposito deposito;

    @OneToOne
    @JoinColumn(name = "id_presupuesto_servicio", referencedColumnName = "id")
    private PresupuestoServicio presupuestoServicio;

    @OneToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_orden_servicio", referencedColumnName = "id")
    private List<OrdenServicioDetalle> ordenServicioDetalles;

    public OrdenServicio() {
    }

    public OrdenServicio(int id, Date fecha, String estado, String observacion, Long total, Date fechaentrega, Estado estadoOrdenServicio,
                         Usuario usuario, Deposito deposito, PresupuestoServicio presupuestoServicio, List<PresupuestoServicioDetalle> presupuestoServicioDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
        this.total = total;
        this.fechaentrega = fechaentrega;
        this.estadoOrdenServicio = estadoOrdenServicio;
        this.usuario = usuario;
        this.deposito = deposito;
        this.presupuestoServicio = presupuestoServicio;
        this.ordenServicioDetalles = ordenServicioDetalles;
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

    public Date getFechaentrega() {return fechaentrega;}

    public void setFechaentrega(Date fechaentrega) {this.fechaentrega = fechaentrega;}

    public Deposito getDeposito() {return deposito;}

    public void setDeposito(Deposito deposito) {this.deposito = deposito;}

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

    public Estado getEstadoo() {
        return estadoOrdenServicio;
    }

    public void setEstadoOrdenServicio(Estado estadoOrdenServicio) {
        this.estadoOrdenServicio = estadoOrdenServicio;}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PresupuestoServicio getPresupuestoServicio() {
        return presupuestoServicio;
    }

    public void setPresupuestoServicio(PresupuestoServicio presupuestoServicio) {
        this.presupuestoServicio = presupuestoServicio;
    }

    public List<OrdenServicioDetalle> getOrdenServicioDetalles() {
        return ordenServicioDetalles;
    }

    @Override
    public String toString() {
        return "OrdenServicio{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                ", total=" + total +
                ", fechaentrega=" + fechaentrega +
                ", estadoOrdenServicio=" + estadoOrdenServicio +
                ", usuario=" + usuario +
                ", deposito=" + deposito +
                ", presupuestoServicio=" + presupuestoServicio +
                ", proveedor=" + proveedor +
                ", ordenServicioDetalles=" + ordenServicioDetalles +
                '}';
    }
}