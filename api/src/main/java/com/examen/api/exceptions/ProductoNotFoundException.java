package com.examen.api.exceptions;

public class ProductoNotFoundException extends RuntimeException {
	public ProductoNotFoundException(String mensaje) {
		super(mensaje);
	}
}
