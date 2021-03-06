package main.model;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class RequestService {
    private Client client;
    private static final String API_NOTAS = "http://notitas.herokuapp.com";
    private static final String RESOURCE_STUDENT = "student";
    private static final String RESOURCE_ASSIGNMENTS = "assignments";
    
    private static final String AUTH_KEY = "Authorization";
    
    private static final String PREFIJO = "Bearer ";
//    private static final String TOKEN_PRUEBA = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    public RequestService() {
        this.client = Client.create();
    }

    public ClientResponse getStudent(String token){    	
    	ClientResponse response = this.client
    							  .resource(API_NOTAS)
    							  .path(RESOURCE_STUDENT)
    							  .header(AUTH_KEY, PREFIJO + token)
    							  .accept(MediaType.APPLICATION_JSON)
    							  .get(ClientResponse.class);
        return response;
    }

    public ClientResponse getAssignments(String token){
        ClientResponse response = this.client
        						  .resource(API_NOTAS)
        						  .path(RESOURCE_STUDENT)
        						  .path(RESOURCE_ASSIGNMENTS)
        						  .header(AUTH_KEY, PREFIJO + token)
        						  .accept(MediaType.APPLICATION_JSON)
        						  .get(ClientResponse.class);
        return response;
    }
    
    public ClientResponse putStudent(String estudiante, String token){
        ClientResponse response = this.client
        						  .resource(API_NOTAS)
        						  .path(RESOURCE_STUDENT)
        						  .header(AUTH_KEY, PREFIJO + token)
        						  .accept(MediaType.APPLICATION_JSON)
        						  .put(ClientResponse.class, estudiante);
        return response;
    }
}