package com.sepomex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sepomex.repository.EstadosRepository;
import com.sepomex.vo.EstadoVO;

/**
 * Implementación del servicio {@link EstadosService} que proporciona
 * funcionalidad para obtener una lista de estados.
 * 
 * <p>Esta clase utiliza un repositorio para acceder a los datos persistentes de los estados
 * y los convierte en objetos {@link EstadoVO} para su uso en capas superiores.</p>
 * 
 * <p>Está anotada con {@link Service}, lo que permite que Spring la detecte como un componente
 * de servicio y la gestione como un bean dentro del contexto de la aplicación.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
@Service
public class EstadosServiceImpl implements EstadosService {

	/**
     * Repositorio para el acceso a datos de los estados.
     * Inyectado automáticamente por Spring mediante {@link Autowired}.
     */
	@Autowired
	EstadosRepository estadosRepository;
	
	/**
     * <p>Recupera todos los estados desde la base de datos y los convierte
     * en una lista de objetos {@link EstadoVO}.</p>
     * 
     * @return una lista de objetos {@link EstadoVO} con los datos de los estados.
     */
	@Override
	public List<EstadoVO> getEstados() {
		List<EstadoVO> list = new ArrayList<EstadoVO>();
		estadosRepository.findAll().forEach(estado -> {
			list.add(new EstadoVO(
					estado.getIdEstado(), 
					estado.getClaveEstado(), 
					estado.getEstado()));
		});
		return list;
	}

}
