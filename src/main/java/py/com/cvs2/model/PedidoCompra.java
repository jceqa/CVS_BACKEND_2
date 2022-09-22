package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido_compra")
public class PedidoCompra implements Serializable {

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
    private Estado estadoPedido;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_pedido_compra", referencedColumnName = "id")
    private List<PedidoCompraDetalle> pedidoCompraDetalles;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_deposito", referencedColumnName = "id")
    private Deposito deposito;

    public PedidoCompra() {
    }

    public PedidoCompra(int id, Date fecha, String estado, List<PedidoCompraDetalle> pedidoCompraDetalles) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.pedidoCompraDetalles = pedidoCompraDetalles;
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

    public List<PedidoCompraDetalle> getDetallePedidoCompras() {
        return pedidoCompraDetalles;
    }

    public void setDetallePedidoCompras(List<PedidoCompraDetalle> pedidoCompraDetalles) {
        this.pedidoCompraDetalles = pedidoCompraDetalles;
    }

    public Estado getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Estado estadoPedido) {
        this.estadoPedido = estadoPedido;
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

    @Override
    public String toString() {
        return "PedidoCompra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", detallePedidoCompras=" + pedidoCompraDetalles +
                '}';
    }
}
