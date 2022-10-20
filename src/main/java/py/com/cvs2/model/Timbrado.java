package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "timbrado")
public class Timbrado implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_inicio_vigencia")
    private Date fechaInicioVigencia;

    @Column(name = "fecha_fin_vigencia")
    private Date fechaFinVigencia;

    @Column(name = "numero_timbrado")
    private String numeroTimbrado;

    public Timbrado() {
    }

    public Timbrado(int id, String estado, Date fechaInicioVigencia, Date fechaFinVigencia, String numeroTimbrado) {
        this.id = id;
        this.estado = estado;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.numeroTimbrado = numeroTimbrado;
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

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getNumeroTimbrado() {
        return numeroTimbrado;
    }

    public void setNumeroTimbrado(String numeroTimbrado) {
        this.numeroTimbrado = numeroTimbrado;
    }

    @Override
    public String toString() {
        return "Timbrado{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", fechaInicioVigencia=" + fechaInicioVigencia +
                ", fechaFinVigencia=" + fechaFinVigencia +
                ", numeroTimbrado='" + numeroTimbrado + '\'' +
                '}';
    }
}
