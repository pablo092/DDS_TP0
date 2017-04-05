package main.viewmodel;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.uqbar.commons.utils.Observable;

import com.sun.jersey.api.client.ClientResponse;

import main.model.Asignacion;
import main.model.Nota;
import main.model.RequestService;

@Observable
public class ConsultarDatos {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private String titulo;
	private String descripcion;
	private String calificacion;
	private String fechaCreacion;
	private String fechaModificacion;
	private ArrayList<Asignacion> assignments;
	private ArrayList<Nota> grades;
	
	public ConsultarDatos() {
		RequestService request = new RequestService();
		ClientResponse res = null;
		JSONObject obj = null;
		String json = null;
		
		res = request.getStudent(Login.getToken_validado());
		json = res.getEntity(String.class);
		
		try {
			obj = new JSONObject(json);
			
			code = obj.getString("code");
			first_name = obj.getString("first_name");
			last_name = obj.getString("last_name");
			github_user = obj.getString("github_user");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		res = request.getAssignments(Login.getToken_validado());
		json = res.getEntity(String.class);
		
		try {
			obj = new JSONObject(json);
			
			titulo = obj.getString("title");
			descripcion = obj.getString("description");
			calificacion = obj.getString("value");
			fechaCreacion = obj.getString("created_at");
			fechaModificacion = obj.getString("updated_at");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGithub_user() {
		return github_user;
	}

	public void setGithub_user(String github_user) {
		this.github_user = github_user;
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

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ArrayList<Asignacion> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Asignacion> assignments) {
		this.assignments = assignments;
	}

	public ArrayList<Nota> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Nota> grades) {
		this.grades = grades;
	}
}
