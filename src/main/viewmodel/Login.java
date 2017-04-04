package main.viewmodel;

import org.uqbar.commons.utils.Observable;

@Observable
public class Login {
	private String token;
	
	public void loginToken(){
		
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
