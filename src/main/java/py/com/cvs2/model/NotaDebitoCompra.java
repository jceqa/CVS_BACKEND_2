package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "nota_debito_compra")
public class NotaDebitoCompra implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "numero")
    private String numero;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoNotaDebitoCompra;

    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_cuenta_a_pagar", referencedColumnName = "id")
    private CuentaAPagar cuentaAPagar;

    @OneToMany(cascade= {CascadeType.ALL})
    @JoinColumn(name = "id_nota_debito", referencedColumnName = "id")
    private List<NotaDebitoCompraDetalle> notaDebitoCompraDetalle;

    public NotaDebitoCompra() {
    }

    public NotaDebitoCompra(int id, String observacion, String estado, String numero, Long monto, Estado estadoNotaDebitoCompra, CuentaAPagar cuentaAPagar, List<NotaDebitoCompraDetalle> notaDebitoCompraDetalle) {
        this.id = id;
        this.observacion = observacion;
        this.estado = estado;
        this.numero = numero;
        this.monto = monto;
        this.estadoNotaDebitoCompra = estadoNotaDebitoCompra;
        this.cuentaAPagar = cuentaAPagar;
        this.notaDebitoCompraDetalle = notaDebitoCompraDetalle;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Estado getEstadoNotaDebitoCompra() {
        return estadoNotaDebitoCompra;
    }

    public void setEstadoNotaDebitoCompra(Estado estadoNotaDebitoCompra) {
        this.estadoNotaDebitoCompra = estadoNotaDebitoCompra;
    }

    public CuentaAPagar getCuentaAPagar() {
        return cuentaAPagar;
    }

    public void setCuentaAPagar(CuentaAPagar cuentaAPagar) {
        this.cuentaAPagar = cuentaAPagar;
    }

    public List<NotaDebitoCompraDetalle> getNotaDebitoCompraDetalle() {
        return notaDebitoCompraDetalle;
    }

    public void setNotaDebitoCompraDetalle(List<NotaDebitoCompraDetalle> notaDebitoCompraDetalle) {
        this.notaDebitoCompraDetalle = notaDebitoCompraDetalle;
    }

    @Override
    public String toString() {
        return "NotaDebitoCompra{" +
                "id=" + id +
                ", observacion='" + observacion + '\'' +
                ", estado='" + estado + '\'' +
                ", numero='" + numero + '\'' +
                ", monto=" + monto +
                ", estadoNotaDebitoCompra=" + estadoNotaDebitoCompra +
                ", cuentaAPagar=" + cuentaAPagar +
                ", notaDebitoCompraDetalle=" + notaDebitoCompraDetalle +
                '}';
    }
}
