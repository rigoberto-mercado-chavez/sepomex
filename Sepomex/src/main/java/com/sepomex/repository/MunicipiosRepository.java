package com.sepomex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sepomex.entity.Estado;
import com.sepomex.entity.Municipio;

/**
 * Repositorio JPA para la entidad {@link Municipio}.
 * 
 * <p>Proporciona operaciones CRUD estándar para gestionar municipios en la base de datos,
 * además de consultas personalizadas específicas.</p>
 * 
 * <p>Extiende {@link JpaRepository} para heredar métodos comunes como guardar,
 * eliminar, buscar por ID, etc.</p>
 * 
 * <p>Define un método personalizado para obtener municipios asociados a un estado dado.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public interface MunicipiosRepository extends JpaRepository<Municipio, Long> {

	/**
     * Obtiene una lista de municipios que pertenecen a un estado específico.
     * 
     * @param estado la entidad {@link Estado} usada para filtrar los municipios
     * @return lista de {@link Municipio} pertenecientes al estado proporcionado
     */
	public List<Municipio> findMunicipiosByEstado(Estado estado);
	
}
