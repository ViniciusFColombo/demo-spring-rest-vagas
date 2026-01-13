package com.projetoscurso.demo_parki_api.service;

import com.projetoscurso.demo_parki_api.entity.Usuario;
import com.projetoscurso.demo_parki_api.exception.EntityNotFoundException;
import com.projetoscurso.demo_parki_api.exception.UsernameUniqueViolationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.projetoscurso.demo_parki_api.repository.UsuarioRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		try {
            return usuarioRepository.save(usuario);
        }
        catch (org.springframework.dao.DataIntegrityViolationException ex){
            throw new UsernameUniqueViolationException(String.format("Username {%s} já cadastrado", usuario.getUsername()));
        }
	}

	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id))
		);
	}

	@Transactional
	public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
		if (!novaSenha.equals(confirmaSenha)) {
			throw new RuntimeException("Nova senha não confere com confirmação de senha");
		}
		Usuario user = buscarPorId(id);
		if (!user.getPassword().equals(senhaAtual)) {
			throw new RuntimeException("Nova senha não confere com confirmação de senha");
		}
		user.setPassword(novaSenha);
		return user;
	}

	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}
}
