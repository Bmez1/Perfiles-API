package com.misiontic.api.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;
import javax.xml.transform.OutputKeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.api.entity.Perfil;
import com.misiontic.api.services.PerfilService;

@RestController
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;	
		
	
	public PerfilController() {

	}
	
	// lista de perfiles	
	@GetMapping(value="lista-perfiles")	
	public ResponseEntity<List<Perfil>> findAll() {
		List<Perfil> perfiles = perfilService.findAll();
		return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK);
	}
	
	// Busqueda de perfil por ID	
	@GetMapping(value = "/perfiles/{perfilId}")	
	public ResponseEntity<Perfil> findById(@PathVariable("perfilId") Long perfilId) {
		Perfil perfil = perfilService.findById(perfilId);
		return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);		
		
	}
	
	// Crear perfil
	@PostMapping(value = "/perfiles")
	public ResponseEntity<Perfil> create(@RequestBody Perfil perfil) {
		Perfil nuevoPerfil = perfilService.create(perfil);
		return new ResponseEntity<Perfil>(nuevoPerfil, HttpStatus.OK);
	}
	
	// Actualizar Perfil
	@PutMapping(value = "/perfiles")
	public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
		Perfil perfilActualizar = perfilService.update(perfil);
		return new ResponseEntity<Perfil>(perfilActualizar, HttpStatus.OK);

	}
	
	// Eliminar perfil	
	@DeleteMapping(value = "/perfiles/{perfilID}")
	public ResponseEntity<Void> delete(@PathVariable("perfilID") Long perfilId) {
		perfilService.delete(perfilId);
		return new ResponseEntity(HttpStatus.OK);
		
	}
}
