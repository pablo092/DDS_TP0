package main.viewmodel;

import org.json.JSONException;
import org.json.JSONObject;
import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Estudiante;
import main.model.RequestService;

@Observable
public class CargarDatos{
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	public CargarDatos() {
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
		
	}
	
	public void cargarDatosEstudiante() {
		RequestService request = new RequestService();
		Gson gson = new Gson();
		
		Estudiante estudiante = new Estudiante(first_name, last_name, github_user, code);
		
		String json = gson.toJson(estudiante);		
		request.putStudent(json, Login.getToken_validado());		
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
