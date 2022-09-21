package com.blogapp.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{

    public String resourceName;
    public String fieldName;
    public Long fieldValue;
    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue){
        super(String.format("%s not found with %s : %l",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
