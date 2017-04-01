package main.modelo;

import java.util.List;

public abstract class Tarea {
	
	private int id;
	private String titulo;
	private String descripcion;
	private List<Nota> notas;
	
	public Tarea(int id, String titulo, String descripcion, List<Nota> notas) {
		super();
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