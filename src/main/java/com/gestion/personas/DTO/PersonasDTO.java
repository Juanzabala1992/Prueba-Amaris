package com.gestion.personas.DTO;

import java.io.Serializable;

public class PersonasDTO implements Serializable{

	private Long id;
	private String p_nombre;
	private String s_nombre;
	private String p_apellido;
	private String s_apellido;
	private String direccion;
	private String ciudad;
	private String documentos;	
	private String t_documentos;
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
	public PersonasDTO(Long id, String p_nombre, String s_nombre, String p_apellido, String s_apellido,
			String direccion, String ciudad, String documentos, String t_documentos) {
		super();
		this.id = id;
		this.p_nombre = p_nombre;
		this.s_nombre = s_nombre;
		this.p_apellido = p_apellido;
		this.s_apellido = s_apellido;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.documentos = documentos;
		this.t_documentos = t_documentos;
	}
	public PersonasDTO() {
		super();
	}
	
}
