package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formulario")
public class Formulario implements Serializable {

	private static final long serialVersionUID = -6533574310851771145L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "url")
	private String url;

	@OneToOne
	@JoinColumn(name = "id_sistema", referencedColumnName = "id")
	private Sistema sistema;

	@OneToOne
	@JoinColumn(name = "id_sub_menu", referencedColumnName = "id")
	private SubMenu subMenu;

	@Column(name = "estado")
	String estado;

	public Formulario() {
	}

	public Formulario(int id, String nombre, String url, Sistema sistema, SubMenu subMenu) {
		this.id = id;
		this.nombre = nombre;
		this.url = url;
		this.sistema = sistema;
		this.subMenu = subMenu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public SubMenu getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(SubMenu subMenu) {
		this.subMenu = subMenu;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Formulario [id=" + id + ", nombre=" + nombre + ", url=" + url + ", sistema=" + sistema + ", subMenu="
				+ subMenu + "]";
	}

}
