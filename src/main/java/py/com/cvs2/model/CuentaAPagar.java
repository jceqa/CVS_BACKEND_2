package py.com.cvs2.model;

import org.eclipse.persistence.annotations.ReadOnly;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cuenta_a_pagar")
public class CuentaAPagar implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "monto")
    private Long monto;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "cantidad_cuotas")
    private Integer cantidadCuotas;

    @Column(name = "numero_cuota")
    private Integer numeroCuota;

    @Column(name = "estado")
    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pago", referencedColumnName = "id")
    private Pago pago;

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoCuentaAPagar;

    public CuentaAPagar() {
    }

    public CuentaAPagar(int id, Long monto, Date fechaVencimiento, Integer cantidadCuotas, Integer numeroCuota, String estado, Estado estadoCuentaAPagar) {
        this.id = id;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidadCuotas = cantidadCuotas;
        this.numeroCuota = numeroCuota;
        this.estado = estado;
        this.estadoCuentaAPagar = estadoCuentaAPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estado getEstadoCuentaAPagar() {
        return estadoCuentaAPagar;
    }

    public void setEstadoCuentaAPagar(Estado estadoCuentaAPagar) {
        this.estadoCuentaAPagar = estadoCuentaAPagar;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "CuentasAPagar{" +
                "id=" + id +
                ", monto=" + monto +
                ", fechaVencimiento=" + fechaVencimiento +
                ", cantidadCuotas=" + cantidadCuotas +
                ", numeroCuota=" + numeroCuota +
                ", estado='" + estado + '\'' +
                ", estadoCuentaAPagar=" + estadoCuentaAPagar +
                '}';
    }
}
