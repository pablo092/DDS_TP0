package main.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Asignacion;
import main.model.Nota;

public class LectorNotas {
	
	private static List<Asignacion> asignaciones;
	
	public LectorNotas() {
		asignaciones = new ArrayList<>();
		ClientResponse res = Login.getRequest().getAssignments(Login.getToken_validado());
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray jArrayAssign = null;
		JsonArray jArrayGrade = null;
		String jsonTareas = null;
		
		jsonTareas = res.getEntity(String.class);
		/*Recupero en un array el json de asignaciones*/
		jArrayAssign = (JsonArray) parser.parse(jsonTareas).getAsJsonObject().get("assignments");
		/*Por cada asignacion del array itero*/
		for (JsonElement asignJson : jArrayAssign) {
			
			List<Nota> notas = new ArrayList<>();
			/*Recupero en un array el json de notas del elemento asignJson*/
			jArrayGrade = (JsonArray) parser.parse(asignJson.getAsJsonObject().toString()).getAsJsonObject().get("grades");
			for(JsonElement gradeJson : jArrayGrade) {
				Nota nota = gson.fromJson(gradeJson, Nota.class);
				notas.add(nota);
			}
			
            Asignacion asign = gson.fromJson(asignJson, Asignacion.class);
            /*Setteo las notas a la asignacion*/
            asign.setNotas(notas);
            asignaciones.add(asign);
        }
	}

	public static List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public static void setAsignaciones(List<Asignacion> asignaciones) {
		LectorNotas.asignaciones = asignaciones;
	}
}
