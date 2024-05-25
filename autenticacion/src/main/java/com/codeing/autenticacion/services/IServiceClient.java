package com.codeing.autenticacion.services;

public interface IServiceClient {

    //Método para llamar a otro servicio mediante solicitud GET
    <T> T callGetService(String endpoint, Class<T> responseType);

    //Método para llamar a otro servicio mediante solicitud POST
    <T> T callPostService(String endpoint, Object request, Class<T> responseType);
}
