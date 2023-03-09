package com.api_flexpag.payment.services;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
