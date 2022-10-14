package py.com.cvs2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido_venta")
public class PedidoVenta implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observacion")
    private String observacion;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoPedidoVenta;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_pedido_venta", referencedColumnName = "id")
    private List<PedidoVentaDetalle> pedidoVentaDetalles;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_deposito", referencedColumnName = "id")
    private Deposito deposito;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    public PedidoVenta() {
    }

    public PedidoVenta(int id, Date fecha, String estado, List<PedidoVentaDetalle> pedidoVentaDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.pedidoVentaDetalles = pedidoVentaDetalles;
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

    public List<PedidoVentaDetalle> getPedidoVentaDetalles() {
        return pedidoVentaDetalles;
    }

    public void setPedidoVentaDetalles(List<PedidoVentaDetalle> pedidoVentaDetalles) {
        this.pedidoVentaDetalles = pedidoVentaDetalles;
    }

    public Estado getEstadoPedidoVenta() {
        return estadoPedidoVenta;
    }

    public void setEstadoPedidoVenta(Estado estadoPedidoVenta) {
        this.estadoPedidoVenta = estadoPedidoVenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "PedidoVenta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", detallePedidoVentas=" + pedidoVentaDetalles +
                '}';
    }
}
