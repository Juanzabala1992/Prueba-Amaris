package com.gestion.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.personas.modelo.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
	Persona findByDocumentos(String documentos);
	
}
