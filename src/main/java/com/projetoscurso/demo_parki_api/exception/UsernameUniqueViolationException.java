package com.projetoscurso.demo_parki_api.exception;

public class UsernameUniqueViolationException extends RuntimeException {

    public UsernameUniqueViolationException(String message) {
        super(message);
    }
}
