package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entrega_equipo")
public class EntregaEquipo implements Serializable {

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

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoEntregaEquipo;

    @OneToOne
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura factura;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_entrega_equipo", referencedColumnName = "id")
    private List<EntregaEquipoDetalle> entregaEquipoDetalle;

    public EntregaEquipo() {
    }

    public EntregaEquipo(int id, String estado, Date fecha,  Usuario usuario, Estado estadoEntregaEquipo, Factura factura, List<EntregaEquipoDetalle> entregaEquipoDetalle) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;;
        this.usuario = usuario;
        this.estadoEntregaEquipo = estadoEntregaEquipo;
        this.factura = factura;
        this.entregaEquipoDetalle = entregaEquipoDetalle;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstadoEntregaEquipo() {
        return estadoEntregaEquipo;
    }

    public void setEstadoEntregaEquipo(Estado estadoEntregaEquipo) {
        this.estadoEntregaEquipo = estadoEntregaEquipo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<EntregaEquipoDetalle> getEntregaEquipoDetalle() {
        return entregaEquipoDetalle;
    }

    public void setEntregaEquipoDetalle(List<EntregaEquipoDetalle> entregaEquipoDetalle) {
        this.entregaEquipoDetalle = entregaEquipoDetalle;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    @Override
    public String toString() {
        return "FacturaCompra{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                ", estadoEntregaEquipo=" + estadoEntregaEquipo +
                ", factura=" + factura +
                '}';
    }
}
