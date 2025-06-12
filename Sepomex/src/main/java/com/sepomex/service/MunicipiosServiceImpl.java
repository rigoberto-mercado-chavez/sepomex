package com.sepomex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sepomex.entity.Estado;
import com.sepomex.repository.MunicipiosRepository;
import com.sepomex.vo.EstadoVO;
import com.sepomex.vo.MunicipioVO;

/**
 * Implementación de la interfaz {@link MunicipiosService} que proporciona
 * funcionalidad para obtener los municipios asociados a un estado.
 *
 * <p>Esta clase es gestionada como un componente de Spring mediante la anotación {@link Service}
 * y utiliza un repositorio para acceder a los datos persistentes de los municipios.</p>
 * 
 * <p>Convierte entidades de tipo {@code Municipio} a objetos {@link MunicipioVO}, incluyendo
 * la información del estado al que pertenecen.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
@Service
public class MunicipiosServiceImpl implements MunicipiosService {

	/**
     * Repositorio para acceder a los datos de municipios.
     * Inyectado automáticamente por Spring.
     */
	@Autowired
	MunicipiosRepository municipiosRepository;
	
	/**
     * <p>Recupera una lista de municipios asociados al estado especificado mediante su ID.
     * Para cada municipio recuperado, se crea un objeto {@link MunicipioVO} que incluye los
     * datos del municipio y su estado correspondiente encapsulado en un {@link EstadoVO}.</p>
     * 
     * @param idEstado el ID del estado cuyos municipios se desean obtener.
     * @return una lista de objetos {@link MunicipioVO} que representan los municipios del estado.
     */
	public List<MunicipioVO> getMunicipios(int idEstado) {
		List<MunicipioVO> list = new ArrayList<MunicipioVO>();
		
		Estado estado = new Estado();
		estado.setIdEstado(idEstado);
		
		municipiosRepository.findMunicipiosByEstado(estado).forEach(municipio -> {
			MunicipioVO municipioVO = new MunicipioVO(
					municipio.getIdMunicipio(), 
					municipio.getClaveMunicipio(),
					municipio.getMunicipio());
			
			municipioVO.setEstadoVO(new EstadoVO(
					municipio.getEstado().getIdEstado(), 
					municipio.getEstado().getClaveEstado(), 
					municipio.getEstado().getEstado()));
			list.add(municipioVO);
		});
		return list;
	}
	
}
