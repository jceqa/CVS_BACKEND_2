package py.com.cvs2.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diagnostico_detalle")
public class DiagnosticoDetalle {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "diagnostico")
    private String diagnostico;

    @ManyToMany
    @JoinTable(
            name = "servicios_por_diagnostico_detalle",
            joinColumns = @JoinColumn(name = "id_diagnostico_detalle", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    )
    private List<Servicio> servicios;

    @OneToOne
    @JoinColumn(name = "id_recepcion_detalle", referencedColumnName = "id")
    private RecepcionDetalle recepcionDetalle;


    public DiagnosticoDetalle() {
    }

    public DiagnosticoDetalle(int id, String estado, String diagnostico, RecepcionDetalle recepcionDetalle) {
        this.id = id;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.recepcionDetalle = recepcionDetalle;
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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public RecepcionDetalle getRecepcionDetalle() {
        return recepcionDetalle;
    }

    public void setRecepcionDetalle(RecepcionDetalle recepcionDetalle) {
        this.recepcionDetalle = recepcionDetalle;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "PresupuestoCompraDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", diagnostico=" + diagnostico +
                ", recepcionDetalle=" + recepcionDetalle +
                '}';
    }
}