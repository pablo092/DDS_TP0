package main.viewmodel;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Estudiante;
import main.view.CargarDatosView;
import main.view.VentanaErroresView;

@Observable
public class CargarDatos{
	
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	
	public CargarDatos() {
		code = Login.getEstudiante().getLegajo();
		first_name = Login.getEstudiante().getNombre();
		last_name = Login.getEstudiante().getApellido();
		github_user = Login.getEstudiante().getGitUser();
	}
	
	public void cargarDatosEstudiante(CargarDatosView oCargarDatosView) {
		ClientResponse res = null;
		Gson gson = new Gson();
		
		Estudiante estudiante = new Estudiante(first_name, last_name, github_user, code);
		
		String json = gson.toJson(estudiante);		
		res = Login.getRequest().putStudent(json, Login.getToken_validado());
		
		if(res.getStatus() == 201) {
			new VentanaErroresView(oCargarDatosView, "Se ha actualizado correctamente!!").open();
			oCargarDatosView.close();
		} else {
			new VentanaErroresView(oCargarDatosView, "No se ha podido actualizar").open();
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
}
