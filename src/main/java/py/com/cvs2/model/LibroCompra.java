package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libro_compra")
public class LibroCompra implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto_iva_5")
    private Long montoIVA5;

    @Column(name = "monto_iva_10")
    private Long montoIVA10;

    @Column(name = "montoNeto")
    private Long montoNeto;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_libro_compra", referencedColumnName = "id")
    private List<LibroCompraDetalle> libroCompraDetalles;

    public LibroCompra() {
    }

    public LibroCompra(int id, Date fecha, Long montoIVA5, Long montoIVA10, Long montoNeto, List<LibroCompraDetalle> libroCompraDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.montoIVA5 = montoIVA5;
        this.montoIVA10 = montoIVA10;
        this.montoNeto = montoNeto;
        this.libroCompraDetalles = libroCompraDetalles;
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

    public Long getMontoIVA5() {
        return montoIVA5;
    }

    public void setMontoIVA5(Long montoIVA5) {
        this.montoIVA5 = montoIVA5;
    }

    public Long getMontoIVA10() {
        return montoIVA10;
    }

    public void setMontoIVA10(Long montoIVA10) {
        this.montoIVA10 = montoIVA10;
    }

    public Long getMontoNeto() {
        return montoNeto;
    }

    public void setMontoNeto(Long montoNeto) {
        this.montoNeto = montoNeto;
    }

    public List<LibroCompraDetalle> getLibroCompraDetalles() {
        return libroCompraDetalles;
    }

    public void setLibroCompraDetalle(List<LibroCompraDetalle> libroCompraDetalles) {
        this.libroCompraDetalles = libroCompraDetalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "LibroCompra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", montoIVA5=" + montoIVA5 +
                ", montoIVA10=" + montoIVA10 +
                ", montoNeto=" + montoNeto +
                ", libroCompraDetalle=" + libroCompraDetalles +
                '}';
    }
}
