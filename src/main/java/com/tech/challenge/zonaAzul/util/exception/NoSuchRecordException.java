package com.tech.challenge.zonaAzul.util.exception;

public class NoSuchRecordException extends RuntimeException {

    NoSuchRecordException(){
        super("Registro nao encontrado");
    }

    public NoSuchRecordException(String message){
        super(message);
    }

    public NoSuchRecordException(Object record){
        super("Registro nao encontrado: " + record.toString());
    }

    public NoSuchRecordException(String message, Object record){
        super("message " + record.toString());
    }
}
