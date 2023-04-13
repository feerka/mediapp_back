package com.feerka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "tbl_paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@NotNull
	@Size(min= 3, message = "El nombre debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@NotEmpty
	@Size(min= 3, message = "El apellido debe tener minimo 3 caracteres")
	@Column(name = "apellido", nullable = false, length = 70)
	private String apellido;
	
	@Size(min= 8, max = 8, message = "El DNI debe ser de 8 caracteres")
	@Column(name = "dni", nullable = false, length = 70)
	private String dni;
	
	@Size(min= 3, max = 150, message = "Direcion no cumple con la longitud requeridad")
	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;
	
	@Size(min= 9, max = 9, message = "Telefono no cumple con la longitud requeridad")
	@Column(name = "telefono", nullable = false, length = 70)
	private String telefono;
	
	@Email(message = "Debe ser un email")
	@Column(name = "email", nullable = false, length = 70)
	private String email;
	
	
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
