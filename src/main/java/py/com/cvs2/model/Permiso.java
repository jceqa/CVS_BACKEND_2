package py.com.cvs2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permiso")
public class Permiso implements Serializable {

	private static final long serialVersionUID = -6533574310851771145L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id")
	private Rol rol;

	@OneToOne
	@JoinColumn(name = "id_formulario", referencedColumnName = "id")
	private Formulario formulario;

	@Column(name = "agregar")
	private boolean agregar;

	@Column(name = "modificar")
	private boolean modificar;

	@Column(name = "eliminar")
	private boolean eliminar;

	@Column(name = "consultar")
	private boolean consultar;

	@Column(name = "listar")
	private boolean listar;

	@Column(name = "informe")
	private boolean informe;

	@Column(name = "exportar")
	private boolean exportar;

	@Column(name = "reactivar")
	private boolean reactivar;

	@Column(name = "anular")
	private boolean anular;

	@Column(name = "estado")
	String estado;

	public Permiso() {
	}

	public Permiso(Rol rol, Formulario formulario){
		this.id = 0;
		this.rol = rol;
		this.formulario = formulario;
		this.agregar = true;
		this.modificar = true;
		this.eliminar = true;
		this.consultar = true;
		this.listar = true;
		this.informe = true;
		this.exportar = true;
		this.reactivar = true;
		this.anular = true;
		this.estado = "ACTIVO";
	}

	public Permiso(int id, Rol rol, Formulario formulario, boolean agregar, boolean modificar, boolean eliminar,
			boolean consultar, boolean listar, boolean informe, boolean exportar) {
		this.id = id;
		this.rol = rol;
		this.formulario = formulario;
		this.agregar = agregar;
		this.modificar = modificar;
		this.eliminar = eliminar;
		this.consultar = consultar;
		this.listar = listar;
		this.informe = informe;
		this.exportar = exportar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public boolean isAgregar() {
		return agregar;
	}

	public void setAgregar(boolean agregar) {
		this.agregar = agregar;
	}

	public boolean isModificar() {
		return modificar;
	}

	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public boolean isConsultar() {
		return consultar;
	}

	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}

	public boolean isListar() {
		return listar;
	}

	public void setListar(boolean listar) {
		this.listar = listar;
	}

	public boolean isInforme() {
		return informe;
	}

	public void setInforme(boolean informe) {
		this.informe = informe;
	}

	public boolean isExportar() {
		return exportar;
	}

	public void setExportar(boolean exportar) {
		this.exportar = exportar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isReactivar() {
		return reactivar;
	}

	public void setReactivar(boolean reactivar) {
		this.reactivar = reactivar;
	}

	public boolean isAnular() {
		return anular;
	}

	public void setAnular(boolean anular) {
		this.anular = anular;
	}

	@Override
	public String toString() {
		return "Permiso [id=" + id + ", rol=" + rol + ", formulario=" + formulario + ", agregar=" + agregar
				+ ", modificar=" + modificar + ", eliminar=" + eliminar + ", consultar=" + consultar + ", listar="
				+ listar + ", informe=" + informe + ", exportar=" + exportar + "]";
	}

}
