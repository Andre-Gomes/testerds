package br.com.testerd.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.testerd.model.Usuario;
import br.com.testerd.repository.PerfilRepository;
import br.com.testerd.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void salvar(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuario.setPerfis(new HashSet<>(perfilRepository.findAll()));
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}
}