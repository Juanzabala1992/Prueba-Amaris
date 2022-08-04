package com.gestion.personas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gestion.personas.validaciones.ValidTaskDTO;

import javax.persistence.GenerationType;

@Entity
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull(message = "Nombre es obligario")
	@Column(name = "p_nombre", nullable = false)
	private String p_nombre;
	
	
	@Column(name = "s_nombre", nullable = false)
	private String s_nombre;
	
	@NotEmpty
	@NotNull(message = "Apellido es obligario")
	@Column(name = "p_apellido", nullable = false)
	private String p_apellido;
	
	@NotEmpty
	@NotNull(message = "Segundo apellido es obligario")
	@Column(name = "s_apellido", nullable = false)
	private String s_apellido;
	
	@NotEmpty
	@NotNull(message = "Direccion es obligaria")
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@NotEmpty
	@NotNull(message = "ciudad es obligaria")
	@Column(name = "ciudad", nullable = false)
	private String ciudad;
	
	@NotEmpty
	@NotNull(message = "Numero de documento es obligario")
	@Column(name = "n_documentos", nullable = false, unique = true)
	private String documentos;
	
	
	@NotEmpty
	@NotNull(message = "tipo de documento es obligario")
	@ValidTaskDTO
	@Column(name = "t_documentos", nullable = false)	
	private String t_documentos;

	public Persona() {

	}

	public Persona(Long id, @NotBlank String p_nombre, String s_nombre, @NotBlank String p_apellido,
			@NotBlank String s_apellido, String direccion, String ciudad, String documentos, String tipo) {
		super();
		this.id = id;
		this.p_nombre = p_nombre;
		this.s_nombre = s_nombre;
		this.p_apellido = p_apellido;
		this.s_apellido = s_apellido;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.documentos = documentos;
		this.t_documentos = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getP_nombre() {
		return p_nombre;
	}

	public void setP_nombre(String p_nombre) {
		this.p_nombre = p_nombre;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getP_apellido() {
		return p_apellido;
	}

	public void setP_apellido(String p_apellido) {
		this.p_apellido = p_apellido;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	public String getT_documentos() {
		return t_documentos;
	}

	public void setT_documentos(String t_documentos) {
		this.t_documentos = t_documentos;
	}
	
}
