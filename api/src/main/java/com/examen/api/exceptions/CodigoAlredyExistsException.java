package com.examen.api.exceptions;

public class CodigoAlredyExistsException extends RuntimeException {
	public CodigoAlredyExistsException(String mensaje) {
		super(mensaje);
	}
}