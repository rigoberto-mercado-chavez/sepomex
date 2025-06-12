package com.sepomex.vo;

import java.io.Serializable;

/**
 * Clase de valor (Value Object) que representa un municipio.
 * 
 * <p>Incluye información como el identificador del municipio, su clave, nombre
 * y el estado al que pertenece.</p>
 * 
 * <p>Implementa {@link Serializable}, lo que permite utilizar esta clase en contextos
 * donde se requiera serialización, como en la transmisión de datos o almacenamiento en caché.</p>
 * 
 * @see EstadoVO
 * 
 * @version 1.0
 */
public class MunicipioVO implements Serializable {

    /** UID para la serialización */
    private static final long serialVersionUID = 1L;

    /** Identificador único del municipio */
    private int idMunicipio;

    /** Clave o código del municipio */
    private String claveMunicipio;

    /** Nombre del municipio */
    private String municipio;

    /** Estado al que pertenece el municipio */
    private EstadoVO estadoVO;

    /**
     * Constructor por defecto.
     */
    public MunicipioVO() {
        super();
    }

    /**
     * Constructor que inicializa los campos principales del municipio.
     * 
     * @param idMunicipio el identificador del municipio
     * @param claveMunicipio la clave o código del municipio
     * @param municipio el nombre del municipio
     */
    public MunicipioVO(int idMunicipio, String claveMunicipio, String municipio) {
        super();
        this.idMunicipio = idMunicipio;
        this.claveMunicipio = claveMunicipio;
        this.municipio = municipio;
    }

    /** @return el identificador del municipio */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /** @param idMunicipio el nuevo identificador del municipio */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /** @return la clave del municipio */
    public String getClaveMunicipio() {
        return claveMunicipio;
    }

    /** @param claveMunicipio la nueva clave del municipio */
    public void setClaveMunicipio(String claveMunicipio) {
        this.claveMunicipio = claveMunicipio;
    }

    /** @return el nombre del municipio */
    public String getMunicipio() {
        return municipio;
    }

    /** @param municipio el nuevo nombre del municipio */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /** @return el estado al que pertenece el municipio */
    public EstadoVO getEstadoVO() {
        return estadoVO;
    }

    /** @param estadoVO el nuevo estado asociado al municipio */
    public void setEstadoVO(EstadoVO estadoVO) {
        this.estadoVO = estadoVO;
    }
}
