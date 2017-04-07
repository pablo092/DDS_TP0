package main.viewmodel;

import org.uqbar.commons.utils.Observable;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Estudiante;
import main.model.RequestService;
import main.view.LoginView;
import main.view.VentanaErroresView;

@Observable
public class Login {

	private String token = "";
	
	private static Estudiante estudiante;
	private static String token_validado;
	private static RequestService request = new RequestService();

	public boolean isValidToken(LoginView oLoginView) {		
		
		Gson gson = new Gson();
		String json = null;
		boolean ok = false;
		
		if (token.equalsIgnoreCase("") || token == null) {
			new VentanaErroresView(oLoginView, "Debe ingresar un token").open();
			return ok;
		}

		try {
			ClientResponse res = request.getStudent(token.trim());
			
			if (res.getStatus() == 200) {
				json = res.getEntity(String.class);
				estudiante = gson.fromJson(json, Estudiante.class);
				
				Login.token_validado = this.token.trim();
				new VentanaErroresView(oLoginView, "Se ha loggeado correctamente!!").open();
				oLoginView.close();
				ok = true;
			} else {
				new VentanaErroresView(oLoginView, "El token no es válido").open();
			}
			
		} catch (Exception e) {
			new VentanaErroresView(oLoginView, "No se pudo establecer conexión \n" + e.getMessage()).open();
		}
		return ok;
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