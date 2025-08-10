package com.sepomex.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sepomex.service.AsentamientosService;
import com.sepomex.service.EstadosService;
import com.sepomex.service.MunicipiosService;

import io.spring.guides.gs_producing_web_service.AsentamientoVO;
import io.spring.guides.gs_producing_web_service.EstadoVO;
import io.spring.guides.gs_producing_web_service.GetAsentamientosRequest;
import io.spring.guides.gs_producing_web_service.GetAsentamientosResponse;
import io.spring.guides.gs_producing_web_service.GetCodigoPostalRequest;
import io.spring.guides.gs_producing_web_service.GetCodigoPostalResponse;
import io.spring.guides.gs_producing_web_service.GetEstadosRequest;
import io.spring.guides.gs_producing_web_service.GetEstadosResponse;
import io.spring.guides.gs_producing_web_service.GetMunicipiosRequest;
import io.spring.guides.gs_producing_web_service.GetMunicipiosResponse;
import io.spring.guides.gs_producing_web_service.MunicipioVO;
import io.spring.guides.gs_producing_web_service.TipoAsentamientoVO;

/**
 * Endpoint SOAP que expone los servicios de consulta para el sistema Sepomex.
 *
 * Este endpoint maneja solicitudes SOAP y delega la lógica de negocio a los servicios
 * correspondientes para obtener información sobre estados, municipios, asentamientos
 * y códigos postales.
 */
@Endpoint
public class SepomexEndpoint {
	
	/**
     * URI del namespace definido en el esquema WSDL/XSD.
     */
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	/**
     * Servicio encargado de manejar la lógica de negocio relacionada con los estados.
     */
	@Autowired
	EstadosService estadosService;
	
	/**
     * Servicio encargado de manejar la lógica de negocio relacionada con los municipios.
     */
	@Autowired
	MunicipiosService municipiosService;
	
	/**
     * Servicio encargado de la lógica relacionada con los asentamientos.
     */
	@Autowired
	AsentamientosService asentamientosService;
	
	/**
     * Maneja la solicitud SOAP para obtener la lista de estados disponibles.
     *
     * @param request solicitud vacía del tipo {@link GetEstadosRequest}
     * @return una respuesta con la lista de estados {@link GetEstadosResponse}
     */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstadosRequest")
	@ResponsePayload
	public GetEstadosResponse getEstados(@RequestPayload GetEstadosRequest request) {
		GetEstadosResponse response = new GetEstadosResponse();
		estadosService.getEstados().forEach(e -> {
			// Datos del estado
			EstadoVO estadoVO = new EstadoVO();
			estadoVO.setIdEstado(e.getIdEstado());
			estadoVO.setClaveEstado(e.getClaveEstado());
			estadoVO.setEstado(e.getEstado());
			response.getEstados().add(estadoVO);
		});
		return response;
	}
	
	/**
     * Maneja la solicitud SOAP para obtener los municipios de un estado específico.
     *
     * @param request contiene el ID del estado {@link GetMunicipiosRequest}
     * @return una respuesta con la lista de municipios del estado {@link GetMunicipiosResponse}
     */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMunicipiosRequest")
	@ResponsePayload
	public GetMunicipiosResponse getMunicipios(@RequestPayload GetMunicipiosRequest request) {
		GetMunicipiosResponse response = new GetMunicipiosResponse();
		municipiosService.getMunicipios(request.getIdEstado()).forEach(m -> {
			// Datos del municipio
			MunicipioVO municipioVO = new MunicipioVO();
			municipioVO.setIdMunicipio(m.getIdMunicipio());
			municipioVO.setClaveMunicipio(m.getClaveMunicipio());
			municipioVO.setMunicipio(m.getMunicipio());
			// Datos del estado
			EstadoVO estadoVO = new EstadoVO();
			estadoVO.setIdEstado(m.getEstadoVO().getIdEstado());
			estadoVO.setClaveEstado(m.getEstadoVO().getClaveEstado());
			estadoVO.setEstado(m.getEstadoVO().getEstado());
			municipioVO.setEstadoVO(estadoVO);
			response.getMunicipios().add(municipioVO);
		});
		return response;
	}
	
