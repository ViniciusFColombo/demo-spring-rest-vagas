package com.projetoscurso.demo_parki_api.service;

import com.projetoscurso.demo_parki_api.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.projetoscurso.demo_parki_api.repository.UsuarioRepository;

@RequiredArgsConstructor
@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar (Usuario usuario){
		return usuarioRepository.save(usuario);
	}
}
