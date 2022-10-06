package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "apertura_cierre_caja")
public class AperturaCierreCaja implements Serializable {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    String estado;

    @Column(name = "fecha_hora_apertura")
    private Date fechaHoraApertura;

    @Column(name = "fecha_hora_cierre")
    private Date fechaHoraCierre;

    @Column(name = "monto_apertura")
    private Long montoApertura;

    @Column(name = "monto_cierre")
    private Long montoCierre;

    @Column(name = "monto_cierre_efectivo")
    private Long montoCierreEfecivo;

    @Column(name = "monto_cierre_cheque")
    private Long montoCierreCheque;

    @Column(name = "monto_cierre_tarjeta")
    private Long montoCierreTarjeta;

    @OneToOne
    @JoinColumn(name = "id_caja", referencedColumnName = "id")
    private Caja caja;

    public AperturaCierreCaja() {
    }

    public AperturaCierreCaja(int id, String descripcion, String estado, Date fechaHoraApertura, Date fechaHoraCierre, Long montoApertura, Long montoCierre, Long montoCierreEfecivo, Long montoCierreCheque, Long montoCierreTarjeta) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaHoraApertura = fechaHoraApertura;
        this.fechaHoraCierre = fechaHoraCierre;
        this.montoApertura = montoApertura;
        this.montoCierre = montoCierre;
        this.montoCierreEfecivo = montoCierreEfecivo;
        this.montoCierreCheque = montoCierreCheque;
        this.montoCierreTarjeta = montoCierreTarjeta;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaHoraApertura() {
        return fechaHoraApertura;
    }

    public void setFechaHoraApertura(Date fechaHoraApertura) {
        this.fechaHoraApertura = fechaHoraApertura;
    }

    public Date getFechaHoraCierre() {
        return fechaHoraCierre;
    }

    public void setFechaHoraCierre(Date fechaHoraCierre) {
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public Long getMontoApertura() {
        return montoApertura;
    }

    public void setMontoApertura(Long montoApertura) {
        this.montoApertura = montoApertura;
    }

    public Long getMontoCierre() {
        return montoCierre;
    }

    public void setMontoCierre(Long montoCierre) {
        this.montoCierre = montoCierre;
    }

    public Long getMontoCierreEfecivo() {
        return montoCierreEfecivo;
    }

    public void setMontoCierreEfecivo(Long montoCierreEfecivo) {
        this.montoCierreEfecivo = montoCierreEfecivo;
    }

    public Long getMontoCierreCheque() {
        return montoCierreCheque;
    }

    public void setMontoCierreCheque(Long montoCierreCheque) {
        this.montoCierreCheque = montoCierreCheque;
    }

    public Long getMontoCierreTarjeta() {
        return montoCierreTarjeta;
    }

    public void setMontoCierreTarjeta(Long montoCierreTarjeta) {
        this.montoCierreTarjeta = montoCierreTarjeta;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    @Override
    public String toString() {
        return "AperturaCierreCaja{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaHoraApertura=" + fechaHoraApertura +
                ", fechaHoraCierre=" + fechaHoraCierre +
                ", montoApertura=" + montoApertura +
                ", montoCierre=" + montoCierre +
                ", montoCierreEfecivo=" + montoCierreEfecivo +
                ", montoCierreCheque=" + montoCierreCheque +
                ", montoCierreTarjeta=" + montoCierreTarjeta +
                '}';
    }
}
