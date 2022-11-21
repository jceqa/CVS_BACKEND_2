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

    @Column(name = "inicio_vigencia")
    private Date inicioVigencia;

    @Column(name = "fin_vigencia")
    private Date finVigencia;

    @Column(name = "numero")
    private String numero;

    public Timbrado() {
    }

    public Timbrado(int id, String estado, Date inicioVigencia, Date finVigencia, String numero) {
        this.id = id;
        this.estado = estado;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.numero = numero;
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

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(Date finVigencia) {
        this.finVigencia = finVigencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Timbrado{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", inicioVigencia=" + inicioVigencia +
                ", finVigencia=" + finVigencia +
                ", numero=" + numero + '\'' +
                '}';
    }
}
