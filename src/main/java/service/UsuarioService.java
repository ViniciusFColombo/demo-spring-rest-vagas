package service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repository.UsuarioRepository;

@RequiredArgsConstructor
@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
}
