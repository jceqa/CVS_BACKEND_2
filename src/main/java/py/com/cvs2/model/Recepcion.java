package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "recepcion")
public class Recepcion implements Serializable {

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
    private Estado estadoRecepcion;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_recepcion", referencedColumnName = "id")
    private List<RecepcionDetalle> recepcionDetalles;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_deposito", referencedColumnName = "id")
    private Deposito deposito;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;


    public Recepcion() {
    }

    public Recepcion(int id, Date fecha, String estado, List<RecepcionDetalle> recepcionDetalle) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.recepcionDetalles = recepcionDetalle;
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

    public List<RecepcionDetalle> getRecepcionDetalles() {return recepcionDetalles;}

    public void setRecepcionDetalles(List<RecepcionDetalle> recepcionDetalles) {
        this.recepcionDetalles = recepcionDetalles;}

    public Deposito getDeposito() {
        return deposito;}

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;}

    public Estado getEstadoRecepcion() {
        return estadoRecepcion;
    }

    public void setEstadoRecepcion(Estado estadoPedido) {
        this.estadoRecepcion = estadoRecepcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Cliente getCliente() {return cliente;
    }

    public void setCliente(Cliente cliente) {this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Recepcion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", recepcionDetalle=" + recepcionDetalles +
                '}';
    }
}