	/**
     * Maneja la solicitud SOAP para obtener los asentamientos de un municipio específico.
     *
     * @param request contiene el ID del estado y del municipio {@link GetAsentamientosRequest}
     * @return una respuesta con la lista de asentamientos {@link GetAsentamientosResponse}
     */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAsentamientosRequest")
	@ResponsePayload
	public GetAsentamientosResponse getAsentamientos(@RequestPayload GetAsentamientosRequest request) {
		GetAsentamientosResponse response = new GetAsentamientosResponse();
		
		asentamientosService.getAsentamientos(request.getIdEstado(), request.getIdMunicipio()).forEach(a -> {
			// Datos del asentamiento
			AsentamientoVO asentamientoVO = new AsentamientoVO();
			asentamientoVO.setIdAsentamiento(a.getIdAsentamiento());
			asentamientoVO.setAsentamiento(a.getAsentamiento());
			asentamientoVO.setCiudad(a.getCiudad());;
			asentamientoVO.setCodigoPostal(a.getCodigoPostal());
			// Datos del municipio
			MunicipioVO municipioVO = new MunicipioVO();
			municipioVO.setIdMunicipio(a.getMunicipioVO().getIdMunicipio());
			municipioVO.setClaveMunicipio(a.getMunicipioVO().getClaveMunicipio());
			municipioVO.setMunicipio(a.getMunicipioVO().getMunicipio());
			// Datos del estado
			EstadoVO estadoVO = new EstadoVO();
			estadoVO.setIdEstado(a.getMunicipioVO().getEstadoVO().getIdEstado());
			estadoVO.setClaveEstado(a.getMunicipioVO().getEstadoVO().getClaveEstado());
			estadoVO.setEstado(a.getMunicipioVO().getEstadoVO().getEstado());
			municipioVO.setEstadoVO(estadoVO);
			// Datos del tipo de asentamiento
			TipoAsentamientoVO tipoAsentamientoVO = new TipoAsentamientoVO();
			tipoAsentamientoVO.setIdTipoAsentamiento(a.getTipoAsentamientoVO().getIdTipoAsentamiento());
			tipoAsentamientoVO.setClaveTipoAsentamiento(a.getTipoAsentamientoVO().getClaveTipoAsentamiento());
			tipoAsentamientoVO.setTipoAsentamiento(a.getTipoAsentamientoVO().getTipoAsentamiento());
			asentamientoVO.setTipoAsentamientoVO(tipoAsentamientoVO);
			
			response.getAsentamientos().add(asentamientoVO);
		});
		return response;
	}
	
	/**
     * Maneja la solicitud SOAP para obtener asentamientos asociados a un código postal.
     *
     * @param request contiene el código postal a consultar {@link GetCodigoPostalRequest}
     * @return una respuesta con la lista de asentamientos relacionados al código postal {@link GetCodigoPostalResponse}
     */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCodigoPostalRequest")
	@ResponsePayload
	public GetCodigoPostalResponse getCodigoPostal(@RequestPayload GetCodigoPostalRequest request) {
		GetCodigoPostalResponse response = new GetCodigoPostalResponse();
		
		asentamientosService.getCodigoPostal(request.getCodigoPostal()).forEach(cp -> {
			// Datos del asentamiento
			AsentamientoVO asentamientoVO = new AsentamientoVO();
			asentamientoVO.setIdAsentamiento(cp.getIdAsentamiento());
			asentamientoVO.setAsentamiento(cp.getAsentamiento());
			asentamientoVO.setCiudad(cp.getCiudad());;
			asentamientoVO.setCodigoPostal(cp.getCodigoPostal());
			// Datos del municipio
			MunicipioVO municipioVO = new MunicipioVO();
			municipioVO.setIdMunicipio(cp.getMunicipioVO().getIdMunicipio());
			municipioVO.setClaveMunicipio(cp.getMunicipioVO().getClaveMunicipio());
			municipioVO.setMunicipio(cp.getMunicipioVO().getMunicipio());
			// Datos del estado
			EstadoVO estadoVO = new EstadoVO();
			estadoVO.setIdEstado(cp.getMunicipioVO().getEstadoVO().getIdEstado());
			estadoVO.setClaveEstado(cp.getMunicipioVO().getEstadoVO().getClaveEstado());
			estadoVO.setEstado(cp.getMunicipioVO().getEstadoVO().getEstado());
			municipioVO.setEstadoVO(estadoVO);
			// Datos del tipo de asentamiento
			TipoAsentamientoVO tipoAsentamientoVO = new TipoAsentamientoVO();
			tipoAsentamientoVO.setIdTipoAsentamiento(cp.getTipoAsentamientoVO().getIdTipoAsentamiento());
			tipoAsentamientoVO.setClaveTipoAsentamiento(cp.getTipoAsentamientoVO().getClaveTipoAsentamiento());
			tipoAsentamientoVO.setTipoAsentamiento(cp.getTipoAsentamientoVO().getTipoAsentamiento());
			asentamientoVO.setTipoAsentamientoVO(tipoAsentamientoVO);
			response.getAsentamientos().add(asentamientoVO);
		});
		return response;
	}
	
}
