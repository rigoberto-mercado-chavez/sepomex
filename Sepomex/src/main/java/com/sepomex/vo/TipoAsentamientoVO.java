package com.sepomex.vo;

import java.io.Serializable;

/**
 * Clase de valor (Value Object) que representa un tipo de asentamiento.
 * 
 * <p>Incluye información como el identificador, la clave y el nombre del tipo de asentamiento,
 * que puede representar entidades como colonias, fraccionamientos, barrios, entre otros.</p>
 * 
 * <p>Esta clase implementa {@link Serializable}, lo cual permite su uso en operaciones
 * donde se requiere la serialización de objetos, como la transmisión de datos o almacenamiento en caché.</p>
 * 
 * @author Rigoberto Mercado
 * @version 1.0
 */
public class TipoAsentamientoVO implements Serializable {

    /** UID para la serialización */
    private static final long serialVersionUID = 1L;

    /** Identificador único del tipo de asentamiento */
    private int idTipoAsentamiento;

    /** Clave o código del tipo de asentamiento */
    private String claveTipoAsentamiento;

    /** Nombre o descripción del tipo de asentamiento */
    private String tipoAsentamiento;

    /**
     * Constructor por defecto.
     */
    public TipoAsentamientoVO() {
        super();
    }

    /**
     * Constructor que inicializa los campos principales del tipo de asentamiento.
     * 
     * @param idTipoAsentamiento el identificador del tipo de asentamiento
     * @param claveTipoAsentamiento la clave o código del tipo
     * @param tipoAsentamiento el nombre o descripción del tipo de asentamiento
     */
    public TipoAsentamientoVO(int idTipoAsentamiento, String claveTipoAsentamiento, String tipoAsentamiento) {
        super();
        this.idTipoAsentamiento = idTipoAsentamiento;
        this.claveTipoAsentamiento = claveTipoAsentamiento;
        this.tipoAsentamiento = tipoAsentamiento;
    }

    /** @return el identificador del tipo de asentamiento */
    public int getIdTipoAsentamiento() {
        return idTipoAsentamiento;
    }

    /** @param idTipoAsentamiento el nuevo identificador del tipo de asentamiento */
    public void setIdTipoAsentamiento(int idTipoAsentamiento) {
        this.idTipoAsentamiento = idTipoAsentamiento;
    }

    /** @return la clave del tipo de asentamiento */
    public String getClaveTipoAsentamiento() {
        return claveTipoAsentamiento;
    }

    /** @param claveTipoAsentamiento la nueva clave del tipo de asentamiento */
    public void setClaveTipoAsentamiento(String claveTipoAsentamiento) {
        this.claveTipoAsentamiento = claveTipoAsentamiento;
    }

    /** @return el nombre del tipo de asentamiento */
    public String getTipoAsentamiento() {
        return tipoAsentamiento;
    }

    /** @param tipoAsentamiento el nuevo nombre del tipo de asentamiento */
    public void setTipoAsentamiento(String tipoAsentamiento) {
        this.tipoAsentamiento = tipoAsentamiento;
    }
}
