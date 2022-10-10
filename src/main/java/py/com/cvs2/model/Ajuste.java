package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ajuste")
public class Ajuste implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    String estado;

    @Column(name ="fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "tipo")
    private String tipo;

    @OneToOne
    @JoinColumn(name = "id_stock", referencedColumnName = "id")
    private Stock stock;

    public Ajuste() {
    }

    public Ajuste(int id, String descripcion, String estado, Date fecha, Integer cantidad, String tipo, Stock stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.stock = stock;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Ajuste{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", tipo='" + tipo + '\'' +
                ", stock=" + stock +
                '}';
    }
}
