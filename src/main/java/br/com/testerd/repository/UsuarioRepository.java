package br.com.testerd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testerd.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByUsername(String username);
}
