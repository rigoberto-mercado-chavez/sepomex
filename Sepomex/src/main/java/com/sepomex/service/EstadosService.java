package com.sepomex.service;

import java.util.List;

import com.sepomex.vo.EstadoVO;

/**
 * Interfaz que define los métodos relacionados con la obtención de estados.
 * 
 * <p>Esta interfaz puede ser implementada por clases que necesiten proporcionar
 * una lista de entidades {@link EstadoVO} representando los diferentes estados disponibles.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public interface EstadosService {

	/**
     * Obtiene una lista de objetos {@link EstadoVO} que representan los estados disponibles.
     * 
     * @return una lista de estados; si no hay estados disponibles, la lista estará vacía pero no será {@code null}.
     */
	public List<EstadoVO> getEstados();
	
}
