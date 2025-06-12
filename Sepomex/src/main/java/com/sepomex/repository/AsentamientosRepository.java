package com.sepomex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sepomex.entity.Asentamiento;

/**
 * Repositorio JPA para la entidad {@link Asentamiento}.
 * 
 * <p>Proporciona métodos para acceder y manipular datos de asentamientos en la base de datos.</p>
 * 
 * <p>Extiende {@link JpaRepository} para heredar operaciones CRUD estándar y
 * define consultas personalizadas mediante {@link Query}.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public interface AsentamientosRepository extends JpaRepository<Asentamiento, Long> {

	/**
     * Recupera la lista de asentamientos que pertenecen a un municipio y estado específicos.
     * 
     * <p>Esta consulta utiliza SQL nativo para hacer un INNER JOIN entre las tablas de
     * asentamientos y municipios, filtrando por el ID del municipio y el ID del estado.</p>
     *
     * @param idEstado el identificador del estado asociado al municipio
     * @param idMunicipio el identificador del municipio para filtrar los asentamientos
     * @return una lista de {@link Asentamiento} que cumplen con los criterios especificados
     */
	@Query(value = "SELECT A.* FROM ASENTAMIENTOS A INNER JOIN MUNICIPIOS M ON (M.ID_MUNICIPIO = A.ID_MUNICIPIO) WHERE M.ID_MUNICIPIO = :idMunicipio AND M.ID_ESTADO = :idEstado", nativeQuery = true)
    public List<Asentamiento> findByMunicipio(
        @Param("idEstado") int idEstado,
        @Param("idMunicipio") int idMunicipio
    );
	
	public List<Asentamiento> findByCodigoPostal(String codigoPostal);
}
