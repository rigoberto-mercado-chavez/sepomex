package com.sepomex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sepomex.service.AsentamientosService;
import com.sepomex.vo.AsentamientoVO;

/**
 * Controlador REST que expone un endpoint para obtener los asentamientos asociados a un código postal.
 * 
 * <p>Este controlador utiliza el servicio {@link AsentamientosService} para recuperar
 * una lista de objetos {@link AsentamientoVO} que representan los asentamientos correspondientes
 * a un código postal específico.</p>
 * 
 * <p>La respuesta se entrega en formato JSON.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 * @see AsentamientoVO
 * @see AsentamientosService
 */
@RestController
public class CodigoPostalController {

	/** Servicio encargado de manejar la lógica relacionada con los asentamientos */
	@Autowired
	AsentamientosService asentamientosService;
	
	/**
     * Obtiene una lista de asentamientos correspondientes al código postal proporcionado.
     * 
     * <p>El código postal es recibido como parte de la URL, y se retorna una lista en formato JSON.</p>
     * 
     * @param codigoPostal el código postal para el cual se desean obtener los asentamientos
     * @return una lista de objetos {@link AsentamientoVO} correspondientes al código postal
     */
	@RequestMapping(path="/codigopostal/{codigoPostal}", produces="application/json")
	public List<AsentamientoVO> getCodigoPostal(@PathVariable("codigoPostal") String codigoPostal) {
		return asentamientosService.getCodigoPostal(codigoPostal);
	}
}
