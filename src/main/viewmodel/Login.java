package main.viewmodel;

import org.uqbar.commons.utils.Observable;

import com.sun.jersey.api.client.ClientResponse;

import main.model.RequestService;

@Observable
public class Login {

	private String token;
	private static String token_validado;

	public boolean isValidToken() {
		
		if (token.equalsIgnoreCase(" ") || token == null) {
			
		}
		
		boolean ok = false;
		RequestService request = new RequestService();
		ClientResponse res = request.getStudent(token);

		if (res.getStatus() != 200) {
			throw new RuntimeException("Falló la conexion con Token : Codigo de error HTTP: " + res.getStatus());
		}
		
		Login.token_validado = this.token;
		ok = true;
		return ok;
	}

	public static String getToken_validado() {
		return token_validado;
	}

	public static void setToken_validado(String token_validado) {
		Login.token_validado = token_validado;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}