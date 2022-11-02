package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reclamo")
public class Reclamo implements Serializable {

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

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoReclamo;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_entrega_equipo", referencedColumnName = "id")
    private EntregaEquipo entregaEquipo;


    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_reclamo", referencedColumnName = "id")
    private List<ReclamoDetalle> reclamoDetalles;

    public Reclamo() {
    }

    public Reclamo(int id, Date fecha, String estado, String observacion, Estado estadoReclamo, Usuario usuario, EntregaEquipo entregaEquipo, List<ReclamoDetalle> reclamoDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
        this.estadoReclamo = estadoReclamo;
        this.usuario = usuario;
        this.entregaEquipo = entregaEquipo;
        this.reclamoDetalles = reclamoDetalles;
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

    public Estado getEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(Estado estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EntregaEquipo getEntregaEquipo() {
        return entregaEquipo;
    }

    public void setEntregaEquipo(EntregaEquipo entregaEquipo) {
        this.entregaEquipo = entregaEquipo;
    }

    public List<ReclamoDetalle> getReclamoDetalle() {
        return getReclamoDetalle();
    }

    public void setReclamoDetalle(List<ReclamoDetalle> reclamoDetalles) {
        this.reclamoDetalles = reclamoDetalles;
    }

    @Override
    public String toString() {
        return "Reclamo{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                ", estadoReclamo=" + estadoReclamo +
                ", usuario=" + usuario +
                ", entregaEquipo=" + entregaEquipo +
                ", reclamoDetalles=" + reclamoDetalles +
                '}';
    }
}
