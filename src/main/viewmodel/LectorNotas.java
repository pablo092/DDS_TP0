package main.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Asignacion;
import main.model.Nota;

public class LectorNotas {
	
	private static List<Asignacion> asignaciones = new ArrayList<>();
	private static List<Nota> notas = new ArrayList<>();
	
	public LectorNotas() {		
//		ClientResponse res = Login.getRequest().getAssignments(Login.getToken_validado());
//		Gson gson = new Gson();
//		String json = null;
//		
//		json = res.getEntity(String.class);
//		asignaciones = gson.fromJson(json, new TypeToken<List<Asignacion>>(){}.getType());
	}

	public static List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public static void setAsignaciones(List<Asignacion> asignaciones) {
		LectorNotas.asignaciones = asignaciones;
	}
	
	public static List<Nota> getNotas() {
		return notas;
	}
	
	public static void setNotas(ArrayList<Nota> notas) {
		LectorNotas.notas = notas;
	}
}
