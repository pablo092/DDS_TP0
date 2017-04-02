package main.viewmodel;

import java.util.ArrayList;

import main.model.Asignacion;
import main.model.Nota;

public class ConsultarDatos {
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private ArrayList<Asignacion> assignments;
	private ArrayList<Nota> grades;
	
	public void consultarDatosEstudiante() {
		
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
