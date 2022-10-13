package py.com.cvs2.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promo_descuento")
public class PromoDescuento implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "porcentaje")
    private Long porcentaje;


    @Column(name = "estado")
    String estado;

    public PromoDescuento() {
    }

    public PromoDescuento(int id, String descripcion, Long porcentaje) {
        this.id = id;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
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

    public Long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PromoDescuento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", porcentaje=" + porcentaje +
                '}';
    }
}