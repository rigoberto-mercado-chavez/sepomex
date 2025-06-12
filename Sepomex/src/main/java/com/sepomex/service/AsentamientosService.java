package com.sepomex.service;

import java.util.List;

import com.sepomex.vo.AsentamientoVO;

/**
 * Interfaz del servicio que maneja la lógica relacionada con los asentamientos.
 * 
 * <p>Define los contratos para obtener información de asentamientos filtrados
 * por estado y municipio.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public interface AsentamientosService {

	/**
     * Obtiene una lista de asentamientos para un estado y municipio específicos.
     *
     * @param idEstado   el identificador del estado
     * @param idMunicipio el identificador del municipio
     * @return lista de objetos {@link AsentamientoVO} que corresponden al estado y municipio indicados
     */
	public List<AsentamientoVO> getAsentamientos(int idEstado, int idMunicipio);
	
	public List<AsentamientoVO> getCodigoPostal(String codigoPostal);
}
