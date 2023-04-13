package com.feerka.model;

import javax.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	
	@Column(name = "nombre",nullable = false, length = 70)
	private String nombre;
	
	@Column(name = "apellido",nullable = false, length = 70)
	private String apellido;
	
	@Column(name = "CMP",nullable = false, length = 12, unique = true)
	private String CMP;
	
	@Column(name = "fotoUrl",nullable = false )
	private String fotoUrl;

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCMP() {
		return CMP;
	}

	public void setCMP(String cMP) {
		CMP = cMP;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	
	
}
