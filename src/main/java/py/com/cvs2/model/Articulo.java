package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_compra")
    private Long precioCompra;

    @Column(name = "precio_venta")
    private Long precioVenta;

    @Column(name = "codigo_generico")
    private String codigoGenerico;

    @ManyToOne
    @JoinColumn(name = "id_impuesto")
    private Impuesto impuesto;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_tipo_articulo")
    private TipoArticulo tipoArticulo;

    @Column(name = "estado")
    String estado;

    public Articulo() {
    }

    public Articulo(int id, String descripcion, Long precioCompra, Long precioVenta, String codigoGenerico, Impuesto impuesto, Marca marca, TipoArticulo tipoArticulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.codigoGenerico = codigoGenerico;
        this.impuesto = impuesto;
        this.marca = marca;
        this.tipoArticulo = tipoArticulo;
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

    public Long getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Long precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Long getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Long precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCodigoGenerico() {
        return codigoGenerico;
    }

    public void setCodigoGenerico(String codigoGenerico) {
        this.codigoGenerico = codigoGenerico;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", codigoGenerico='" + codigoGenerico + '\'' +
                ", impuesto=" + impuesto +
                ", marca=" + marca +
                ", tipoArticulo=" + tipoArticulo +
                '}';
    }
}
