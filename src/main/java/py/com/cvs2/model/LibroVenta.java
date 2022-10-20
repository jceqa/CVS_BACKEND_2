package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libro_venta")
public class LibroVenta implements Serializable {

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_libro_venta", referencedColumnName = "id")
    private List<LibroVentaDetalle> libroVentaDetalles;

    public LibroVenta() {
    }

    public LibroVenta(int id, Date fecha, String estado, Long montoIVA5, Long montoIVA10, Long montoNeto, List<LibroVentaDetalle> libroVentaDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.montoIVA5 = montoIVA5;
        this.montoIVA10 = montoIVA10;
        this.montoNeto = montoNeto;
        this.libroVentaDetalles = libroVentaDetalles;
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

    public List<LibroVentaDetalle> getLibroVentaDetalles() {
        return libroVentaDetalles;
    }

    public void setLibroVentaDetalles(List<LibroVentaDetalle> libroVentaDetalles) {
        this.libroVentaDetalles = libroVentaDetalles;
    }

    @Override
    public String toString() {
        return "LibroVenta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", montoIVA5=" + montoIVA5 +
                ", montoIVA10=" + montoIVA10 +
                ", montoNeto=" + montoNeto +
                ", libroVentaDetalles=" + libroVentaDetalles +
                '}';
    }
}
