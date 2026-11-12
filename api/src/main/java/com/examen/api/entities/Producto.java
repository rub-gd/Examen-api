package com.examen.api.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Producto", schema = "api", uniqueConstraints = {@UniqueConstraint(name = "uk_codigo_sku", columnNames = "codigo_sku")})
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")private Integer id_product;
	@Column(name = "codigo_sku", length = 10, unique = true, nullable = false)private String codigoSku;
	@Column(name = "nombre", length = 100, nullable = false)private String nombre;
	@Column(name = "descripcion", length = 255)private String descripcion;
	@Column(name = "precio", nullable = false)private Integer precio;
	@Column(name = "stock", nullable = false)private Integer stock;
	@Column(name = "fecha_alta", nullable = false)private LocalDate fecha_alta;
	
	public Producto() {
		
	}

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	public String getCodigoSku() {
		return codigoSku;
	}

	public void setCodigoSku(String codigo_sku) {
		this.codigoSku = codigo_sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public LocalDate getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
}
