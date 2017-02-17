package br.com.testerd.service;

import br.com.testerd.model.Usuario;

/**
 * Herdando da interface específica do Spring Securit para recuperar dados do usuário. 
 */
public interface UsuarioService {
	void salvar(Usuario user);

	Usuario findByUsername(String username);
}