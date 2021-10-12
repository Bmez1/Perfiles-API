package com.misiontic.api.validators;

import com.misiontic.api.entity.Perfil;

public class PerfilValidator {
	
	public static void save(Perfil perfil) {
		perfil.setNombre(perfil.getNombre().trim());
		if (perfil.getNombre().isEmpty() || perfil.getNombre() == null) {
			throw new RuntimeException("El nombre del perfil es obligatorio...");
		}
	}

}
