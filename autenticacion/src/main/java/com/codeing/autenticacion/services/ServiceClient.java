package com.codeing.autenticacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClient implements IServiceClient{

    private final RestTemplate restTemplate;
    public String urlBase = "";

    @Autowired
    private ServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Método para manejar errores al hacer la solicitud
    private <T> T executeRequest(RequestExecutor<T> executor){
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

    @Override
    public <T> T callGetService(String endpoint, Class<T> responseType) {
        String url = urlBase + endpoint;

        return executeRequest(() ->
           restTemplate.getForEntity(url, responseType)
        );
    }

    @Override
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
    private static class RestClientException extends RuntimeException{
        public RestClientException(String message, Throwable cause){
            super(message, cause);
        }

    }
}