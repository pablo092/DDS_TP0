package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import main.modelo.RequestService;

public class Test_Lector_Notas {

	RequestService requester;

    @Before
    public void setUp() throws Exception {
        this.requester = new RequestService();
    }

    @Test
    public void testObtenerAlumno() throws Exception {
        ClientResponse response = this.requester.getStudent("9706434526");
        assertEquals(response.getStatus(), 200);
        String json = response.getEntity(String.class);
        assertTrue(json.contains("items"));
        assertTrue(json.contains("Tio Tom"));
    }
    
    @Test
    public void testObtenerTareas() throws Exception {
    	ClientResponse response = this.requester.getAssignments("9706434526");
        assertEquals(response.getStatus(), 200);
        String json = response.getEntity(String.class);
        assertTrue(json.contains("items"));
        assertTrue(json.contains("Tio Tom"));
    }

    @Test
    public void testObtenerAlumnoConError() throws Exception {
    	ClientResponse response = this.requester.getStudent("9706434526");
        assertNotEquals(response.getStatus(), 200);
        String json = response.getEntity(String.class);
        assertTrue(json.contains("invalidParameter"));
    }
    
    @Test
    public void testObtenerTareasConError() throws Exception {
    	ClientResponse response = this.requester.getAssignments("9706434526");
        assertNotEquals(response.getStatus(), 200);
        String json = response.getEntity(String.class);
        assertTrue(json.contains("invalidParameter"));
    }

    @Test
    public void testActualizarAlumno() throws Exception {
    	ClientResponse response = this.requester.putStudent("9706434526");
        assertEquals(response.getStatus(),412);
        String json = response.getEntity(String.class);
        assertTrue(json.contains("Precondition Failed"));
        assertTrue(json.contains("If-Match"));
    }

}
