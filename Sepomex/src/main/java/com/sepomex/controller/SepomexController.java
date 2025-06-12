package com.sepomex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador MVC que maneja las solicitudes web para la aplicación SEPOMEX.
 * 
 * <p>Proporciona el endpoint raíz ("/") que devuelve la vista principal llamada "index".</p>
 * 
 * <p>Esta clase está anotada con {@link Controller}, lo que indica que maneja
 * solicitudes HTTP y retorna nombres de vistas para ser resueltas por el motor de vistas configurado.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
@Controller
public class SepomexController {

	/**
     * Maneja solicitudes HTTP GET a la raíz ("/") de la aplicación.
     *
     * @return el nombre de la vista "index" que será renderizada
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
}
