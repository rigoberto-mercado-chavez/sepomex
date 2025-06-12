package com.sepomex.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the asentamientos database table.
 * 
 */
@Entity
@Table(name="asentamientos")
@NamedQuery(name="Asentamiento.findAll", query="SELECT a FROM Asentamiento a")
public class Asentamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ASENTAMIENTO")
	private int idAsentamiento;

	private String asentamiento;

	private String ciudad;

	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="ID_MUNICIPIO")
	private Municipio municipio;

	//bi-directional many-to-one association to TipoAsentamiento
	@ManyToOne
	@JoinColumn(name="ID_TIPO_ASENTAMIENTO")
	private TipoAsentamiento tipoAsentamiento;

	public Asentamiento() {
	}

	public int getIdAsentamiento() {
		return this.idAsentamiento;
	}

	public void setIdAsentamiento(int idAsentamiento) {
		this.idAsentamiento = idAsentamiento;
	}

	public String getAsentamiento() {
		return this.asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public TipoAsentamiento getTipoAsentamiento() {
		return this.tipoAsentamiento;
	}

	public void setTipoAsentamiento(TipoAsentamiento tipoAsentamiento) {
		this.tipoAsentamiento = tipoAsentamiento;
	}

}