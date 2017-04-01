package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import main.model.Asignacion;
import main.model.Estudiante;
import main.model.RequestService;

public class TestLectorNotas {

	RequestService requester;

    @Before
    public void setUp() throws Exception {
        this.requester = new RequestService();
    }

    @Test
    public void testObtenerEstudiante() throws Exception {
        ClientResponse response = this.requester.getStudent();
        assertEquals(response.getStatus(), 200);
        String json = response.getEntity(Estudiante.class).toString();
        assertTrue(json.contains("code"));
        assertTrue(json.contains("111222333"));
    }
    
    @Test
    public void testObtenerAsignaciones() throws Exception {
    	ClientResponse response = this.requester.getAssignments();
        assertEquals(response.getStatus(), 200);
        String json = response.getEntity(Asignacion.class).toString();
        assertTrue(json.contains("title"));
        assertTrue(json.contains("TPA1"));
    }

    @Test
    public void testActualizarEstudainte() throws Exception {
    	ClientResponse response = this.requester.putStudent();
        assertEquals(response.getStatus(),201);
    }
}
