package com.examen.api.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.api.dtos.ProductoRequestDto;
import com.examen.api.dtos.ProductoResponseDto;
import com.examen.api.entities.Producto;
import com.examen.api.exceptions.CodigoAlredyExistsException;
import com.examen.api.exceptions.ProductoNotFoundException;
import com.examen.api.repositories.ProductoRepository;
import com.examen.api.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	private ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductoResponseDto> listarTodosLosProductos() {
		return productoRepository.findAll().stream().map(this::convertirProductoCogido).toList();
	}

	@Override
	@Transactional
	public ProductoResponseDto crearProducto(ProductoRequestDto creacion) {
		Producto nuevoProducto = new Producto();
			if (productoRepository.existsByCodigoSku(creacion.codigo_sku())) {
				throw new CodigoAlredyExistsException("Ya existe un alumno registrado con este código.");
			}
			else {
					nuevoProducto.setCodigoSku(creacion.codigo_sku());
					nuevoProducto.setNombre(creacion.nombre());
					nuevoProducto.setDescripcion(creacion.descripcion());
					nuevoProducto.setPrecio(creacion.precio());
					nuevoProducto.setStock(creacion.stock());
					nuevoProducto.setFecha_alta(creacion.fecha_alta());
						productoRepository.save(nuevoProducto);
							return convertirProductoCogido(nuevoProducto);
			}
	}

	@Override
	@Transactional
	public ProductoResponseDto modificarProductoPorCodigo_sku(String codigo_sku, ProductoRequestDto datos_actualizados) {
		Producto productoEncontrado = productoRepository.findByCodigoSku(codigo_sku).orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado."));
			if (productoRepository.existsByCodigoSku(datos_actualizados.codigo_sku())) {
					throw new CodigoAlredyExistsException("Ya existe un alumno registrado con este código.");
			}
			else {
				productoEncontrado.setCodigoSku(datos_actualizados.codigo_sku());
				productoEncontrado.setNombre(datos_actualizados.nombre());
				productoEncontrado.setDescripcion(datos_actualizados.descripcion());
				productoEncontrado.setPrecio(datos_actualizados.precio());
				productoEncontrado.setStock(datos_actualizados.stock());
				productoEncontrado.setFecha_alta(datos_actualizados.fecha_alta());
					productoRepository.save(productoEncontrado);
						return convertirProductoCogido(productoEncontrado);
			}
	}

	@Override
	@Transactional
	public void eliminarProductoPorCodigo_sku(String codigo_sku) {
		Producto productoEncontrado = productoRepository.findByCodigoSku(codigo_sku).orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado."));
			productoRepository.delete(productoEncontrado);
	}

	private ProductoResponseDto convertirProductoCogido(Producto productoCogido) {
		return new ProductoResponseDto(
			productoCogido.getId_product(),
			productoCogido.getCodigoSku(),
			productoCogido.getNombre(),
			productoCogido.getDescripcion(),
			productoCogido.getPrecio(),
			productoCogido.getStock(),
			productoCogido.getFecha_alta()
		);
	}
}
