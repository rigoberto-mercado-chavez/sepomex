package com.sepomex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sepomex.entity.Estado;

/**
 * Repositorio JPA para la entidad {@link Estado}.
 * 
 * <p>Proporciona las operaciones CRUD estándar para gestionar los datos de estados
 * en la base de datos.</p>
 * 
 * <p>Extiende {@link JpaRepository} para heredar métodos como guardar, eliminar,
 * buscar por ID, entre otros.</p>
 * 
 * No contiene métodos personalizados, pero puede ser extendido para añadir consultas específicas.
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public interface EstadosRepository extends JpaRepository<Estado, Long> {

}
