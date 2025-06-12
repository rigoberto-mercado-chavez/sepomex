package com.sepomex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sepomex.service.EstadosService;
import com.sepomex.vo.EstadoVO;

/**
 * Controlador REST para exponer información relacionada con los estados de México.
 * 
 * <p>Este controlador proporciona un endpoint REST que devuelve una lista de estados,
 * representados por objetos {@link EstadoVO}, en formato JSON.</p>
 * 
 * <p>Utiliza el servicio {@link EstadosService} para obtener los datos desde la capa de negocio
 * o persistencia.</p>
 *
 * <p>La clase está anotada con {@link RestController}, lo que la convierte en un controlador
 * especializado para servicios REST, y permite que los métodos devuelvan directamente
 * datos serializados (como JSON).</p>
 *
 * @author Rigoberto Mercado
 * @version 1.0
 */
@RestController
public class EstadosController {

	/**
     * Servicio encargado de manejar la lógica de negocio relacionada con los estados.
     */
	@Autowired
	EstadosService estadosService;

	/**
     * Endpoint que retorna una lista de estados en formato JSON.
     *
     * <p>Se accede mediante una petición HTTP GET al path <strong>/estados</strong>.</p>
     *
     * @return una lista de objetos {@link EstadoVO} representando los estados disponibles
     */
	@RequestMapping(path="/estados", produces="application/json")
	public List<EstadoVO> getEstados() {
		return estadosService.getEstados();
	}
	
}