package com.gestion.personas.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.personas.DTO.PersonasDTO;
import com.gestion.personas.modelo.Persona;
import com.gestion.personas.repository.PersonaRepositorio;
import com.gestion.personas.service.PersonaServicio;



@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins="http://localhost:4200/")
public class PersonaControlador {
	
	@Autowired
	private PersonaRepositorio repositorio;
	
	@Autowired
	private PersonaServicio personaServicio; 
	
	@GetMapping("/personas/all")
	public ResponseEntity <List<Persona>> listarTodosLosEmpleados(){		
		List<Persona> all = repositorio.findAll();		
		return personaServicio.getAllData(all);
	}
	
	@GetMapping("/persona/{id}")
	public ResponseEntity <Optional<Persona>> obtenerPersona(@PathVariable Long id){
		Optional<Persona> persona = repositorio.findById(id);					
		return personaServicio.getData(persona);				
	}
	@GetMapping("/personas/document")
	public ResponseEntity<Persona> obtenerPersona(@Valid @RequestBody Persona personasDTO, BindingResult result){
		return personaServicio.getDataDoc(personasDTO, result);
					
	}
	@PostMapping("/save")
	public ResponseEntity<Persona> guardarEmpleado(@Valid @RequestBody Persona persona, BindingResult result) {	
		return personaServicio.setData(persona, result);
	
	}
}
