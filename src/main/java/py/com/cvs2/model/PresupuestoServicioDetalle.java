package py.com.cvs2.model;


import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "presupuesto_servicio_detalle")
public class PresupuestoServicioDetalle {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_diagnostico_detalle", referencedColumnName = "id")
    private DiagnosticoDetalle diagnosticoDetalle;

    public PresupuestoServicioDetalle() {
    }

    public PresupuestoServicioDetalle(int id, String estado, Long monto, DiagnosticoDetalle diagnosticoDetalle) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.diagnosticoDetalle = diagnosticoDetalle;
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

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public DiagnosticoDetalle getDiagnosticoDetalle() {
        return diagnosticoDetalle;
    }

    public void setDiagnosticoDetalle(DiagnosticoDetalle diagnosticoDetalle) {
        this.diagnosticoDetalle = diagnosticoDetalle;
    }

    @Override
    public String toString() {
        return "PresupuestoServicioDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", diagnosticoDetalle=" + diagnosticoDetalle +
                '}';
    }
}