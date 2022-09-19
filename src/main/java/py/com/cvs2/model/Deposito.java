package py.com.cvs2.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "deposito")
public class Deposito implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @Column(name = "estado")
    String estado;

    public Deposito() {
    }

    public Deposito(int id, String descripcion, Sucursal sucursal) {
        this.id = id;
        this.descripcion = descripcion;
        this.sucursal = sucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", sucursal=" + sucursal +
                '}';
    }
}