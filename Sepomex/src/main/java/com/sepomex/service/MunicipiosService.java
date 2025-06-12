package com.sepomex.service;

import java.util.List;

import com.sepomex.vo.MunicipioVO;

/**
 * Interfaz que define los métodos relacionados con la obtención de municipios.
 * 
 * <p>Proporciona una operación para recuperar una lista de municipios asociados
 * a un estado específico identificado por su ID.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public interface MunicipiosService {

	/**
     * Obtiene una lista de objetos {@link MunicipioVO} que representan los municipios
     * pertenecientes al estado especificado por su ID.
     * 
     * @param idEstado el identificador único del estado cuyos municipios se desean obtener.
     * @return una lista de municipios correspondientes al estado; si no hay municipios, se retorna una lista vacía.
     */
	public List<MunicipioVO> getMunicipios(int idEstado);
	
}
