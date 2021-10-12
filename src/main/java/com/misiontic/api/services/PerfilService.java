package com.misiontic.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.api.entity.Perfil;
import com.misiontic.api.repositorios.PerfilRepositorio;
import com.misiontic.api.validators.PerfilValidator;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepositorio perfilRepository;

	// lista de perfiles
	public List<Perfil> findAll() {
		List<Perfil> perfiles = perfilRepository.findAll();
		return perfiles;
	}

	// Busqueda de perfil por ID
	public Perfil findById(Long perfilId) {
		Perfil perfil = perfilRepository.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("El perfil no existe..."));
		return perfil;

	}

	// Crear perfil
	@Transactional
	public Perfil create(Perfil perfil) {
		PerfilValidator.save(perfil);
		Perfil nuevoPerfil = perfilRepository.save(perfil);
		return nuevoPerfil;
	}

	// Actualizar Perfil
	@Transactional
	public Perfil update(Perfil perfil) {
		PerfilValidator.save(perfil);
		Perfil perfilActualizar = perfilRepository.findById(perfil.getId())
				.orElseThrow(() -> new RuntimeException("El perfil no existe..."));
		perfilActualizar.setNombre(perfil.getNombre());
		perfilRepository.save(perfilActualizar);
		return perfilActualizar;

	}

	// Eliminar perfil
	@Transactional
	public void delete(Long perfilId) {
		Perfil perfil = perfilRepository.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("El perfil no existe..."));
		perfilRepository.delete(perfil);

	}

}
