package py.com.cvs2.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4916959025046531907L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id")
	private Rol rol;

	@Column(name = "estado")
	private String estado;

	public UsuarioRol() {
	}

	public UsuarioRol(Usuario usuario, Rol rol) {
		this.id = 0;
		this.usuario = usuario;
		this.rol = rol;
		this.estado = "ACTIVO";
	}

	public UsuarioRol(int id, Usuario usuario, Rol rol) {
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "UsuarioRol [id=" + id + ", usuario=" + usuario + ", rol=" + rol + "]";
	}

}
