package main.viewmodel;

import com.google.gson.Gson;

import main.model.Estudiante;
import main.model.RequestService;

public class CargarDatos {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	public void cargarDatosEstudiante() {
		RequestService request = new RequestService();
		Gson gson = new Gson();
		
		Estudiante estudiante = new Estudiante(first_name, last_name, github_user, code, null);
		
		String json = gson.toJson(estudiante);		
		request.putStudent(json);		
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
}
