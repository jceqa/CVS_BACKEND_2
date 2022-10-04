package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "existencia")
    private Integer existencia;

    @OneToOne
    @JoinColumn(name = "id_articulo", referencedColumnName = "id")
    private Articulo articulo;

    @OneToOne
    @JoinColumn(name = "id_deposito", referencedColumnName = "id")
    private Deposito deposito;

    public Stock() {
    }

    public Stock(int id, Integer existencia, Articulo articulo, Deposito deposito) {
        this.id = id;
        this.existencia = existencia;
        this.articulo = articulo;
        this.deposito = deposito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", existencia=" + existencia +
                ", articulo=" + articulo +
                ", deposito=" + deposito +
                '}';
    }
}