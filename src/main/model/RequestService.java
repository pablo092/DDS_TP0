package main.model;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/* 
 * Para el ejemplo se usara el siguiente recurso
 *http://notitas.herokuapp.com/student/?q=
 */

public class RequestService {
    private Client client;
    private static final String API_NOTAS = "http://notitas.herokuapp.com";
    private static final String RESOURCE_STUDENT = "student";
    private static final String RESOURCE_ASSIGMENTS = "assignments";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
    }

    public ClientResponse getStudent(String value){    	
    	ClientResponse response = this.client
    							  .resource(API_NOTAS)
    							  .path(RESOURCE_STUDENT)
    							  .header("Authorization",TOKEN)
    							  .accept(MediaType.APPLICATION_JSON)
    							  .get(ClientResponse.class);
        return response;
    }

    public ClientResponse getAssignments(String value){
        ClientResponse response = this.client
        						  .resource(API_NOTAS)
        						  .path(RESOURCE_STUDENT)
        						  .path(RESOURCE_ASSIGMENTS)
        						  .accept(MediaType.APPLICATION_JSON)
        						  .get(ClientResponse.class);
        return response;
    }
    
    public ClientResponse putStudent(String value){
        ClientResponse response = this.client
        						  .resource(API_NOTAS)
        						  .path(RESOURCE_STUDENT)
        						  .path(RESOURCE_ASSIGMENTS)
        						  .accept(MediaType.APPLICATION_JSON)
        						  .get(ClientResponse.class);
        return response;
    }
    
//	##########ESTO ESTA DE EJEMPLO PARA TERMIANR LOS OTROS MÉTODOS###################
//    public ClientResponse getBookAndSendHeader(String filter, String value, String header, String headerValue){
//        ClientResponse response = this.client.resource(API_NOTAS).path(RESOURCE_STUDENT)
//                .queryParam("q",filter + ":" + value).header(header, headerValue)
//                .accept(MediaType.APPLICATION_JSON)
//                .get(ClientResponse.class);
//        return response;
//    }
}