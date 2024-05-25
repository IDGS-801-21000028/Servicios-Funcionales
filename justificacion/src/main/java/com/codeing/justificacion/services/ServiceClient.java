package com.codeing.justificacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClient {

    private final RestTemplate restTemplate;

    public String urlBase = "";

    @Autowired
    public ServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Método para manejar errores al hacer la solicitud
    public <T> T executeRequest(RequestExecutor<T> executor){
        try{
            ResponseEntity<T> responseEntity = executor.execute();
            return responseEntity.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e){
            String error = "Error HTTP: " + e.getStatusCode();
            throw new RestClientException(error, e);
        } catch (ResourceAccessException e){
            String error = "Error de acceso a recursos: " + e.getMessage();
            throw new RestClientException(error, e);
        } catch (Exception e){
            String error = "Error inesperado: " + e.getMessage();
            throw new RestClientException(error, e);
        }
    }

    //Método para llamar a otro servicio mediante solicitud GET
    public <T> T callGetService(String endpoint, Class<T> responseType) {
        String url = urlBase + endpoint;

        return executeRequest(() ->
           restTemplate.getForEntity(url, responseType)
        );
    }

    //Método para llamar a otro servicio mediante solicitud POST
    public <T> T callPostService(String endpoint, Object request, Class<T> responseType) {
        String url = urlBase + endpoint;

        return executeRequest(() ->
            restTemplate.postForEntity(url, request, responseType)
        );
    }

    @FunctionalInterface
    private interface RequestExecutor<T> {
        ResponseEntity<T> execute();
    }

    //Menejador de errores
    public static class RestClientException extends RuntimeException{

        public RestClientException(String message, Throwable cause){
            super(message, cause);
        }

    }
}