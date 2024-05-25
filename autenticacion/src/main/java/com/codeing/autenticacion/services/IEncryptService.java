package com.codeing.autenticacion.services;

public interface IEncryptService {

    String encryptPassword(String password);

    boolean verifyPassword(String originalPassword, String hashPassword);

}
