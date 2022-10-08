package py.com.cvs2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "diagnostico")
public class Diagnostico implements Serializable {

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
    private Estado estadoDiagnostico;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_recepcion", referencedColumnName = "id")
    private Recepcion recepcion;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id")
    private List<DiagnosticoDetalle> diagnosticoDetalles;

    public Diagnostico() {
    }

    public Diagnostico(int id, Date fecha, String estado, String observacion, Estado estadoDiagnostico, Usuario usuario,
                       Recepcion recepcion, List<DiagnosticoDetalle> diagnosticoDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.observacion = observacion;
        this.estadoDiagnostico = estadoDiagnostico;
        this.usuario = usuario;
        this.recepcion = recepcion;
        this.diagnosticoDetalles = diagnosticoDetalles;
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

    public Estado getEstadoDiagnostico() {
        return estadoDiagnostico;
    }

    public void setEstadoDiagnostico(Estado estadoDiagnostico) {
        this.estadoDiagnostico = estadoDiagnostico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public List<DiagnosticoDetalle> getDiagnosticoDetalles() {
        return diagnosticoDetalles;
    }

    public void setDignosticoDetalles(List<DiagnosticoDetalle> diagnosticoDetalles) {
        this.diagnosticoDetalles = diagnosticoDetalles;
    }


    @Override
    public String toString() {
        return "Diagnostico{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                ", estadoDiagnostico=" + estadoDiagnostico +
                ", usuario=" + usuario +
                ", recepcion=" + recepcion +
                ", diagnosticoDetalles=" + diagnosticoDetalles +
                '}';
    }
}
