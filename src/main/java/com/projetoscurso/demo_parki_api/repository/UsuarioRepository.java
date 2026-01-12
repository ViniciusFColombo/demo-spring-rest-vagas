package com.projetoscurso.demo_parki_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoscurso.demo_parki_api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
}
