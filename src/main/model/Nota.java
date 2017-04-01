package main.model;

import java.util.Date;

public class Nota {
	
	private int id;
	private String calificacion;
	private Date fecha_creacion;
	private Date fecha_modificacion;
	
	public Nota(int id, String calificacion, Date fecha_creacion, Date fecha_modificacion) {
		super();
		this.id = id;
		this.calificacion = calificacion;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", calificacion=" + calificacion + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_modificacion=" + fecha_modificacion + "]";
	}
}