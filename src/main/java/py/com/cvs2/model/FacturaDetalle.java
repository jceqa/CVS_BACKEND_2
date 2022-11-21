package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factura_detalle")
public class FacturaDetalle implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private Long monto;

    @OneToOne
    @JoinColumn(name = "id_pedido_venta_detalle", referencedColumnName = "id")
    private PedidoVentaDetalle pedidoVentaDetalle;

    @OneToOne
    @JoinColumn(name = "id_oreden_servicio_detalle", referencedColumnName = "id")
    private OrdenServicioDetalle ordenServicioDetalle;

    public FacturaDetalle() {
    }

    public FacturaDetalle(int id, String estado, Long monto, PedidoVentaDetalle pedidoVentaDetalle, OrdenServicioDetalle ordenServicioDetalle) {
        this.id = id;
        this.estado = estado;
        this.monto = monto;
        this.pedidoVentaDetalle = pedidoVentaDetalle;
        this.ordenServicioDetalle = ordenServicioDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public PedidoVentaDetalle getPedidoVentaDetalle() {
        return pedidoVentaDetalle;
    }

    public void setPedidoVentaDetalle(PedidoVentaDetalle pedidoVentaDetalle) {
        this.pedidoVentaDetalle = pedidoVentaDetalle;
    }

    public OrdenServicioDetalle getOrdenServicioDetalle() {
        return ordenServicioDetalle;
    }

    public void setOrdenServicioDetalle(OrdenServicioDetalle ordenServicioDetalle) {
        this.ordenServicioDetalle = ordenServicioDetalle;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", monto=" + monto +
                ", pedidoVentaDetalle=" + pedidoVentaDetalle +
                ", ordenServicioDetalle=" + ordenServicioDetalle +
                '}';
    }
}
