package py.com.cvs2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -418054006327426686L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "serie")
	private String serie;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "modelo")
	private String modelo;

	@OneToOne
	@JoinColumn(name = "id_marca", referencedColumnName = "id")
	private Marca marca;

	public Equipo() {
	}

	public Equipo(int id, String serie, String descripcion, String modelo, Marca marca) {
		this.id = id;
		this.serie = serie;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", serie=" + serie + ", descripcion=" + descripcion + ", modelo=" + modelo
				+ ", marca=" + marca + "]";
	}

}
