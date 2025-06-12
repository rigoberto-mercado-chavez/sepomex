package com.sepomex.vo;

import java.io.Serializable;

/**
 * Clase de valor (Value Object) que representa un asentamiento.
 * 
 * <p>Contiene información como el nombre del asentamiento, ciudad, código postal,
 * así como referencias al municipio al que pertenece y su tipo de asentamiento.</p>
 * 
 * <p>Esta clase implementa {@link Serializable} para permitir su uso en contextos
 * donde es necesario serializar objetos, como en transmisión por red o almacenamiento en caché.</p>
 * 
 * @see MunicipioVO
 * @see TipoAsentamientoVO
 * 
 * @version 1.0
 */
public class AsentamientoVO implements Serializable {

	/** UID para la serialización */
	private static final long serialVersionUID = 1L;
	
	/** Identificador único del asentamiento */
	private int idAsentamiento;
	
	 /** Nombre del asentamiento */
	private String asentamiento;
	
	/** Nombre de la ciudad a la que pertenece el asentamiento */
	private String ciudad;
	
	 /** Código postal del asentamiento */
	private String codigoPostal;
	
	 /** Municipio asociado al asentamiento */
	private MunicipioVO municipioVO;
	
	/** Tipo de asentamiento (por ejemplo: colonia, fraccionamiento, etc.) */
	private TipoAsentamientoVO tipoAsentamientoVO;
	
	/**
     * Constructor por defecto.
     */
	public AsentamientoVO() {
		super();
	}

	/**
     * Constructor que inicializa los campos básicos del asentamiento.
     * 
     * @param idAsentamiento el identificador del asentamiento
     * @param asentamiento el nombre del asentamiento
     * @param ciudad el nombre de la ciudad
     * @param codigoPostal el código postal del asentamiento
     */
	public AsentamientoVO(int idAsentamiento, String asentamiento, String ciudad, String codigoPostal) {
		super();
		this.idAsentamiento = idAsentamiento;
		this.asentamiento = asentamiento;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
	}

	/** @return el identificador del asentamiento */
	public int getIdAsentamiento() {
		return idAsentamiento;
	}

	/** @param idAsentamiento el nuevo identificador del asentamiento */
    public void setIdAsentamiento(int idAsentamiento) {
        this.idAsentamiento = idAsentamiento;
    }

    /** @return el nombre del asentamiento */
    public String getAsentamiento() {
        return asentamiento;
    }

    /** @param asentamiento el nuevo nombre del asentamiento */
    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }

    /** @return el nombre de la ciudad */
    public String getCiudad() {
        return ciudad;
    }

    /** @param ciudad la nueva ciudad del asentamiento */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /** @return el código postal */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /** @param codigoPostal el nuevo código postal del asentamiento */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /** @return el municipio asociado al asentamiento */
    public MunicipioVO getMunicipioVO() {
        return municipioVO;
    }

    /** @param municipioVO el nuevo municipio asociado al asentamiento */
    public void setMunicipioVO(MunicipioVO municipioVO) {
        this.municipioVO = municipioVO;
    }

    /** @return el tipo de asentamiento */
    public TipoAsentamientoVO getTipoAsentamientoVO() {
        return tipoAsentamientoVO;
    }

    /** @param tipoAsentamientoVO el nuevo tipo de asentamiento */
    public void setTipoAsentamientoVO(TipoAsentamientoVO tipoAsentamientoVO) {
        this.tipoAsentamientoVO = tipoAsentamientoVO;
    }
	
}
