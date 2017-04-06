package main.model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
public class Asignacion {
	
	@SerializedName(value = "id")
	private int id;
	@SerializedName(value = "title")
	private String titulo;
	@SerializedName(value = "description")
	private String descripcion;
	@SerializedName(value = "grades")
	private List<Nota> notas;
	
	public Asignacion(int id, String titulo, String descripcion, List<Nota> notas) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.notas = notas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", notas=" + notas + "]";
	}
}