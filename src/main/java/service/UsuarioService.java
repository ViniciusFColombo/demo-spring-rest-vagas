package service;

import entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repository.UsuarioRepository;

@RequiredArgsConstructor
@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar (Usuario usuario){
		return usuarioRepository.save(usuario);
	}
}
