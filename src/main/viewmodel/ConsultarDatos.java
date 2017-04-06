package main.viewmodel;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import main.model.Asignacion;

@Observable
public class ConsultarDatos {

	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private List<Asignacion> assignments;

	public ConsultarDatos() {
		code = Login.getEstudiante().getLegajo();
		first_name = Login.getEstudiante().getNombre();
		last_name = Login.getEstudiante().getApellido();
		github_user = Login.getEstudiante().getGitUser();
		assignments = LectorNotas.getAsignaciones();
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

	public List<Asignacion> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Asignacion> assignments) {
		this.assignments = assignments;
	}
}
