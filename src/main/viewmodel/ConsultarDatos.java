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
	
	private String code = new String();
	private String first_name = new String();
	private String last_name = new String();
	private String github_user = new String();
	private ArrayList<Asignacion> assignments;
	private ArrayList<Nota> grades;
	
	public ConsultarDatos() {
		RequestService request = new RequestService();
		ClientResponse res = null;
		JSONObject obj = null;
		res = request.getStudent(Login.getToken_validado());

		String json = res.getEntity(String.class);
		
		
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
