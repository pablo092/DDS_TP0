package main.model;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import com.google.gson.annotations.SerializedName;

@Transactional
@Observable
public class Nota {
	
	@SerializedName(value = "id")
	private int id;
	@SerializedName(value = "value")
	private String calificacion;
	@SerializedName(value = "created_at")
	private String fecha_creacion;
	@SerializedName(value = "updated_at")
	private String fecha_modificacion;
	
	public Nota(int id, String calificacion, String fecha_creacion, String fecha_modificacion) {
		this.id = id;
		this.calificacion = calificacion;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}
	
	public boolean estaAprobado() {
		try {
			return Integer.parseInt(calificacion) > 4;
		} catch (NumberFormatException e){
			return !calificacion.contentEquals("M");
		}
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

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", calificacion=" + calificacion + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_modificacion=" + fecha_modificacion + "]";
	}
}