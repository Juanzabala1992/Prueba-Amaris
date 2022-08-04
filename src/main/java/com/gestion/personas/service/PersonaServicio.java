package com.gestion.personas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.gestion.personas.excepciones.ApiRequestException;
import com.gestion.personas.excepciones.ApiRequestExceptionValid;
import com.gestion.personas.modelo.Persona;
import com.gestion.personas.repository.PersonaRepositorio;

@Service
public class PersonaServicio {
	
	@Autowired
	private PersonaRepositorio repositorio;	
	

	public ResponseEntity<List<Persona>> getAllData(List<Persona> lista){
		if(lista.isEmpty() || lista == null) {
			throw new ApiRequestException("No hay usuarios en la base");			 
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}
	}
	public ResponseEntity<Optional<Persona>> getData(Optional<Persona> persona){
		if(persona.isEmpty() || persona == null) {
			throw new ApiRequestException("No se encuentra el usuario" );			 
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(persona);
		}	
	}
	
	
	public ResponseEntity<Persona> setData(Persona personaData, BindingResult result){
		if(result.hasErrors()) {
			if(!result.getFieldError().getDefaultMessage().isEmpty()) {				
				throw new ApiRequestExceptionValid(result.getFieldError().getDefaultMessage());
				
			}else {				
				throw new ApiRequestExceptionValid("Datos no validos");
			}
			
		}else {
				String doc = personaData.getDocumentos();
				Persona person = repositorio.findByDocumentos(doc);				
				if(person == null) {
					Persona persona = repositorio.save(personaData);
					return ResponseEntity.status(HttpStatus.OK).body(personaData);			
				}else {
					throw new ApiRequestExceptionValid("Persona ya existe");				
				}			
		}		
	}
	public ResponseEntity<Persona> getDataDoc(Persona personasDTO, BindingResult result){			
		if(!personasDTO.getDocumentos().isEmpty() && !personasDTO.getT_documentos().isEmpty()) {
			
			String doc = personasDTO.getDocumentos();
			Persona person = repositorio.findByDocumentos(doc);

			if(person == null || !person.getT_documentos().equals(personasDTO.getT_documentos())) {
				
				throw new ApiRequestExceptionValid("Persona no existe o los datos ingresados no son correctos");
			}else {
				return ResponseEntity.status(HttpStatus.OK).body(person);
			}
		}else {
				throw new ApiRequestExceptionValid("Debe ingresar el Documento y tipo");
				}
			}
	}
