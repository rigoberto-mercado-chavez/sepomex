package com.sepomex.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase de valor (Value Object) que representa un estado dentro del sistema.
 * 
 * <p>Contiene información como el identificador del estado, su clave, su nombre y la lista
 * de municipios que lo conforman.</p>
 * 
 * <p>Implementa la interfaz {@link Serializable}, lo que permite que esta clase sea utilizada
 * en contextos donde se requiera serialización de objetos (por ejemplo, transporte de datos
 * entre capas de una aplicación o almacenamiento en caché).</p>
 * 
 * @see MunicipioVO
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public class EstadoVO implements Serializable {

    /** UID para la serialización */
    private static final long serialVersionUID = 1L;

    /** Identificador único del estado */
    private int idEstado;

    /** Clave del estado (abreviatura o código oficial) */
    private String claveEstado;

    /** Nombre del estado */
    private String estado;

    /** Lista de municipios pertenecientes al estado */
    private List<MunicipioVO> municipiosVOs;

    /**
     * Constructor por defecto.
     */
    public EstadoVO() {
        super();
    }

    /**
     * Constructor que inicializa los campos principales del estado.
     * 
     * @param idEstado el identificador del estado
     * @param claveEstado la clave o código del estado
     * @param estado el nombre del estado
     */
    public EstadoVO(int idEstado, String claveEstado, String estado) {
        super();
        this.idEstado = idEstado;
        this.claveEstado = claveEstado;
        this.estado = estado;
    }

    /** @return el identificador del estado */
    public int getIdEstado() {
        return idEstado;
    }

    /** @param idEstado el nuevo identificador del estado */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    /** @return la clave del estado */
    public String getClaveEstado() {
        return claveEstado;
    }

    /** @param claveEstado la nueva clave del estado */
    public void setClaveEstado(String claveEstado) {
        this.claveEstado = claveEstado;
    }

    /** @return el nombre del estado */
    public String getEstado() {
        return estado;
    }

    /** @param estado el nuevo nombre del estado */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** @return la lista de municipios del estado */
    public List<MunicipioVO> getMunicipiosVOs() {
        return municipiosVOs;
    }

    /** @param municipiosVOs la nueva lista de municipios del estado */
    public void setMunicipiosVOs(List<MunicipioVO> municipiosVOs) {
        this.municipiosVOs = municipiosVOs;
    }
}
