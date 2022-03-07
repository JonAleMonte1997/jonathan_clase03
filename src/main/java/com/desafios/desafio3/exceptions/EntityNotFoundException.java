package com.desafios.desafio3.exceptions;

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException() {
        super("No se encontro la entidad");
    }
}
