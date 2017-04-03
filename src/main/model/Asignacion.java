package main.model;

import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

@Transactional
@Observable
public class Asignacion {
	
	private int id;
	private String titulo;
	private String descripcion;
	private ArrayList<Nota> notas;
	
	public Asignacion(int id, String titulo, String descripcion, ArrayList<Nota> notas) {
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

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", notas=" + notas + "]";
	}
}