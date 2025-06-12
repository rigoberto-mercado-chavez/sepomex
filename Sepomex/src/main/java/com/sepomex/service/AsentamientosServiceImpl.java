package com.sepomex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sepomex.repository.AsentamientosRepository;
import com.sepomex.vo.AsentamientoVO;
import com.sepomex.vo.EstadoVO;
import com.sepomex.vo.MunicipioVO;
import com.sepomex.vo.TipoAsentamientoVO;

/**
 * Implementación del servicio para manejar operaciones relacionadas con los asentamientos.
 * 
 * Esta clase proporciona la funcionalidad para obtener una lista de asentamientos
 * filtrados por estado y municipio, devolviendo objetos de tipo {@link AsentamientoVO}.
 * 
 * Utiliza el repositorio {@link AsentamientosRepository} para acceder a los datos.
 */
@Service
public class AsentamientosServiceImpl implements AsentamientosService {

	/**
     * Repositorio para el acceso a datos de los asentamientos.
     * Inyectado automáticamente por Spring mediante {@link Autowired}.
     */
	@Autowired
	AsentamientosRepository asentamientosRepository;

	/**
     * Obtiene una lista de asentamientos correspondientes a un estado y municipio específicos.
     * 
     * @param idEstado    El identificador del estado para filtrar los asentamientos.
     * @param idMunicipio El identificador del municipio para filtrar los asentamientos.
     * @return Una lista de objetos {@link AsentamientoVO} que representan los asentamientos encontrados.
     */
	@Override
	public List<AsentamientoVO> getAsentamientos(int idEstado, int idMunicipio) {
        List<AsentamientoVO> list = new ArrayList<AsentamientoVO>();		
        asentamientosRepository.findByMunicipio(idEstado, idMunicipio).forEach(asentamiento -> {
			AsentamientoVO asentamientoVO = new AsentamientoVO(
					asentamiento.getIdAsentamiento(), 
					asentamiento.getAsentamiento(), 
					asentamiento.getCiudad(), 
					asentamiento.getCodigoPostal());
			
			asentamientoVO.setMunicipioVO(new MunicipioVO(
					asentamiento.getMunicipio().getIdMunicipio(), 
					asentamiento.getMunicipio().getClaveMunicipio(), 
					asentamiento.getMunicipio().getMunicipio()));
			
			asentamientoVO.getMunicipioVO().setEstadoVO(new EstadoVO(
					asentamiento.getMunicipio().getEstado().getIdEstado(), 
					asentamiento.getMunicipio().getEstado().getClaveEstado(), 
					asentamiento.getMunicipio().getEstado().getEstado()));
			
			asentamientoVO.setTipoAsentamientoVO(new TipoAsentamientoVO(
					asentamiento.getTipoAsentamiento().getIdTipoAsentamiento(), 
					asentamiento.getTipoAsentamiento().getClaveTipoAsentamiento(), 
					asentamiento.getTipoAsentamiento().getTipoAsentamiento()));
			list.add(asentamientoVO);
		});
		return list;
	}

	@Override
	public List<AsentamientoVO> getCodigoPostal(String codigoPostal) {
		List<AsentamientoVO> list = new ArrayList<AsentamientoVO>();
		asentamientosRepository.findByCodigoPostal(codigoPostal).forEach(asentamiento -> {
			AsentamientoVO asentamientoVO = new AsentamientoVO(
					asentamiento.getIdAsentamiento(), 
					asentamiento.getAsentamiento(), 
					asentamiento.getCiudad(), 
					asentamiento.getCodigoPostal());
			
			asentamientoVO.setMunicipioVO(new MunicipioVO(
					asentamiento.getMunicipio().getIdMunicipio(), 
					asentamiento.getMunicipio().getClaveMunicipio(), 
					asentamiento.getMunicipio().getMunicipio()));
			
			asentamientoVO.getMunicipioVO().setEstadoVO(new EstadoVO(
					asentamiento.getMunicipio().getEstado().getIdEstado(), 
					asentamiento.getMunicipio().getEstado().getClaveEstado(), 
					asentamiento.getMunicipio().getEstado().getEstado()));
			
			asentamientoVO.setTipoAsentamientoVO(new TipoAsentamientoVO(
					asentamiento.getTipoAsentamiento().getIdTipoAsentamiento(), 
					asentamiento.getTipoAsentamiento().getClaveTipoAsentamiento(), 
					asentamiento.getTipoAsentamiento().getTipoAsentamiento()));
			list.add(asentamientoVO);
		});
		return list;
	}

}
