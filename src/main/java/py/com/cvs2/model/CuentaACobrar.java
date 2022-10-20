package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cuenta_a_cobrar")
public class CuentaACobrar implements Serializable {

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

    @OneToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    private Estado estadoCuentaACobrar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cobro", referencedColumnName = "id")
    private Cobro cobro;

    public CuentaACobrar() {
    }

    public CuentaACobrar(int id, Long monto, Date fechaVencimiento, Integer cantidadCuotas, Integer numeroCuota, String estado, Estado estadoCuentaACobrar, Cobro cobro) {
        this.id = id;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidadCuotas = cantidadCuotas;
        this.numeroCuota = numeroCuota;
        this.estado = estado;
        this.estadoCuentaACobrar = estadoCuentaACobrar;
        this.cobro = cobro;
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

    public Estado getEstadoCuentaACobrar() {
        return estadoCuentaACobrar;
    }

    public void setEstadoCuentaACobrar(Estado estadoCuentaACobrar) {
        this.estadoCuentaACobrar = estadoCuentaACobrar;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }

    @Override
    public String toString() {
        return "CuentaACobrar{" +
                "id=" + id +
                ", monto=" + monto +
                ", fechaVencimiento=" + fechaVencimiento +
                ", cantidadCuotas=" + cantidadCuotas +
                ", numeroCuota=" + numeroCuota +
                ", estado='" + estado + '\'' +
                ", estadoCuentaACobrar=" + estadoCuentaACobrar +
                ", cobro=" + cobro +
                '}';
    }
}
