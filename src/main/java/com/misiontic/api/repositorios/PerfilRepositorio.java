package com.misiontic.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.api.entity.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

}
