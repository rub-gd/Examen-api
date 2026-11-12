package com.examen.api.dtos;

import java.time.LocalDate;

public record ProductoResponseDto(
	Integer id_product,
	String codigo_sku,
	String nombre,
	String descripcion,
	Integer precio,
	Integer stock,
	LocalDate fecha_alta
) {}
