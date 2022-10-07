package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nota_remision")
public class NotaRemision implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha")
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoNotaRemision;

    @OneToOne
    @JoinColumn(name = "id_pedido_compra", referencedColumnName = "id")
    private PedidoCompra pedidoCompra;

    @OneToOne
    @JoinColumn(name = "id_origen", referencedColumnName = "id")
    private Deposito origen;

    @OneToOne
    @JoinColumn(name = "id_destino", referencedColumnName = "id")
    private Deposito destino;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_nota_remision", referencedColumnName = "id")
    private List<NotaRemisionDetalle> notaRemisionDetalle;

    public NotaRemision() {
    }

    public NotaRemision(int id, String observacion, String estado, String tipo, Estado estadoNotaRemision, PedidoCompra pedidoCompra, Deposito origen, Deposito destino, List<NotaRemisionDetalle> notaRemisionDetalle) {
        this.id = id;
        this.observacion = observacion;
        this.estado = estado;
        this.tipo = tipo;
        this.estadoNotaRemision = estadoNotaRemision;
        this.pedidoCompra = pedidoCompra;
        this.origen = origen;
        this.destino = destino;
        this.notaRemisionDetalle = notaRemisionDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Estado getEstadoNotaRemision() {
        return estadoNotaRemision;
    }

    public void setEstadoNotaRemision(Estado estadoNotaRemision) {
        this.estadoNotaRemision = estadoNotaRemision;
    }

    public PedidoCompra getPedidoCompra() {
        return pedidoCompra;
    }

    public void setPedidoCompra(PedidoCompra pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    public Deposito getOrigen() {
        return origen;
    }

    public void setOrigen(Deposito origen) {
        this.origen = origen;
    }

    public Deposito getDestino() {
        return destino;
    }

    public void setDestino(Deposito destino) {
        this.destino = destino;
    }

    public List<NotaRemisionDetalle> getNotaRemisionDetalle() {
        return notaRemisionDetalle;
    }

    public void setNotaRemisionDetalle(List<NotaRemisionDetalle> notaRemisionDetalle) {
        this.notaRemisionDetalle = notaRemisionDetalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "NotaRemision{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estadoNotaRemision=" + estadoNotaRemision +
                ", pedidoCompra=" + pedidoCompra +
                ", origen=" + origen +
                ", destino=" + destino +
                ", notaRemisionDetalle=" + notaRemisionDetalle +
                '}';
    }
}
