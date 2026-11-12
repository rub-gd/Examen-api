package com.examen.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examen.api.dtos.ProductoRequestDto;
import com.examen.api.dtos.ProductoResponseDto;
import com.examen.api.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	private final ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProductoResponseDto>> listarTodosLosProductos(){
		return ResponseEntity.ok(productoService.listarTodosLosProductos());
	}
	
	@PostMapping
	public ResponseEntity<ProductoResponseDto> crearProducto(ProductoRequestDto creacion){
		return ResponseEntity.ok(productoService.crearProducto(creacion));
	}
	
	@PutMapping("/código sku/{codigo_sku}")
	public ResponseEntity<ProductoResponseDto> modificarProductoPorCodigo_sku(String codigo_sku, ProductoRequestDto datos_actualizados){
		return ResponseEntity.ok(productoService.modificarProductoPorCodigo_sku(codigo_sku, datos_actualizados));
	}
	
	@DeleteMapping("/código sku/{codigo_sku}")
	public ResponseEntity<Void> eliminarProductoPorCodigo_sku(String codigo_sku){
		productoService.eliminarProductoPorCodigo_sku(codigo_sku);
			return ResponseEntity.noContent().build();
	}
}
