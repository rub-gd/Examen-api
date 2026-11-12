package com.examen.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.api.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	Optional<Producto> findByCodigoSku(String codigo_sku);
	boolean existsByCodigoSku(String codigo_sku);
	void deleteByCodigoSku(String codigo_sku);
}
