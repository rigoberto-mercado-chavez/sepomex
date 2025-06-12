package com.sepomex.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_asentamientos database table.
 * 
 */
@Entity
@Table(name="tipo_asentamientos")
@NamedQuery(name="TipoAsentamiento.findAll", query="SELECT t FROM TipoAsentamiento t")
public class TipoAsentamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_ASENTAMIENTO")
	private int idTipoAsentamiento;

	@Column(name="CLAVE_TIPO_ASENTAMIENTO")
	private String claveTipoAsentamiento;

	@Column(name="TIPO_ASENTAMIENTO")
	private String tipoAsentamiento;

	//bi-directional many-to-one association to Asentamiento
	@OneToMany(mappedBy="tipoAsentamiento")
	private List<Asentamiento> asentamientos;

	public TipoAsentamiento() {
	}

	public int getIdTipoAsentamiento() {
		return this.idTipoAsentamiento;
	}

	public void setIdTipoAsentamiento(int idTipoAsentamiento) {
		this.idTipoAsentamiento = idTipoAsentamiento;
	}

	public String getClaveTipoAsentamiento() {
		return this.claveTipoAsentamiento;
	}

	public void setClaveTipoAsentamiento(String claveTipoAsentamiento) {
		this.claveTipoAsentamiento = claveTipoAsentamiento;
	}

	public String getTipoAsentamiento() {
		return this.tipoAsentamiento;
	}

	public void setTipoAsentamiento(String tipoAsentamiento) {
		this.tipoAsentamiento = tipoAsentamiento;
	}

	public List<Asentamiento> getAsentamientos() {
		return this.asentamientos;
	}

	public void setAsentamientos(List<Asentamiento> asentamientos) {
		this.asentamientos = asentamientos;
	}

	public Asentamiento addAsentamiento(Asentamiento asentamiento) {
		getAsentamientos().add(asentamiento);
		asentamiento.setTipoAsentamiento(this);

		return asentamiento;
	}

	public Asentamiento removeAsentamiento(Asentamiento asentamiento) {
		getAsentamientos().remove(asentamiento);
		asentamiento.setTipoAsentamiento(null);

		return asentamiento;
	}

}