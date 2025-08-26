package com.certifai.CertifAI.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User ID " + id + "not found");
    }
}
