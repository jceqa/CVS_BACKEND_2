package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "presupuesto_servicio")
public class PresupuestoServicio implements Serializable {

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
    private Estado estadoPresupuestoServicio;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_promo_descuento", referencedColumnName = "id")
    private PromoDescuento promoDescuento;

    @OneToOne
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    private Diagnostico diagnostico;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_presuesto_servicio", referencedColumnName = "id")
    private List<PresupuestoServicioDetalle> presupuestoServicioDetalles;

    public PresupuestoServicio() {
    }

    public PresupuestoServicio(int id, Date fecha, String estado, String observacion, Long total, Estado estadoPresupuestoServicio,
                               Usuario usuario, PromoDescuento promoDescuento,  Diagnostico diagnostico, List<PresupuestoServicioDetalle> presupuestoServicioDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
        this.total = total;
        this.estadoPresupuestoServicio = estadoPresupuestoServicio;
        this.usuario = usuario;
        this.promoDescuento = promoDescuento;
        this.diagnostico = diagnostico;
        this.presupuestoServicioDetalles = presupuestoServicioDetalles;
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

    public Estado getEstadoPresupuestoServicio() {
        return estadoPresupuestoServicio;
    }

    public void setEstadoPresupuestoServicio(Estado estadoPresupuesto) {
        this.estadoPresupuestoServicio = estadoPresupuestoServicio;
    }

    public PromoDescuento getPromoDescuento() {return promoDescuento;
    }

    public void setPromoDescuento(PromoDescuento promoDescuento) {this.promoDescuento = promoDescuento;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<PresupuestoServicioDetalle> getPresupuestoServicioDetalles() {
        return presupuestoServicioDetalles;
    }

    public void setPresupuestoServicioDetalles(List<PresupuestoServicioDetalle> presupuestoServicioDetalles) {
        this.presupuestoServicioDetalles = presupuestoServicioDetalles;
    }

    @Override
    public String toString() {
        return "PresupuestoServicio{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                ", total=" + total +
                ", estadoPresupuestoServicio=" + estadoPresupuestoServicio +
                ", usuario=" + usuario +
                ", diagnostico=" + diagnostico +
                ", presupuestoServicioDetalles=" + presupuestoServicioDetalles +
                '}';
    }
}