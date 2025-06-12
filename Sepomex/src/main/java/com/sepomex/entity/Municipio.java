package com.sepomex.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the municipios database table.
 * 
 */
@Entity
@Table(name="municipios")
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MUNICIPIO")
	private int idMunicipio;

	@Column(name="CLAVE_MUNICIPIO")
	private String claveMunicipio;

	private String municipio;

	//bi-directional many-to-one association to Asentamiento
	@OneToMany(mappedBy="municipio")
	private List<Asentamiento> asentamientos;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	public Municipio() {
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getClaveMunicipio() {
		return this.claveMunicipio;
	}

	public void setClaveMunicipio(String claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public List<Asentamiento> getAsentamientos() {
		return this.asentamientos;
	}

	public void setAsentamientos(List<Asentamiento> asentamientos) {
		this.asentamientos = asentamientos;
	}

	public Asentamiento addAsentamiento(Asentamiento asentamiento) {
		getAsentamientos().add(asentamiento);
		asentamiento.setMunicipio(this);

		return asentamiento;
	}

	public Asentamiento removeAsentamiento(Asentamiento asentamiento) {
		getAsentamientos().remove(asentamiento);
		asentamiento.setMunicipio(null);

		return asentamiento;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}