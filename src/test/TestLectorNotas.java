package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

import main.model.Estudiante;
import main.model.RequestService;

/*
 * Al realiza las consultas al WS con el token dado de prueba, se obtienen como respuestas del metodo GET
 * 
 * {
	  "code": "111222333",
	  "first_name": "Leandro",
	  "last_name": "Bulgarelli",
	  "github_user": "flbulgarelli"
	}

	{
	  "assignments": [
	    {
	      "id": 1,
	      "title": "TPA1",
	      "description": "Entrega 1 del TP Anual",
	      "grades": []
	    },
	    {
	      "id": 2,
	      "title": "TPA2",
	      "description": "Entrega 2 del TP Anual",
	      "grades": []
	    }
	  ]
	}
 * que son los resultados que se pusieron como test unitarios y dan como OK
 * */

public class TestLectorNotas {

	RequestService requester;
	String json;

    @Before
    public void setUp() throws Exception {
        this.requester = new RequestService();
        this.json = new String();
    }

    @Test
    public void testObtenerEstudiante() throws Exception {
        ClientResponse response = this.requester.getStudent();
        json = response.getEntity(String.class);
        assertTrue(json.contains("code"));
        assertTrue(json.contains("111222333"));
    }
    
    @Test
    public void testObtenerAsignaciones() throws Exception {
    	ClientResponse response = this.requester.getAssignments();
        json = response.getEntity(String.class);
        assertTrue(json.contains("title"));
        assertTrue(json.contains("TPA1"));
    }

    @Test
    public void testActualizarEstudainte() throws Exception {
    	Gson gson = new Gson();
    	Estudiante estudiante = new Estudiante("Pedro", "Fulano", "pfulano23", "1214731", null);
    	json = gson.toJson(estudiante);	
    	ClientResponse response = this.requester.putStudent(json);
        assertEquals(response.getStatus(),201);
    }
}
