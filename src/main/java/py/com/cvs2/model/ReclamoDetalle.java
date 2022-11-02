package py.com.cvs2.model;

import javax.persistence.*;

@Entity
@Table(name = "reclamo_detalle")
public class ReclamoDetalle {

    private static final long serialVersionUID = -6533574310851771145L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "id_entrega_equipo_detalle", referencedColumnName = "id")
    private EntregaEquipoDetalle entregaEquipoDetalle;

    @OneToOne
    @JoinColumn(name = "id_reclamo_detalle", referencedColumnName = "id")
    private ReclamoDetalle reclamoDetalle;

    public ReclamoDetalle() {
    }

    public ReclamoDetalle(int id, String estado, EntregaEquipoDetalle entregaEquipoDetalle) {
        this.id = id;
        this.estado = estado;
        this.entregaEquipoDetalle = entregaEquipoDetalle;
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

    public EntregaEquipoDetalle getEntregaEquipoDetalle() {
        return entregaEquipoDetalle;
    }

    public void setEntregaEquipoDetalle(EntregaEquipoDetalle entregaEquipoDetalle) {
        this.entregaEquipoDetalle = entregaEquipoDetalle;
    }

    @Override
    public String toString() {
        return "EntregaEquipoDetalle{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", entregaEquipoDetalle=" + entregaEquipoDetalle +
                '}';
    }
}