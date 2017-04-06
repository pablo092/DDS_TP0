package main.viewmodel;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Estudiante;
import main.model.RequestService;

@Observable
public class Login {

	private String token;
	
	private static Estudiante estudiante;
	private static String token_validado;
	private static RequestService request = new RequestService();

	public boolean isValidToken() {
		
		if (token.equalsIgnoreCase(" ") || token == null) {
//			MOSTRAR MENSAJE QUE ESTA VACIO
		}
		
		ClientResponse res = request.getStudent(token.trim());
		Gson gson = new Gson();
		String json = null;

		if (res.getStatus() == 200) {
			json = res.getEntity(String.class);
			estudiante = gson.fromJson(json, Estudiante.class);
			
			Login.token_validado = this.token.trim();
			//MUESTRO QUE INICIE TODO Ok
			return true;
			
		}
		//MUESTRO QUE OCURRIO UN ERROR
		return false;
	}

	public static String getToken_validado() {
		return token_validado;
	}

	public static void setToken_validado(String token_validado) {
		Login.token_validado = token_validado;
	}
	
	public static Estudiante getEstudiante() {
		return estudiante;
	}

	public static void setEstudiante(Estudiante estudiante) {
		Login.estudiante = estudiante;
	}

	public static RequestService getRequest() {
		return request;
	}

	public static void setRequest(RequestService request) {
		Login.request = request;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}