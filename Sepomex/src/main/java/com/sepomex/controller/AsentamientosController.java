package com.sepomex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sepomex.service.AsentamientosService;
import com.sepomex.vo.AsentamientoVO;

/**
 * Controlador REST que expone información sobre los asentamientos de un estado específico.
 *
 * <p>Este controlador proporciona un endpoint para consultar asentamientos en función
 * del ID del estado y del ID del asentamiento. La respuesta se devuelve en formato JSON.</p>
 *
 * <p>Utiliza el servicio {@link AsentamientosService} para recuperar los datos desde la capa
 * de negocio o persistencia.</p>
 *
 * <p>La anotación {@link RestController} indica que esta clase maneja solicitudes REST
 * y que los valores devueltos se serializan automáticamente como JSON.</p>
 *
 * @author Rigoberto Mercado
 * @version 1.0
 */
@RestController
public class AsentamientosController {

	/**
     * Servicio encargado de la lógica relacionada con los asentamientos.
     */
	@Autowired
	AsentamientosService asentamientosService;
	
	/**
     * Endpoint para obtener una lista de asentamientos filtrados por ID de estado e ID de asentamiento.
     *
     * <p>Se accede mediante una petición HTTP GET con el siguiente path:
     * <strong>/asentamientos/{idEstado}/{idAsentamiento}</strong></p>
     *
     * @param idEstado ID del estado del cual se desean obtener asentamientos
     * @param idAsentamiento ID específico del asentamiento a buscar
     * @return una lista de objetos {@link AsentamientoVO} que representan los asentamientos encontrados
     */
	@RequestMapping(path="/asentamientos/{idEstado}/{idAsentamiento}", produces="application/json")
	public List<AsentamientoVO> getAsentamientos(@PathVariable("idEstado") int idEstado, @PathVariable("idAsentamiento") int idAsentamiento) {
		return asentamientosService.getAsentamientos(idEstado, idAsentamiento);
	}
	
}