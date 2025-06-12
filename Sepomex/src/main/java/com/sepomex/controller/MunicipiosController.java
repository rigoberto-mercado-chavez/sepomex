package com.sepomex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sepomex.service.MunicipiosService;
import com.sepomex.vo.MunicipioVO;

/**
 * Controlador REST que expone información sobre los municipios de un estado específico.
 *
 * <p>Proporciona un endpoint que permite obtener una lista de municipios asociada a un
 * determinado estado, identificado por su ID. La respuesta se devuelve en formato JSON.</p>
 *
 * <p>Utiliza el servicio {@link MunicipiosService} para acceder a la lógica de negocio
 * y recuperación de datos desde la capa correspondiente.</p>
 *
 * <p>La clase está anotada con {@link RestController}, lo que permite exponer métodos
 * RESTful directamente, con los resultados serializados automáticamente como JSON.</p>
 *
 * @author TuNombre
 * @version 1.0
 */
@RestController
public class MunicipiosController {

	/**
     * Servicio encargado de manejar la lógica de negocio relacionada con los municipios.
     */
	@Autowired
	MunicipiosService municipiosService;

	/**
     * Endpoint que retorna la lista de municipios de un estado dado.
     *
     * <p>Se accede mediante una petición HTTP GET al path:
     * <strong>/municipios/{idEstado}</strong>.</p>
     *
     * @param idEstado el ID del estado para el cual se desean consultar los municipios
     * @return una lista de objetos {@link MunicipioVO} representando los municipios encontrados
     */
	@RequestMapping(path="/municipios/{idEstado}", produces="application/json")
	public List<MunicipioVO> getMunicipios(@PathVariable("idEstado") int idEstado) {
		return municipiosService.getMunicipios(idEstado);
	}
	
}