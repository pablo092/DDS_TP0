package main.model;

import java.util.List;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import com.google.gson.annotations.SerializedName;

@Transactional
@Observable
public class Estudiante {

	@SerializedName(value = "first_name")
	private String nombre;
	@SerializedName(value = "last_name")
	private String apellido;
	@SerializedName(value = "github_user")
	private String gitUser;
	@SerializedName(value = "code")
	private String legajo;
	@SerializedName(value = "assignments")
	private List<Asignacion> asignaciones;

	public Estudiante(String nombre, String apellido, String gitUser, String legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.gitUser = gitUser;
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGitUser() {
		return gitUser;
	}

	public void setGitUser(String gitUser) {
		this.gitUser = gitUser;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", gitUser=" + gitUser + ", legajo=" + legajo
				+ ", asignaciones=" + asignaciones + "]";
	}
}
