package main.modelo;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/* 
 * Para el ejemplo se usara el siguiente recurso
 *http://notitas.herokuapp.com/student/?q=isbn:9706434526&fields=totalItems,items(id,volumeInfo(title,publishedDate))
 */

public class RequestService {
    private Client client;
    private static final String API_NOTAS = "http://notitas.herokuapp.com";
    private static final String RESOURCE_STUDENT = "student";
    private static final String RESOURCE_ASSIGMENTS = "assignments";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
    }

    //Prueba de concepto de un parametro y los mensajes por separado para identificar los tipos de datos.
    public ClientResponse getBookByFilter(String filter, String value){
    	WebResource recurso = this.client.resource(API_NOTAS).path(RESOURCE_STUDENT);
    	WebResource recursoConParametros = recurso.queryParam("q",filter + ":" + value);
    	WebResource.Builder builder = recursoConParametros.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        return response;
    }

    //Prueba de concepto de envio de dos parametros, y el envio de mensajes juntos.
    public ClientResponse getBookByFilter(String filter, String value, String fields){
        ClientResponse response = this.client.resource(API_NOTAS).path(RESOURCE_STUDENT)
                .queryParam("q",filter + ":" + value).queryParam("fields",fields)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        return response;
    }

    //Prueba de concepto del envio de un request con un header.
    public ClientResponse getBookAndSendHeader(String filter, String value, String header, String headerValue){
        ClientResponse response = this.client.resource(API_NOTAS).path(RESOURCE_STUDENT)
                .queryParam("q",filter + ":" + value).header(header, headerValue)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        return response;
    }
}